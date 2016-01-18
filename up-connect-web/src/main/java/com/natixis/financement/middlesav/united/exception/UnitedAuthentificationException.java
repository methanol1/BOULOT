package com.natixis.financement.middlesav.united.exception;

@SuppressWarnings("serial")
public class UnitedAuthentificationException extends Exception {

	private String errorCode;
	
	public UnitedAuthentificationException(String aMessage, String aErrorCode, Throwable aCause){
		super(aMessage, aCause);
		this.errorCode = aErrorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
