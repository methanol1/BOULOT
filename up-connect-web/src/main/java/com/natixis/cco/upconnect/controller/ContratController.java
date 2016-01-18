package com.natixis.cco.upconnect.controller;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.manager.contrat.AbstractContratManager;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP1;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP2;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP1;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP2;
import com.natixis.cco.upconnect.modelnfi.contrat.ContratV1;
import com.natixis.cco.upconnect.modelnfi.contrat.ContratV2;
import com.natixis.cco.upconnect.modelnfi.contrat.InputContratV1;
import com.natixis.cco.upconnect.modelnfi.contrat.InputContratV2;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;


/**
 * Cette classe est responsable du choix de la version du service UP utilisé pour répondre à la demande
 * d'une version pour le client. 
 * Exemple : le client (une application Middle) a besoin de l'objet ContratV1, car ce contrat
 * contient toutes les données dont il a besoin, le controller se chargera d'utiliser le 
 * service UP qui convient.
 * @author steph
 *
 */
public class ContratController extends VersionController {
	@Inject
	AbstractContratManager<InputContratV1, InputContratUP1, OutputContratUP1, ContratV1> contrat1UP1Manager;
	
	@Inject
	AbstractContratManager<InputContratV2, InputContratUP2, OutputContratUP2, ContratV2> contrat2UP2Manager;
	
	public ContratV1 getContrat1(String dossier) throws ConverterException, ContratNonTrouveBusinessException {
		InputContratV1 input = new InputContratV1();
		input.setNumeroDossier(dossier);
		return contrat1UP1Manager.getContrat(input);
	}

	public ContratV2 getContrat2(String dossier) throws ConverterException, ContratNonTrouveBusinessException {
		InputContratV2 input = new InputContratV2();
		input.setNumeroDossier(dossier);
		return contrat2UP2Manager.getContrat(input);
	}
	
	@Override
	public InfosServices getinfoService(){
		InfosServices is = new InfosServices();
		is.addInfoService(contrat1UP1Manager.getInfosVersion());
		is.addInfoService(contrat2UP2Manager.getInfosVersion());
		return is;
	}
}
