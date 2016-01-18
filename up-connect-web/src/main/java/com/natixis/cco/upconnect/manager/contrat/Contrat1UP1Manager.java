package com.natixis.cco.upconnect.manager.contrat;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.contrat.ContratV1UP1InputConverter;
import com.natixis.cco.upconnect.converter.contrat.ContratV1UP1OutputConverter;
import com.natixis.cco.upconnect.manager.VersionService;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP1;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP1;
import com.natixis.cco.upconnect.modelnfi.contrat.ContratV1;
import com.natixis.cco.upconnect.modelnfi.contrat.InputContratV1;
import com.natixis.cco.upconnect.service.contrat.up1.ContratUP1Service;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;

public class Contrat1UP1Manager
		extends
		AbstractContratManager<InputContratV1, InputContratUP1, OutputContratUP1, ContratV1> {

	@Inject
	ContratUP1Service contratService;

	public Contrat1UP1Manager() {
		inputConverter = new ContratV1UP1InputConverter();
		outputConverter = new ContratV1UP1OutputConverter();
	}

	@Override
	public OutputContratUP1 doGetContrat(InputContratUP1 inputUP)
			throws ConverterException, ContratNonTrouveBusinessException {
		return contratService.execute(inputUP);
	}

	public VersionService<ContratV1> getInfosVersion() {
		VersionService<ContratV1> version = new VersionService<ContratV1>();
		version.setVersionUP("UP1");
		version.setVersionMiddleConnect("ContratV1");
		version.setContent(ContratV1.class);
		return version;
	}
}
