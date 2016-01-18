package com.natixis.cco.upconnect.commarea.dmen;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaObject;

/**
 * Longueur attendu de la réponse UP : 780 (=taille de la question) 
 * 	130 pour la partie header
 *  56 pour l'objet DMenUP1Description
 *  594 pour atteindre 780...avec un filler
 * @author fleuryst
 *
 */
public class DMenUP1CommareaDescriptionResponse extends UnitedCommareaDescriptionHeader {

	@UnitedCommareaObject(position=17, longueur=56)
	private DMenUP1Description dmen;
	
	@UnitedCommareaField(position=27, longueur=594)
	private String filler;

	public DMenUP1Description getDmen() {
		return dmen;
	}

	public void setDmen(DMenUP1Description dmen) {
		this.dmen = dmen;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}
}
