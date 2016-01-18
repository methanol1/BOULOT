package com.natixis.cco.upconnect.service.agence.up1;

import javax.enterprise.inject.Alternative;

import com.natixis.cco.upconnect.commarea.agence.AgenceUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.agence.AgenceUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.agence.AgenceUP1Description;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.agence.AgenceUP1RequestConverter;
import com.natixis.cco.upconnect.converter.agence.AgenceUP1ResponseConverter;
import com.natixis.cco.upconnect.modelUP.agence.InputAgenceUP1;
import com.natixis.cco.upconnect.modelUP.agence.OutputAgenceUP1;
import com.natixis.financement.middlesav.commun.exceptions.AgenceNonTrouveBusinessException;
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
public class AgenceUP1ServiceMock extends AgenceUP1Service {

	private static final String VERSION_SERVICE = "UP1-MOCK";

	public AgenceUP1ServiceMock() {
		inputConverter = new AgenceUP1RequestConverter();
		outputConverter = new AgenceUP1ResponseConverter();
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		return TypeTransaction.ASSURANCE;
	}

	@Override
	protected String getVersionUP() {
		return VERSION_SERVICE;
	}

	public OutputAgenceUP1 execute(InputAgenceUP1 input)
			throws ConverterException, AgenceNonTrouveBusinessException {
		return getAgence(input);
	}

	@Override
	public AgenceUP1CommareaDescriptionResponse doGetAgence(
			AgenceUP1CommareaDescriptionRequest inputUP) {
		// Construction d'un objet AgenceUP1CommareaDescriptionResponse
		// bouchonné
		AgenceUP1CommareaDescriptionResponse rep = new AgenceUP1CommareaDescriptionResponse();
		AgenceUP1Description agence = new AgenceUP1Description();
		if (inputUP.getNumeroAgence().equals("123")) {
			agence.setNomAgence("UneDeuxTrois");
		} else if (inputUP.getNumeroAgence().equals("456")) {
			agence.setNomAgence("QuatreCinqSix");
		} else {
			agence.setNomAgence("AutreAgence");
		}
		agence.setFermetureApresMidi1("fermetureApresMidi1");
		agence.setFermetureApresMidi2("fermetureApresMidi2");
		agence.setFermetureMatin1("fermetureMatin1");
		agence.setFermetureMatin2("fermetureMatin2");
		agence.setNumeroFax("9999999999");
		agence.setNumeroTel("0154252525");
		agence.setOuvertureApresMidi1("ouvertureApresMidi1");
		agence.setOuvertureApresMidi2("ouvertureApresMidi2");
		agence.setOuvertureMatin1("ouvertureMatin1");
		agence.setOuvertureMatin2("ouvertureMatin2");
		agence.setPlage1("plage1");
		agence.setPlage2("plage2");
		
		rep.setAgence(agence);
		return rep;
	}

}
