package com.natixis.cco.upconnect.service.contrat.up2;

import javax.enterprise.inject.Alternative;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP2CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP2CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP2Description;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.contrat.ContratUP2RequestConverter;
import com.natixis.cco.upconnect.converter.contrat.ContratUP2ResponseConverter;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP2;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP2;
import com.natixis.cco.upconnect.service.contrat.AbstractContratService;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.mock.Mock;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

@Mock
@Alternative
public class ContratUP2ServiceMock extends ContratUP2Service {
	
	
	private static final String VERSION_SERVICE = "UP2-MOCK";
	
	public ContratUP2ServiceMock() {
		inputConverter = new ContratUP2RequestConverter();
		outputConverter = new ContratUP2ResponseConverter();
	}

	

	@Override
	public ContratUP2CommareaDescriptionResponse doGetContrat(
			ContratUP2CommareaDescriptionRequest inputUP) {
		//Construction d'un objet ContratUP2CommareaDescriptionResponse bouchonné
		ContratUP2CommareaDescriptionResponse rep = new ContratUP2CommareaDescriptionResponse();
		ContratUP2Description contrat = new ContratUP2Description();
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

	public OutputContratUP2 execute(InputContratUP2 input)
			throws ConverterException, ContratNonTrouveBusinessException {
		return getContrat(input);
	}

}
