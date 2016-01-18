package com.natixis.cco.upconnect.service.dcrl;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.service.AbstractUnitedService;

public abstract class AbstractDCrlService<I, J extends UnitedCommareaDescriptionHeader, K extends UnitedCommareaDescriptionHeader, L>
extends AbstractUnitedService implements DCrlUPService<I, L> {
	
	protected InputConverter<I,J> inputConverter;
	protected OutputConverter<K,L> outputConverter;
	
	
	public final L calculDCrl(I input) throws ConverterException {
		initUnitedDao();
		J inputUP = inputConverter.extractInput(input);
		valoriserHeader(inputUP);
		K outputUP = doCalculDCrl(inputUP);
		return outputConverter.extract(outputUP);
	}
	
	public abstract K doCalculDCrl(J inputUP);
	

}
