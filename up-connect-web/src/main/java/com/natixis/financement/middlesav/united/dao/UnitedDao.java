package com.natixis.financement.middlesav.united.dao;

import java.lang.reflect.Field;
import java.util.ResourceBundle;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.Interaction;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bnpp.pf.lib.ctgrelay.client.ByteArrayRecord;
import com.bnpp.pf.lib.ctgrelay.client.ConnectionSpec;
import com.bnpp.pf.lib.ctgrelay.client.ConnectionSpec.Builder;
import com.bnpp.pf.lib.ctgrelay.client.InteractionSpec;
import com.bnpp.pf.lib.ctgrelay.client.protocol.ConnectionFactory;
import com.bnpp.pf.lib.ctgrelay.client.protocol.TechnicalException;
import com.natixis.cco.upconnect.commarea.UnitedCommareaDescription;
import com.natixis.cco.upconnect.interceptors.LogCommarea;
import com.natixis.financement.middlesav.business.log.interceptor.annotation.LogServiceUP;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.config.annotations.ExceptionBundle;
import com.natixis.financement.middlesav.commun.config.annotations.UnitedBundle;
import com.natixis.financement.middlesav.commun.config.annotations.UnitedConnectionFactory;
import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;
import com.natixis.financement.middlesav.united.UnitedCommareaHandler;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaList;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaObject;
import com.natixis.financement.middlesav.united.exception.UnitedAuthentificationException;
import com.natixis.financement.middlesav.united.exception.UnitedTechnicalException;

@Default
@Alternative
public class UnitedDao implements CtgDao {

    private static Logger logger = LoggerFactory.getLogger(UnitedDao.class);

    @Inject
    @UnitedConnectionFactory
    private ConnectionFactory factory;

    @Inject
    private UnitedCommareaHandler commareaHandler;

    @Inject
    @ExceptionBundle
    private ResourceBundle exceptionBundle;

    @Inject
    @UnitedBundle
    private ResourceBundle unitedBundle;

    private String programName;

    private String transactionName;

    private Logger requetesLogger = LoggerFactory.getLogger(Constantes.COMMAREAS);



    /**
     * Construit la commarea, l'envoie à UNITED, la récupére et la parse.
     * 
     * @param aIdAttComm
     *            id UNITED
     * @param aMdpAttComm
     *            mdp UNITED
     * @param aDescriptionRequest
     *            la description question
     * @param aDescriptionResponseClass
     *            la classe de la description réponse
     * @return
     * @throws UnitedTechnicalException
     * @throws UnitedAuthentificationException
     */
    @LogServiceUP
    public UnitedCommareaDescription callUnited(final UnitedCommareaDescription aDescriptionRequest, final Class<? extends UnitedCommareaDescription> aDescriptionResponseClass) throws UnitedTechnicalException, UnitedAuthentificationException {

        String lCommareaQuestion = commareaHandler.buildCommarea(aDescriptionRequest);
        
        lCommareaQuestion = fillQuestionToResponseLength(lCommareaQuestion, aDescriptionResponseClass);
        
        final String lCommareaReponse = sendCommarea(lCommareaQuestion);
        return (UnitedCommareaDescription) commareaHandler.parseCommarea(lCommareaReponse, aDescriptionResponseClass);
    }

    /**
     * Complète la commarea de question pour la rendre aussi longue que la
     * commarea attendue en réponse. La complétion se fait en lisant, pour
     * chaque champ de la classe, l'attribut
     * {@link com.natixis.financement.middlesav.united.annotation.UnitedCommareaObject#longueur()}
     * de l'annotation si elle existe.
     * 
     * @param commareaQuestion
     *            - la commarea de question valorisée
     * @param descriptionResponseClass
     *            - la classe représentant la commarea de réponse
     * @return la commarea de question à la longueur de celle de réponse
     */
    protected String fillQuestionToResponseLength(final String commareaQuestion, final Class<? extends UnitedCommareaDescription> descriptionResponseClass) {
        int fillerLength = 0;
        Class<?> classToParse = descriptionResponseClass;
        do {
            for (final Field field : classToParse.getDeclaredFields()) {
                fillerLength += readUnitedCommareaAnnotations(field);
            }
            classToParse = classToParse.getSuperclass();
        } while (classToParse != null);

        return StringUtils.rightPad(commareaQuestion, fillerLength);
    }

    /**
     * Lit les annotations UnitedCommarea* et en récupère la longueur (ou la
     * longueur x nombre d'occurences max pour les listes)
     * 
     * @param field
     * @return
     */
    private int readUnitedCommareaAnnotations(final Field field) {
        int fillerLength = 0;
        final UnitedCommareaObject annotationObject = field.getAnnotation(UnitedCommareaObject.class);
        if (annotationObject != null) {
            fillerLength += annotationObject.longueur();
        }
        final UnitedCommareaField annotationField = field.getAnnotation(UnitedCommareaField.class);
        if (annotationField != null) {
            fillerLength += annotationField.longueur();
        }
        final UnitedCommareaList annotationList = field.getAnnotation(UnitedCommareaList.class);
        if (annotationList != null) {
            // FIXME: a priori ça ne donne pas le nombre attendu par Ismahel...
            // à étudier avec lui (+ désignorer le TU associé)
            fillerLength += annotationList.longueur() * annotationList.nombre();
        }
        return fillerLength;
    }

    /**
     * Envoie aCommarea au service UNITED décrit par les paramètres.
     * 
     * @param aCicsName
     * @param aProgramName
     * @param aTransactionName
     * @param aCommarea
     * @return la Commarea retournée par UNITED
     * @throws UnitedTechnicalException
     * @throws UnitedAuthentificationException
     */
    @LogCommarea
    private String sendCommarea(final String aCommarea) throws UnitedTechnicalException, UnitedAuthentificationException {

        requetesLogger.debug("CommareaReq=["+aCommarea+"]");

        ByteArrayRecord lCommareaReponse = new ByteArrayRecord();

        Connection connection;
        try {

            // Acces avec le compte générique défini dans la config du connecteur JCA
        	try{
            connection = factory.getConnection(getConnectionSpec());
        	}
        	catch(Throwable t){
        		t.printStackTrace(System.err);
        		throw new RuntimeException(t.getMessage());
        	}
            if (connection == null){
                throw new SavTechnicalException("Aucune connexion à United n'a pas être obtenue.");
            }

            final Interaction lInteraction = connection.createInteraction();
            // Routage vers le bon programme / transaction
            final InteractionSpec lParams = new InteractionSpec(programName, transactionName);

            final ByteArrayRecord lCommareaQuestion = new ByteArrayRecord(aCommarea, aCommarea.length());

            // Exécution du programme
            lCommareaReponse = (ByteArrayRecord) lInteraction.execute(lParams, lCommareaQuestion);
        } catch (final ResourceException e) {
            logger.error(exceptionBundle.getString("united.erreur.communication"), e);
            if (unitedBundle.getString("united.authentification.code.erreur").equals(e.getErrorCode())) {
                throw new UnitedAuthentificationException(e.getMessage(), e.getErrorCode(), e);
            }
            final String nestedMessage = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
            throw new UnitedTechnicalException(nestedMessage, e);
        }
        String result = new String(lCommareaReponse.getCommArea());
        requetesLogger.debug("CommareaRep=["+result+"]");
        return result;
    }


    /**
     * @return
     * @throws TechnicalException
     */
    private ConnectionSpec getConnectionSpec() throws TechnicalException {
        if (StringUtils.isBlank(factory.getCics())) {
            throw new TechnicalException("Unable to initialise Connection, cics is empty.");
        }
        if ((StringUtils.isBlank(factory.getUserName())) || (StringUtils.isBlank(factory.getUserName()))) {
            throw new TechnicalException("Unable to initialise Connection, userName or password are empty.");
        }

        final Builder builder = new Builder(factory.getCics()).credentials(factory.getUserName(), factory.getPassword());

        // Gestion Timeout CTG BNPF
        builder.setConnectTimeout(30000);
        builder.setRequestTimeout(30000);

        return builder.build();
    }


    public void setTransactionName(final String transactionName) {
        this.transactionName = transactionName;
    }

    public void setProgramName(final String programName) {
        this.programName = programName;
    }
}
