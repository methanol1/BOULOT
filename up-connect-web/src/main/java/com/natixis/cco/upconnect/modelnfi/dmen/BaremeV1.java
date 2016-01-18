package com.natixis.cco.upconnect.modelnfi.dmen;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name="bareme")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaremeV1 {

	/**
	 * TNC annuel
	 */
	@XmlElement(name="tncAnnuel")
	@ApiModelProperty(value="tncAnnuel", required=true)
	@NotNull
	@Min(value=0, message="Valeur min : {value}") 
	@DecimalMax(value="99.999999", message="Valeur max : {value}")
	private BigDecimal tncAnnuel;
	
	/**
	 * Découvert minimum
	 */
	@XmlElement(name="decouvertMin")
	@ApiModelProperty(value="decouvertMin", required=true)
	@NotNull
	@Min(value=0,message="Valeur min : {value}") 
	@DecimalMax(value="999999.99",message="Valeur max : {value}")
	private BigDecimal decouvertMin;
	
	/**
	 * Découvert maximum
	 */
	@XmlElement(name="decouvertMax")
	@ApiModelProperty(value="decouvertMax", required=true)
	@NotNull
	@Min(value=0,message="Valeur min ; {value}") 
	@DecimalMax(value="999999.99",message="Valeur max : {value}")
	private BigDecimal decouvertMax;

	public BigDecimal getTncAnnuel() {
		return tncAnnuel;
	}

	public void setTncAnnuel(BigDecimal tncAnnuel) {
		this.tncAnnuel = tncAnnuel;
	}

	public BigDecimal getDecouvertMin() {
		return decouvertMin;
	}

	public void setDecouvertMin(BigDecimal decouvertMin) {
		this.decouvertMin = decouvertMin;
	}

	public BigDecimal getDecouvertMax() {
		return decouvertMax;
	}

	public void setDecouvertMax(BigDecimal decouvertMax) {
		this.decouvertMax = decouvertMax;
	}

	@Override
	public String toString() {
		return "Bareme [tncAnnuel=" + tncAnnuel + ", decouvertMin="
				+ decouvertMin + ", decouvertMax=" + decouvertMax + "]";
	}
	
}
