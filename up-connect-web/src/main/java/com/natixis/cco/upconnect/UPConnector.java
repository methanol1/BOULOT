package com.natixis.cco.upconnect;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.natixis.cco.upconnect.controller.AgenceController;
import com.natixis.cco.upconnect.controller.AssuranceController;
import com.natixis.cco.upconnect.controller.ContratController;
import com.natixis.cco.upconnect.controller.DCrlController;
import com.natixis.cco.upconnect.controller.DMenController;
import com.natixis.cco.upconnect.controller.DomBanController;
import com.natixis.cco.upconnect.controller.HistoController;
import com.natixis.cco.upconnect.controller.InfosServices;
import com.natixis.cco.upconnect.controller.RachatController;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.interceptors.contrat.AgenceStatLogger;
import com.natixis.cco.upconnect.interceptors.contrat.AssuranceStatLogger;
import com.natixis.cco.upconnect.interceptors.contrat.ContratStatLogger;
import com.natixis.cco.upconnect.interceptors.contrat.DomBanStatLogger;
import com.natixis.cco.upconnect.interceptors.contrat.RachatStatLogger;
import com.natixis.cco.upconnect.interceptors.historique.HistoStatLogger;
import com.natixis.cco.upconnect.interceptors.m2cr.DCrlStatLogger;
import com.natixis.cco.upconnect.interceptors.m2cr.DMenStatLogger;
import com.natixis.cco.upconnect.modelnfi.agence.AgenceV1;
import com.natixis.cco.upconnect.modelnfi.assurance.AssuranceV1;
import com.natixis.cco.upconnect.modelnfi.contrat.ContratV1;
import com.natixis.cco.upconnect.modelnfi.contrat.ContratV2;
import com.natixis.cco.upconnect.modelnfi.dcrl.DCrlV1;
import com.natixis.cco.upconnect.modelnfi.dcrl.InputDCrlV1;
import com.natixis.cco.upconnect.modelnfi.dmen.DMenV1;
import com.natixis.cco.upconnect.modelnfi.dmen.InputDMenV1;
import com.natixis.cco.upconnect.modelnfi.domban.DomBanV1;
import com.natixis.cco.upconnect.modelnfi.historique.HistoV1;
import com.natixis.cco.upconnect.modelnfi.historique.InputHistoV1;
import com.natixis.cco.upconnect.modelnfi.rachat.RachatV1;
import com.natixis.financement.middlesav.commun.exceptions.AgenceNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.DomBanBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.HistoriqueNonTrouveException;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.natixis.financement.middlesav.commun.exceptions.RachatBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SocieteNonTrouveException;

public class UPConnector {
	
	private static final String FORMAT_DE_DATE_INCORRECT = "Format de date incorrect";

	private static final String DEFAULT_DATE = "01.01.0001";

	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
	
	private static final String CONTRAT = "CONTRAT";
	private static final String AGENCE = "AGENCE";
	private static final String RACHAT = "RACHAT";
	private static final String BANCAIRE = "BANCAIRE";
	private static final String ASSURANCE = "ASSURANCE";
	private static final String DMEN = "DMEN";
	private static final String DCRL = "DCRL";
	private static final String DHIS = "DHIS";
	
	private static Pattern pattern = Pattern.compile ("[0-9]{14}");

	@Inject
	ContratController contratController;
	
	@Inject
	RachatController rachatController;
	
	@Inject
	AssuranceController assuranceController;
	
	@Inject
	AgenceController agenceController;
	
	@Inject
	DomBanController dombanController;
	
	@Inject
	DMenController dmenController;
	
	@Inject
	DCrlController dCrlController;
	
	@Inject
	HistoController histoController;

	/**
	 * Méthode permettant de récupérer un objet Contrat en version 1. Peu
	 * importe la version du service UP appelé.
	 * 
	 * @param dossier
	 * @return
	 * @throws ConverterException
	 * @throws InputValuesException 
	 */
	@ContratStatLogger
	public ContratV1 getContratV1(String dossier) 
			throws ConverterException, ContratNonTrouveBusinessException, InputValuesException {
		validerDossier(dossier);
		return contratController.getContrat1(dossier);
	}
	
	/**
	 * Méthode permettant de récupérer un objet Contrat en version 2. Peu
	 * importe la version du service UP appelé.
	 * 
	 * @param dossier
	 * @return
	 * @throws ConverterException
	 * @throws InputValuesException 
	 */
	@ContratStatLogger
	public ContratV2 getContratV2(String dossier) 
			throws ConverterException, ContratNonTrouveBusinessException, InputValuesException {
		validerDossier(dossier);
		return contratController.getContrat2(dossier);
	}
	
	/**
	 * Méthode permettant de récupérer un objet Rachat en version 1. Peu
	 * importe la version du service UP appelé.
	 * 
	 * @param dossier
	 * @return
	 * @throws ConverterException
	 * @throws InputValuesException 
	 */
	@RachatStatLogger
	public RachatV1 getRachatV1(String dossier, String date) 
			throws ConverterException, RachatBusinessException, InputValuesException {
		validerDossier(dossier);
		if(null != date){
			try{
				df.parse(date);
			}catch(ParseException pe){
				throw new InputValuesException(FORMAT_DE_DATE_INCORRECT);
			}
		}
		else{
			date = DEFAULT_DATE;
		}
		return rachatController.getRachat1(dossier, date);
	}
	
	@AssuranceStatLogger
	public AssuranceV1 getAssuranceV1(String dossier, String date)
			throws ConverterException, ContratNonTrouveBusinessException, InputValuesException {
		validerDossier(dossier);
		if(null != date){
			try{
				df.parse(date);
			}catch(ParseException pe){
				throw new InputValuesException(FORMAT_DE_DATE_INCORRECT);
			}
		}
		else{
			date = DEFAULT_DATE;
		}
		return assuranceController.getAssurance1(dossier, date);
	}
	
	@AgenceStatLogger
	public AgenceV1 getAgenceV1(String codeAgence)
			throws ConverterException, AgenceNonTrouveBusinessException, InputValuesException {
		validerAgence(codeAgence);
		return agenceController.getAgence1(codeAgence);
	}
	
	@DomBanStatLogger
	public DomBanV1 getDomBanV1(String dossier, String date) 
			throws ConverterException, DomBanBusinessException, InputValuesException {
		validerDossier(dossier);
		if(null != date){
			try{
				df.parse(date);
			}catch(ParseException pe){
				throw new InputValuesException(FORMAT_DE_DATE_INCORRECT);
			}
		}
		else{
			date = DEFAULT_DATE;
		}
		return dombanController.getDomBan1(dossier, date);
	}
	
	@DMenStatLogger
	public DMenV1 calculMens1(InputDMenV1 request) throws ConverterException, ContratNonTrouveBusinessException, 
			SocieteNonTrouveException, InputValuesException {
		
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<InputDMenV1>> constraintViolations =
		validator.validate(request);
		StringBuffer buffer = new StringBuffer();
		if (constraintViolations.size() > 0 ) {
			for (ConstraintViolation<InputDMenV1> constraintViolation : constraintViolations) {
				buffer.append(constraintViolation.getPropertyPath()+":"+constraintViolation.getMessage()+". ");
			}
			throw new InputValuesException(buffer.toString());
		}
		
		return dmenController.calculDMen1(request);
	}
	
	@DCrlStatLogger
	public DCrlV1 calculDCrlV1(InputDCrlV1 request)throws ConverterException, InputValuesException {
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<InputDCrlV1>> constraintViolations =
		validator.validate(request);
		StringBuffer buffer = new StringBuffer();
		if (constraintViolations.size() > 0 ) {
			for (ConstraintViolation<InputDCrlV1> constraintViolation : constraintViolations) {
				buffer.append(constraintViolation.getPropertyPath()+":"+constraintViolation.getMessage()+". ");
			}
			throw new InputValuesException(buffer.toString());
		}
		return dCrlController.calculDCrl1(request);
	}
	

	@HistoStatLogger
	public HistoV1 historiques(InputHistoV1 request)throws ConverterException, InputValuesException, HistoriqueNonTrouveException{
		
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<InputHistoV1>> constraintViolations =
		validator.validate(request);
		StringBuffer buffer = new StringBuffer();
		if (constraintViolations.size() > 0 ) {
			for (ConstraintViolation<InputHistoV1> constraintViolation : constraintViolations) {
				buffer.append(constraintViolation.getPropertyPath()+":"+constraintViolation.getMessage()+". ");
			}
			throw new InputValuesException(buffer.toString());
		}
		return histoController.historiques(request);
		
	}
	
	

	public Map<String, InfosServices> getVersions (){
		Map<String, InfosServices> map = new Hashtable<String, InfosServices>();
		map.put(CONTRAT, contratController.getinfoService());
		map.put(RACHAT, rachatController.getinfoService());
		map.put(ASSURANCE, assuranceController.getinfoService());
		map.put(AGENCE, agenceController.getinfoService());
		map.put(BANCAIRE, dombanController.getinfoService());
		map.put(DMEN, dmenController.getinfoService());
		map.put(DCRL, dCrlController.getinfoService());
		map.put(DHIS, histoController.getinfoService());
		return map;
	}
	
	private void validerDossier(String dossier) throws InputValuesException{
		if(null == dossier || dossier.length() != 14){
			throw new InputValuesException("Numéro de dossier incorrect.");
		}
		System.out.println("pattern.matcher("+dossier+").matches() = " + pattern.matcher(dossier).matches());
		if(!pattern.matcher(dossier).matches()){
			throw new InputValuesException("Numéro de dossier attendu sur 14 chiffres");
		}
	}
	private void validerAgence(String codeAgence) throws InputValuesException{
		if(null == codeAgence || codeAgence.length() != 3){
			throw new InputValuesException("Code agence doit être sur 3 caractères.");
		}
	}
}
