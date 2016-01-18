package com.natixis.cco.upconnect.manager.dmen;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.manager.IVersionManager;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SocieteNonTrouveException;

public abstract class AbstractDMenManager<T,V,U,S> implements IVersionManager {
	
	protected InputConverter<T,V> inputConverter;
	protected OutputConverter<U,S> outputConverter;
	
	
	/**
	 * Cette méthode est responsable de l'enchaînement des traitements.
	 * Elle retourne un contrat dans une certaine version.
	 */
	public final S calculDMen(T input) throws ConverterException,ContratNonTrouveBusinessException, SocieteNonTrouveException {
		V inputUP = inputConverter.extractInput(input);
		
		U outputUP = doCalculDMen(inputUP);
		
		return outputConverter.extract(outputUP);
	}

	public abstract U doCalculDMen(V inputUP) throws ConverterException,ContratNonTrouveBusinessException, SocieteNonTrouveException;
}
