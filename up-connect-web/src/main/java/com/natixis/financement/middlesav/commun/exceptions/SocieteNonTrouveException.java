package com.natixis.financement.middlesav.commun.exceptions;

public class SocieteNonTrouveException extends SavBusinessException {

	private String codeUP;
	
	public SocieteNonTrouveException() {
		// TODO Auto-generated constructor stub
	}

	public SocieteNonTrouveException(String message, String codeUP) {
		super(message);
		this.codeUP = codeUP;
	}

	public SocieteNonTrouveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SocieteNonTrouveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SocieteNonTrouveException(SavError savError, String... parameters) {
		super(savError, parameters);
		// TODO Auto-generated constructor stub
	}
	public String getCodeUP() {
		return codeUP;
	}

	public void setCodeUP(String codeUP) {
		this.codeUP = codeUP;
	}
}
