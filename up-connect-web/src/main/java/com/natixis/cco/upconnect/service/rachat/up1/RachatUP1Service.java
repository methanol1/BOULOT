package com.natixis.cco.upconnect.service.rachat.up1;

import com.natixis.cco.upconnect.commarea.rachat.RachatUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.rachat.RachatUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.modelUP.rachat.InputRachatUP1;
import com.natixis.cco.upconnect.modelUP.rachat.OutputRachatUP1;
import com.natixis.cco.upconnect.service.rachat.AbstractRachatService;

public abstract class RachatUP1Service
		extends
		AbstractRachatService<InputRachatUP1, RachatUP1CommareaDescriptionRequest, RachatUP1CommareaDescriptionResponse, OutputRachatUP1> {

	public static String codesRachatPbCalcul = "DRCH03";
	public static String dateInvalide = "DRCH04";
}
