package com.natixis.cco.upconnect.service.dmen;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SocieteNonTrouveException;

public interface DMenUPService<I,L> {
	public L execute(I input) throws ConverterException, ContratNonTrouveBusinessException,SocieteNonTrouveException;
}
