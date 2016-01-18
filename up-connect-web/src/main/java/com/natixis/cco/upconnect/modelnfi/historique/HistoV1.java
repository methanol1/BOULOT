package com.natixis.cco.upconnect.modelnfi.historique;

import java.util.ArrayList;
import java.util.List;

public class HistoV1 {
	
	private HistoV1Header header;
	
	private List<HistoDescriptionV1> operations;
	
	private String finDeListe;
	

	public HistoV1() {
		super();
		operations= new ArrayList<HistoDescriptionV1>();
	}

	public List<HistoDescriptionV1> getOperations() {
		return operations;
	}

	public void setOperations(List<HistoDescriptionV1> operations) {
		this.operations = operations;
	}

	public HistoV1Header getHeader() {
		return header;
	}

	public void setHeader(HistoV1Header header) {
		this.header = header;
	}

	public String getFinDeListe() {
		return finDeListe;
	}

	public void setFinDeListe(String finDeListe) {
		this.finDeListe = finDeListe;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HistoV1 [header=");
		builder.append(header);
		builder.append(", operations=");
		builder.append(operations);
		builder.append(", finDeListe=");
		builder.append(finDeListe);
		builder.append("]");
		return builder.toString();
	}

	
	
	

}
