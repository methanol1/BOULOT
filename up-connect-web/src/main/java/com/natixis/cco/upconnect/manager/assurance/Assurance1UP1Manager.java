package com.natixis.cco.upconnect.manager.assurance;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.assurance.AssuranceV1UP1InputConverter;
import com.natixis.cco.upconnect.converter.assurance.AssuranceV1UP1OutputConverter;
import com.natixis.cco.upconnect.manager.VersionService;
import com.natixis.cco.upconnect.modelUP.assurance.InputAssuranceUP1;
import com.natixis.cco.upconnect.modelUP.assurance.OutputAssuranceUP1;
import com.natixis.cco.upconnect.modelnfi.assurance.AssuranceV1;
import com.natixis.cco.upconnect.modelnfi.assurance.InputAssuranceV1;
import com.natixis.cco.upconnect.service.assurance.up1.AssuranceUP1Service;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;

public class Assurance1UP1Manager
		extends
		AbstractAssuranceManager<InputAssuranceV1, InputAssuranceUP1, OutputAssuranceUP1, AssuranceV1> {
	
	@Inject
	AssuranceUP1Service assuranceService;

	public Assurance1UP1Manager() {
		inputConverter = new AssuranceV1UP1InputConverter();
		outputConverter = new AssuranceV1UP1OutputConverter();
	}

	@Override
	public OutputAssuranceUP1 doGetAssurance(InputAssuranceUP1 inputUP)
			throws ConverterException, ContratNonTrouveBusinessException {
		return assuranceService.execute(inputUP);
	}

	public VersionService<AssuranceV1> getInfosVersion() {
		VersionService<AssuranceV1> version = new VersionService<AssuranceV1>();
		version.setVersionUP("UP1");
		version.setVersionMiddleConnect("AssuranceV1");
		version.setContent(AssuranceV1.class);
		return version;
	}

}
