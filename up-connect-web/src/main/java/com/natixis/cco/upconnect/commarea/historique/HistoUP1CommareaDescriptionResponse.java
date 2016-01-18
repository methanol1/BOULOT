package com.natixis.cco.upconnect.commarea.historique;

import java.util.List;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaList;

public class HistoUP1CommareaDescriptionResponse extends UnitedCommareaDescriptionHeader{
	
	
	/**
	 * EIMDCDOOUTTOPFINLISTE 
	 */
	@UnitedCommareaField(position = 17, longueur = 1)
	private String finDeListe;
	
	/**
	 * EIMDCDOOUT-DONNEES 
	 * 40 occurences maximum - longueur d une Operation 131
	 */
	@UnitedCommareaList(position = 18, nombre = 40, longueur = 131)
	private List<HistoResponseDescription> tableauDonneesSpecifiquesCB;


	public String getFinDeListe() {
		return finDeListe;
	}

	public void setFinDeListe(String finDeListe) {
		this.finDeListe = finDeListe;
	}

	public List<HistoResponseDescription> getTableauDonneesSpecifiquesCB() {
		return tableauDonneesSpecifiquesCB;
	}

	public void setTableauDonneesSpecifiquesCB(
			List<HistoResponseDescription> tableauDonneesSpecifiquesCB) {
		this.tableauDonneesSpecifiquesCB = tableauDonneesSpecifiquesCB;
	}
	
	

}
