package com.natixis.cco.upconnect.modelUP.assurance;

import java.math.BigDecimal;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescription;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;


/**
 * Cette classe rassemble toutes les données issues du service
 * Assurance UP version 1 (bloc assurance du service Contrat) 
 * telles qu'elles sont lues depuis la commarea de sortie.
 * 
 * Nous aurons enlevé les infos techniques et les fillers
 * 
 * C'est une image objet Java de la commarea du service UP version 1.
 * 
 * C'est donc la classe correspondant à AssuranceDescription de l'ancien code.
 * Avec en plus la notion de version.
 * 
 * @author steph
 *
 */
public class OutputAssuranceUP1 {
	private String typeMessage;
	
	private String numVersionEntete;
	
	private String programmeJavaAppelant;
	
	private String programmeMainframeAppele;
	
	private String idRequete;
	
	private String typePasserelle;
	
	private String idPartenaire;
	
	private String idCanal;
	
	private String idErreurMainframe;
	
	private String idFctAppelee;
	
	private String codePaysISO;
	
	private String codeRetourSimple;
	
	private String codeRetourPrecis;

	/**
	 * Taux mensuel d'assurance souscripteur
	 */
	private String tauxMensSousc;
	
	/**
	 * Taux mensuel d'assurance co-souscripteur
	 */
	private String tauxMensCoSousc;

	/**
	 * Option assurance souscripteur
	 */
	private String optionSous;
	
	/**
	 * Option assurance co-souscripteur
	 */
	private String optionCoSous;

	/**
	 * Prime forfaitaire assurance souscripteur
	 */
	private String primeSous;
	
	/**
	 * Prime forfaitaire assurance co-souscripteur
	 */
	private String primeCoSous;
	
	private String codeConvention;
	
	private String dateSous;
	
	private String dateCoSous;

	public String getTypeMessage() {
		return typeMessage;
	}

	public void setTypeMessage(String typeMessage) {
		this.typeMessage = typeMessage;
	}

	public String getNumVersionEntete() {
		return numVersionEntete;
	}

	public void setNumVersionEntete(String numVersionEntete) {
		this.numVersionEntete = numVersionEntete;
	}

	public String getProgrammeJavaAppelant() {
		return programmeJavaAppelant;
	}

	public void setProgrammeJavaAppelant(String programmeJavaAppelant) {
		this.programmeJavaAppelant = programmeJavaAppelant;
	}

	public String getProgrammeMainframeAppele() {
		return programmeMainframeAppele;
	}

	public void setProgrammeMainframeAppele(String programmeMainframeAppele) {
		this.programmeMainframeAppele = programmeMainframeAppele;
	}

	public String getIdRequete() {
		return idRequete;
	}

	public void setIdRequete(String idRequete) {
		this.idRequete = idRequete;
	}

	public String getTypePasserelle() {
		return typePasserelle;
	}

	public void setTypePasserelle(String typePasserelle) {
		this.typePasserelle = typePasserelle;
	}

	public String getIdPartenaire() {
		return idPartenaire;
	}

	public void setIdPartenaire(String idPartenaire) {
		this.idPartenaire = idPartenaire;
	}

	public String getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}

	public String getIdErreurMainframe() {
		return idErreurMainframe;
	}

	public void setIdErreurMainframe(String idErreurMainframe) {
		this.idErreurMainframe = idErreurMainframe;
	}

	public String getIdFctAppelee() {
		return idFctAppelee;
	}

	public void setIdFctAppelee(String idFctAppelee) {
		this.idFctAppelee = idFctAppelee;
	}

	public String getCodePaysISO() {
		return codePaysISO;
	}

	public void setCodePaysISO(String codePaysISO) {
		this.codePaysISO = codePaysISO;
	}

	public String getCodeRetourSimple() {
		return codeRetourSimple;
	}

	public void setCodeRetourSimple(String codeRetourSimple) {
		this.codeRetourSimple = codeRetourSimple;
	}

	public String getCodeRetourPrecis() {
		return codeRetourPrecis;
	}

	public void setCodeRetourPrecis(String codeRetourPrecis) {
		this.codeRetourPrecis = codeRetourPrecis;
	}

	public String getTauxMensSousc() {
		return tauxMensSousc;
	}

	public void setTauxMensSousc(String tauxMensSousc) {
		this.tauxMensSousc = tauxMensSousc;
	}

	public String getTauxMensCoSousc() {
		return tauxMensCoSousc;
	}

	public void setTauxMensCoSousc(String tauxMensCoSousc) {
		this.tauxMensCoSousc = tauxMensCoSousc;
	}

	public String getOptionSous() {
		return optionSous;
	}

	public void setOptionSous(String optionSous) {
		this.optionSous = optionSous;
	}

	public String getOptionCoSous() {
		return optionCoSous;
	}

	public void setOptionCoSous(String optionCoSous) {
		this.optionCoSous = optionCoSous;
	}

	public String getPrimeSous() {
		return primeSous;
	}

	public void setPrimeSous(String primeSous) {
		this.primeSous = primeSous;
	}

	public String getPrimeCoSous() {
		return primeCoSous;
	}

	public void setPrimeCoSous(String primeCoSous) {
		this.primeCoSous = primeCoSous;
	}

	public String getCodeConvention() {
		return codeConvention;
	}

	public void setCodeConvention(String codeConvention) {
		this.codeConvention = codeConvention;
	}

	public String getDateSous() {
		return dateSous;
	}

	public void setDateSous(String dateSous) {
		this.dateSous = dateSous;
	}

	public String getDateCoSous() {
		return dateCoSous;
	}

	public void setDateCoSous(String dateCoSous) {
		this.dateCoSous = dateCoSous;
	}

}
