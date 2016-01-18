package com.natixis.cco.upconnect.manager.domban;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.manager.IVersionManager;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.DomBanBusinessException;

public abstract class AbstractDomBanManager<T,V,U,S> implements IVersionManager {

	protected InputConverter<T,V> inputConverter;
	protected OutputConverter<U,S> outputConverter;
	
	/**
	 * Cette méthode est responsable de l'enchaînement des traitements.
	 * Elle retourne un contrat dans une certaine version.
	 */
	public final S getDomBan(T input) throws ConverterException, DomBanBusinessException {
		
		V inputUP = inputConverter.extractInput(input);
		
		U outputUP = doGetDomBan(inputUP);
		
		return outputConverter.extract(outputUP);
	}
	
	public abstract U doGetDomBan(V inputUP) throws ConverterException, DomBanBusinessException;
}
