package com.natixis.cco.upconnect.converter.rachat;

import com.natixis.cco.upconnect.commarea.rachat.RachatUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.rachat.InputRachatUP1;

public class RachatUP1RequestConverter implements
		InputConverter<InputRachatUP1, RachatUP1CommareaDescriptionRequest> {

	public RachatUP1CommareaDescriptionRequest extractInput(InputRachatUP1 input)
			throws ConverterException {
		RachatUP1CommareaDescriptionRequest request = new RachatUP1CommareaDescriptionRequest();
		request.setNumeroDossier(input.getNumeroDossier());
		request.setDateRachat(input.getDateRachat());
		return request;
	}

}
