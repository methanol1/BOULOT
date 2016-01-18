package com.natixis.cco.upconnect.commarea.dcrl;

import java.util.ArrayList;
import java.util.List;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;

import com.natixis.financement.middlesav.united.annotation.UnitedCommareaList;

public  class DCrlUP1CommareaDescriptionRequest extends UnitedCommareaDescriptionHeader{
	/**
	 * EIMDCRL-IN-TABLE
	 */
	@UnitedCommareaList(position=17, longueur=167, nombre=20)
	private List<DCrlUP1RequestDescription> dcrlsRequests;
	

	public List<DCrlUP1RequestDescription> getDcrlsRequests() {
		return dcrlsRequests;
	}

	public void setDcrlsRequests(List<DCrlUP1RequestDescription> dcrlsRequests) {
		this.dcrlsRequests = dcrlsRequests;
	}

	public DCrlUP1CommareaDescriptionRequest() {
		super();
		dcrlsRequests = new ArrayList<DCrlUP1RequestDescription>();
	}


	
	

}
