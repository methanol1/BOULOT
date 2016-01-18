package com.natixis.cco.upconnect.service.assurance.up1;

import java.util.Arrays;
import java.util.List;

import com.natixis.cco.upconnect.commarea.assurance.AssuranceUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.assurance.AssuranceUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.modelUP.assurance.InputAssuranceUP1;
import com.natixis.cco.upconnect.modelUP.assurance.OutputAssuranceUP1;
import com.natixis.cco.upconnect.service.assurance.AbstractAssuranceService;

public abstract class AssuranceUP1Service
		extends
		AbstractAssuranceService<InputAssuranceUP1, AssuranceUP1CommareaDescriptionRequest, AssuranceUP1CommareaDescriptionResponse, OutputAssuranceUP1> {

	protected static List<String> codesContratNonTrouve = Arrays
			.asList("DASU13","DASU15","DASU17","DASU19","DASU52","DASU54","DASU58","DASU60");
}
