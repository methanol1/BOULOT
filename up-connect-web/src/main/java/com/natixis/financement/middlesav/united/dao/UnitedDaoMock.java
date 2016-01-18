package com.natixis.financement.middlesav.united.dao;

import java.lang.reflect.Field;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescription;
import com.natixis.cco.upconnect.commarea.agence.AgenceUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.assurance.AssuranceUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP2CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.dcrl.DCrlUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.dcrl.DCrlUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.dmen.DMenUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.domban.DomBanUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.historique.HistoUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.rachat.RachatUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.interceptors.LogCommarea;
import com.natixis.financement.middlesav.mock.Mock;
import com.natixis.financement.middlesav.united.UnitedCommareaHandler;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaList;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaObject;
import com.natixis.financement.middlesav.united.exception.UnitedAuthentificationException;
import com.natixis.financement.middlesav.united.exception.UnitedTechnicalException;

@Mock
@Alternative
public class UnitedDaoMock implements CtgDao {

	private static Logger logger = LoggerFactory.getLogger(UnitedDaoMock.class);
	
	private static String PROGRAM_IMDCTR0 = "IMDCTR0";
	
	private static String PROGRAM_IMDBQE0 = "IMDBQE0";
	
	private static String PROGRAM_IMDRCH0 = "IMDRCH0";
	
	private static String PROGRAM_IMDASU0 = "IMDASU0";
	
	private static String PROGRAM_IMDAGE0 = "IMDAGE0";
	
	private static String PROGRAM_IMDMEN0 = "IMDMEN0";
	
	private static String PROGRAM_IMDCRL0 = "IMDCRL0";
	
	private static String PROGRAM_IMDHIS0="IMDHIS0";
	
	
	private static final String UP1_VERSION = "1";
	private static final String UP2_VERSION = "2";
	private static final String UP3_VERSION = "3";

	@Inject
	private UnitedCommareaHandler commareaHandler;
	
	private String programName;
	
	private String transactionName;
	
	/**
	 * Construit la commarea, l'envoie à UNITED, la récupére et la parse.
	 * @param aIdAttComm id UNITED
	 * @param aMdpAttComm mdp UNITED
	 * @param aDescriptionRequest la description question
	 * @param aDescriptionResponseClass la classe de la description réponse
	 * @return
	 * @throws UnitedTechnicalException
	 * @throws UnitedAuthentificationException 
	 */
    public UnitedCommareaDescription callUnited(final UnitedCommareaDescription aDescriptionRequest,
			final Class<? extends UnitedCommareaDescription> aDescriptionResponseClass) throws UnitedTechnicalException, UnitedAuthentificationException {
		String lCommareaQuestion = commareaHandler.buildCommarea(aDescriptionRequest);
		lCommareaQuestion = fillQuestionToResponseLength(lCommareaQuestion, aDescriptionResponseClass);

		logger.debug("QUESTION:["+lCommareaQuestion+"]");//TODO : a supprimer une fois le dev termine
		String commareaResponse = sendCommarea(lCommareaQuestion, aDescriptionRequest);
		logger.debug("REPONSE :["+commareaResponse+"]");//TODO : a supprimer une fois le dev termine
		
		return (UnitedCommareaDescription)commareaHandler.parseCommarea(commareaResponse, aDescriptionResponseClass);
	}
	
	@LogCommarea
    private String sendCommarea(String aCommarea,UnitedCommareaDescription aDescriptionRequest) throws UnitedTechnicalException, UnitedAuthentificationException {
		String commareaResponse = null;
		if(PROGRAM_IMDCTR0.equals(programName)) {
			if(aDescriptionRequest instanceof ContratUP1CommareaDescriptionRequest){
				if(((ContratUP1CommareaDescriptionRequest)aDescriptionRequest).getNumeroContrat().startsWith("0")){//Contrat en contentieux
					commareaResponse = "R01---------------IMDCTR0 --------------------CNF I1--2015-06-29-15.31.48.108698--------------------FRA0DCTR00********************CX      161    000000000000é000000000000é          000000000000é0000000000é00000               000000000000é000000000000é000000000000é000000000000000 000000000000000                                    000000000000é000000000000é000000000000é                                         000000000000é000000000000é000000000000é000000000000é000000000000é000000                    000000000000é  ";
				}
				else {
					commareaResponse = "R01UP-CONNECT     IMDCTR0 nx-?-1423475908972  CNF P1                            ?                   FRA0DCTR17                    ESCP ENC168UD7 000000001823B000000001823B19.11.2012000000000000é0008794000é00011000119004122302000000000033B000000000313B000000000000é005504194504585M16834919660000101.01.2001                          000000000000é000000000000é000000000000é0                                        000000000000é000000000000é000000000000é000000000000é000000000000é00600005.05.2013          000000000000éNN";
				}
			}
			else if(aDescriptionRequest instanceof ContratUP2CommareaDescriptionRequest){
				// Test ContratV2 : un contrat commencant par 0 ne sera pas trouvé
				if(((ContratUP2CommareaDescriptionRequest) aDescriptionRequest).getNumeroContrat().startsWith("0")){
					commareaResponse = "R02UP-CONNECT     IMDCTR0 nx-?-1423475908972  CNF P2                            ?                   FRA1DCTR18                    "+/* Fin entete */"ESCP ENC168CP7 000000000000é000000000000é01.01.0001000000016924H0000000000é02024000119002945905000000021413F000000000000é000000000000é005504119504570M16823080050001601.01.000116800002401.01.0001NFINANCABLE     000000001586D000000000000é000000000000é001.01.000101.01.000101.01.000101.01.0001000000000000é000000000000è000000000000è000000000000é01.01.0001000000000000000000é00001.03.201905.06.2015000000000000éNN";
				}
				else{//Exemple normal de bon fonctionnement
					commareaResponse = "R02UP-CONNECT     IMDCTR0 nx-?-1423475908972  CNF P2                            ?                   FRA0DCTR17                    "+/* Fin entete */"ESCP ENC168CP7 000000000000é000000035000é20.03.2006000000016924H0013725000é02024000119002945905000000021413F000000001000é000000000000é005504119504570M16823080050001601.01.000116843603620.07.2015NFINANCABLE     000000001586D000000000000é000000023000é001.11.201521.01.201523.02.201522.06.2015000000000966é000000001000è000000001000è000000000000é01.01.0001000555000000000000é00001.03.201905.06.2015000000000000éON";
				}
			}
			else{
				throw new IllegalStateException("Cette version ("+aDescriptionRequest.getClass().getName()+") de requete UP n'est pas gérée.");
			}
		} 			
		else if(PROGRAM_IMDRCH0.equals(programName)) {//SERVICE RACHAT
			if(aDescriptionRequest instanceof RachatUP1CommareaDescriptionRequest){
				//Longueur commarea attendue : 163
				// ATTENTION, Tout changement de la commarea implique modification du test associé : RachatV1UP1MockTest
				if(((RachatUP1CommareaDescriptionRequest) aDescriptionRequest).getNumeroDossier().startsWith("0")){
					commareaResponse = "R01UP-CONNECT     IMDRCH0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service Rachat      FRA1DRCH03                    "+/* Fin entete */"000000000033D000000006477R1234567";
				}
				else if(((RachatUP1CommareaDescriptionRequest) aDescriptionRequest).getNumeroDossier().startsWith("1")){
					commareaResponse = "R01UP-CONNECT     IMDRCH0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service Rachat      FRA0ALPHAA                    "+/* Fin entete */"000000000033D000000006477R1234567";
				}
				else if(((RachatUP1CommareaDescriptionRequest) aDescriptionRequest).getNumeroDossier().startsWith("2")){
					commareaResponse = "R01UP-CONNECT     IMDRCH0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service Rachat      FRA0ALPHAA                    "+/* Fin entete */"000000000033D00000000A477R1234567";
				}
				else {
					commareaResponse = "R01UP-CONNECT     IMDRCH0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service Rachat      FRA0ALPHAA                    "+/* Fin entete */"000000000033D000000006477R1234567";
				}
			}
			else{
				throw new IllegalStateException("Cette version ("+aDescriptionRequest.getClass().getName()+") de requete UP n'est pas gérée.");
			}
		}
		else if(PROGRAM_IMDASU0.equals(programName)) { //SERVICE ASSURANCE
			if(aDescriptionRequest instanceof AssuranceUP1CommareaDescriptionRequest) {
				//Longueur commarea attendue : 205
				// ATTENTION, Tout changement de la commarea implique modification du test associé : AssuranceV1UP1MockTest
				if(((AssuranceUP1CommareaDescriptionRequest) aDescriptionRequest).getNumeroContrat().startsWith("0")){
					commareaResponse = "R01UP-CONNECT     IMDASU0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service Assurance   FRA1DASU13                    "+/* Fin entete */"00032910042401ABCDEFGHIJ00000000000000000000000000     01.01.000101.01.0001";
				}
				else if(((AssuranceUP1CommareaDescriptionRequest) aDescriptionRequest).getNumeroContrat().startsWith("9")){ //Simule un probleme de conversion : ERREUR GRAVE sur Prime souscripteur
					commareaResponse = "R01UP-CONNECT     IMDASU0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service Assurance   FRA0ALPHAA                    "+/* Fin entete */"00032910042401ABCDEFGHIJ00000003  00é000000089000éAAAAA10.02.201415.02.2014";
				}
				else{
					commareaResponse = "R01UP-CONNECT     IMDASU0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service Assurance   FRA0ALPHAA                    "+/* Fin entete */"00032910042401ABCDEFGHIJ000000035000é000000089000éAAAAA10.02.201415.02.2014";
				}
			}
			else{
				throw new IllegalStateException("Cette version ("+aDescriptionRequest.getClass().getName()+") de requete UP n'est pas gérée.");
			}
		}
		else if(PROGRAM_IMDAGE0.equals(programName)) { //SERVICE AGENCE
			if(aDescriptionRequest instanceof AgenceUP1CommareaDescriptionRequest){
				//Longueur commarea attendue : 312
				// ATTENTION, Tout changement de la commarea implique modification du test associé : AgenceV1UP1MockTest
				if(((AgenceUP1CommareaDescriptionRequest) aDescriptionRequest).getNumeroAgence().startsWith("0")){ //Simule agence non trouvée
					commareaResponse = "R01UP-CONNECT     IMDAGE0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service Agence      FRA1DAGE03                    "+/* Fin entete */"                              000000000000000000000000000000                                                                                                                          ";
				}
				else /*if(((AgenceUP1CommareaDescriptionRequest) aDescriptionRequest).getNumeroAgence().startsWith("1"))*/{
					commareaResponse = "R01UP-CONNECT     IMDAGE0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service Agence      FRA0ALPHAA                    "+/* Fin entete */"La super agence               000000125489856000009985632563DU LUNDI AU VENDRDI          08.30.0012.00.0013.30.0017.00.00SEMAINE SAUF MERCREDI APM    09.00.0012.00.0014.00.0018.00.00";
				}
			}
			else{
				throw new IllegalStateException("Cette version ("+aDescriptionRequest.getClass().getName()+") de requete UP n'est pas gérée.");
			}
		}
		else if(PROGRAM_IMDBQE0.equals(programName)) { //SERVICE DOMICILIATION BANCAIRE
			if(aDescriptionRequest instanceof DomBanUP1CommareaDescriptionRequest){
				//Longueur commarea attendue : 
				// ATTENTION, Tout changement de la commarea implique modification du test associé : DomBanV1UP1MockTest
				if(((DomBanUP1CommareaDescriptionRequest) aDescriptionRequest).getNumeroContrat().startsWith("1")){
					commareaResponse = "R01UP-CONNECT     IMDBQE0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service Domic banc  FRA0ALPHAA                    "+/* Fin entete */"CEPAFRPP118FR7630046001290029721519546       Pierre Paul                                       10.02.20102010?Le libellé de domiciliation                       X00000001235Le code Rum                        STA";
				}
				else if(((DomBanUP1CommareaDescriptionRequest) aDescriptionRequest).getNumeroContrat().startsWith("0")){ //Simule agence non trouvée
					commareaResponse = "R01UP-CONNECT     IMDBQE0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service Domic banc  FRA1DBQE03                    "+/* Fin entete */"                                                                                                         0000                                                    00000000000                                      ";
				}
			}
			else{
				throw new IllegalStateException("Cette version ("+aDescriptionRequest.getClass().getName()+") de requete UP n'est pas gérée.");
			}
		}
		else if(PROGRAM_IMDMEN0.equals(programName)) { //SERVICE DMEN
			if(aDescriptionRequest instanceof DMenUP1CommareaDescriptionRequest){
				//Longueur commarea attendue : 780
				// ATTENTION, Tout changement de la commarea implique modification du test associé : DMenV1UP1MockTest
				if(((DMenUP1CommareaDescriptionRequest) aDescriptionRequest).getNumroDossier().startsWith("1")){
					commareaResponse = "R01UP-CONNECT     IMDMEN0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service DMEN        FRA0ALPHAA                    "+/* Fin entete */"11234000132950001450004800004586000190000000085405256000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ";
				}
				else{ //Simule ...
					commareaResponse = "R01UP-CONNECT     IMDMEN0 nx-?-1423475908972  CNF P1  CODE ERREUR MAINFRAME     Service DMEN        FRA0ALPHAA                    "+/* Fin entete */"11234000132950001450004800004586000190000000085400012459                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ";
				}
			}
			else{
				throw new IllegalStateException("Cette version ("+aDescriptionRequest.getClass().getName()+") de requete UP n'est pas gérée.");
			}
		}
		else if(PROGRAM_IMDCRL0.equals(programName)) { //SERVICE DCRL
			if(aDescriptionRequest instanceof DCrlUP1CommareaDescriptionRequest){
					//commareaResponse= "R01UP-CONNECT     IMDCRL0 nx-?-1423475908972  CNF I1--2015-07-22-15.17.40.218850Service DCRL        FRA0DCRL00********************00001900340001435700000000000019955978000000000000000000000000000000000000000000001657C52000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   0000000000000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ";
				commareaResponse= "R01---------------IMDCRL0 --------------------CNF I1--2015-07-22-15.56.50.372981--------------------FRA0------********************00002600230000961300000000000019955978000000000000000000000000000000000000000000002413000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000   0000000000000";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    

			}
			else{
				throw new IllegalStateException("Cette version ("+aDescriptionRequest.getClass().getName()+") de requete UP n'est pas gérée.");
			}
		}
		else if(PROGRAM_IMDHIS0.equals(programName)) { //SERVICE DCRL
			if(aDescriptionRequest instanceof HistoUP1CommareaDescriptionRequest){
				commareaResponse= "R01UPCONNECT-HISTOIMDHIS0 nxDHIS-1440501195297CNF I1  2015-08-25-13.13.15.192596                    FRA0DCDO00                    O201507071080000004183L2015-07-07-07.19.58.741788                                                                                000201507070280000004183C2015-07-07-07.19.58.741952          CAISSE D EPARGNE NORMANDIE                                            000201507230980000000167L2015-07-23-10.13.16.268844                                                                                000201508071080000004183L2015-08-07-03.20.47.510747                                                                                000201508071270000004183C2015-08-07-03.20.47.511229                                                                                00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        00000000000   0000000000頠                                                                                                        000";
			}
			else{
				throw new IllegalStateException("Cette version ("+aDescriptionRequest.getClass().getName()+") de requete UP n'est pas gérée.");
			}
		}
		return commareaResponse;
	}
	
	
	/**
	 * Cf UnitedDao
	 * @param commareaQuestion
	 * @param descriptionResponseClass
	 * @return
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
	 * Cf UnitedDao
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

    public void setTransactionName(final String transactionName) {
		this.transactionName = transactionName;
	}
	
    public void setProgramName(final String programName) {
		this.programName = programName;
	}
}
