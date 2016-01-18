package com.natixis.cco.upconnect.converter.contrat;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP2;
import com.natixis.cco.upconnect.modelnfi.contrat.InputContratV2;

public class ContratV2UP2InputConverter implements InputConverter<InputContratV2, InputContratUP2> {

	public InputContratUP2 extractInput(InputContratV2 input) throws ConverterException {
		InputContratUP2 res = new InputContratUP2();
		res.setNumeroDossier(input.getNumeroDossier());
		return res;
	}

}
