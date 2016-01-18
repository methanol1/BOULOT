package com.natixis.cco.upconnect.rest.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ContratNotFoundException extends WebApplicationException {

	private static final long serialVersionUID = 1L;
	
	private static final String message = "Contrat non trouvé";
	

	public String getMessage() {
		return message;
	}

	public ContratNotFoundException() {
		super(Response.status(Status.NOT_FOUND).build());
	}

	public ContratNotFoundException(Response arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ContratNotFoundException(int arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ContratNotFoundException(Status arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ContratNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ContratNotFoundException(Throwable arg0, Response arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ContratNotFoundException(Throwable arg0, int arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ContratNotFoundException(Throwable arg0, Status arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
