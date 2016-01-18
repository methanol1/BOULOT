package com.natixis.cco.upconnect.rest.tech.objets;

public class ErreurReponse {
	
	private String codeRetour;
	
	private String message;
	
	private String versionUPConnectService;
	
	private String versionUPService;

	public String getCodeRetour() {
		return codeRetour;
	}

	public void setCodeRetour(String codeRetour) {
		this.codeRetour = codeRetour;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getVersionUPConnectService() {
		return versionUPConnectService;
	}

	public void setVersionUPConnectService(String versionUPConnectService) {
		this.versionUPConnectService = versionUPConnectService;
	}

	public String getVersionUPService() {
		return versionUPService;
	}

	public void setVersionUPService(String vresionUPService) {
		this.versionUPService = vresionUPService;
	}

}
