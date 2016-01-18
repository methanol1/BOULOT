package com.natixis.cco.upconnect.service.dmen.up1;

import javax.enterprise.inject.Alternative;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.commarea.dmen.DMenUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.dmen.DMenUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.dmen.DMenUP1RequestConverter;
import com.natixis.cco.upconnect.converter.dmen.DMenUP1ResponseConverter;
import com.natixis.cco.upconnect.modelUP.dmen.InputDMenUP1;
import com.natixis.cco.upconnect.modelUP.dmen.OutputDMenUP1;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SavError;
import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;
import com.natixis.financement.middlesav.commun.exceptions.SocieteNonTrouveException;
import com.natixis.financement.middlesav.united.exception.UnitedAuthentificationException;
import com.natixis.financement.middlesav.united.exception.UnitedTechnicalException;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

@Alternative
public class DMenUP1ServiceImpl extends DMenUP1Service {
	
	private final Logger logger = LoggerFactory
			.getLogger(DMenUP1ServiceImpl.class);

	private static final String VERSION_SERVICE = "UP1";
	
	public DMenUP1ServiceImpl() {
		inputConverter = new DMenUP1RequestConverter();
		outputConverter = new DMenUP1ResponseConverter();
	}

	@Override
	protected String getVersionUP() {
		return VERSION_SERVICE;
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		return TypeTransaction.DMEN;
	}


	public OutputDMenUP1 execute(InputDMenUP1 input)
			throws ConverterException, ContratNonTrouveBusinessException,SocieteNonTrouveException {
		return calculDMen(input);
	}

	@Override
	public DMenUP1CommareaDescriptionResponse doCalculDMen(
			DMenUP1CommareaDescriptionRequest inputUP) throws ContratNonTrouveBusinessException, SocieteNonTrouveException {
		try {
			// Appel United
			DMenUP1CommareaDescriptionResponse response = (DMenUP1CommareaDescriptionResponse) unitedDao
					.callUnited(inputUP,
							DMenUP1CommareaDescriptionResponse.class);
			//Gestion des exception
			if (null == response) {
				logger.error("Objet réponse de l'appel UP est nul.");
				throw new SavTechnicalException(SavError.UNITED_TECHNIQUE);
			}
			if (Constantes.RETOUR_COMMAREA_KO.equals(response
					.getCodeRetourSimple())) {
				if(codesDossierNonTrouve.contains(response.getCodeRetourPrecis())){
					throw new ContratNonTrouveBusinessException("Code retour précis = "+response.getCodeRetourPrecis(),response.getCodeRetourPrecis());
				}
				if(codesSocieteNonTrouve.equals(response.getCodeRetourPrecis())){
					throw new SocieteNonTrouveException("Code retour précis = "+response.getCodeRetourPrecis(),response.getCodeRetourPrecis());
				}
				else{
					throw new SavTechnicalException("Code retour (simple, précis) du service UP : ("
							+ response.getCodeRetourSimple()+","+response.getCodeRetourPrecis()+")");
				}
			}
			else if (!Constantes.RETOUR_COMMAREA_OK.equals(response
					.getCodeRetourSimple())) {
				throw new SavTechnicalException("Code retour (simple, précis) du service UP : ("
						+ response.getCodeRetourSimple()+","+response.getCodeRetourPrecis()+")");
			}
			return response;
		} catch (final UnitedTechnicalException e) {
			logger.error(e.getMessage());
			throw new SavTechnicalException(SavError.UNITED_TECHNIQUE,
					e.getMessage());
		} catch (final UnitedAuthentificationException e) {
			logger.error(e.getMessage());
			throw new SavTechnicalException(
					SavError.UNITED_ERREUR_AUTHENTIFICATION, e.getMessage());
		}
	}

}
