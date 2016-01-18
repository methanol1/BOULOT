package com.natixis.cco.upconnect.converter.historique;


import com.natixis.cco.upconnect.commarea.historique.HistoUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.historique.InputHistoUP1;

public class HistoUP1RequestConverter implements InputConverter<InputHistoUP1, HistoUP1CommareaDescriptionRequest> {

	@Override
	public HistoUP1CommareaDescriptionRequest extractInput(InputHistoUP1 input)
			throws ConverterException {
		HistoUP1CommareaDescriptionRequest request = new HistoUP1CommareaDescriptionRequest();
		
		request.setNumeroContrat(input.getNumeroContrat());
		request.setNombreOperationMaxARestituer(input.getNombreOperationMaxARestituer());
		request.setSensRestition(input.getSensRestition());
		request.setIdOperation(input.getIdOperation());
		return request;
	}

}
