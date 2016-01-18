package com.natixis.cco.upconnect.service.contrat.up2;

import java.util.Arrays;
import java.util.List;

import com.natixis.cco.upconnect.commarea.contrat.ContratUP2CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP2CommareaDescriptionResponse;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP2;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP2;
import com.natixis.cco.upconnect.service.contrat.AbstractContratService;

public abstract class ContratUP2Service extends AbstractContratService<InputContratUP2, ContratUP2CommareaDescriptionRequest, 
ContratUP2CommareaDescriptionResponse, OutputContratUP2> {
	
	protected static List<String> codesContratNonTrouve = 
			Arrays.asList("DCTR04","DCTR08","DCTR10","DCTR12","DCTR14","DCTR16","DCTR18","DCTR22", "DCTR26");

}
