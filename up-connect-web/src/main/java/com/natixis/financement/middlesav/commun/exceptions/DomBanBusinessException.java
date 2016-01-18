package com.natixis.financement.middlesav.commun.exceptions;

public class DomBanBusinessException extends Exception {
	private String codeUP;

	public DomBanBusinessException() {
		// TODO Auto-generated constructor stub
	}

	public DomBanBusinessException(String message, String code) {
		super(message);
		codeUP = code;
	}

	public DomBanBusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DomBanBusinessException(String message, Throwable cause) {
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
