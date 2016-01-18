package com.natixis.cco.upconnect.commarea.agence;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;



/**
 * La commarea requete. Sa longueur est de  : 130 (techn) + 182 (Fonctionn) = 312
 * 
 * @author fleuryst
 *
 */
public class AgenceUP1CommareaDescriptionRequest extends
		UnitedCommareaDescriptionHeader {

	@UnitedCommareaField(position=17, longueur=3)
	private String numeroAgence;

	@UnitedCommareaField(position=18, longueur=179)
	private String filler;

	public String getNumeroAgence() {
		return numeroAgence;
	}

	public void setNumeroAgence(String numeroAgence) {
		this.numeroAgence = numeroAgence;
	}

	@Override
	public String toString() {
		return "AgenceUP1CommareaDescriptionRequest [numeroAgence="
				+ numeroAgence + "]";
	}

	
}
