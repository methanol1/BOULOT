package com.natixis.cco.upconnect.commarea.dmen;

import java.util.List;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.modelnfi.dmen.BaremeV1;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaList;

/**
 * Cette classe ajoute la description fonctionnelle à l'appel United DMEN version UP1.
 */
public class DMenUP1CommareaDescriptionRequest extends UnitedCommareaDescriptionHeader {

	@UnitedCommareaField(position=17, longueur=3)
	private String modeAppel;
	
	@UnitedCommareaField(position=18, longueur=3)
	private String codeDegressivite;

	@UnitedCommareaField(position=19, longueur=3)
	private String codeBareme;
	
	@UnitedCommareaField(position=20, longueur=8)
	private String tauxAssurance;
	
	@UnitedCommareaField(position=21, longueur=8)
	private String montantFinancement;
	
	@UnitedCommareaField(position=22, longueur=8)
	private String montantReglement;
	
	@UnitedCommareaField(position=23, longueur=3)
	private String nbEcheancesSouhaitees;
	
	@UnitedCommareaField(position=24, longueur=8)
	private String cma;
	
	@UnitedCommareaField(position=25, longueur=3)
	private String dureeMaxFormule;
	
	@UnitedCommareaField(position=26, longueur=3)
	private String codeSocComm;
	
	@UnitedCommareaField(position=27, longueur=14)
	private String numroDossier;
	
	@UnitedCommareaField(position=28, longueur=1)
	private String nbJokerReports;
	
	@UnitedCommareaList(position=29, longueur=24, nombre=20)
	private List<BaremeUP1Description> baremes;

	public String getModeAppel() {
		return modeAppel;
	}

	public void setModeAppel(String modeAppel) {
		this.modeAppel = modeAppel;
	}

	public String getCodeDegressivite() {
		return codeDegressivite;
	}

	public void setCodeDegressivite(String codeDegressivite) {
		this.codeDegressivite = codeDegressivite;
	}

	public String getCodeBareme() {
		return codeBareme;
	}

	public void setCodeBareme(String codeBareme) {
		this.codeBareme = codeBareme;
	}

	public String getTauxAssurance() {
		return tauxAssurance;
	}

	public void setTauxAssurance(String tauxAssurance) {
		this.tauxAssurance = tauxAssurance;
	}

	public String getMontantFinancement() {
		return montantFinancement;
	}

	public void setMontantFinancement(String montantFinancement) {
		this.montantFinancement = montantFinancement;
	}

	public String getMontantReglement() {
		return montantReglement;
	}

	public void setMontantReglement(String montantReglement) {
		this.montantReglement = montantReglement;
	}

	public String getNbEcheancesSouhaitees() {
		return nbEcheancesSouhaitees;
	}

	public void setNbEcheancesSouhaitees(String nbEcheancesSouhaitees) {
		this.nbEcheancesSouhaitees = nbEcheancesSouhaitees;
	}

	public String getCma() {
		return cma;
	}

	public void setCma(String cma) {
		this.cma = cma;
	}

	public String getDureeMaxFormule() {
		return dureeMaxFormule;
	}

	public void setDureeMaxFormule(String dureeMaxFormule) {
		this.dureeMaxFormule = dureeMaxFormule;
	}

	public String getCodeSocComm() {
		return codeSocComm;
	}

	public void setCodeSocComm(String codeSocComm) {
		this.codeSocComm = codeSocComm;
	}

	public String getNumroDossier() {
		return numroDossier;
	}

	public void setNumroDossier(String numroDossier) {
		this.numroDossier = numroDossier;
	}

	public String getNbJokerReports() {
		return nbJokerReports;
	}

	public void setNbJokerReports(String nbJokerReports) {
		this.nbJokerReports = nbJokerReports;
	}

	public List<BaremeUP1Description> getBaremes() {
		return baremes;
	}

	public void setBaremes(List<BaremeUP1Description> baremes) {
		this.baremes = baremes;
	}

}
