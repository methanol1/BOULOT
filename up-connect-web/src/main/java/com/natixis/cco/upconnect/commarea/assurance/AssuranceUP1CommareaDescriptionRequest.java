package com.natixis.cco.upconnect.commarea.assurance;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

public class AssuranceUP1CommareaDescriptionRequest extends
		UnitedCommareaDescriptionHeader {

	@UnitedCommareaField(position=17, longueur=14)
	private String numeroContrat;
	
	@UnitedCommareaField(position=18, longueur=10)
	private String dateSignature;
	
	@UnitedCommareaField(position=19, longueur=51)
	private String filler;

	public String getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(String numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	public String getDateSignature() {
		return dateSignature;
	}

	public void setDateSignature(String dateSignature) {
		this.dateSignature = dateSignature;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	@Override
	public String toString() {
		return "AssuranceUP1CommareaDescriptionRequest [numeroContrat="
				+ numeroContrat + ", dateSignature=" + dateSignature
				+ ", filler=" + filler + ", getTypeMessage()="
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
