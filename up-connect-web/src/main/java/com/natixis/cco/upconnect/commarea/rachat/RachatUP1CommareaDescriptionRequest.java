package com.natixis.cco.upconnect.commarea.rachat;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

/**
 * Cette classe ajoute la description fonctionnelle à l'appel United service Rachat version UP1.
 */
public class RachatUP1CommareaDescriptionRequest extends
		UnitedCommareaDescriptionHeader {
	/**
	 * numero de contrat
	 */
	@UnitedCommareaField(position =	17, longueur = 14)
	private String numeroDossier; 
	
	/**
	 * Date de rachat
	 */
	@UnitedCommareaField(position =	18, longueur = 10)
	private String dateRachat;

	public String getNumeroDossier() {
		return numeroDossier;
	}

	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}

	public String getDateRachat() {
		return dateRachat;
	}

	public void setDateRachat(String dateRachat) {
		this.dateRachat = dateRachat;
	}

	@Override
	public String toString() {
		return "RachatUP1CommareaDescriptionRequest [numeroDossier="
				+ numeroDossier + ", dateRachat=" + dateRachat
				+ ", getTypeMessage()=" + getTypeMessage()
				+ ", getNumVersionEntete()=" + getNumVersionEntete()
				+ ", getProgrammeJavaAppelant()=" + getProgrammeJavaAppelant()
				+ ", getProgrammeMainframeAppele()="
				+ getProgrammeMainframeAppele() + ", getIdRequete()="
				+ getIdRequete() + ", getTypePasserelle()="
				+ getTypePasserelle() + ", getIdPartenaire()="
				+ getIdPartenaire() + ", getIdCanal()=" + getIdCanal()
				+ ", getNumeroVersionContratEchange()="
				+ getNumeroVersionContratEchange() + ", getFiller1()="
				+ getFiller1() + ", getIdErreurMainframe()="
				+ getIdErreurMainframe() + ", getIdFctAppelee()="
				+ getIdFctAppelee() + ", getCodePaysISO()=" + getCodePaysISO()
				+ ", getCodeRetourSimple()=" + getCodeRetourSimple()
				+ ", getCodeRetourPrecis()=" + getCodeRetourPrecis()
				+ ", getFiller2()=" + getFiller2() + "]";
	}
	
	
}
