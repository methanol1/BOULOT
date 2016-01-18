package com.natixis.cco.upconnect.modelnfi.dcrl;


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
@XmlRootElement(name="requete")
public class InputDCrlDescriptionV1 {	

	/**
	 * Liste de barêmes par tranche
	 */
	@XmlElement(name="baremes")
	@ApiModelProperty(value="baremes", required=true)
	@NotNull
	@Size(max=5, min=1,message="La liste des barêmes doit être composée de {min} à {max} éléments")
	@Valid
	private List<BaremeV1> baremes;
	
	/**
	 * Taux d'assurance mensuel
	 */
	@XmlElement(name="tauxAssurance")
	@ApiModelProperty(value="tauxAssurance", required=true)
	@Min(value=0) @DecimalMax(value="99.999999")
	@NotNull
	private BigDecimal tauxAssurance;

	/**
	 * Montant de capital restant dû
	 */
	@XmlElement(name="montantCapitalDu")
	@ApiModelProperty(value="montantCapitalDu", required=true)
	@Min(value=0) @DecimalMax(value="999999.99")
	private BigDecimal montantCapitalDu;

	/**
	 * Montant du financement
	 */
	@XmlElement(name="montantFinan")
	@ApiModelProperty(value="montantFinan", required=true)
	@Min(value=0, message="montantFinan doit être de valeur min = {min}")  @DecimalMax(value="9999999.99")
	private BigDecimal montantFinan;

	/**
	 * Date (du financement, ou du début de mois)
	 */
	@XmlElement(name="date")
	@ApiModelProperty(value="date", required=true)
	@NotNull
	@Size(max=8, min=0,message=" date : la taille doit être compris entre {min} et {max}")
	@Pattern(regexp="((?:19|20)\\d\\d)(0?[1-9]|1[012])(0?[1-9]|[12][0-9]|3[01])",message="La date doit être au format aaaammjj ex :20151230 ")
	private String date;

	/**
	 * 
	 */
	@XmlElement(name="nbJokers")
	@ApiModelProperty(value="nbJokers", required=true)
	@NotNull
	@Min(value=0,message="nbJokers doit être de valeur min : {value}") 
	@Max(value=9,message="nbJokers doit être de valeur max : {value}")
	private int nbJokers;

	/**
	 * Montant de la mensualité souhaitée
	 */
	@XmlElement(name="montantMens")
	@ApiModelProperty(value="montantMens")
	private BigDecimal montantMens;

	/**
	 * Nombre d’échéances souhaité
	 */
	@XmlElement(name="nbEcheance")
	@ApiModelProperty(value="nbEcheance")
	@Min(value=0,message="nbEcheance doit être de valeur min : {value}") 
	@Max(value=999, message="nbEcheance doit être de valeur max : {value}")
	private int nbEcheance;

	/**
	 * le pas de la mensualité, pas par défaut du moteur de calcul = 1
	 */	
	@XmlElement(name="pasMens")
	@ApiModelProperty(value="pasMens")
	@Min(value=0,message="pasMens doit être de valeur min : {value}")
	@NotNull
	private BigDecimal pasMens;
	
	

	public InputDCrlDescriptionV1() {
		super();
	}

	public List<BaremeV1> getBaremes() {
		return baremes;
	}

	public void setBaremes(List<BaremeV1> baremes) {
		this.baremes = baremes;
	}

	public BigDecimal getTauxAssurance() {
		return tauxAssurance;
	}

	public void setTauxAssurance(BigDecimal tauxAssurance) {
		this.tauxAssurance = tauxAssurance;
	}

	public BigDecimal getMontantCapitalDu() {
		return montantCapitalDu;
	}

	public void setMontantCapitalDu(BigDecimal montantCapitalDu) {
		this.montantCapitalDu = montantCapitalDu;
	}

	public BigDecimal getMontantFinan() {
		return montantFinan;
	}

	public void setMontantFinan(BigDecimal montantFinan) {
		this.montantFinan = montantFinan;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNbJokers() {
		return nbJokers;
	}

	public void setNbJokers(int nbJokers) {
		this.nbJokers = nbJokers;
	}

	public BigDecimal getMontantMens() {
		return montantMens;
	}

	public void setMontantMens(BigDecimal montantMens) {
		this.montantMens = montantMens;
	}

	public int getNbEcheance() {
		return nbEcheance;
	}

	public void setNbEcheance(int nbEcheance) {
		this.nbEcheance = nbEcheance;
	}

	public BigDecimal getPasMens() {
		return pasMens;
	}

	public void setPasMens(BigDecimal pasMens) {
		this.pasMens = pasMens;
	}

	
	
	
}
