package com.natixis.cco.upconnect.manager.rachat;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.rachat.RachatV1UP1InputConverter;
import com.natixis.cco.upconnect.converter.rachat.RachatV1UP1OutputConverter;
import com.natixis.cco.upconnect.manager.VersionService;
import com.natixis.cco.upconnect.modelUP.rachat.InputRachatUP1;
import com.natixis.cco.upconnect.modelUP.rachat.OutputRachatUP1;
import com.natixis.cco.upconnect.modelnfi.rachat.InputRachatV1;
import com.natixis.cco.upconnect.modelnfi.rachat.RachatV1;
import com.natixis.cco.upconnect.service.rachat.up1.RachatUP1Service;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.RachatBusinessException;

public class Rachat1UP1Manager extends AbstractRachatManager<InputRachatV1, InputRachatUP1, OutputRachatUP1, RachatV1> {

	@Inject
	RachatUP1Service service;
	
	public Rachat1UP1Manager() {
		inputConverter = new RachatV1UP1InputConverter();
		outputConverter = new RachatV1UP1OutputConverter();
	}
	
	@Override
	public OutputRachatUP1 doGetRachat(InputRachatUP1 inputUP)
			throws ConverterException, RachatBusinessException {
		return service.execute(inputUP);
	}

	public VersionService<RachatV1> getInfosVersion() {
		VersionService<RachatV1> version = new VersionService<RachatV1>();
		version.setVersionUP("UP1");
		version.setVersionMiddleConnect("RachatV1");
		version.setContent(RachatV1.class);
		return version;
	}

}
