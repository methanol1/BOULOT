package com.natixis.cco.upconnect.commarea.dmen;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescription;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

public class BaremeUP1Description implements UnitedCommareaDescription {

	@UnitedCommareaField(position=1, longueur=8)
	private String tnc;
	@UnitedCommareaField(position=2, longueur=8)
	private String decouvertMin;
	@UnitedCommareaField(position=3, longueur=8)
	private String decouvertMax;
	public String getTnc() {
		return tnc;
	}
	public void setTnc(String tnc) {
		this.tnc = tnc;
	}
	public String getDecouvertMin() {
		return decouvertMin;
	}
	public void setDecouvertMin(String decouvertMin) {
		this.decouvertMin = decouvertMin;
	}
	public String getDecouvertMax() {
		return decouvertMax;
	}
	public void setDecouvertMax(String decouvertMax) {
		this.decouvertMax = decouvertMax;
	}
	
}
