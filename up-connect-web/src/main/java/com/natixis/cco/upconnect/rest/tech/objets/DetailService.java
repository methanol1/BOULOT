package com.natixis.cco.upconnect.rest.tech.objets;

import java.util.List;

public class DetailService {
	
	private String versionUP;
	private List<String> champs;
	public String getVersionUP() {
		return versionUP;
	}
	public void setVersionUP(String versionUP) {
		this.versionUP = versionUP;
	}
	public List<String> getChamps() {
		return champs;
	}
	public void setChamps(List<String> fieldsnames) {
		this.champs = fieldsnames;
	}
	
	

}
