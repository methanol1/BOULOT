package com.natixis.financement.middlesav.commun.exceptions;

public class HistoriqueNonTrouveException extends SavBusinessException {

	private String codeUP;
	
	public HistoriqueNonTrouveException() {
		// TODO Auto-generated constructor stub
	}

	public HistoriqueNonTrouveException(String message, String codeUP) {
		super(message);
		this.codeUP = codeUP;
	}

	public HistoriqueNonTrouveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public HistoriqueNonTrouveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HistoriqueNonTrouveException(SavError savError, String... parameters) {
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
