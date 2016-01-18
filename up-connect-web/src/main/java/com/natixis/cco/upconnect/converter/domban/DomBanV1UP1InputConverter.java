package com.natixis.cco.upconnect.converter.domban;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.domban.InputDomBanUP1;
import com.natixis.cco.upconnect.modelnfi.domban.InputDomBanV1;

public class DomBanV1UP1InputConverter implements InputConverter<InputDomBanV1, InputDomBanUP1> {

	public InputDomBanUP1 extractInput(InputDomBanV1 input)
			throws ConverterException {
		InputDomBanUP1 res = new InputDomBanUP1();
		res.setNumeroDossier(input.getNumeroDossier());
		res.setDateUtilisation(input.getDateUtilisation());
		return res;
	}

}
