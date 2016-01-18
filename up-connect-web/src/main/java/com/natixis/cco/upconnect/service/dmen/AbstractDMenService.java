package com.natixis.cco.upconnect.service.dmen;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.service.AbstractUnitedService;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SocieteNonTrouveException;

public abstract class AbstractDMenService<I, J extends UnitedCommareaDescriptionHeader, K extends UnitedCommareaDescriptionHeader, L>
		extends AbstractUnitedService implements DMenUPService<I, L> {

	protected InputConverter<I,J> inputConverter;
	protected OutputConverter<K,L> outputConverter;
	
	
	public final L calculDMen(I input) throws ConverterException, ContratNonTrouveBusinessException, SocieteNonTrouveException {
		initUnitedDao();
		J inputUP = inputConverter.extractInput(input);
		valoriserHeader(inputUP);
		K outputUP = doCalculDMen(inputUP);
		return outputConverter.extract(outputUP);
	}
	
	public abstract K doCalculDMen(J inputUP) throws ContratNonTrouveBusinessException, SocieteNonTrouveException;

}
