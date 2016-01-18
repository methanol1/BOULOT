package com.natixis.cco.upconnect.commarea.rachat;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaObject;


public class RachatUP1CommareaDescriptionResponse extends
		UnitedCommareaDescriptionHeader {

	@UnitedCommareaObject(position=17, longueur=33)
	private RachatUP1Description rachat;

	public RachatUP1Description getRachat() {
		return rachat;
	}

	public void setRachat(RachatUP1Description rachat) {
		this.rachat = rachat;
	}

	@Override
	public String toString() {
		return "RachatUP1CommareaDescriptionResponse [rachat=" + rachat + "]";
	}
	
	
}
