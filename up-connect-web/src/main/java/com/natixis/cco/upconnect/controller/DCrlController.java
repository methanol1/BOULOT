package com.natixis.cco.upconnect.controller;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.manager.dcrl.AbstractDCrlManager;
import com.natixis.cco.upconnect.modelUP.dcrl.InputDCrlUP1;
import com.natixis.cco.upconnect.modelUP.dcrl.OutputDCrlUP1;
import com.natixis.cco.upconnect.modelnfi.dcrl.DCrlV1;
import com.natixis.cco.upconnect.modelnfi.dcrl.InputDCrlV1;



public class DCrlController extends VersionController {

	@Inject
	AbstractDCrlManager<InputDCrlV1, InputDCrlUP1, OutputDCrlUP1, DCrlV1> dcrl1UP1Manager;
	
	
	public DCrlV1 calculDCrl1(InputDCrlV1 input) throws ConverterException {
		return dcrl1UP1Manager.calculDCRL(input);
	}
	
	@Override
	public InfosServices getinfoService(){
		InfosServices is = new InfosServices();
		is.addInfoService(dcrl1UP1Manager.getInfosVersion());
		return is;
	}

}
