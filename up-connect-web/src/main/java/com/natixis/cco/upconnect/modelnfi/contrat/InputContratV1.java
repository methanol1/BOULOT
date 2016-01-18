package com.natixis.cco.upconnect.modelnfi.contrat;

/**
 * Cette classe possède toutes les informations fonctionnelles nécessaires 
 * à l'appel du service UP. (Aucune info technique)
 * @author steph
 *
 */
public class InputContratV1 {
	private String numeroDossier;

	public InputContratV1() {
	}

	public String getNumeroDossier() {
		return numeroDossier;
	}

	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}

}
