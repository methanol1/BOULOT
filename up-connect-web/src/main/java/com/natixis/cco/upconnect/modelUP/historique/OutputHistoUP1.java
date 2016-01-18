package com.natixis.cco.upconnect.modelUP.historique;

import java.util.ArrayList;
import java.util.List;

public class OutputHistoUP1 {
	
	private HistoUP1Header header;
	private List<OutputHistoDescription> operations;
	private String finDeListe;
	
	public OutputHistoUP1() {
		super();
		operations = new ArrayList<OutputHistoDescription>();
	}
	public HistoUP1Header getHeader() {
		return header;
	}
	public void setHeader(HistoUP1Header header) {
		this.header = header;
	}
	public List<OutputHistoDescription> getOperations() {
		return operations;
	}
	public void setOperations(List<OutputHistoDescription> operations) {
		this.operations = operations;
	}
	public String getFinDeListe() {
		return finDeListe;
	}
	public void setFinDeListe(String finDeListe) {
		this.finDeListe = finDeListe;
	}
	
	
	
	

}
