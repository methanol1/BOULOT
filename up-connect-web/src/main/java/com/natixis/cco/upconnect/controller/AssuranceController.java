package com.natixis.cco.upconnect.controller;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.manager.assurance.AbstractAssuranceManager;
import com.natixis.cco.upconnect.modelUP.assurance.InputAssuranceUP1;
import com.natixis.cco.upconnect.modelUP.assurance.OutputAssuranceUP1;
import com.natixis.cco.upconnect.modelnfi.assurance.AssuranceV1;
import com.natixis.cco.upconnect.modelnfi.assurance.InputAssuranceV1;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;

public class AssuranceController extends VersionController {
	@Inject
	AbstractAssuranceManager<InputAssuranceV1, InputAssuranceUP1, OutputAssuranceUP1, AssuranceV1> assurance1UP1Manager;

	public AssuranceV1 getAssurance1(String dossier, String dateSign)
			throws ConverterException, ContratNonTrouveBusinessException {
		InputAssuranceV1 input = new InputAssuranceV1();
		input.setNumeroDossier(dossier);
		input.setDateParam(dateSign);
		return assurance1UP1Manager.getAssurance(input);
	}

	@Override
	public InfosServices getinfoService() {
		InfosServices is = new InfosServices();
		is.addInfoService(assurance1UP1Manager.getInfosVersion());
		return is;
	}
}
