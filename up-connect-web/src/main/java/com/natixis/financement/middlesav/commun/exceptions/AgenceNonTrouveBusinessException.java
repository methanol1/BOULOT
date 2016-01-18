package com.natixis.financement.middlesav.commun.exceptions;

public class AgenceNonTrouveBusinessException extends SavBusinessException {
	
	private String codeUP;

	public AgenceNonTrouveBusinessException() {
		// TODO Auto-generated constructor stub
	}

	public AgenceNonTrouveBusinessException(String message, String code) {
		super(message);
		codeUP = code;
	}

	public AgenceNonTrouveBusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public AgenceNonTrouveBusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	public AgenceNonTrouveBusinessException(final SavError savError, final String... parameters){
		super(savError, parameters);
	}

	public String getCodeUP() {
		return codeUP;
	}

	public void setCodeUP(String codeUP) {
		this.codeUP = codeUP;
	}

}
