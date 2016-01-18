package com.natixis.cco.upconnect.rest.tech.objets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Cette rassemble toutes les informations "techniques" de l'application déployée.
 * 
 * @author fleuryst
 *
 */
//@XmlRootElement(name="infosTechniques")
@XmlAccessorType(XmlAccessType.FIELD)
public class DetailInfos {

	@XmlElement(name="numeroBaseline")
	private String numeroBaseline;

	public String getNumeroBaseline() {
		return numeroBaseline;
	}

	public void setNumeroBaseline(String numero) {
		this.numeroBaseline = numero;
	}

	
	
	
}
