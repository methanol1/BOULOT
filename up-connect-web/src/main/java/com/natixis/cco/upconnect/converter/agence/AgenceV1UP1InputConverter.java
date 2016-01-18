package com.natixis.cco.upconnect.converter.agence;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.agence.InputAgenceUP1;
import com.natixis.cco.upconnect.modelnfi.agence.InputAgenceV1;

public class AgenceV1UP1InputConverter implements
		InputConverter<InputAgenceV1, InputAgenceUP1> {

	public InputAgenceUP1 extractInput(InputAgenceV1 input)
			throws ConverterException {
		InputAgenceUP1 res = new InputAgenceUP1();
		res.setNumeroAgence(input.getNumeroAgence());
		return res;
	}

}
