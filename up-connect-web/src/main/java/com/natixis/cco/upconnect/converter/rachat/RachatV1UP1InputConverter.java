package com.natixis.cco.upconnect.converter.rachat;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.rachat.InputRachatUP1;
import com.natixis.cco.upconnect.modelnfi.rachat.InputRachatV1;

public class RachatV1UP1InputConverter implements InputConverter<InputRachatV1, InputRachatUP1> {

	public InputRachatUP1 extractInput(InputRachatV1 input)
			throws ConverterException {
		InputRachatUP1 res = new InputRachatUP1();
		res.setNumeroDossier(input.getNumeroDossier());
		res.setDateRachat(input.getDateRachat());
		return res;
	}

}
