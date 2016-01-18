package com.natixis.cco.upconnect.commarea.domban;

import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;


/**
 * Longueur : 210
 * 
 * @author fleuryst
 *
 */
public class DomBanUP1Description {

	/**
     * Code BIC
     */
    @UnitedCommareaField(position = 1, longueur = 11)
    private String codeBic;
    
    /**
     * Code IBAN
     */
    @UnitedCommareaField(position = 2, longueur = 34)
    private String codeIban;
    
    /**
     * Nom du titulaire
     */
    @UnitedCommareaField(position = 3, longueur = 50)
    private String nomTitulaire; 
    
    /**
     * Date de création
     */
    @UnitedCommareaField(position = 4, longueur = 10)
    private String dateCreation; 
    
    /**
     * Année d'ouverture
     */
    @UnitedCommareaField(position = 5, longueur = 4)
    private String anneeOuverture;
    
    /**
     * Type de carte
     */
    @UnitedCommareaField(position = 6, longueur = 1)
    private String typeCarte;
    
    /**
     * Libellé de domiciliation
     */
    @UnitedCommareaField(position = 7, longueur = 50)
    private String libelleDomiciliation;
    
    /**
     * Code du titulaire du compte
     */
    @UnitedCommareaField(position = 8, longueur = 1)
    private String codeTitulaireCompte;
    
    /**
     * Code identifiant domiciliation bancaire
     */
    @UnitedCommareaField(position = 9, longueur = 11)
    private String codeIdentifiant; 
    
    /**
     * Code Rum
     */
    @UnitedCommareaField(position = 10, longueur = 35)
    private String codeRum;
    
    /**
     * Statut du mandat
     */
    @UnitedCommareaField(position = 11, longueur = 3)
    private String statutMandat;

	public String getCodeBic() {
		return codeBic;
	}

	public void setCodeBic(String codeBic) {
		this.codeBic = codeBic;
	}

	public String getCodeIban() {
		return codeIban;
	}

	public void setCodeIban(String codeIban) {
		this.codeIban = codeIban;
	}

	public String getNomTitulaire() {
		return nomTitulaire;
	}

	public void setNomTitulaire(String nomTitulaire) {
		this.nomTitulaire = nomTitulaire;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getAnneeOuverture() {
		return anneeOuverture;
	}

	public void setAnneeOuverture(String anneeOuverture) {
		this.anneeOuverture = anneeOuverture;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public String getLibelleDomiciliation() {
		return libelleDomiciliation;
	}

	public void setLibelleDomiciliation(String libelleDomiciliation) {
		this.libelleDomiciliation = libelleDomiciliation;
	}

	public String getCodeTitulaireCompte() {
		return codeTitulaireCompte;
	}

	public void setCodeTitulaireCompte(String codeTitulaireCompte) {
		this.codeTitulaireCompte = codeTitulaireCompte;
	}

	public String getCodeIdentifiant() {
		return codeIdentifiant;
	}

	public void setCodeIdentifiant(String codeIdentifiant) {
		this.codeIdentifiant = codeIdentifiant;
	}

	public String getCodeRum() {
		return codeRum;
	}

	public void setCodeRum(String codeRum) {
		this.codeRum = codeRum;
	}

	public String getStatutMandat() {
		return statutMandat;
	}

	public void setStatutMandat(String statutMandat) {
		this.statutMandat = statutMandat;
	}

	@Override
	public String toString() {
		return "DomBanUP1Description [codeBic=" + codeBic + ", codeIban="
				+ codeIban + ", nomTitulaire=" + nomTitulaire
				+ ", dateCreation=" + dateCreation + ", anneeOuverture="
				+ anneeOuverture + ", typeCarte=" + typeCarte
				+ ", libelleDomiciliation=" + libelleDomiciliation
				+ ", codeTitulaireCompte=" + codeTitulaireCompte
				+ ", codeIdentifiant=" + codeIdentifiant + ", codeRum="
				+ codeRum + ", statutMandat=" + statutMandat + "]";
	}
    
    
}
