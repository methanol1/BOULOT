package com.natixis.cco.upconnect.commarea.agence;

import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;


/**
 * Longueur : 182
 * 
 * @author fleuryst
 *
 */
public class AgenceUP1Description {

	/**
     * Nom de l'agence
     */
    @UnitedCommareaField(position = 1, longueur = 30)
    private String nomAgence;
    
    /**
     * Numéro de téléphone
     */
    @UnitedCommareaField(position = 2, longueur = 15)
    private String numeroTel;
    
    /**
     * Numéro de FAX
     */
    @UnitedCommareaField(position = 3, longueur = 15)
    private String numeroFax; 
    
    /**
     * Plage d'ouverture Numero 1
     */
    @UnitedCommareaField(position = 4, longueur = 29)
    private String plage1; 
    
    /**
     * Horaire ouverture matin1
     * Format hh.mm.ss
     */
    @UnitedCommareaField(position = 5, longueur = 8)
    private String ouvertureMatin1;
    
    /**
     * Horaire fermeture matin1
     * Format hh.mm.ss
     */
    @UnitedCommareaField(position = 6, longueur = 8)
    private String fermetureMatin1;
    
    /**
     * Horaire ouverture apres midi1
     * Format hh.mm.ss
     */
    @UnitedCommareaField(position = 7, longueur = 8)
    private String ouvertureApresMidi1;
    
    /**
     * Horaire fermeture apres midi1
     * Format hh.mm.ss
     */
    @UnitedCommareaField(position = 8, longueur = 8)
    private String fermetureApresMidi1;
    
    /**
     * Plage d'ouverture Numero 2
     */
    @UnitedCommareaField(position = 9, longueur = 29)
    private String plage2; 
    
    /**
     * Horaire ouverture matin2
     * Format hh.mm.ss
     */
    @UnitedCommareaField(position = 10, longueur = 8)
    private String ouvertureMatin2;
    
    /**
     * Horaire fermeture matin2
     * Format hh.mm.ss
     */
    @UnitedCommareaField(position = 11, longueur = 8)
    private String fermetureMatin2;
    
    /**
     * Horaire ouverture apres midi2
     * Format hh.mm.ss
     */
    @UnitedCommareaField(position = 12, longueur = 8)
    private String ouvertureApresMidi2;
    
    /**
     * Horaire fermeture apres midi2
     * Format hh.mm.ss
     */
    @UnitedCommareaField(position = 13, longueur = 8)
    private String fermetureApresMidi2;

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

	@Override
	public String toString() {
		return "AgenceUP1Description [nomAgence=" + nomAgence + ", numeroTel="
				+ numeroTel + ", numeroFax=" + numeroFax + ", plage1=" + plage1
				+ ", ouvertureMatin1=" + ouvertureMatin1 + ", fermetureMatin1="
				+ fermetureMatin1 + ", ouvertureApresMidi1="
				+ ouvertureApresMidi1 + ", fermetureApresMidi1="
				+ fermetureApresMidi1 + ", plage2=" + plage2
				+ ", ouvertureMatin2=" + ouvertureMatin2 + ", fermetureMatin2="
				+ fermetureMatin2 + ", ouvertureApresMidi2="
				+ ouvertureApresMidi2 + ", fermetureApresMidi2="
				+ fermetureApresMidi2 + "]";
	}
    
    
}
