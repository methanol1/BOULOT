package com.natixis.cco.upconnect.service.rachat;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.RachatBusinessException;

public interface RachatUPService<I,L> {

	public L execute(I input) throws ConverterException, RachatBusinessException;
}
