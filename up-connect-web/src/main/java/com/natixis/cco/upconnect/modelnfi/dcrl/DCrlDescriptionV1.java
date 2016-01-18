package com.natixis.cco.upconnect.modelnfi.dcrl;

import java.math.BigDecimal;
import java.util.List;


public class DCrlDescriptionV1 {
	

	
	private BigDecimal montantMensCalc;
	
	private Integer nbEcheanceCalc;
	
	private BigDecimal coutTotalInteret;
	
	private BigDecimal coutTotalAssurance;
	
	private BigDecimal taea;	
	
	private List<BigDecimal> taegs;
	
	private BigDecimal montantAssurancePremiereMens;	
	
	private BigDecimal montantDerniereMens;
	
	private String codeRetCalc;
	
	private BigDecimal montantFinancable;

	public BigDecimal getMontantMensCalc() {
		return montantMensCalc;
	}

	public void setMontantMensCalc(BigDecimal montantMensCalc) {
		this.montantMensCalc = montantMensCalc;
	}



	public Integer getNbEcheanceCalc() {
		return nbEcheanceCalc;
	}

	public void setNbEcheanceCalc(Integer nbEcheanceCalc) {
		this.nbEcheanceCalc = nbEcheanceCalc;
	}

	public BigDecimal getCoutTotalInteret() {
		return coutTotalInteret;
	}

	public void setCoutTotalInteret(BigDecimal coutTotalInteret) {
		this.coutTotalInteret = coutTotalInteret;
	}

	public BigDecimal getCoutTotalAssurance() {
		return coutTotalAssurance;
	}

	public void setCoutTotalAssurance(BigDecimal coutTotalAssurance) {
		this.coutTotalAssurance = coutTotalAssurance;
	}



	public BigDecimal getTaea() {
		return taea;
	}

	public void setTaea(BigDecimal taea) {
		this.taea = taea;
	}

	public List<BigDecimal> getTaegs() {
		return taegs;
	}

	public void setTaegs(List<BigDecimal> taegs) {
		this.taegs = taegs;
	}

	public BigDecimal getMontantAssurancePremiereMens() {
		return montantAssurancePremiereMens;
	}

	public void setMontantAssurancePremiereMens(
			BigDecimal montantAssurancePremiereMens) {
		this.montantAssurancePremiereMens = montantAssurancePremiereMens;
	}

	public BigDecimal getMontantDerniereMens() {
		return montantDerniereMens;
	}

	public void setMontantDerniereMens(BigDecimal montantDerniereMens) {
		this.montantDerniereMens = montantDerniereMens;
	}

	public String getCodeRetCalc() {
		return codeRetCalc;
	}

	public void setCodeRetCalc(String codeRetCalc) {
		this.codeRetCalc = codeRetCalc;
	}

	public BigDecimal getMontantFinancable() {
		return montantFinancable;
	}

	public void setMontantFinancable(BigDecimal montantFinancable) {
		this.montantFinancable = montantFinancable;
	}

	
	
	

}
