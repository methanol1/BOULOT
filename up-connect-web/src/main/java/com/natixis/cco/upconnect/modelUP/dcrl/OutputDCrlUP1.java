package com.natixis.cco.upconnect.modelUP.dcrl;

import java.util.ArrayList;
import java.util.List;

public class OutputDCrlUP1 {
	
	//HEAD
	private DCrlUP1Header header;
	
	//BEADY
	
	private List<OutputDCrlUP1Description> outputs;
	
	

	public List<OutputDCrlUP1Description> getOutputs() {
		return outputs;
	}

	public void setOutputs(List<OutputDCrlUP1Description> outputs) {
		this.outputs = outputs;
	}

	public DCrlUP1Header getHeader() {
		return header;
	}

	public void setHeader(DCrlUP1Header header) {
		this.header = header;
	}

	public OutputDCrlUP1() {
		super();
		outputs = new ArrayList<OutputDCrlUP1Description>();
	}

	
	
	

}
