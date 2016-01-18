package com.natixis.cco.upconnect.converter.agence;

import com.natixis.cco.upconnect.commarea.agence.AgenceUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.agence.InputAgenceUP1;

public class AgenceUP1RequestConverter
		implements
		InputConverter<InputAgenceUP1, AgenceUP1CommareaDescriptionRequest> {

	public AgenceUP1CommareaDescriptionRequest extractInput(
			InputAgenceUP1 input) throws ConverterException {
		AgenceUP1CommareaDescriptionRequest req = new AgenceUP1CommareaDescriptionRequest();
		req.setNumeroAgence(input.getNumeroAgence());
		return req;
	}

}
