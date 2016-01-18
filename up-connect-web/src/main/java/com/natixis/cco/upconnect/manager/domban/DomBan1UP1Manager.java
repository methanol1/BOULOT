package com.natixis.cco.upconnect.manager.domban;

import javax.inject.Inject;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.domban.DomBanV1UP1InputConverter;
import com.natixis.cco.upconnect.converter.domban.DomBanV1UP1OutputConverter;
import com.natixis.cco.upconnect.manager.VersionService;
import com.natixis.cco.upconnect.modelUP.domban.InputDomBanUP1;
import com.natixis.cco.upconnect.modelUP.domban.OutputDomBanUP1;
import com.natixis.cco.upconnect.modelnfi.domban.DomBanV1;
import com.natixis.cco.upconnect.modelnfi.domban.InputDomBanV1;
import com.natixis.cco.upconnect.service.domban.up1.DomBanUP1Service;
import com.natixis.financement.middlesav.commun.exceptions.DomBanBusinessException;

public class DomBan1UP1Manager extends AbstractDomBanManager<InputDomBanV1, InputDomBanUP1, OutputDomBanUP1, DomBanV1> {

	@Inject
	DomBanUP1Service service;
	
	public DomBan1UP1Manager() {
		inputConverter = new DomBanV1UP1InputConverter();
		outputConverter = new DomBanV1UP1OutputConverter();
	}
	
	@Override
	public OutputDomBanUP1 doGetDomBan(InputDomBanUP1 inputUP)
			throws ConverterException, DomBanBusinessException {
		return service.execute(inputUP);
	}

	public VersionService<DomBanV1> getInfosVersion() {
		VersionService<DomBanV1> version = new VersionService<DomBanV1>();
		version.setVersionUP("UP1");
		version.setVersionMiddleConnect("DomBanV1");
		version.setContent(DomBanV1.class);
		return version;
	}

}
