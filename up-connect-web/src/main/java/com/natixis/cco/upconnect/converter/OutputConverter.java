package com.natixis.cco.upconnect.converter;


public interface OutputConverter<U,S> {

	public S extract(U outputUP) throws ConverterException;
}
