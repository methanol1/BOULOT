package com.natixis.cco.upconnect.converter.historique;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.UPRequestConverter;
import com.natixis.cco.upconnect.modelUP.historique.InputHistoUP1;
import com.natixis.cco.upconnect.modelnfi.historique.InputHistoV1;


public class HistoV1UP1InputConverter extends UPRequestConverter<InputHistoV1, InputHistoUP1>{

	@Override
	public InputHistoUP1 extractInput(InputHistoV1 input)
			throws ConverterException {
		InputHistoUP1 in  = new InputHistoUP1();
		in.setNombreOperationMaxARestituer(getStringNValueFromInt(input.getNombreOperationMaxARestituer(),2));
		in.setNumeroContrat(input.getNumeroContrat());
		in.setSensRestition(input.getSensRestitution());
		in.setIdOperation(input.getIdOperation());
		return in;
	}

}
