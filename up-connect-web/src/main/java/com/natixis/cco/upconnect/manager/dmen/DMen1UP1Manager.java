package com.natixis.cco.upconnect.manager.dmen;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.dmen.DMenV1UP1InputConverter;
import com.natixis.cco.upconnect.converter.dmen.DMenV1UP1OutputConverter;
import com.natixis.cco.upconnect.manager.VersionService;
import com.natixis.cco.upconnect.modelUP.dmen.InputDMenUP1;
import com.natixis.cco.upconnect.modelUP.dmen.OutputDMenUP1;
import com.natixis.cco.upconnect.modelnfi.dmen.DMenV1;
import com.natixis.cco.upconnect.modelnfi.dmen.InputDMenV1;
import com.natixis.cco.upconnect.service.dmen.up1.DMenUP1Service;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SocieteNonTrouveException;

public class DMen1UP1Manager extends AbstractDMenManager<InputDMenV1, InputDMenUP1, OutputDMenUP1, DMenV1> {

	@Inject
	DMenUP1Service dmenService;
	
	public DMen1UP1Manager(){
		inputConverter = new DMenV1UP1InputConverter();
		outputConverter = new DMenV1UP1OutputConverter();
	}
	
	@Override
	public VersionService getInfosVersion() {
		VersionService<DMenV1> version = new VersionService<DMenV1>();
		version.setVersionUP("UP1");
		version.setVersionMiddleConnect("DMenV1");
		version.setContent(DMenV1.class);
		return version;
	}

	@Override
	public OutputDMenUP1 doCalculDMen(InputDMenUP1 inputUP)
			throws ConverterException,ContratNonTrouveBusinessException, SocieteNonTrouveException {
		return dmenService.calculDMen(inputUP);
	}

	

}
