package com.natixis.financement.middlesav.commun.exceptions;

public class SavBusinessException extends Exception {

	public SavBusinessException() {
		// TODO Auto-generated constructor stub
	}

	public SavBusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SavBusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SavBusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	
	public SavBusinessException(final SavError savError, final String... parameters) {
		//TODO : Reprendre le code de la classe existante.
	}
}
