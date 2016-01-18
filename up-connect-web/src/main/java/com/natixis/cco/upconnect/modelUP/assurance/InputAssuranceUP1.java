package com.natixis.cco.upconnect.modelUP.assurance;


/**
 * Cette classe rassemble toutes les données que doit contenir la commarea d'entrée du service
 * Assurance UP 
 * 
 * C'est une image objet Java de la commarea du service UP version 1.
 * 
 * 
 * 
 * @author steph
 *
 */
public class InputAssuranceUP1 {

	private String numeroDossier;
	
	private String dateParam;

	public String getNumeroDossier() {
		return numeroDossier;
	}

	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}

	public String getDateParam() {
		return dateParam;
	}

	public void setDateParam(String dateParam) {
		this.dateParam = dateParam;
	}
	
	
}
