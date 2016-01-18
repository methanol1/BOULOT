package com.natixis.cco.upconnect.service.dmen.up1;

import java.util.Arrays;
import java.util.List;

import com.natixis.cco.upconnect.commarea.dmen.DMenUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.dmen.DMenUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.modelUP.dmen.InputDMenUP1;
import com.natixis.cco.upconnect.modelUP.dmen.OutputDMenUP1;
import com.natixis.cco.upconnect.service.dmen.AbstractDMenService;

public abstract class DMenUP1Service extends 
	AbstractDMenService<InputDMenUP1, DMenUP1CommareaDescriptionRequest, 
				DMenUP1CommareaDescriptionResponse, OutputDMenUP1> {
	protected static List<String> codesDossierNonTrouve = Arrays.asList("DMEN28","DMEN29","DMEN30","DMEN31");
	protected static String codesSocieteNonTrouve = "DMEN32";
}
