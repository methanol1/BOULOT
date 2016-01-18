package com.natixis.cco.upconnect.commarea.agence;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaObject;

/**
 * Cette classe ajoute la description fonctionnelle à l'appel United Agence.
 * 
 * La commarea reponse. Sa longueur est de  : 130 (techn) + 182 (Fonctionn) = 312
 * 
 * 
 * @author steph
 *
 */
public class AgenceUP1CommareaDescriptionResponse extends
		UnitedCommareaDescriptionHeader {

	@UnitedCommareaObject(position=17, longueur=182)
	private AgenceUP1Description agence;

	public AgenceUP1Description getAgence() {
		return agence;
	}

	public void setAgence(AgenceUP1Description agence) {
		this.agence = agence;
	}

	@Override
	public String toString() {
		return "AgenceUP1CommareaDescriptionResponse [agence="
				+ agence + ", getTypeMessage()=" + getTypeMessage()
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
