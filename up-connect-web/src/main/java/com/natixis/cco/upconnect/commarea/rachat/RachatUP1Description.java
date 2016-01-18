package com.natixis.cco.upconnect.commarea.rachat;

import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

public class RachatUP1Description {

	/**
	 * Montant théorique des IRAs S9(11)V9(2)
	 */
	@UnitedCommareaField(position =	1, longueur = 13)
	private String 	montantTheoIra;
	
	/**
	 * Montant du solde anticipé S9(11)V9(2)
	 */
	@UnitedCommareaField(position =	2, longueur = 13)
	private String 	montantSoldeAnti;
	
	/**
	 * Taux de l'IRA négocié S9(5)V9(2)
	 */
	@UnitedCommareaField(position =	3, longueur = 7)
	private String 	tauxIraNegoc;

	public String getMontantTheoIra() {
		return montantTheoIra;
	}

	public void setMontantTheoIra(String montantTheoIra) {
		this.montantTheoIra = montantTheoIra;
	}

	public String getMontantSoldeAnti() {
		return montantSoldeAnti;
	}

	public void setMontantSoldeAnti(String montantSoldeAnti) {
		this.montantSoldeAnti = montantSoldeAnti;
	}

	public String getTauxIraNegoc() {
		return tauxIraNegoc;
	}

	public void setTauxIraNegoc(String tauxIraNegoc) {
		this.tauxIraNegoc = tauxIraNegoc;
	}

	@Override
	public String toString() {
		return "RachatUP1Description [montantTheoIra=" + montantTheoIra
				+ ", montantSoldeAnti=" + montantSoldeAnti + ", tauxIraNegoc="
				+ tauxIraNegoc + "]";
	}
	
}
