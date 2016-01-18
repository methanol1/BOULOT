package com.natixis.cco.upconnect.manager.dcrl;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.dcrl.DCrlV1UP1InputConverter;
import com.natixis.cco.upconnect.converter.dcrl.DCrlV1UP1OutputConverter;
import com.natixis.cco.upconnect.manager.VersionService;
import com.natixis.cco.upconnect.modelUP.dcrl.InputDCrlUP1;
import com.natixis.cco.upconnect.modelUP.dcrl.OutputDCrlUP1;
import com.natixis.cco.upconnect.modelnfi.dcrl.DCrlV1;
import com.natixis.cco.upconnect.modelnfi.dcrl.InputDCrlV1;
import com.natixis.cco.upconnect.service.dcrl.up1.DCrlUP1Service;



public class DCrl1UP1Manager extends AbstractDCrlManager<InputDCrlV1, InputDCrlUP1, OutputDCrlUP1, DCrlV1> {

	
	@Inject
	DCrlUP1Service dcrlService;
	
	public DCrl1UP1Manager(){
		inputConverter = new DCrlV1UP1InputConverter();
		outputConverter = new DCrlV1UP1OutputConverter();
	}
	
	@Override
	public VersionService<DCrlV1> getInfosVersion() {
		VersionService<DCrlV1> version = new VersionService<DCrlV1>();
		version.setVersionUP("UP1");
		version.setVersionMiddleConnect("DCrlV1");
		version.setContent(DCrlV1.class);
		return version;
	}

	@Override
	public OutputDCrlUP1 doCalculDCrl(InputDCrlUP1 inputUP)
			throws ConverterException {
		return dcrlService.calculDCrl(inputUP);
	}

}
