package com.natixis.cco.upconnect.converter.assurance;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.assurance.InputAssuranceUP1;
import com.natixis.cco.upconnect.modelnfi.assurance.InputAssuranceV1;

public class AssuranceV1UP1InputConverter implements
		InputConverter<InputAssuranceV1, InputAssuranceUP1> {

	public InputAssuranceUP1 extractInput(InputAssuranceV1 input)
			throws ConverterException {
		InputAssuranceUP1 res = new InputAssuranceUP1();
		res.setNumeroDossier(input.getNumeroDossier());
		res.setDateParam(input.getDateParam());
		return res;
	}

}
