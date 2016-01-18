package com.natixis.cco.upconnect.modelnfi.dcrl;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModelProperty;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "request")
public class InputDCrlV1 {	
	/**
	 * Liste de requêtes de calcul DCRL
	 */
	@XmlElement(name = "requetes")
	@ApiModelProperty(value="requetes",required=true)
	@Valid
	@Size(max=20, min=1,message="La liste de requêtes doit être composée de {min} à {max} éléments")
	private List<InputDCrlDescriptionV1> inDescriptionV1s;

	public List<InputDCrlDescriptionV1> getInDescriptionV1s() {
		return inDescriptionV1s;
	}

	public void setInDescriptionV1s(List<InputDCrlDescriptionV1> inDescriptionV1s) {
		this.inDescriptionV1s = inDescriptionV1s;
	}

	public InputDCrlV1() {
		super();
		inDescriptionV1s = new ArrayList<InputDCrlDescriptionV1>();
	}
	
	
	
}
