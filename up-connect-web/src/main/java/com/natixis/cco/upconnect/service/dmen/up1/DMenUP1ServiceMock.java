package com.natixis.cco.upconnect.service.dmen.up1;

import javax.enterprise.inject.Alternative;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1Description;
import com.natixis.cco.upconnect.commarea.dmen.DMenUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.dmen.DMenUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.dmen.DMenUP1Description;
import com.natixis.cco.upconnect.commarea.domban.DomBanUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.domban.DomBanUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.domban.DomBanUP1Description;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.modelUP.dmen.InputDMenUP1;
import com.natixis.cco.upconnect.modelUP.dmen.OutputDMenUP1;
import com.natixis.cco.upconnect.modelUP.domban.InputDomBanUP1;
import com.natixis.cco.upconnect.modelUP.domban.OutputDomBanUP1;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.DomBanBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SocieteNonTrouveException;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

@Alternative
public class DMenUP1ServiceMock extends DMenUP1Service {

	private static final String VERSION_SERVICE = "UP1-MOCK";

	@Override
	protected String getVersionUP() {
		return VERSION_SERVICE;
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		return TypeTransaction.DMEN;
	}

	@Override
	public DMenUP1CommareaDescriptionResponse doCalculDMen(
			DMenUP1CommareaDescriptionRequest inputUP) throws ContratNonTrouveBusinessException, SocieteNonTrouveException {
		DMenUP1CommareaDescriptionResponse rep = new DMenUP1CommareaDescriptionResponse();
		DMenUP1Description dmen = new DMenUP1Description();
		dmen.setCodeRetour("1");
		dmen.setCodeRetourComp("AAAA");
		dmen.setCoutTotAssurance("00004590");
		dmen.setCoutTotInterets("00001259");
		dmen.setDuree("012");
		dmen.setMensAAppliquer("00014568");
		dmen.setMensCalculee("00016834");
		dmen.setMensMax("00017000");
		dmen.setMontantDerniereMens("00010254");
		rep.setDmen(dmen);

		return rep;
	}

	@Override
	public OutputDMenUP1 execute(InputDMenUP1 input) throws ConverterException, ContratNonTrouveBusinessException,SocieteNonTrouveException {
		return calculDMen(input);
	}

}
