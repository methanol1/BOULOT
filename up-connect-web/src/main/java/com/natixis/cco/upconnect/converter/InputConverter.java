package com.natixis.cco.upconnect.converter;


public interface InputConverter<T,V> {
	public V extractInput(T input) throws ConverterException;
}
