package com.natixis.cco.upconnect.commarea.historique;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescription;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

public class HistoResponseDescription implements UnitedCommareaDescription{
	
	 /**
     * EIMDCDOOUT-DATEOPE
     */
    @UnitedCommareaField(position = 1, longueur = 8)
    private String dateOperation;

    /**
     * EIMDCDOOUTCODEOPE
     */
    @UnitedCommareaField(position = 2, longueur = 3)
    private String codeOperation;

    /**
     * EIMDCDOOUT-MTOPE (en centimes)+
     */
    @UnitedCommareaField(position = 3, longueur = 11)
    private String montantOperation;

    /**
     * EIMDCDOOUTTIMESTAMPOPE
     */
    @UnitedCommareaField(position = 4, longueur = 26)
    private String idOperation;

    /***
     * EIMDCDOOUTDATFONC2
     */
    @UnitedCommareaField(position = 5, longueur = 10)
    private String dateFonctionnelle2;

    /***
     * EIMDCDOOUTNOMBQE
     */
    @UnitedCommareaField(position = 6, longueur = 40)
    private String nomBanqueDePrelevement;

    /**
     * EIMDCDOOUT-NUMMOB
     */
    @UnitedCommareaField(position = 7, longueur = 30)
    private String lieuEtNumeroMobile;

    /**
     * EIMDCDOOUTNUMCHQE
     */
    @UnitedCommareaField(position = 8, longueur = 3)
    private String numeroCheque;

	public String getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getCodeOperation() {
		return codeOperation;
	}

	public void setCodeOperation(String codeOperation) {
		this.codeOperation = codeOperation;
	}

	public String getMontantOperation() {
		return montantOperation;
	}

	public void setMontantOperation(String montantOperation) {
		this.montantOperation = montantOperation;
	}

	public String getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(String idOperation) {
		this.idOperation = idOperation;
	}

	public String getDateFonctionnelle2() {
		return dateFonctionnelle2;
	}

	public void setDateFonctionnelle2(String dateFonctionnelle2) {
		this.dateFonctionnelle2 = dateFonctionnelle2;
	}

	public String getNomBanqueDePrelevement() {
		return nomBanqueDePrelevement;
	}

	public void setNomBanqueDePrelevement(String nomBanqueDePrelevement) {
		this.nomBanqueDePrelevement = nomBanqueDePrelevement;
	}

	public String getLieuEtNumeroMobile() {
		return lieuEtNumeroMobile;
	}

	public void setLieuEtNumeroMobile(String lieuEtNumeroMobile) {
		this.lieuEtNumeroMobile = lieuEtNumeroMobile;
	}

	public String getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	
	
	
	
	
	

}
