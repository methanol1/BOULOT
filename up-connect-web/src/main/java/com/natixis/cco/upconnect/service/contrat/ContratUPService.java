package com.natixis.cco.upconnect.service.contrat;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;


public interface ContratUPService<I,L> {

	public L execute(I input) throws ConverterException, ContratNonTrouveBusinessException;
}
