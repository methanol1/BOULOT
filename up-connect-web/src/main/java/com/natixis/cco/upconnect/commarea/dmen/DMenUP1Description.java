package com.natixis.cco.upconnect.commarea.dmen;

import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

/**
 * Longueur : 56
 * 
 * @author fleuryst
 *
 */
public class DMenUP1Description {

	@UnitedCommareaField(position =	1, longueur = 1)
	private String codeRetour;
	
	@UnitedCommareaField(position =	2, longueur = 4)
	private String codeRetourComp;
	
	@UnitedCommareaField(position =	3, longueur = 8)
	private String mensAAppliquer;
	
	@UnitedCommareaField(position =	4, longueur = 8)
	private String mensCalculee;
	
	@UnitedCommareaField(position =	5, longueur = 3)
	private String duree;
	
	@UnitedCommareaField(position =	6, longueur = 8)
	private String montantDerniereMens;
	
	@UnitedCommareaField(position =	7, longueur = 8)
	private String mensMax;
	
	@UnitedCommareaField(position =	8, longueur = 8)
	private String coutTotInterets;
	
	@UnitedCommareaField(position =	9, longueur = 8)
	private String coutTotAssurance;

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

	public String getMensAAppliquer() {
		return mensAAppliquer;
	}

	public void setMensAAppliquer(String mensAAppliquer) {
		this.mensAAppliquer = mensAAppliquer;
	}

	public String getMensCalculee() {
		return mensCalculee;
	}

	public void setMensCalculee(String mensCalculee) {
		this.mensCalculee = mensCalculee;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getMontantDerniereMens() {
		return montantDerniereMens;
	}

	public void setMontantDerniereMens(String montantDerniereMens) {
		this.montantDerniereMens = montantDerniereMens;
	}

	public String getMensMax() {
		return mensMax;
	}

	public void setMensMax(String mensMax) {
		this.mensMax = mensMax;
	}

	public String getCoutTotInterets() {
		return coutTotInterets;
	}

	public void setCoutTotInterets(String coutTotInterets) {
		this.coutTotInterets = coutTotInterets;
	}

	public String getCoutTotAssurance() {
		return coutTotAssurance;
	}

	public void setCoutTotAssurance(String coutTotAssurance) {
		this.coutTotAssurance = coutTotAssurance;
	}
	
}
