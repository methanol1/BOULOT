package com.natixis.cco.upconnect.modelUP.dcrl;

import java.util.List;

public class InputDCrlUP1Description {
	
	private List<InputBaremeUP1> baremes;
	
	private String tauxAssurance;
	
	private String montantCapitalDu;
	
	private String montantFinan;
	
	private String date;
	
	private String nbJokers;
	
	private String montantMens;
	
	private String nbEcheance;
	
	private String pasMens;

	public List<InputBaremeUP1> getBaremes() {
		return baremes;
	}

	public void setBaremes(List<InputBaremeUP1> baremes) {
		this.baremes = baremes;
	}

	public String getTauxAssurance() {
		return tauxAssurance;
	}

	public void setTauxAssurance(String tauxAssurance) {
		this.tauxAssurance = tauxAssurance;
	}

	public String getMontantCapitalDu() {
		return montantCapitalDu;
	}

	public void setMontantCapitalDu(String montantCapitalDu) {
		this.montantCapitalDu = montantCapitalDu;
	}

	public String getMontantFinan() {
		return montantFinan;
	}

	public void setMontantFinan(String montantFinan) {
		this.montantFinan = montantFinan;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNbJokers() {
		return nbJokers;
	}

	public void setNbJokers(String nbJokers) {
		this.nbJokers = nbJokers;
	}

	public String getMontantMens() {
		return montantMens;
	}

	public void setMontantMens(String montantMens) {
		this.montantMens = montantMens;
	}

	public String getNbEcheance() {
		return nbEcheance;
	}

	public void setNbEcheance(String nbEcheance) {
		this.nbEcheance = nbEcheance;
	}

	public String getPasMens() {
		return pasMens;
	}

	public void setPasMens(String pasMens) {
		this.pasMens = pasMens;
	}

	@Override
	public String toString() {
		return "InputDCrlUP1 [baremes=" + baremes + ", tauxAssurance="
				+ tauxAssurance + ", montantCapitalDu=" + montantCapitalDu
				+ ", montantFinan=" + montantFinan + ", date=" + date
				+ ", nbJokers=" + nbJokers + ", montantMens=" + montantMens
				+ ", nbEcheance=" + nbEcheance + ", pasMens=" + pasMens + "]";
	}
	
	

}
