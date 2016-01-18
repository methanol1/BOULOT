package com.natixis.cco.upconnect.service.rachat;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.service.AbstractUnitedService;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.RachatBusinessException;

public abstract class AbstractRachatService<I, J extends UnitedCommareaDescriptionHeader, K extends UnitedCommareaDescriptionHeader, L>
		extends AbstractUnitedService implements RachatUPService<I, L> {

	protected InputConverter<I,J> inputConverter;
	protected OutputConverter<K,L> outputConverter;

	
	public final L getRachat(I input) throws ConverterException, RachatBusinessException {
		initUnitedDao();
		J inputUP = inputConverter.extractInput(input);
		valoriserHeader(inputUP);
		K outputUP = doGetRachat(inputUP);
		return outputConverter.extract(outputUP);
	}
	
	public abstract K doGetRachat(J inputUP) throws RachatBusinessException;

}
