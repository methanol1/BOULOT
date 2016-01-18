package com.natixis.cco.upconnect.service.agence.up1;

import java.util.Arrays;
import java.util.List;

import com.natixis.cco.upconnect.commarea.agence.AgenceUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.agence.AgenceUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.modelUP.agence.InputAgenceUP1;
import com.natixis.cco.upconnect.modelUP.agence.OutputAgenceUP1;
import com.natixis.cco.upconnect.service.agence.AbstractAgenceService;

public abstract class AgenceUP1Service
		extends
		AbstractAgenceService<InputAgenceUP1, AgenceUP1CommareaDescriptionRequest, AgenceUP1CommareaDescriptionResponse, OutputAgenceUP1> {

	protected static List<String> codesAgenceNonTrouve = Arrays
			.asList("DAGE03","DAGE05");
}
