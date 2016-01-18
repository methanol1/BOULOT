package com.natixis.cco.upconnect.commarea.dcrl;

import java.util.List;

import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaList;

public class DCrlUP1ResponseDescription {


	/**
	 * EIMDCRL-OUT-MT-MENS
	 */
	@UnitedCommareaField(position =	1, longueur = 8)
	private String montantMensCalc;
	
	/**
	 * EIMDCRL-OUT-NB-ECHE
	 */
	@UnitedCommareaField(position =	2, longueur = 2)
	private String nbEcheanceCalc;
	
	/**
	 * EIMDCRL-OUT-MT-TOT-INT
	 */
	@UnitedCommareaField(position =	3, longueur = 8)
	private String coutTotalInteret;
	
	/**
	 * EIMDCRL-OUT-MT-TOT-ASS
	 */
	@UnitedCommareaField(position =	4, longueur =8)
	private String coutTotalAssurance;
	
	/**
	 * EIMDCRL-OUT-TAEA
	 */
	@UnitedCommareaField(position =	5, longueur = 4)
	private String taea;	
	
	/**
	 * EIMDCRL-OUT-MT-MENS
	 */
	@UnitedCommareaList(position=6, longueur=8, nombre=5)
	private List<TaegUP1Description> taegs;
	
	/**
	 * EIMDCRL-OUT-MT-ASS-MENS
	 */
	@UnitedCommareaField(position =	11, longueur = 8)
	private String montantAssurancePremiereMens;	
	
	/**
	 * EIMDCRL-OUT-MT-DER-MENS
	 */
	@UnitedCommareaField(position =	12, longueur = 8)
	private String montantDerniereMens;
	
	
	@UnitedCommareaField(position =13, longueur = 3)
	private String codeRetCalc;
	
	@UnitedCommareaField(position =	14, longueur = 13)
	private String montantFinancable;
	


	public String getMontantMensCalc() {
		return montantMensCalc;
	}

	public void setMontantMensCalc(String montantMensCalc) {
		this.montantMensCalc = montantMensCalc;
	}

	public String getNbEcheanceCalc() {
		return nbEcheanceCalc;
	}

	public void setNbEcheanceCalc(String nbEcheanceCalc) {
		this.nbEcheanceCalc = nbEcheanceCalc;
	}

	public String getCoutTotalInteret() {
		return coutTotalInteret;
	}

	public void setCoutTotalInteret(String coutTotalInteret) {
		this.coutTotalInteret = coutTotalInteret;
	}

	public String getCoutTotalAssurance() {
		return coutTotalAssurance;
	}

	public void setCoutTotalAssurance(String coutTotalAssurance) {
		this.coutTotalAssurance = coutTotalAssurance;
	}

	public String getTaea() {
		return taea;
	}

	public void setTaea(String taea) {
		this.taea = taea;
	}

	

	public List<TaegUP1Description> getTaegs() {
		return taegs;
	}

	public void setTaegs(List<TaegUP1Description> taegs) {
		this.taegs = taegs;
	}

	public String getMontantAssurancePremiereMens() {
		return montantAssurancePremiereMens;
	}

	public void setMontantAssurancePremiereMens(String montantAssurancePremiereMens) {
		this.montantAssurancePremiereMens = montantAssurancePremiereMens;
	}

	public String getMontantDerniereMens() {
		return montantDerniereMens;
	}

	public void setMontantDerniereMens(String montantDerniereMens) {
		this.montantDerniereMens = montantDerniereMens;
	}

	public String getCodeRetCalc() {
		return codeRetCalc;
	}

	public void setCodeRetCalc(String codeRetCalc) {
		this.codeRetCalc = codeRetCalc;
	}

	public String getMontantFinancable() {
		return montantFinancable;
	}

	public void setMontantFinancable(String montantFinancable) {
		this.montantFinancable = montantFinancable;
	}

	
	
	

}
