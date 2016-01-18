package com.natixis.cco.upconnect.modelUP.dmen;

/**
 * Cette classe rassemble toutes les données issues du service
 * DMen UP version 1 
 * telles qu'elles sont lues depuis la commarea de sortie.
 * 
 * Nous aurons enlevé les infos techniques et les fillers
 * 
 * C'est une image objet Java de la commarea du service UP version 1.
 * 
 * 
 * @author steph
 *
 */
public class OutputDMenUP1 {

	private String typeMessage;
	
	private String numVersionEntete;
	
	private String programmeJavaAppelant;
	
	private String programmeMainframeAppele;
	
	private String idRequete;
	
	private String typePasserelle;
	
	private String idPartenaire;
	
	private String idCanal;
	
	private String numVersionContratEchang;
	
	private String idErreurMainframe;
	
	private String idFctAppelee;
	
	private String codePaysISO;
	
	private String codeRetourSimple;
	
	private String codeRetourPrecis;
	
	private String codeRetourGal;
	
	private String codeRetourCompl;
	
	private String mensAAppliquer;
	
	private String mensCalculee;
	
	private String dureeCalculee;
	
	private String montantDerniereMens;
	
	private String mensMax;
	
	private String coutTotInterets;
	
	private String coutTotAssur;

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

	public String getNumVersionContratEchang() {
		return numVersionContratEchang;
	}

	public void setNumVersionContratEchang(String numVersionContratEchang) {
		this.numVersionContratEchang = numVersionContratEchang;
	}

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

	public String getCodeRetourGal() {
		return codeRetourGal;
	}

	public void setCodeRetourGal(String codeRetourGal) {
		this.codeRetourGal = codeRetourGal;
	}

	public String getCodeRetourCompl() {
		return codeRetourCompl;
	}

	public void setCodeRetourCompl(String codeRetourCompl) {
		this.codeRetourCompl = codeRetourCompl;
	}

	public String getMensAAppliquer() {
		return mensAAppliquer;
	}

	public void setMensAAppliquer(String mensAAppliquer) {
		this.mensAAppliquer = mensAAppliquer;
	}

	public String getMensCalculee() {
		return mensCalculee;
	}

	public void setMensCalculee(String mensCalculee) {
		this.mensCalculee = mensCalculee;
	}

	public String getDureeCalculee() {
		return dureeCalculee;
	}

	public void setDureeCalculee(String dureeCalculee) {
		this.dureeCalculee = dureeCalculee;
	}

	public String getMontantDerniereMens() {
		return montantDerniereMens;
	}

	public void setMontantDerniereMens(String montantDerniereMens) {
		this.montantDerniereMens = montantDerniereMens;
	}

	public String getMensMax() {
		return mensMax;
	}

	public void setMensMax(String mensMax) {
		this.mensMax = mensMax;
	}

	public String getCoutTotInterets() {
		return coutTotInterets;
	}

	public void setCoutTotInterets(String coutTotInterets) {
		this.coutTotInterets = coutTotInterets;
	}

	public String getCoutTotAssur() {
		return coutTotAssur;
	}

	public void setCoutTotAssur(String coutTotAssur) {
		this.coutTotAssur = coutTotAssur;
	}
	
}
