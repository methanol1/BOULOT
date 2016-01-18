package com.natixis.cco.upconnect.controller;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.manager.domban.AbstractDomBanManager;
import com.natixis.cco.upconnect.modelUP.domban.InputDomBanUP1;
import com.natixis.cco.upconnect.modelUP.domban.OutputDomBanUP1;
import com.natixis.cco.upconnect.modelnfi.domban.DomBanV1;
import com.natixis.cco.upconnect.modelnfi.domban.InputDomBanV1;
import com.natixis.financement.middlesav.commun.exceptions.DomBanBusinessException;

public class DomBanController extends VersionController {
	
	@Inject
	AbstractDomBanManager<InputDomBanV1, InputDomBanUP1, OutputDomBanUP1, DomBanV1> domban1UP1Manager;

	public DomBanV1 getDomBan1(String dossier, String date) throws ConverterException, DomBanBusinessException {
		InputDomBanV1 input = new InputDomBanV1();
		input.setNumeroDossier(dossier);
		input.setDateUtilisation(date);
		return domban1UP1Manager.getDomBan(input);
	}

	@Override
	public InfosServices getinfoService() {
		InfosServices services = new InfosServices();
		services.addInfoService(domban1UP1Manager.getInfosVersion());
		return services;
	}
}
