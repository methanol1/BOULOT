package com.natixis.cco.upconnect.commarea.assurance;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaObject;

/**
 * Cette classe ajoute la description fonctionnelle à l'appel United Assurance.
 * @author steph
 *
 */
public class AssuranceUP1CommareaDescriptionResponse extends
		UnitedCommareaDescriptionHeader {

	@UnitedCommareaObject(position=17, longueur=75)
	private AssuranceUP1Description assurance;

	public AssuranceUP1Description getAssurance() {
		return assurance;
	}

	public void setAssurance(AssuranceUP1Description assurance) {
		this.assurance = assurance;
	}

	@Override
	public String toString() {
		return "AssuranceUP1CommareaDescriptionResponse [assurance="
				+ assurance + ", getTypeMessage()=" + getTypeMessage()
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
