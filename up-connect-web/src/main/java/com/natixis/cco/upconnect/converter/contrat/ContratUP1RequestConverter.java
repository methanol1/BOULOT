package com.natixis.cco.upconnect.converter.contrat;

import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP1;

public class ContratUP1RequestConverter 
	implements InputConverter<InputContratUP1, ContratUP1CommareaDescriptionRequest> {

	public ContratUP1CommareaDescriptionRequest extractInput(
			InputContratUP1 input) throws ConverterException {
		ContratUP1CommareaDescriptionRequest unitedContratRequest = new ContratUP1CommareaDescriptionRequest();
		unitedContratRequest.setNumeroContrat(input.getNumeroDossier());
		return unitedContratRequest;
	}


}
