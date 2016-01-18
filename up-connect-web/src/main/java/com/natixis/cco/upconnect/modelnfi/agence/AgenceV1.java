package com.natixis.cco.upconnect.modelnfi.agence;


public class AgenceV1 {
	
	private AgenceV1Header header = new AgenceV1Header();
	
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

	public AgenceV1Header getHeader() {
		return header;
	}

	public void setHeader(AgenceV1Header header) {
		this.header = header;
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
