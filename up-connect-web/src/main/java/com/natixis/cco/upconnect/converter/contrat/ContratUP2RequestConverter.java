package com.natixis.cco.upconnect.converter.contrat;

import com.natixis.cco.upconnect.commarea.contrat.ContratUP2CommareaDescriptionRequest;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP2;

public class ContratUP2RequestConverter 
	implements InputConverter<InputContratUP2, ContratUP2CommareaDescriptionRequest> {

	public ContratUP2CommareaDescriptionRequest extractInput(
			InputContratUP2 input) throws ConverterException {
		ContratUP2CommareaDescriptionRequest unitedContratRequest = new ContratUP2CommareaDescriptionRequest();
		unitedContratRequest.setNumeroContrat(input.getNumeroDossier());
		return unitedContratRequest;
	}


}
