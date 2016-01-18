package com.natixis.cco.upconnect.modelnfi.rachat;

import java.math.BigDecimal;

public class RachatV1 {
	
	private RachatV1Header header = new RachatV1Header();
	
	private BigDecimal montantTheoIra;
	
	private BigDecimal montantSoldeAnti;
	
	private BigDecimal tauxIra;

	public RachatV1Header getHeader() {
		return header;
	}

	public void setHeader(RachatV1Header header) {
		this.header = header;
	}

	public BigDecimal getMontantTheoIra() {
		return montantTheoIra;
	}

	public void setMontantTheoIra(BigDecimal montantTheoIra) {
		this.montantTheoIra = montantTheoIra;
	}

	public BigDecimal getMontantSoldeAnti() {
		return montantSoldeAnti;
	}

	public void setMontantSoldeAnti(BigDecimal montantSoldeAnti) {
		this.montantSoldeAnti = montantSoldeAnti;
	}

	public BigDecimal getTauxIra() {
		return tauxIra;
	}

	public void setTauxIra(BigDecimal tauxIra) {
		this.tauxIra = tauxIra;
	}

	@Override
	public String toString() {
		return "RachatV1 [header=" + header + ", montantTheoIra="
				+ montantTheoIra + ", montantSoldeAnti=" + montantSoldeAnti
				+ ", tauxIra=" + tauxIra + "]";
	}

}
