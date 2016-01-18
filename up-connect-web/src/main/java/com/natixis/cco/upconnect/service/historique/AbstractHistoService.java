package com.natixis.cco.upconnect.service.historique;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.service.AbstractUnitedService;
import com.natixis.financement.middlesav.commun.exceptions.HistoriqueNonTrouveException;


public abstract class AbstractHistoService<I, J extends UnitedCommareaDescriptionHeader, K extends UnitedCommareaDescriptionHeader, L>
extends AbstractUnitedService implements HistoUPService<I, L> {

	
	
	protected InputConverter<I,J> inputConverter;
	protected OutputConverter<K,L> outputConverter;
	
	
	public final L historiques(I input) throws ConverterException, HistoriqueNonTrouveException {
		initUnitedDao();
		J inputUP = inputConverter.extractInput(input);
		valoriserHeader(inputUP);
		K outputUP = getHistoriques(inputUP);
		return outputConverter.extract(outputUP);
	}
	
	public abstract K getHistoriques(J inputUP) throws HistoriqueNonTrouveException;
}
