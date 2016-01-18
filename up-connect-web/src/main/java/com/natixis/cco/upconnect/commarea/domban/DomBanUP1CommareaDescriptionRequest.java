package com.natixis.cco.upconnect.commarea.domban;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;



/**
 * La commarea requete. Sa longueur est de  : 130 (techn) + 210 (Fonctionn) = 340
 * 
 * @author fleuryst
 *
 */
public class DomBanUP1CommareaDescriptionRequest extends
		UnitedCommareaDescriptionHeader {

	@UnitedCommareaField(position=17, longueur=14)
	private String numeroContrat;
	
	@UnitedCommareaField(position=18, longueur=10)
	private String dateUtil;

	@UnitedCommareaField(position=19, longueur=186)
	private String filler;

	public String getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(String numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	public String getDateUtil() {
		return dateUtil;
	}

	public void setDateUtil(String dateUtil) {
		this.dateUtil = dateUtil;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	@Override
	public String toString() {
		return "DomBanUP1CommareaDescriptionRequest [numeroContrat="
				+ numeroContrat + ", dateUtil=" + dateUtil + ", filler="
				+ filler + "]";
	}

	
}
