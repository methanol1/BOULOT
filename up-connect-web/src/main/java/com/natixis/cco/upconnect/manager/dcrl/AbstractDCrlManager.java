package com.natixis.cco.upconnect.manager.dcrl;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.manager.IVersionManager;


public abstract class AbstractDCrlManager<T,V,U,S> implements IVersionManager {

	
	protected InputConverter<T,V> inputConverter;
	protected OutputConverter<U,S> outputConverter;
	
	public final S calculDCRL(T input) throws ConverterException {
		V inputUP = inputConverter.extractInput(input);
		
		U outputUP = doCalculDCrl(inputUP);
		
		return outputConverter.extract(outputUP);
	}

	public abstract U doCalculDCrl(V inputUP) throws ConverterException;

}
