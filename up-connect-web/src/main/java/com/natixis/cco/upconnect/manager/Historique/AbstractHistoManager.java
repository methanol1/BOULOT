package com.natixis.cco.upconnect.manager.Historique;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.manager.IVersionManager;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.HistoriqueNonTrouveException;

public abstract class AbstractHistoManager<T,V,U,S> implements IVersionManager {
	
	
	protected InputConverter<T,V> inputConverter;
	protected OutputConverter<U,S> outputConverter;
	
	
	public final S historiques(T input) throws ConverterException, HistoriqueNonTrouveException {
		V inputUP = inputConverter.extractInput(input);
		
		U outputUP = getHistoriques(inputUP);
		
		return outputConverter.extract(outputUP);
	}
	public abstract U getHistoriques(V inputUP) throws ConverterException, HistoriqueNonTrouveException;

}
