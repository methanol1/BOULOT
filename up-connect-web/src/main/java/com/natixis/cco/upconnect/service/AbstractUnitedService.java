package com.natixis.cco.upconnect.service;

import java.util.ResourceBundle;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.commun.config.annotations.ExceptionBundle;
import com.natixis.financement.middlesav.commun.config.annotations.UnitedBundle;
import com.natixis.financement.middlesav.commun.exceptions.SavError;
import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;
import com.natixis.financement.middlesav.united.dao.CtgDao;
import com.natixis.financement.middlesav.united.dao.UnitedDaoMock;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

public abstract class AbstractUnitedService {
	
	
    @Inject
    @UnitedBundle
    protected ResourceBundle unitedBundle;

    @Inject
    @ExceptionBundle
    protected ResourceBundle exceptionBundle;

    @Inject
    protected CtgDao unitedDao;

    /**
     * Retourne l'id de la requête envoyé à UNITED. ATTENTION : la valeur de
     * aCodeService ne doit pas faire plus de 3 caractères !!!
     * 
     * @param aCodeService
     * @return
     */
    protected String getIdRequeteUnited(final String aCodeService) {
        return "nx" + aCodeService + "-" + System.currentTimeMillis();
    }

    public ResourceBundle getUnitedBundle() {
        return unitedBundle;
    }

    public void setUnitedBundle(ResourceBundle unitedBundle) {
        this.unitedBundle = unitedBundle;
    }

    public ResourceBundle getExceptionBundle() {
        return exceptionBundle;
    }

    public void setExceptionBundle(ResourceBundle exceptionBundle) {
        this.exceptionBundle = exceptionBundle;
    }

    protected SavTechnicalException getSavTechnicalException(String aMessage) {   
        try{
            //0: getStackTraceImpl, 1:getStackTrace, 2:getSavBusinessException, 3: caller
            String className = Thread.currentThread().getStackTrace()[3].getClassName();
            String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
            return new SavTechnicalException(SavError.SAV_TECHNIQUE_ERREUR, className+"."+methodName+":"+aMessage);
        }catch(Exception e){
            return new SavTechnicalException(SavError.SAV_TECHNIQUE_ERREUR, aMessage);
        }
    }

    /**
     * Valorise les attributs d'entête avec les éléments définis dans le fichier de properties
     * @param unitedRequest
     * @param transaction - le préfixe des clés pour la transaction appelée, dans united-infos.properties
     */
    protected void valoriserHeader(UnitedCommareaDescriptionHeader unitedRequest) {
        // valorisation des champs communs
        unitedRequest.setTypeMessage(unitedBundle.getString("united.type.message"));
        unitedRequest.setNumVersionEntete(unitedBundle.getString("united.num.version.entete"));
        unitedRequest.setTypePasserelle(unitedBundle.getString("united.type.passerelle"));
        unitedRequest.setIdPartenaire(unitedBundle.getString("united.id.partenaire"));
        unitedRequest.setIdCanal(unitedBundle.getString("united.id.canal"));
        unitedRequest.setCodePaysISO(unitedBundle.getString("united.code.pays.iso"));
        
        fillInfosTransaction(unitedRequest);
    }

    protected void initUnitedDao() {
        unitedDao.setProgramName(unitedBundle.getString(getTypeTransaction().getCle() + ".program.name."+ getVersionUP()));
        unitedDao.setTransactionName(unitedBundle.getString(getTypeTransaction().getCle() + ".transaction.name."+ getVersionUP()));
    }
    
	protected abstract String getVersionUP();
    
    protected abstract TypeTransaction getTypeTransaction();
    
    protected void fillInfosTransaction(UnitedCommareaDescriptionHeader unitedRequest){
    	// valorisation des champs spéficiques à la transaction
    			unitedRequest.setProgrammeJavaAppelant(unitedBundle
    					.getString(getTypeTransaction().getCle() + ".prog.appelant."
    							+ getVersionUP()));
    			unitedRequest.setProgrammeMainframeAppele(unitedBundle
    					.getString(getTypeTransaction().getCle() + ".program.name."
    							+ getVersionUP()));
    			unitedRequest.setIdFctAppelee(unitedBundle
    					.getString(getTypeTransaction().getCle() + ".code.service."
    							+ getVersionUP()));
    			unitedRequest.setIdRequete(getIdRequeteUnited(unitedBundle
    					.getString(getTypeTransaction().getCle() + ".transaction.name."
    							+ getVersionUP())));
    			unitedRequest.setNumeroVersionContratEchange(unitedBundle
    					.getString(getTypeTransaction().getCle()
    							+ ".transaction.up.version." + getVersionUP()));
    }
}
