package com.natixis.cco.upconnect.modelUP.dcrl;

import java.util.List;

import com.natixis.cco.upconnect.commarea.dcrl.TaegUP1Description;

public class OutputDCrlUP1Description {
	
	
	//BEADY
	private String montantMensCalc;
	
	private String nbEcheanceCalc;

	private String coutTotalInteret;
	
	private String coutTotalAssurance;
	
	private String taea;	
	
	private List<TaegUP1Description> taegs;
	
	private String montantAssurancePremiereMens;	
	
	private String montantDerniereMens;

	private String codeRetCalc;
	
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
