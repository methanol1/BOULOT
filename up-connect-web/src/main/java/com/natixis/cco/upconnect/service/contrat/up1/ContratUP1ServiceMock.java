package com.natixis.cco.upconnect.service.contrat.up1;

import javax.enterprise.inject.Alternative;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1Description;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.contrat.ContratUP1RequestConverter;
import com.natixis.cco.upconnect.converter.contrat.ContratUP1ResponseConverter;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP1;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP1;
import com.natixis.cco.upconnect.service.contrat.AbstractContratService;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.mock.Mock;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

/**
 * Ce bouchon permet de construire manuellement un objet ContratUP1CommareaDescriptionResponse.
 * Toute la partie commarea est "zappée"
 * @author steph
 *
 */
@Mock
@Alternative
public class ContratUP1ServiceMock extends ContratUP1Service {
	
	
	private static final String VERSION_SERVICE = "UP1-MOCK";
	
	public ContratUP1ServiceMock() {
		inputConverter = new ContratUP1RequestConverter();
		outputConverter = new ContratUP1ResponseConverter();
	}

	

	@Override
	public ContratUP1CommareaDescriptionResponse doGetContrat(
			ContratUP1CommareaDescriptionRequest inputUP) {
		//Construction d'un objet ContratUP1CommareaDescriptionResponse bouchonné
		ContratUP1CommareaDescriptionResponse rep = new ContratUP1CommareaDescriptionResponse();
		ContratUP1Description contrat = new ContratUP1Description();
		if(inputUP.getNumeroContrat().equals("45966969696969")){
			contrat.setPositionActuelle("SOL");
		}
		else if (inputUP.getNumeroContrat().equals("15966969696969")){
			contrat.setPositionActuelle("RET");
		}
		else{
			contrat.setPositionActuelle("ENC");
		}
		contrat.setNumeroSocieteFinanciere("111");
		contrat.setTypeProduit("FFF");
		contrat.setGestionContrat("AAA");
		
		rep.setContrat(contrat);
		return rep;
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		return TypeTransaction.CONTRAT;
	}


	@Override
	protected String getVersionUP() {
		return VERSION_SERVICE;
	}

	public OutputContratUP1 execute(InputContratUP1 input)
			throws ConverterException, ContratNonTrouveBusinessException {
		return getContrat(input);
	}

}
