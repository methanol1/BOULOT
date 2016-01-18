package com.natixis.cco.upconnect.converter.dcrl;


import java.util.ArrayList;
import java.util.List;

import com.natixis.cco.upconnect.commarea.dcrl.BaremeUP1Description;
import com.natixis.cco.upconnect.commarea.dcrl.DCrlUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.dcrl.DCrlUP1RequestDescription;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.dcrl.InputBaremeUP1;
import com.natixis.cco.upconnect.modelUP.dcrl.InputDCrlUP1;
import com.natixis.cco.upconnect.modelUP.dcrl.InputDCrlUP1Description;


public class DCrlUP1RequestConverter implements InputConverter<InputDCrlUP1, DCrlUP1CommareaDescriptionRequest>{

	@Override
	public DCrlUP1CommareaDescriptionRequest extractInput(InputDCrlUP1 input)
			throws ConverterException {
		DCrlUP1CommareaDescriptionRequest request = new DCrlUP1CommareaDescriptionRequest();
		for(InputDCrlUP1Description in : input.getIntputs()){
			
			DCrlUP1RequestDescription req = new DCrlUP1RequestDescription();
			req.setDate(in.getDate());
			req.setMontantCapitalDu(in.getMontantCapitalDu());
			req.setMontantFinan(in.getMontantFinan());
			req.setNbEcheance(in.getNbEcheance());
			req.setNbJokers(in.getNbJokers());
			req.setPasMens(in.getPasMens());
			req.setTauxAssurance(in.getTauxAssurance());
			req.setMontantMens(in.getMontantMens());
			
			List<BaremeUP1Description> baremes= new ArrayList<BaremeUP1Description>();
			
			for(InputBaremeUP1 ib : in.getBaremes()){
				BaremeUP1Description bu= new BaremeUP1Description();
				bu.setDecouvertMax(ib.getDecouvertMax());
				bu.setDecouvertMin(ib.getDecouvertMin());
				bu.setTnc(ib.getTncAnnuel());
				baremes.add(bu);
			}
			req.setBaremes(baremes);
			
			request.getDcrlsRequests().add(req);
		}
	
		return request;
	}

}
