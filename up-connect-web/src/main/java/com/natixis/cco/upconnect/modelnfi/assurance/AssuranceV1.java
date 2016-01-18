package com.natixis.cco.upconnect.modelnfi.assurance;

import java.math.BigDecimal;

public class AssuranceV1 {
	
	private AssuranceV1Header header = new AssuranceV1Header();
	
	/**
	 * Taux mensuel d'assurance souscripteur
	 */
	
	private BigDecimal tauxMensSousc;
	
	/**
	 * Taux mensuel d'assurance co-souscripteur
	 */
	private BigDecimal tauxMensCoSousc;

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
	private BigDecimal primeSous;
	
	/**
	 * Prime forfaitaire assurance co-souscripteur
	 */
	private BigDecimal primeCoSous;
	
	private String codeConvention;
	
	private String dateSous;
	
	private String dateCoSous;

	public AssuranceV1Header getHeader() {
		return header;
	}

	public void setHeader(AssuranceV1Header header) {
		this.header = header;
	}

	public BigDecimal getTauxMensSousc() {
		return tauxMensSousc;
	}

	public void setTauxMensSousc(BigDecimal tauxMensSousc) {
		this.tauxMensSousc = tauxMensSousc;
	}

	public BigDecimal getTauxMensCoSousc() {
		return tauxMensCoSousc;
	}

	public void setTauxMensCoSousc(BigDecimal tauxMensCoSousc) {
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

	public BigDecimal getPrimeSous() {
		return primeSous;
	}

	public void setPrimeSous(BigDecimal primeSous) {
		this.primeSous = primeSous;
	}

	public BigDecimal getPrimeCoSous() {
		return primeCoSous;
	}

	public void setPrimeCoSous(BigDecimal primeCoSous) {
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
