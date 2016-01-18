package com.natixis.cco.upconnect.converter.contrat;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP1;
import com.natixis.cco.upconnect.modelnfi.contrat.InputContratV1;

public class ContratV1UP1InputConverter implements InputConverter<InputContratV1, InputContratUP1> {

	public InputContratUP1 extractInput(InputContratV1 input) throws ConverterException {
		InputContratUP1 res = new InputContratUP1();
		res.setNumeroDossier(input.getNumeroDossier());
		return res;
	}

}
