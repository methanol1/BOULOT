package com.natixis.cco.upconnect.controller;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.manager.dmen.AbstractDMenManager;
import com.natixis.cco.upconnect.modelUP.dmen.InputDMenUP1;
import com.natixis.cco.upconnect.modelUP.dmen.OutputDMenUP1;
import com.natixis.cco.upconnect.modelnfi.dmen.DMenV1;
import com.natixis.cco.upconnect.modelnfi.dmen.InputDMenV1;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SocieteNonTrouveException;

public class DMenController extends VersionController {
	
	@Inject
	AbstractDMenManager<InputDMenV1, InputDMenUP1, OutputDMenUP1, DMenV1> dmen1UP1Manager;
	

	
	public DMenV1 calculDMen1(InputDMenV1 input) throws ConverterException, ContratNonTrouveBusinessException, SocieteNonTrouveException {
		return dmen1UP1Manager.calculDMen(input);
	}
	
	@Override
	public InfosServices getinfoService(){
		InfosServices is = new InfosServices();
		is.addInfoService(dmen1UP1Manager.getInfosVersion());
		return is;
	}

}
