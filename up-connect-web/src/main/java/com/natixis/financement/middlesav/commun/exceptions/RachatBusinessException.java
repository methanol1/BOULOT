package com.natixis.financement.middlesav.commun.exceptions;

public class RachatBusinessException extends Exception {
	
	private String codeUP;

	public RachatBusinessException() {
		// TODO Auto-generated constructor stub
	}

	public RachatBusinessException(String message, String code) {
		super(message);
		codeUP = code;
	}

	public RachatBusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public RachatBusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public String getCodeUP() {
		return codeUP;
	}

	public void setCodeUP(String codeUP) {
		this.codeUP = codeUP;
	}
}
