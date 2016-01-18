package com.natixis.cco.upconnect.service.domban.up1;

import javax.enterprise.inject.Alternative;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1Description;
import com.natixis.cco.upconnect.commarea.domban.DomBanUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.domban.DomBanUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.domban.DomBanUP1Description;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.modelUP.domban.InputDomBanUP1;
import com.natixis.cco.upconnect.modelUP.domban.OutputDomBanUP1;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.DomBanBusinessException;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

@Alternative
public class DomBanUP1ServiceMock extends DomBanUP1Service {

	private static final String VERSION_SERVICE = "UP1-MOCK";

	@Override
	protected String getVersionUP() {
		return VERSION_SERVICE;
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		return TypeTransaction.DOMICILIATION_BANCAIRE;
	}


	public OutputDomBanUP1 execute(InputDomBanUP1 input)
			throws ConverterException, DomBanBusinessException {
		return getDomBan(input);
	}

	@Override
	public DomBanUP1CommareaDescriptionResponse doGetDomBan(
			DomBanUP1CommareaDescriptionRequest inputUP) {
		// Construction d'un objet DomBanUP1CommareaDescriptionResponse
		// bouchonné
		DomBanUP1CommareaDescriptionResponse rep = new DomBanUP1CommareaDescriptionResponse();
		DomBanUP1Description domban = new DomBanUP1Description();
		if (inputUP.getNumeroContrat().equals("45966969696969")) {
			domban.setAnneeOuverture("1999");;
		} else if (inputUP.getNumeroContrat().equals("15966969696969")) {
			domban.setAnneeOuverture("1998");
		} else {
			domban.setAnneeOuverture("2012");
		}
		
		rep.setDomban(domban);
		return rep;
	}

}
