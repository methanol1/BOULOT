package com.natixis.cco.upconnect.commarea.dcrl;

import java.util.List;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaList;

public  class DCrlUP1CommareaDescriptionResponse extends UnitedCommareaDescriptionHeader{
	/**
	 * EIMDCRL-OUT-TABLE
	 */
	@UnitedCommareaList(position=17, longueur=102, nombre=20)
	private List<DCrlUP1ResponseDescription> dcrls;
	
	@UnitedCommareaField(position=31, longueur=1300)
	private String filler;
	
	public List<DCrlUP1ResponseDescription> getDcrls() {
		return dcrls;
	}

	public void setDcrls(List<DCrlUP1ResponseDescription> dcrls) {
		this.dcrls = dcrls;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	@Override
	public String toString() {
		return "DCrlUP1CommareaDescriptionResponse [dcrls=" + dcrls
				+ ", filler=" + filler + "]";
	}
	
	
	
	

}
