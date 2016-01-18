package com.natixis.cco.upconnect.modelnfi.historique;

import java.math.BigDecimal;
import java.util.Date;

public class HistoDescriptionV1 {



	private String dateOperation;

	   
    private String codeOperation;

    private BigDecimal montantOperation;

    
    private String idOperation;

  
    private String dateFonctionnelle2;

    private String nomBanqueDePrelevement;

  
    private String lieuEtNumeroMobile;
    
    private String numeroCheque;



	public String getCodeOperation() {
		return codeOperation;
	}

	public void setCodeOperation(String codeOperation) {
		this.codeOperation = codeOperation;
	}

	public BigDecimal getMontantOperation() {
		return montantOperation;
	}

	public void setMontantOperation(BigDecimal montantOperation) {
		this.montantOperation = montantOperation;
	}

	public String getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(String idOperation) {
		this.idOperation = idOperation;
	}



	public String getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
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




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HistoDescriptionV1 [dateOperation=");
		builder.append(dateOperation);
		builder.append(", codeOperation=");
		builder.append(codeOperation);
		builder.append(", montantOperation=");
		builder.append(montantOperation);
		builder.append(", idOperation=");
		builder.append(idOperation);
		builder.append(", dateFonctionnelle2=");
		builder.append(dateFonctionnelle2);
		builder.append(", nomBanqueDePrelevement=");
		builder.append(nomBanqueDePrelevement);
		builder.append(", lieuEtNumeroMobile=");
		builder.append(lieuEtNumeroMobile);
		builder.append(", numeroCheque=");
		builder.append(numeroCheque);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
