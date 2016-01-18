package com.natixis.cco.upconnect.service.dcrl.up1;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

import com.natixis.cco.upconnect.commarea.dcrl.DCrlUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.dcrl.DCrlUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.dcrl.DCrlUP1ResponseDescription;
import com.natixis.cco.upconnect.commarea.dcrl.TaegUP1Description;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.dcrl.DCrlUP1RequestConverter;
import com.natixis.cco.upconnect.converter.dcrl.DCrlUP1ResponseConverter;
import com.natixis.cco.upconnect.modelUP.dcrl.InputDCrlUP1;
import com.natixis.cco.upconnect.modelUP.dcrl.OutputDCrlUP1;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;



@Alternative
public class DCrlUP1ServiceMock extends DCrlUP1Service {

	
	private static final String VERSION_SERVICE = "UP1-MOCK";
	
	
	public DCrlUP1ServiceMock() {
		inputConverter = new DCrlUP1RequestConverter();
		outputConverter = new DCrlUP1ResponseConverter();
	}
	@Override
	public OutputDCrlUP1 execute(InputDCrlUP1 input) throws ConverterException {
		
			return calculDCrl(input);
	}

	@Override
	public DCrlUP1CommareaDescriptionResponse doCalculDCrl(
			DCrlUP1CommareaDescriptionRequest inputUP) {
		
		DCrlUP1CommareaDescriptionResponse res = new  DCrlUP1CommareaDescriptionResponse();
		List<DCrlUP1ResponseDescription> dcrls = new ArrayList<DCrlUP1ResponseDescription>();
		DCrlUP1ResponseDescription dcrl = new DCrlUP1ResponseDescription();
		
		dcrl.setCodeRetCalc("2");
		dcrl.setCoutTotalAssurance("100.10");
		dcrl.setCoutTotalInteret("500");
		dcrl.setMontantAssurancePremiereMens("200.10");
		dcrl.setMontantDerniereMens("100.00");
		dcrl.setMontantFinancable("400.00");
		dcrl.setMontantMensCalc("329.99");
		dcrl.setNbEcheanceCalc("2");
		dcrl.setTaea("3.8");
		
		List<TaegUP1Description> taegs = new ArrayList<TaegUP1Description>();
		for(int i=0;i<5;i++) taegs.add(new TaegUP1Description("18.2"+i));		
		dcrl.setTaegs(taegs );
		
		dcrls.add(dcrl);
		res.setDcrls(dcrls);
		
		return res;
	}

	@Override
	protected String getVersionUP() {
		return VERSION_SERVICE;
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		
		return TypeTransaction.DCRL;
	}

}
