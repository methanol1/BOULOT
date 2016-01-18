package com.natixis.cco.upconnect.rest.services.dmen;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "request")
public class DMenRequest {
	@XmlElement(name="modeAppel")
	@ApiModelProperty(value="modeAppel", required=true)
	private String modeAppel;
	
	/**
	 * Un nombre sur 3 digits. Ex : 444
	 */
	@XmlElement(name="codeDegressivite")
	@ApiModelProperty(value="codeDegressivite", required=true)
	private int degressivite;
	
	/**
	 * Le code barême sur 3 digits
	 */
	@XmlElement(name="codeBareme")
	@ApiModelProperty(value="codeBareme", required=true)
	private int codeBareme;
	
	/**
	 * Taux d'assurance mensuelle. 2 chiffres avant la virgule, 6 chiffres après.
	 */
	@XmlElement(name="tauxAssurance")
	@ApiModelProperty(value="tauxAssurance", required=true)
	private BigDecimal tauxAssurance;
	
	/**
	 * 
	 * Montant du financement
	 */
	@XmlElement(name="montantFinancement")
	@ApiModelProperty(value="montantFinancement", required=true)
	private BigDecimal montantFinancement;
	
	/**
	 * 
	 * Montant du règlement
	 */
	@XmlElement(name="montantReglement")
	@ApiModelProperty(value="montantReglement", required=true)
	private BigDecimal montantReglement;
	
	/**
	 * Nb d'échéances souhaitées. <= 999 
	 */
	@XmlElement(name="nombreEcheancesSouhaitees")
	@ApiModelProperty(value="nombre Echeances Souhaitees", required=true)
	private int nbEchSouhaitee;
	
	
	/**
	 * Crédit maximum autorisé
	 */
	@XmlElement(name="creditMaxAutorise")
	@ApiModelProperty(value="credit Maxi Autorisé", required=true)
	private BigDecimal cma;
	
	/**
	 * Durée maximum formule
	 */
	@XmlElement(name="dureeMaxiFormule")
	@ApiModelProperty(value="duree Maxi Formule", required=true)
	private int dureeMaxFormule;
	
	/**
	 * Code société commerciale
	 */
	@XmlElement(name="codeSocCommercial")
	@ApiModelProperty(value="code Société Commerciale", required=true)
	private int codeSocieteComm;
	
	/**
	 * Numéro de dossier
	 */
	@XmlElement(name="dossier")
	@ApiModelProperty(value="Numéro de dossier", required=true)
	private String numeroDossier;
	
	/**
	 * Nombre de Jokers/Reports
	 */
	@XmlElement(name="nbJokerReport")
	@ApiModelProperty(value="nbJokerReport", required=true)
	private int nbJokerReport;
	
	/**
	 * Liste de barêmes par tranche
	 */
	@XmlElement(name="baremes")
	@ApiModelProperty(value="baremes", required=true)
	private List<Bareme> baremes;

	public DMenRequest() {
	}

	public String getModeAppel() {
		return modeAppel;
	}

	public void setModeAppel(String modeAppel) {
		this.modeAppel = modeAppel;
	}

	public int getDegressivite() {
		return degressivite;
	}

	public void setDegressivite(int degressivite) {
		this.degressivite = degressivite;
	}

	public int getCodeBareme() {
		return codeBareme;
	}

	public void setCodeBareme(int codeBareme) {
		this.codeBareme = codeBareme;
	}

	public BigDecimal getTauxAssurance() {
		return tauxAssurance;
	}

	public void setTauxAssurance(BigDecimal tauxAssurance) {
		this.tauxAssurance = tauxAssurance;
	}

	public BigDecimal getMontantFinancement() {
		return montantFinancement;
	}

	public void setMontantFinancement(BigDecimal montantFinancement) {
		this.montantFinancement = montantFinancement;
	}

	public BigDecimal getMontantReglement() {
		return montantReglement;
	}

	public void setMontantReglement(BigDecimal montantReglement) {
		this.montantReglement = montantReglement;
	}

	public int getNbEchSouhaitee() {
		return nbEchSouhaitee;
	}

	public void setNbEchSouhaitee(int nbEchSouhaitee) {
		this.nbEchSouhaitee = nbEchSouhaitee;
	}

	public BigDecimal getCma() {
		return cma;
	}

	public void setCma(BigDecimal cma) {
		this.cma = cma;
	}

	public int getDureeMaxFormule() {
		return dureeMaxFormule;
	}

	public void setDureeMaxFormule(int dureeMaxFormule) {
		this.dureeMaxFormule = dureeMaxFormule;
	}

	public int getCodeSocieteComm() {
		return codeSocieteComm;
	}

	public void setCodeSocieteComm(int codeSocieteComm) {
		this.codeSocieteComm = codeSocieteComm;
	}

	public String getNumeroDossier() {
		return numeroDossier;
	}

	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}

	public int getNbJokerReport() {
		return nbJokerReport;
	}

	public void setNbJokerReport(int nbJokerReport) {
		this.nbJokerReport = nbJokerReport;
	}

	public List<Bareme> getBaremes() {
		return baremes;
	}

	public void setBaremes(List<Bareme> baremes) {
		this.baremes = baremes;
	}

	@Override
	public String toString() {
		return "DMenInputRequest [modeAppel=" + modeAppel + ", degressivite="
				+ degressivite + ", codeBareme=" + codeBareme
				+ ", tauxAssurance=" + tauxAssurance + ", montantFinancement="
				+ montantFinancement + ", montantReglement=" + montantReglement
				+ ", nbEchSouhaitee=" + nbEchSouhaitee + ", cma=" + cma
				+ ", dureeMaxFormule=" + dureeMaxFormule + ", codeSocieteComm="
				+ codeSocieteComm + ", numeroDossier=" + numeroDossier
				+ ", nbJokerReport=" + nbJokerReport + ", baremes=" + baremes
				+ "]";
	}

}
