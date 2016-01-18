package com.natixis.cco.upconnect.modelUP.agence;

import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;



/**
 * Cette classe rassemble toutes les données issues du service
 * Agence UP version 1 (bloc assurance du service Contrat) 
 * telles qu'elles sont lues depuis la commarea de sortie.
 * 
 * Nous aurons enlevé les infos techniques et les fillers
 * 
 * C'est une image objet Java de la commarea du service UP version 1.
 * 
 * C'est donc la classe correspondant à AgenceDescription de l'ancien code.
 * Avec en plus la notion de version.
 * 
 * @author steph
 *
 */
public class OutputAgenceUP1 {
	private String typeMessage;
	
	private String numVersionEntete;
	
	private String programmeJavaAppelant;
	
	private String programmeMainframeAppele;
	
	private String idRequete;
	
	private String typePasserelle;
	
	private String idPartenaire;
	
	private String idCanal;
	
	private String numVersionContratEchang;
	
	private String idErreurMainframe;
	
	private String idFctAppelee;
	
	private String codePaysISO;
	
	private String codeRetourSimple;
	
	private String codeRetourPrecis;

	/**
     * Nom de l'agence
     */
    private String nomAgence;
    
    /**
     * Numéro de téléphone
     */
    private String numeroTel;
    
    /**
     * Numéro de FAX
     */
    private String numeroFax; 
    
    /**
     * Plage d'ouverture Numero 1
     */
    private String plage1; 
    
    /**
     * Horaire ouverture matin1
     * Format hh.mm.ss
     */
    private String ouvertureMatin1;
    
    /**
     * Horaire fermeture matin1
     * Format hh.mm.ss
     */
    private String fermetureMatin1;
    
    /**
     * Horaire ouverture apres midi1
     * Format hh.mm.ss
     */
    private String ouvertureApresMidi1;
    
    /**
     * Horaire fermeture apres midi1
     * Format hh.mm.ss
     */
    private String fermetureApresMidi1;
    
    /**
     * Plage d'ouverture Numero 2
     */
    private String plage2; 
    
    /**
     * Horaire ouverture matin2
     * Format hh.mm.ss
     */
    private String ouvertureMatin2;
    
    /**
     * Horaire fermeture matin2
     * Format hh.mm.ss
     */
    private String fermetureMatin2;
    
    /**
     * Horaire ouverture apres midi2
     * Format hh.mm.ss
     */
    private String ouvertureApresMidi2;
    
    /**
     * Horaire fermeture apres midi2
     * Format hh.mm.ss
     */
    private String fermetureApresMidi2;

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

	public String getNumVersionContratEchang() {
		return numVersionContratEchang;
	}

	public void setNumVersionContratEchang(String numVersionContratEchang) {
		this.numVersionContratEchang = numVersionContratEchang;
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

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getPlage1() {
		return plage1;
	}

	public void setPlage1(String plage1) {
		this.plage1 = plage1;
	}

	public String getOuvertureMatin1() {
		return ouvertureMatin1;
	}

	public void setOuvertureMatin1(String ouvertureMatin1) {
		this.ouvertureMatin1 = ouvertureMatin1;
	}

	public String getFermetureMatin1() {
		return fermetureMatin1;
	}

	public void setFermetureMatin1(String fermetureMatin1) {
		this.fermetureMatin1 = fermetureMatin1;
	}

	public String getOuvertureApresMidi1() {
		return ouvertureApresMidi1;
	}

	public void setOuvertureApresMidi1(String ouvertureApresMidi1) {
		this.ouvertureApresMidi1 = ouvertureApresMidi1;
	}

	public String getFermetureApresMidi1() {
		return fermetureApresMidi1;
	}

	public void setFermetureApresMidi1(String fermetureApresMidi1) {
		this.fermetureApresMidi1 = fermetureApresMidi1;
	}

	public String getPlage2() {
		return plage2;
	}

	public void setPlage2(String plage2) {
		this.plage2 = plage2;
	}

	public String getOuvertureMatin2() {
		return ouvertureMatin2;
	}

	public void setOuvertureMatin2(String ouvertureMatin2) {
		this.ouvertureMatin2 = ouvertureMatin2;
	}

	public String getFermetureMatin2() {
		return fermetureMatin2;
	}

	public void setFermetureMatin2(String fermetureMatin2) {
		this.fermetureMatin2 = fermetureMatin2;
	}

	public String getOuvertureApresMidi2() {
		return ouvertureApresMidi2;
	}

	public void setOuvertureApresMidi2(String ouvertureApresMidi2) {
		this.ouvertureApresMidi2 = ouvertureApresMidi2;
	}

	public String getFermetureApresMidi2() {
		return fermetureApresMidi2;
	}

	public void setFermetureApresMidi2(String fermetureApresMidi2) {
		this.fermetureApresMidi2 = fermetureApresMidi2;
	}


}
