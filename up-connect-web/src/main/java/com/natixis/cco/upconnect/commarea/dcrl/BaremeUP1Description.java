package com.natixis.cco.upconnect.commarea.dcrl;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescription;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

public class BaremeUP1Description implements UnitedCommareaDescription  {
	
	/**
	 * EIMDCRL-IN-TX-TNC
	 */
	@UnitedCommareaField(position=1, longueur=8)
	private String tnc;
	
	/**
	 *EIMDCRL-IN-MT-DECMIN
	 */
	@UnitedCommareaField(position=2, longueur=8)
	private String decouvertMin;
	
	/**
	 * EIMDCRL-IN-MT-DECMAX
	 */
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
	@Override
	public String toString() {
		return "BaremeUP1Description [tnc=" + tnc + ", decouvertMin="
				+ decouvertMin + ", decouvertMax=" + decouvertMax + "]";
	}
	
}
