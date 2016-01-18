package com.natixis.cco.upconnect.rest.services.dcrl;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name="bareme")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bareme {

	/**
	 * TNC annuel
	 */
	@XmlElement(name="tncAnnuel")
	@ApiModelProperty(value="tncAnnuel", required=true)
	private BigDecimal tncAnnuel;
	
	/**
	 * Découvert minimum
	 */
	@XmlElement(name="decouvertMin")
	@ApiModelProperty(value="decouvertMin", required=true)
	private BigDecimal decouvertMin;
	
	/**
	 * Découvert maximum
	 */
	@XmlElement(name="decouvertMax")
	@ApiModelProperty(value="decouvertMax", required=true)
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
