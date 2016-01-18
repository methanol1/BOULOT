package com.natixis.cco.upconnect.commarea.dcrl;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescription;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

public class TaegUP1Description implements UnitedCommareaDescription  {
	/**
	 * EIMDCRL-IN-TX-TNC
	 */
	@UnitedCommareaField(position=1, longueur=8)
	private String value;
	
	

	public TaegUP1Description() {
		super();
	}

	public TaegUP1Description(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	

}
