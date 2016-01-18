package com.natixis.cco.upconnect.converter.assurance;

import com.natixis.cco.upconnect.commarea.assurance.AssuranceUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.assurance.InputAssuranceUP1;

public class AssuranceUP1RequestConverter
		implements
		InputConverter<InputAssuranceUP1, AssuranceUP1CommareaDescriptionRequest> {

	public AssuranceUP1CommareaDescriptionRequest extractInput(
			InputAssuranceUP1 input) throws ConverterException {
		AssuranceUP1CommareaDescriptionRequest req = new AssuranceUP1CommareaDescriptionRequest();
		req.setDateSignature(input.getDateParam());
		req.setNumeroContrat(input.getNumeroDossier());
		return req;
	}

}
