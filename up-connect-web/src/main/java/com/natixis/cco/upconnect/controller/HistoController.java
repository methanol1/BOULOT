package com.natixis.cco.upconnect.controller;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.manager.Historique.AbstractHistoManager;
import com.natixis.cco.upconnect.modelUP.historique.InputHistoUP1;
import com.natixis.cco.upconnect.modelUP.historique.OutputHistoUP1;
import com.natixis.cco.upconnect.modelnfi.historique.HistoV1;
import com.natixis.cco.upconnect.modelnfi.historique.InputHistoV1;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.HistoriqueNonTrouveException;


public class HistoController extends VersionController {
	
	@Inject
	AbstractHistoManager<InputHistoV1, InputHistoUP1, OutputHistoUP1, HistoV1> histo1UP1Manager;
	
	public HistoV1 historiques(InputHistoV1 input) throws ConverterException, HistoriqueNonTrouveException {
		return histo1UP1Manager.historiques(input);
	}
	
	@Override
	public InfosServices getinfoService(){
		InfosServices is = new InfosServices();
		is.addInfoService(histo1UP1Manager.getInfosVersion());
		return is;
	}

}
