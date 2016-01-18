package com.natixis.cco.upconnect.modelnfi.dmen;

import java.math.BigDecimal;


public class DMenV1 {
	
	private DMenV1Header header = new DMenV1Header();

	
	public DMenV1Header getHeader() {
		return header;
	}

	public void setHeader(DMenV1Header header) {
		this.header = header;
	}

	private String codeRetour;
	private String codeRetourComp;
	private BigDecimal coutTotalAssur; 
	private BigDecimal coutTotalInterets;
	private int dureeRecalculee;
	private BigDecimal montantDerniereMens;
	private BigDecimal montantMensAAppliq;
	private BigDecimal montantMensCalculee;
	private BigDecimal montantMensMaxi;
	private String libelleInformatif;
	private String codeInformatif;
	public String getCodeRetour() {
		return codeRetour;
	}
	public void setCodeRetour(String codeRetour) {
		this.codeRetour = codeRetour;
	}
	public String getCodeRetourComp() {
		return codeRetourComp;
	}
	public void setCodeRetourComp(String codeRetourComp) {
		this.codeRetourComp = codeRetourComp;
	}
	public BigDecimal getCoutTotalAssur() {
		return coutTotalAssur;
	}
	public void setCoutTotalAssur(BigDecimal coutTotalAssur) {
		this.coutTotalAssur = coutTotalAssur;
	}
	public BigDecimal getCoutTotalInterets() {
		return coutTotalInterets;
	}
	public void setCoutTotalInterets(BigDecimal coutTotalInterets) {
		this.coutTotalInterets = coutTotalInterets;
	}
	public int getDureeRecalculee() {
		return dureeRecalculee;
	}
	public void setDureeRecalculee(int dureeRecalculee) {
		this.dureeRecalculee = dureeRecalculee;
	}
	public BigDecimal getMontantDerniereMens() {
		return montantDerniereMens;
	}
	public void setMontantDerniereMens(BigDecimal montantDerniereMens) {
		this.montantDerniereMens = montantDerniereMens;
	}
	public BigDecimal getMontantMensAAppliq() {
		return montantMensAAppliq;
	}
	public void setMontantMensAAppliq(BigDecimal montantMensAAppliq) {
		this.montantMensAAppliq = montantMensAAppliq;
	}
	public BigDecimal getMontantMensCalculee() {
		return montantMensCalculee;
	}
	public void setMontantMensCalculee(BigDecimal montantMensCalculee) {
		this.montantMensCalculee = montantMensCalculee;
	}
	public BigDecimal getMontantMensMaxi() {
		return montantMensMaxi;
	}
	public void setMontantMensMaxi(BigDecimal montantMensMaxi) {
		this.montantMensMaxi = montantMensMaxi;
	}
	
	public String getLibelleInformatif() {
		return libelleInformatif;
	}

	public void setLibelleInformatif(String libelleInformatif) {
		this.libelleInformatif = libelleInformatif;
	}

	public String getCodeInformatif() {
		return codeInformatif;
	}
	public void setCodeInformatif(String codeInformatif) {
		this.codeInformatif = codeInformatif;
	}
}
