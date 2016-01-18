package com.natixis.cco.upconnect.rest.tech.objets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="infos")
@XmlAccessorType(XmlAccessType.FIELD)
public class EtatUPConnect {
	
	@XmlElement(name="versionBaseline")
	private String baseline;
	
	@XmlElement(name="connexionBackOffice")
	private DetailConnexionBack connexion;

	public String getBaseline() {
		return baseline;
	}

	public void setBaseline(String baseline) {
		this.baseline = baseline;
	}

	public DetailConnexionBack getConnexion() {
		return connexion;
	}

	public void setConnexion(DetailConnexionBack connexion) {
		this.connexion = connexion;
	}

	
}
