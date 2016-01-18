package com.natixis.cco.upconnect.modelUP.dcrl;

import java.util.ArrayList;
import java.util.List;

import com.natixis.cco.upconnect.commarea.dcrl.BaremeUP1Description;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaList;

public class InputDCrlUP1 {
	
	private List<InputDCrlUP1Description> intputs;
	
	public List<InputDCrlUP1Description> getIntputs() {
		return intputs;
	}
	
	public void setIntputs(List<InputDCrlUP1Description> intputs) {
		this.intputs = intputs;
	}

	public InputDCrlUP1() {
		super();
		intputs = new ArrayList<InputDCrlUP1Description>();
	}

	@Override
	public String toString() {
		return "InputDCrlUP1 [intputs=" + intputs + "]";
	}


	
	

}
