package com.natixis.cco.upconnect.commarea.contrat;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaObject;

/**
 * Cette classe ajoute la description fonctionnelle à l'appel United InfosContrat.
 */
public class ContratUP1CommareaDescriptionResponse extends UnitedCommareaDescriptionHeader { 
	
	@UnitedCommareaObject(position=17, longueur=387)
	private ContratUP1Description contrat;

	public ContratUP1Description getContrat() {
		return contrat;
	}

	public void setContrat(ContratUP1Description contrat) {
		this.contrat = contrat;
	}

	@Override
	public String toString() {
		return "ContratUP1CommareaDescriptionResponse [contrat=" + contrat
				+ ", getContrat()=" + getContrat() + ", getTypeMessage()="
				+ getTypeMessage() + ", getNumVersionEntete()="
				+ getNumVersionEntete() + ", getProgrammeJavaAppelant()="
				+ getProgrammeJavaAppelant()
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
				+ ", getFiller2()=" + getFiller2()+ "]";
	}
	
}
