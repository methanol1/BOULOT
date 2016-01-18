package com.natixis.cco.upconnect.modelnfi.dcrl;


import java.util.ArrayList;
import java.util.List;




public class DCrlV1 {
	
	private DCrlV1Header header;
	
	private List<DCrlDescriptionV1> dcrlsResponses; 
	

	public DCrlV1() {
		super();
	 header = new DCrlV1Header();		
	 dcrlsResponses = new ArrayList<DCrlDescriptionV1>();		
		
	}

	public DCrlV1Header getHeader() {
		return header;
	}

	public void setHeader(DCrlV1Header header) {
		this.header = header;
	}

	public List<DCrlDescriptionV1> getDcrlsResponses() {
		return dcrlsResponses;
	}

	public void setDcrlsResponses(List<DCrlDescriptionV1> dcrlsResponses) {
		this.dcrlsResponses = dcrlsResponses;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DCrlV1 [header=");
		builder.append(header);
		builder.append(", dcrlsResponses=");
		builder.append(dcrlsResponses);
		builder.append("]");
		return builder.toString();
	}




	
	
	
	

}
