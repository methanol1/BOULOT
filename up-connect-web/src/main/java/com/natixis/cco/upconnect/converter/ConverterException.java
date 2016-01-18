package com.natixis.cco.upconnect.converter;

@SuppressWarnings("serial")
public class ConverterException extends Exception {
	
	private String field;

	public ConverterException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConverterException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ConverterException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public ConverterException(String message, String aField) {
		super(message);
		field = aField;
	}

	public ConverterException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
