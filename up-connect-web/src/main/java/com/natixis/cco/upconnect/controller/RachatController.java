package com.natixis.cco.upconnect.controller;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.manager.rachat.AbstractRachatManager;
import com.natixis.cco.upconnect.modelUP.rachat.InputRachatUP1;
import com.natixis.cco.upconnect.modelUP.rachat.OutputRachatUP1;
import com.natixis.cco.upconnect.modelnfi.rachat.InputRachatV1;
import com.natixis.cco.upconnect.modelnfi.rachat.RachatV1;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.RachatBusinessException;

public class RachatController extends VersionController {
	
	@Inject
	AbstractRachatManager<InputRachatV1, InputRachatUP1, OutputRachatUP1, RachatV1> rachat1UP1Manager;

	public RachatV1 getRachat1(String dossier, String date) throws ConverterException, RachatBusinessException {
		InputRachatV1 input = new InputRachatV1();
		input.setNumeroDossier(dossier);
		input.setDateRachat(date);
		return rachat1UP1Manager.getRachat(input);
	}

	@Override
	public InfosServices getinfoService() {
		InfosServices services = new InfosServices();
		services.addInfoService(rachat1UP1Manager.getInfosVersion());
		return services;
	}
}
