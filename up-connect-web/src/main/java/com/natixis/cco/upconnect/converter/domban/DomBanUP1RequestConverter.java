package com.natixis.cco.upconnect.converter.domban;

import com.natixis.cco.upconnect.commarea.domban.DomBanUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.domban.InputDomBanUP1;

public class DomBanUP1RequestConverter implements
		InputConverter<InputDomBanUP1, DomBanUP1CommareaDescriptionRequest> {

	public DomBanUP1CommareaDescriptionRequest extractInput(InputDomBanUP1 input)
			throws ConverterException {
		DomBanUP1CommareaDescriptionRequest request = new DomBanUP1CommareaDescriptionRequest();
		request.setNumeroContrat(input.getNumeroDossier());
		request.setDateUtil(input.getDateUtilisation());
		return request;
	}

}
