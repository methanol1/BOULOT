package com.natixis.cco.upconnect.manager.Historique;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.historique.HistoV1UP1InputConverter;
import com.natixis.cco.upconnect.converter.historique.HistoV1UP1OutputConverter;
import com.natixis.cco.upconnect.manager.VersionService;
import com.natixis.cco.upconnect.modelUP.historique.InputHistoUP1;
import com.natixis.cco.upconnect.modelUP.historique.OutputHistoUP1;
import com.natixis.cco.upconnect.modelnfi.historique.HistoV1;
import com.natixis.cco.upconnect.modelnfi.historique.InputHistoV1;
import com.natixis.cco.upconnect.service.historique.up1.HistoUP1Service;
import com.natixis.financement.middlesav.commun.exceptions.HistoriqueNonTrouveException;



public class HistoUP1Manager extends AbstractHistoManager<InputHistoV1, InputHistoUP1, OutputHistoUP1, HistoV1>{

	@Inject
	HistoUP1Service histoService;
	
	public HistoUP1Manager(){
		inputConverter = new HistoV1UP1InputConverter();
		outputConverter = new HistoV1UP1OutputConverter();
	}
	
	
	@Override
	public VersionService getInfosVersion() {
		VersionService<HistoV1> version = new VersionService<HistoV1>();
		version.setVersionUP("UP1");
		version.setVersionMiddleConnect("DCrlV1");
		version.setContent(HistoV1.class);
		return version;
	}

	@Override
	public OutputHistoUP1 getHistoriques(InputHistoUP1 inputUP)
			throws ConverterException, HistoriqueNonTrouveException {
		
		return histoService.historiques(inputUP);
	}

}
