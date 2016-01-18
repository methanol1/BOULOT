package com.natixis.cco.upconnect.modelnfi.domban;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DomBanV1 {
	
	private DomBanV1Header header = new DomBanV1Header();

	public DomBanV1Header getHeader() {
		return header;
	}

	public void setHeader(DomBanV1Header header) {
		this.header = header;
	}

	private String codeBic;
	private String codeIban;
	private String nomTitulaire;
	private String dateCreation;
	private int anneeOuverture;
	private String typeCarte;
	private String libelleDomiciliation;
	private String codeTitulaire;
	private long codeIdentifiant;
	private String codeRum;
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

	public int getAnneeOuverture() {
		return anneeOuverture;
	}

	public void setAnneeOuverture(int anneeOuverture) {
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

	public String getCodeTitulaire() {
		return codeTitulaire;
	}

	public void setCodeTitulaire(String codeTitulaire) {
		this.codeTitulaire = codeTitulaire;
	}

	public long getCodeIdentifiant() {
		return codeIdentifiant;
	}

	public void setCodeIdentifiant(long codeIdentifiant) {
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
	

}
