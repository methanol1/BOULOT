package com.natixis.cco.upconnect.controller;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.manager.agence.AbstractAgenceManager;
import com.natixis.cco.upconnect.modelUP.agence.InputAgenceUP1;
import com.natixis.cco.upconnect.modelUP.agence.OutputAgenceUP1;
import com.natixis.cco.upconnect.modelnfi.agence.AgenceV1;
import com.natixis.cco.upconnect.modelnfi.agence.InputAgenceV1;
import com.natixis.financement.middlesav.commun.exceptions.AgenceNonTrouveBusinessException;

public class AgenceController extends VersionController {
	@Inject
	AbstractAgenceManager<InputAgenceV1, InputAgenceUP1, OutputAgenceUP1, AgenceV1> agence1UP1Manager;

	public AgenceV1 getAgence1(String codeAgence)
			throws ConverterException, AgenceNonTrouveBusinessException {
		InputAgenceV1 input = new InputAgenceV1();
		input.setNumeroAgence(codeAgence);
		return agence1UP1Manager.getAgence(input);
	}

	@Override
	public InfosServices getinfoService() {
		InfosServices is = new InfosServices();
		is.addInfoService(agence1UP1Manager.getInfosVersion());
		return is;
	}
}
