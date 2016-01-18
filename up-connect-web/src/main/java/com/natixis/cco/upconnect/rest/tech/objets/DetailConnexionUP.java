package com.natixis.cco.upconnect.rest.tech.objets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DetailConnexionUP extends DetailConnexionBack {

	@XmlElement(name="URL")
	private String url;
	
	@XmlElement(name="username")
	private String user;
	
	@XmlElement(name="CICS")
	private String cics;
	
	@XmlElement(name="UP-disponible")
	private boolean upDispo;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCics() {
		return cics;
	}

	public void setCics(String cics) {
		this.cics = cics;
	}

	public boolean isUpDispo() {
		return upDispo;
	}

	public void setUpDispo(boolean upDispo) {
		this.upDispo = upDispo;
	}
	
}
