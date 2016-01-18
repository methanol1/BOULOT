package com.natixis.cco.upconnect.service.dcrl;

import com.natixis.cco.upconnect.converter.ConverterException;

public interface DCrlUPService <I,L> {
	public L execute(I input) throws ConverterException;
}
