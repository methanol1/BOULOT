package com.natixis.cco.upconnect.manager.assurance;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.manager.IVersionManager;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;

public abstract class AbstractAssuranceManager<T,V,U,S> implements IVersionManager {

	protected InputConverter<T,V> inputConverter;
	protected OutputConverter<U,S> outputConverter;
	
	/**
	 * Cette méthode est responsable de l'enchaînement des traitements.
	 * Elle retourne une assurance dans une certaine version.
	 */
	public final S getAssurance(T input) throws ConverterException, ContratNonTrouveBusinessException {
		
		V inputUP = inputConverter.extractInput(input);
		
		U outputUP = doGetAssurance(inputUP);
		
		return outputConverter.extract(outputUP);
	}
	
	public abstract U doGetAssurance(V inputUP) throws ConverterException, ContratNonTrouveBusinessException;
}
