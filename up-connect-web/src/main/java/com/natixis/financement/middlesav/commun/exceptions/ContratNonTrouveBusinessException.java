package com.natixis.financement.middlesav.commun.exceptions;

public class ContratNonTrouveBusinessException extends SavBusinessException {
	
	private String codeUP;

	public ContratNonTrouveBusinessException() {
		// TODO Auto-generated constructor stub
	}

	public ContratNonTrouveBusinessException(String message, String code) {
		super(message);
		codeUP = code;
	}

	public ContratNonTrouveBusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ContratNonTrouveBusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	public ContratNonTrouveBusinessException(final SavError savError, final String... parameters){
		super(savError, parameters);
	}

	public String getCodeUP() {
		return codeUP;
	}

	public void setCodeUP(String codeUP) {
		this.codeUP = codeUP;
	}

}
