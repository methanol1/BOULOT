package com.natixis.cco.upconnect.manager.agence;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.agence.AgenceV1UP1InputConverter;
import com.natixis.cco.upconnect.converter.agence.AgenceV1UP1OutputConverter;
import com.natixis.cco.upconnect.manager.VersionService;
import com.natixis.cco.upconnect.modelUP.agence.InputAgenceUP1;
import com.natixis.cco.upconnect.modelUP.agence.OutputAgenceUP1;
import com.natixis.cco.upconnect.modelnfi.agence.AgenceV1;
import com.natixis.cco.upconnect.modelnfi.agence.InputAgenceV1;
import com.natixis.cco.upconnect.service.agence.up1.AgenceUP1Service;
import com.natixis.financement.middlesav.commun.exceptions.AgenceNonTrouveBusinessException;

public class Agence1UP1Manager
		extends
		AbstractAgenceManager<InputAgenceV1, InputAgenceUP1, OutputAgenceUP1, AgenceV1> {
	
	@Inject
	AgenceUP1Service agenceService;

	public Agence1UP1Manager() {
		inputConverter = new AgenceV1UP1InputConverter();
		outputConverter = new AgenceV1UP1OutputConverter();
	}

	@Override
	public OutputAgenceUP1 doGetAgence(InputAgenceUP1 inputUP)
			throws ConverterException, AgenceNonTrouveBusinessException {
		return agenceService.execute(inputUP);
	}

	public VersionService<AgenceV1> getInfosVersion() {
		VersionService<AgenceV1> version = new VersionService<AgenceV1>();
		version.setVersionUP("UP1");
		version.setVersionMiddleConnect("AgenceV1");
		version.setContent(AgenceV1.class);
		return version;
	}

}
