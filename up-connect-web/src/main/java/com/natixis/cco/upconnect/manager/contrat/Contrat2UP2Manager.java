package com.natixis.cco.upconnect.manager.contrat;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.contrat.ContratV2UP2InputConverter;
import com.natixis.cco.upconnect.converter.contrat.ContratV2UP2OutputConverter;
import com.natixis.cco.upconnect.manager.VersionService;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP2;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP2;
import com.natixis.cco.upconnect.modelnfi.contrat.ContratV2;
import com.natixis.cco.upconnect.modelnfi.contrat.InputContratV2;
import com.natixis.cco.upconnect.service.contrat.up2.ContratUP2Service;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;

public class Contrat2UP2Manager
		extends
		AbstractContratManager<InputContratV2, InputContratUP2, OutputContratUP2, ContratV2> {

	@Inject
	ContratUP2Service contratService;

	public Contrat2UP2Manager() {
		inputConverter = new ContratV2UP2InputConverter();
		outputConverter = new ContratV2UP2OutputConverter();
	}

	@Override
	public OutputContratUP2 doGetContrat(InputContratUP2 inputUP)
			throws ConverterException, ContratNonTrouveBusinessException {
		return contratService.execute(inputUP);
	}
	
	public VersionService<ContratV2> getInfosVersion() {
		VersionService<ContratV2> version = new VersionService<ContratV2>();
		version.setVersionUP("UP2");
		version.setVersionMiddleConnect("ContratV2");
		version.setContent(ContratV2.class);
		return version;
	}
}
