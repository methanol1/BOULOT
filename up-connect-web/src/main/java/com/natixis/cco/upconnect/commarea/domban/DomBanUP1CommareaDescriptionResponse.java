package com.natixis.cco.upconnect.commarea.domban;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaObject;

/**
 * Cette classe ajoute la description fonctionnelle à l'appel United Domiciliation Bancaire.
 * 
 * La commarea reponse. Sa longueur est de  : 130 (techn) + 210 (Fonctionn) = 340
 * 
 * 
 * @author steph
 *
 */
public class DomBanUP1CommareaDescriptionResponse extends
		UnitedCommareaDescriptionHeader {

	@UnitedCommareaObject(position=17, longueur=210)
	private DomBanUP1Description domban;

	public DomBanUP1Description getDomban() {
		return domban;
	}

	public void setDomban(DomBanUP1Description domban) {
		this.domban = domban;
	}

	@Override
	public String toString() {
		return "DomBanUP1CommareaDescriptionResponse [domban=" + domban
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
				+ ", getFiller2()=" + getFiller2() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
