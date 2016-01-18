package com.natixis.cco.upconnect.modelnfi.dmen;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "request")
public class InputDMenV1 {
	@XmlElement(name="modeAppel")
	@ApiModelProperty(value="modeAppel", required=true, allowableValues="SAV,ENT")
	@NotNull
	@Pattern(regexp="ENT|SAV",message="Valeurs possibles : 'ENT' ou  'SAV'")
	@Size(min=3,max=3,message="Le mode appel doit être sur 3 caractères")
	private String modeAppel;
	
	/**
	 * Un nombre sur 3 digits. Ex : 444
	 */
	@XmlElement(name="codeDegressivite")
	@ApiModelProperty(value="codeDegressivite", required=true)
	@NotNull
	@Min(value=0,message="Valeur min : {value}") @Max(value=999, message="Valeur max : {value}")
	private int degressivite;
	
	/**
	 * Le code barême sur 3 digits
	 */
	@XmlElement(name="codeBareme")
	@ApiModelProperty(value="codeBareme", required=true)
	@NotNull
	@Min(value=0,message="Valeur min : {value}") @Max(value=999, message="Valeur max : {value}")
	private int codeBareme;
	
	/**
	 * Taux d'assurance mensuelle. 2 chiffres avant la virgule, 6 chiffres après.
	 */
	@XmlElement(name="tauxAssurance")
	@ApiModelProperty(value="tauxAssurance", required=true)
	@NotNull
	@Min(value=0,message="Valeur min : {value}") @DecimalMax(value="99.999999", message="Valeur max : {value}")
	private BigDecimal tauxAssurance;
	
	/**
	 * 
	 * Montant du financement. 6 chiffres avant la virgule, 2 chiffres après
	 */
	@XmlElement(name="montantFinancement")
	@ApiModelProperty(value="montantFinancement", required=true)
	@NotNull
	@Min(value=0,message="Valeur min : {value}")  @DecimalMax(value="999999.99", message="Valeur max : {value}")
	private BigDecimal montantFinancement;
	
	/**
	 * 
	 * Montant du règlement
	 */
	@XmlElement(name="montantReglement")
	@ApiModelProperty(value="montantReglement", required=true)
	@NotNull
	@Min(value=0,message="Valeur min : {value}")  @DecimalMax(value="999999.99", message="Valeur max : {value}")
	private BigDecimal montantReglement;
	
	/**
	 * Nb d'échéances souhaitées. <= 999 
	 */
	@XmlElement(name="nombreEcheancesSouhaitees")
	@ApiModelProperty(value="nombre Echeances Souhaitees", required=true)
	@NotNull
	@Min(value=0,message="Valeur min : {value}") @Max(value=999, message="Valeur max : {value}")
	private int nbEchSouhaitee;
	
	
	/**
	 * Crédit maximum autorisé
	 */
	@XmlElement(name="creditMaxAutorise")
	@ApiModelProperty(value="credit Maxi Autorisé", required=true)
	@NotNull
	@Min(value=0,message="Valeur min : {value}") @DecimalMax(value="999999.99", message="Valeur max : {value}")
	private BigDecimal cma;
	
	/**
	 * Durée maximum formule
	 */
	@XmlElement(name="dureeMaxiFormule")
	@ApiModelProperty(value="duree Maxi Formule", required=true)
	@NotNull
	@Min(value=0) @Max(value=999)
	private int dureeMaxFormule;
	
	/**
	 * Code société commerciale
	 */
	@XmlElement(name="codeSocCommercial")
	@ApiModelProperty(value="code Société Commerciale", required=true)
	@NotNull
	@Min(value=0,message="Valeur min : {value}") @Max(value=999, message="Valeur max : {value}")
	private int codeSocieteComm;
	
	/**
	 * Numéro de dossier
	 */
	@XmlElement(name="dossier")
	@ApiModelProperty(value="Numéro de dossier", required=true)
	@NotNull
	@Size(min=14,max=14,message="Le numéro de dossier doit être sur exactement 14 caractères.")
	@Pattern(regexp="[0-9]{14}",message="Le numéro de dossier doit être composé de 14 chiffres.")
	private String numeroDossier;
	
	/**
	 * Nombre de Jokers/Reports
	 */
	@XmlElement(name="nbJokerReport")
	@ApiModelProperty(value="nbJokerReport", required=true)
	@NotNull
	@Min(value=0,message="Valeur min : {value}") @Max(value=9,message="Valeur max : {value}")
	private int nbJokerReport;
	
	/**
	 * Liste de barêmes par tranche
	 */
	@XmlElement(name="listeBareme")
	@ApiModelProperty(value="listeBareme", required=true)
	@NotNull
	@Size(max=20, min=0,message="La liste des barêmes doit être composées de {min} à {max} élément${max > 1 ? 's' : ''}")
	@Valid
	private List<BaremeV1> baremes;

	public InputDMenV1() {
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

	public List<BaremeV1> getBaremes() {
		return baremes;
	}

	public void setBaremes(List<BaremeV1> baremes) {
		this.baremes = baremes;
	}


}
