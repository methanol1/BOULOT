package com.natixis.cco.upconnect.service.domban;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.DomBanBusinessException;

public interface DomBanUPService<I,L> {

	public L execute(I input) throws ConverterException, DomBanBusinessException;
}
