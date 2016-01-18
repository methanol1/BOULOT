package com.natixis.cco.upconnect.commarea.contrat;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaObject;

/**
 * Cette classe possède la description fonctionnelle de la réponse United InfosContrat.
 */
public class ContratUP2CommareaDescriptionResponse extends UnitedCommareaDescriptionHeader { 
	
	@UnitedCommareaObject(position=17, longueur=409)
	private ContratUP2Description contrat;

	public ContratUP2Description getContrat() {
		return contrat;
	}

	public void setContrat(ContratUP2Description contrat) {
		this.contrat = contrat;
	}

	@Override
	public String toString() {
		return "ContratUP2CommareaDescriptionResponse [contrat=" + contrat
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
				+ ", getFiller2()=" + getFiller2() + "]";
	}
	
	
}
