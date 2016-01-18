package com.natixis.cco.upconnect.manager.agence;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.manager.IVersionManager;
import com.natixis.financement.middlesav.commun.exceptions.AgenceNonTrouveBusinessException;

public abstract class AbstractAgenceManager<T,V,U,S> implements IVersionManager {

	protected InputConverter<T,V> inputConverter;
	protected OutputConverter<U,S> outputConverter;
	
	/**
	 * Cette méthode est responsable de l'enchaînement des traitements.
	 * Elle retourne une assurance dans une certaine version.
	 */
	public final S getAgence(T input) throws ConverterException, AgenceNonTrouveBusinessException {
		
		V inputUP = inputConverter.extractInput(input);
		
		U outputUP = doGetAgence(inputUP);
		
		return outputConverter.extract(outputUP);
	}
	
	public abstract U doGetAgence(V inputUP) throws ConverterException, AgenceNonTrouveBusinessException;
}
