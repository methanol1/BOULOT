package com.natixis.cco.upconnect.service.domban.up1;

import java.util.Arrays;
import java.util.List;

import com.natixis.cco.upconnect.commarea.domban.DomBanUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.domban.DomBanUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.modelUP.domban.InputDomBanUP1;
import com.natixis.cco.upconnect.modelUP.domban.OutputDomBanUP1;
import com.natixis.cco.upconnect.service.domban.AbstractDomBanService;

public abstract class DomBanUP1Service
		extends
		AbstractDomBanService<InputDomBanUP1, DomBanUP1CommareaDescriptionRequest, DomBanUP1CommareaDescriptionResponse, OutputDomBanUP1> {

	protected static List<String> codesDomBanNonTrouve = 
			Arrays.asList("DBQE03","DBQE05"); 
}
