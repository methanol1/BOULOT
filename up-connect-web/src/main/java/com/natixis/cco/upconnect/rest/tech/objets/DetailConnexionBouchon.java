package com.natixis.cco.upconnect.rest.tech.objets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DetailConnexionBouchon extends DetailConnexionBack {

	@XmlElement(name="statut")
	private String statut = "Bouchonné";

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
}
