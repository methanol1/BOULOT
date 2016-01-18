package com.natixis.cco.upconnect.modelnfi.rachat;

public class RachatV1Header {
	private String idErreurMainframe;

	private String idFctAppelee;

	private String codePaysISO;

	private String codeRetourSimple;

	private String codeRetourPrecis;
	
	private String typeMessage;
	
	private String numVersionEntete;
	
	private String programmeJavaAppelant;
	
	private String programmeMainframeAppele;
	
	private String idRequete;
	
	private String typePasserelle;
	
	private String idPartenaire;
	
	private String idCanal;

	public String getIdErreurMainframe() {
		return idErreurMainframe;
	}

	public void setIdErreurMainframe(String idErreurMainframe) {
		this.idErreurMainframe = idErreurMainframe;
	}

	public String getIdFctAppelee() {
		return idFctAppelee;
	}

	public void setIdFctAppelee(String idFctAppelee) {
		this.idFctAppelee = idFctAppelee;
	}

	public String getCodePaysISO() {
		return codePaysISO;
	}

	public void setCodePaysISO(String codePaysISO) {
		this.codePaysISO = codePaysISO;
	}

	public String getCodeRetourSimple() {
		return codeRetourSimple;
	}

	public void setCodeRetourSimple(String codeRetourSimple) {
		this.codeRetourSimple = codeRetourSimple;
	}

	public String getCodeRetourPrecis() {
		return codeRetourPrecis;
	}

	public void setCodeRetourPrecis(String codeRetourPrecis) {
		this.codeRetourPrecis = codeRetourPrecis;
	}

	public String getTypeMessage() {
		return typeMessage;
	}

	public void setTypeMessage(String typeMessage) {
		this.typeMessage = typeMessage;
	}

	public String getNumVersionEntete() {
		return numVersionEntete;
	}

	public void setNumVersionEntete(String numVersionEntete) {
		this.numVersionEntete = numVersionEntete;
	}

	public String getProgrammeJavaAppelant() {
		return programmeJavaAppelant;
	}

	public void setProgrammeJavaAppelant(String programmeJavaAppelant) {
		this.programmeJavaAppelant = programmeJavaAppelant;
	}

	public String getProgrammeMainframeAppele() {
		return programmeMainframeAppele;
	}

	public void setProgrammeMainframeAppele(String programmeMainframeAppele) {
		this.programmeMainframeAppele = programmeMainframeAppele;
	}

	public String getIdRequete() {
		return idRequete;
	}

	public void setIdRequete(String idRequete) {
		this.idRequete = idRequete;
	}

	public String getTypePasserelle() {
		return typePasserelle;
	}

	public void setTypePasserelle(String typePasserelle) {
		this.typePasserelle = typePasserelle;
	}

	public String getIdPartenaire() {
		return idPartenaire;
	}

	public void setIdPartenaire(String idPartenaire) {
		this.idPartenaire = idPartenaire;
	}

	public String getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}

	@Override
	public String toString() {
		return "RachatV1Header [idErreurMainframe=" + idErreurMainframe
				+ ", idFctAppelee=" + idFctAppelee + ", codePaysISO="
				+ codePaysISO + ", codeRetourSimple=" + codeRetourSimple
				+ ", codeRetourPrecis=" + codeRetourPrecis + ", typeMessage="
				+ typeMessage + ", numVersionEntete=" + numVersionEntete
				+ ", programmeJavaAppelant=" + programmeJavaAppelant
				+ ", programmeMainframeAppele=" + programmeMainframeAppele
				+ ", idRequete=" + idRequete + ", typePasserelle="
				+ typePasserelle + ", idPartenaire=" + idPartenaire
				+ ", idCanal=" + idCanal + "]";
	}
	
	
}
