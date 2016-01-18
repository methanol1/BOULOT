package com.natixis.cco.upconnect.commarea.dcrl;

import java.util.List;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescription;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaList;

public class DCrlUP1RequestDescription implements UnitedCommareaDescription{

	/**
	 * EIMDCRL-IN-LIST-TRANCHE-BAREME
	 */
	@UnitedCommareaList(position=1, longueur=24, nombre=5)
	private List<BaremeUP1Description> baremes;
	
	/**
	 * EIMDCRL-IN-TX-ASSMENS
	 */
	@UnitedCommareaField(position=16, longueur=8)
	private String tauxAssurance;
	
	/**
	 * EIMDCRL-IN-MT-CRD
	 */
	@UnitedCommareaField(position=17, longueur=8)
	private String montantCapitalDu;
	
	/**
	 * EIMDCRL-IN-MT-FINANCE
	 */
	@UnitedCommareaField(position=18, longueur=8)
	private String montantFinan;
	
	/**
	 * EIMDCRL-IN-DATE-FINANCE
	 */
	@UnitedCommareaField(position=19, longueur=8)
	private String date;
	
	/**
	 * EIMDCRL-IN-NB-JOKERS
	 */
	@UnitedCommareaField(position=20, longueur=1)
	private String nbJokers;
	
	/**
	 * EIMDCRL-IN-MT-MENS
	 */
	@UnitedCommareaField(position=21, longueur=8)
	private String montantMens;
	/**
	 * EIMDCRL-IN-NB-ECHE
	 */
	@UnitedCommareaField(position=22, longueur=2)
	private String nbEcheance;
	
	/**
	 * EIMDCRL-IN-MT-PASMENS
	 */
	@UnitedCommareaField(position=23, longueur=4)
	private String pasMens;


	public List<BaremeUP1Description> getBaremes() {
		return baremes;
	}


	public void setBaremes(List<BaremeUP1Description> baremes) {
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
	

}
