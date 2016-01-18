package com.natixis.cco.upconnect.commarea.contrat;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

/**
 * Cette classe ajoute la description fonctionnelle à l'appel United InfosContrat version UP1.
 */
public class ContratUP1CommareaDescriptionRequest extends UnitedCommareaDescriptionHeader {

	@UnitedCommareaField(position=17, longueur=14)
	private String numeroContrat;

	public String getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(String numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	@Override
	public String toString() {
		return "ContratUP1CommareaDescriptionRequest [numeroContrat="
				+ numeroContrat + ", getTypeMessage()=" + getTypeMessage()
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
