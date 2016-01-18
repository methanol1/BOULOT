package com.natixis.cco.upconnect.service.historique;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.financement.middlesav.commun.exceptions.HistoriqueNonTrouveException;

public interface HistoUPService <I,L> {
	public L execute(I input) throws ConverterException,HistoriqueNonTrouveException;

}
