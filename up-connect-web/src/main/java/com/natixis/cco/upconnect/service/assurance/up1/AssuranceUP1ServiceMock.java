package com.natixis.cco.upconnect.service.assurance.up1;

import javax.enterprise.inject.Alternative;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.commarea.assurance.AssuranceUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.assurance.AssuranceUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.assurance.AssuranceUP1Description;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.assurance.AssuranceUP1RequestConverter;
import com.natixis.cco.upconnect.converter.assurance.AssuranceUP1ResponseConverter;
import com.natixis.cco.upconnect.modelUP.assurance.InputAssuranceUP1;
import com.natixis.cco.upconnect.modelUP.assurance.OutputAssuranceUP1;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.mock.Mock;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

/**
 * Ce bouchon permet de construire manuellement un objet
 * ContratUP1CommareaDescriptionResponse. Toute la partie commarea est "zappée"
 * 
 * @author steph
 *
 */
@Mock
@Alternative
public class AssuranceUP1ServiceMock extends AssuranceUP1Service {

	private static final String VERSION_SERVICE = "UP1-MOCK";

	public AssuranceUP1ServiceMock() {
		inputConverter = new AssuranceUP1RequestConverter();
		outputConverter = new AssuranceUP1ResponseConverter();
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		return TypeTransaction.ASSURANCE;
	}

	@Override
	protected String getVersionUP() {
		return VERSION_SERVICE;
	}

	public OutputAssuranceUP1 execute(InputAssuranceUP1 input)
			throws ConverterException, ContratNonTrouveBusinessException {
		return getAssurance(input);
	}

	@Override
	public AssuranceUP1CommareaDescriptionResponse doGetAssurance(
			AssuranceUP1CommareaDescriptionRequest inputUP) {
		// Construction d'un objet AssuranceUP1CommareaDescriptionResponse
		// bouchonné
		AssuranceUP1CommareaDescriptionResponse rep = new AssuranceUP1CommareaDescriptionResponse();
		AssuranceUP1Description assurance = new AssuranceUP1Description();
		if (inputUP.getNumeroContrat().equals("45966969696969")) {
			assurance.setOptionSous("ABCDE");
		} else if (inputUP.getNumeroContrat().equals("15966969696969")) {
			assurance.setOptionSous("FGHIJ");
		} else {
			assurance.setOptionSous("ZZZZZ");
		}
		assurance.setCodeConv("9885V");
		assurance.setDateSous("19.01.2015");
		assurance.setDateCoSous("20.04.2015");
		assurance.setPrimeSous("17.5");
		assurance.setPrimeCoSous("0");
		assurance.setTauxMenSous("0.0008");
		assurance.setTauxMenCoSous("0");
		rep.setAssurance(assurance);
		return rep;
	}

}
