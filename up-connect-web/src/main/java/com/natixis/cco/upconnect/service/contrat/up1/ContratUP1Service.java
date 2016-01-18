package com.natixis.cco.upconnect.service.contrat.up1;

import java.util.Arrays;
import java.util.List;

import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP1;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP1;
import com.natixis.cco.upconnect.service.contrat.AbstractContratService;

public abstract class ContratUP1Service
		extends
		AbstractContratService<InputContratUP1, ContratUP1CommareaDescriptionRequest, ContratUP1CommareaDescriptionResponse, OutputContratUP1> {

	protected static List<String> codesContratNonTrouve = 
			Arrays.asList("DCTR04","DCTR08","DCTR10","DCTR12","DCTR14","DCTR16","DCTR18","DCTR22", "DCTR26");
}
