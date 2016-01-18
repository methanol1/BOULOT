package com.natixis.cco.upconnect.service.assurance;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.service.AbstractUnitedService;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;

public abstract class AbstractAssuranceService<I,J extends UnitedCommareaDescriptionHeader,
					K extends UnitedCommareaDescriptionHeader,L> 
		extends AbstractUnitedService implements AssuranceUPService<I, L> {
	
	protected InputConverter<I,J> inputConverter;
	protected OutputConverter<K,L> outputConverter;

	
	public final L getAssurance(I input) throws ConverterException, ContratNonTrouveBusinessException {
		initUnitedDao();
		J inputUP = inputConverter.extractInput(input);
		valoriserHeader(inputUP);
		K outputUP = doGetAssurance(inputUP);
		return outputConverter.extract(outputUP);
	}
	
	public abstract K doGetAssurance(J inputUP) throws ContratNonTrouveBusinessException;


}
