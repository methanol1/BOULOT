package com.natixis.cco.upconnect.service.rachat.up1;

import javax.enterprise.inject.Alternative;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1Description;
import com.natixis.cco.upconnect.commarea.rachat.RachatUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.rachat.RachatUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.rachat.RachatUP1Description;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.modelUP.rachat.InputRachatUP1;
import com.natixis.cco.upconnect.modelUP.rachat.OutputRachatUP1;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.RachatBusinessException;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

@Alternative
public class RachatUP1ServiceMock extends RachatUP1Service {

	private static final String VERSION_SERVICE = "UP1-MOCK";

	@Override
	protected String getVersionUP() {
		return VERSION_SERVICE;
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		return TypeTransaction.RACHAT;
	}


	public OutputRachatUP1 execute(InputRachatUP1 input)
			throws ConverterException, RachatBusinessException {
		return getRachat(input);
	}

	@Override
	public RachatUP1CommareaDescriptionResponse doGetRachat(
			RachatUP1CommareaDescriptionRequest inputUP) {
		// Construction d'un objet RachatUP1CommareaDescriptionResponse
		// bouchonné
		RachatUP1CommareaDescriptionResponse rep = new RachatUP1CommareaDescriptionResponse();
		RachatUP1Description rachat = new RachatUP1Description();
		if (inputUP.getNumeroDossier().equals("45966969696969")) {
			rachat.setMontantSoldeAnti("000000000700é");
		} else if (inputUP.getNumeroDossier().equals("15966969696969")) {
			rachat.setMontantSoldeAnti("000000000800é");
		} else {
			rachat.setMontantSoldeAnti("000000000900é");
		}
		
		rep.setRachat(rachat);
		return rep;
	}

}
