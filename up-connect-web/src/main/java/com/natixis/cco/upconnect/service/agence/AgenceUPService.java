package com.natixis.cco.upconnect.service.agence;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.financement.middlesav.commun.exceptions.AgenceNonTrouveBusinessException;

public interface AgenceUPService<I,L> {
		public L execute(I input) throws ConverterException, AgenceNonTrouveBusinessException;
}
