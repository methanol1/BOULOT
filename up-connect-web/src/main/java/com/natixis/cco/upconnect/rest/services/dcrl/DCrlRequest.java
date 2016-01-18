package com.natixis.cco.upconnect.rest.services.dcrl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "request")
public class DCrlRequest {
	

	@XmlElement(name="baremes")
	@ApiModelProperty(value="baremes", required=true)
	private List<Bareme> baremes;
	
	@XmlElement(name="tauxAssurance")
	@ApiModelProperty(value="tauxAssurance", required=true)
	private BigDecimal tauxAssurance;
	
	@XmlElement(name="montantCapitalDu")
	@ApiModelProperty(value="montantCapitalDu", required=true)
	private BigDecimal montantCapitalDu;
	
	@XmlElement(name="montantFinan")
	@ApiModelProperty(value="montantFinan", required=true)
	private BigDecimal montantFinan;
	
	@XmlElement(name="date")
	@ApiModelProperty(value="date", required=true)
	private Date date;
	
	@XmlElement(name="nbJokers")
	@ApiModelProperty(value="nbJokers", required=true)
	private String nbJokers;
	
	@XmlElement(name="modeAppel")
	@ApiModelProperty(value="modeAppel", required=true)
	private BigDecimal montantMens;
	
	@XmlElement(name="nbEcheance")
	@ApiModelProperty(value="nbEcheance", required=true)
	private int nbEcheance;
	
	
	@XmlElement(name="pasMens")
	@ApiModelProperty(value="pasMens", required=true)
	private int pasMens;


	public List<Bareme> getBaremes() {
		return baremes;
	}


	public void setBaremes(List<Bareme> baremes) {
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getNbJokers() {
		return nbJokers;
	}


	public void setNbJokers(String nbJokers) {
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


	public int getPasMens() {
		return pasMens;
	}


	public void setPasMens(int pasMens) {
		this.pasMens = pasMens;
	}
	
	
	

}
