package com.natixis.cco.upconnect.service.agence;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.service.AbstractUnitedService;
import com.natixis.financement.middlesav.commun.exceptions.AgenceNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;

public abstract class AbstractAgenceService<I,J extends UnitedCommareaDescriptionHeader,
					K extends UnitedCommareaDescriptionHeader,L> 
		extends AbstractUnitedService implements AgenceUPService<I, L> {
	
	protected InputConverter<I,J> inputConverter;
	protected OutputConverter<K,L> outputConverter;

	
	public final L getAgence(I input) throws ConverterException, AgenceNonTrouveBusinessException {
		initUnitedDao();
		J inputUP = inputConverter.extractInput(input);
		valoriserHeader(inputUP);
		K outputUP = doGetAgence(inputUP);
		return outputConverter.extract(outputUP);
	}
	
	public abstract K doGetAgence(J inputUP) throws AgenceNonTrouveBusinessException;


}
