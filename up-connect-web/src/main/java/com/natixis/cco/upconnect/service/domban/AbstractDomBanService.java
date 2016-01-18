package com.natixis.cco.upconnect.service.domban;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.service.AbstractUnitedService;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.DomBanBusinessException;

public abstract class AbstractDomBanService<I, J extends UnitedCommareaDescriptionHeader, K extends UnitedCommareaDescriptionHeader, L>
		extends AbstractUnitedService implements DomBanUPService<I, L> {

	protected InputConverter<I,J> inputConverter;
	protected OutputConverter<K,L> outputConverter;

	
	public final L getDomBan(I input) throws ConverterException, DomBanBusinessException {
		initUnitedDao();
		J inputUP = inputConverter.extractInput(input);
		valoriserHeader(inputUP);
		K outputUP = doGetDomBan(inputUP);
		return outputConverter.extract(outputUP);
	}
	
	public abstract K doGetDomBan(J inputUP) throws DomBanBusinessException;

}
