package com.natixis.cco.upconnect.modelUP.domban;

import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

public class DomBanUP1Header {
/* Entête technique */
	
	@UnitedCommareaField(position=1, longueur=1)
	private String typeMessage;
	
	@UnitedCommareaField(position=2, longueur=2)
	private String numVersionEntete;
	
	@UnitedCommareaField(position=3, longueur=15)
	private String programmeJavaAppelant;
	
	@UnitedCommareaField(position=4, longueur=8)
	private String programmeMainframeAppele;
	
	@UnitedCommareaField(position=5, longueur=20)
	private String idRequete;
	
	@UnitedCommareaField(position=6, longueur=1)
	private String typePasserelle;
	
	@UnitedCommareaField(position=7, longueur=3)
	private String idPartenaire;
	
	@UnitedCommareaField(position=8, longueur=1)
	private String idCanal;

	/**
	 * ZHCTGMQ-TECNVSXCH
	 */
	@UnitedCommareaField(position=9, longueur=1)
	private String numeroVersionContratEchange;
	
	@UnitedCommareaField(position=10, longueur=2)
	private String filler1;
	
	/* Ent�te applicatif */
	@UnitedCommareaField(position=11, longueur=26)
	private String idErreurMainframe;
	
	@UnitedCommareaField(position=12, longueur=20)
	private String idFctAppelee;
	
	@UnitedCommareaField(position=13, longueur=3)
	private String codePaysISO;
	
	@UnitedCommareaField(position=14, longueur=1)
	private String codeRetourSimple;
	
	@UnitedCommareaField(position=15, longueur=6)
	private String codeRetourPrecis;
	
	@UnitedCommareaField(position=16, longueur=20)
	private String filler2;

	/*
	 * Getters / Setters
	 */
	
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

	public String getNumeroVersionContratEchange() {
		return numeroVersionContratEchange;
	}

	public void setNumeroVersionContratEchange(String numeroVersionContratEchange) {
		this.numeroVersionContratEchange = numeroVersionContratEchange;
	}

	public String getFiller1() {
		return filler1;
	}

	public void setFiller1(String filler1) {
		this.filler1 = filler1;
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

	public String getFiller2() {
		return filler2;
	}

	public void setFiller2(String filler2) {
		this.filler2 = filler2;
	}
}
