package com.natixis.cco.upconnect.modelUP.dcrl;


public class InputBaremeUP1 {
	private String tncAnnuel;
	
	private String decouvertMin;
	
	private String decouvertMax;

	public String getTncAnnuel() {
		return tncAnnuel;
	}

	public void setTncAnnuel(String tncAnnuel) {
		this.tncAnnuel = tncAnnuel;
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
		return "InputBaremeUP1 [tncAnnuel=" + tncAnnuel + ", decouvertMin="
				+ decouvertMin + ", decouvertMax=" + decouvertMax + "]";
	}
	

}
