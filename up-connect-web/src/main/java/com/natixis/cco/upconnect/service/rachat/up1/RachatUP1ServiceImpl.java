package com.natixis.cco.upconnect.service.rachat.up1;

import javax.enterprise.inject.Alternative;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.rachat.RachatUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.rachat.RachatUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.rachat.RachatUP1RequestConverter;
import com.natixis.cco.upconnect.converter.rachat.RachatUP1ResponseConverter;
import com.natixis.cco.upconnect.converter.rachat.RachatV1UP1InputConverter;
import com.natixis.cco.upconnect.converter.rachat.RachatV1UP1OutputConverter;
import com.natixis.cco.upconnect.modelUP.rachat.InputRachatUP1;
import com.natixis.cco.upconnect.modelUP.rachat.OutputRachatUP1;
import com.natixis.cco.upconnect.service.contrat.up1.ContratUP1ServiceImpl;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.RachatBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SavError;
import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;
import com.natixis.financement.middlesav.united.exception.UnitedAuthentificationException;
import com.natixis.financement.middlesav.united.exception.UnitedTechnicalException;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

@Alternative
public class RachatUP1ServiceImpl extends RachatUP1Service {
	
	private final Logger logger = LoggerFactory
			.getLogger(RachatUP1ServiceImpl.class);

	private static final String VERSION_SERVICE = "UP1";
	
	public RachatUP1ServiceImpl() {
		inputConverter = new RachatUP1RequestConverter();
		outputConverter = new RachatUP1ResponseConverter();
	}

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
			RachatUP1CommareaDescriptionRequest requestUP) throws RachatBusinessException {
		try {
			// Appel United
			RachatUP1CommareaDescriptionResponse response = (RachatUP1CommareaDescriptionResponse) unitedDao
					.callUnited(requestUP,
							RachatUP1CommareaDescriptionResponse.class);
			//Gestion des exception
			if (null == response) {
				logger.error("Objet réponse de l'appel UP est nul.");
				throw new SavTechnicalException(SavError.UNITED_TECHNIQUE);
			}
			if (Constantes.RETOUR_COMMAREA_KO.equals(response
					.getCodeRetourSimple())) {
				if (codesRachatPbCalcul.equals(response
						.getCodeRetourPrecis())) {
					throw new RachatBusinessException("Problème de calcul IRA", codesRachatPbCalcul);
				}
				else if(dateInvalide.equals(response.getCodeRetourPrecis())){
					throw new RachatBusinessException("Date rachat invalide", dateInvalide);
				}
				
				throw new SavTechnicalException("Retour KO du service UP avec "
						+ response.getCodeRetourPrecis()
						+ " en code retour précis.");
			} else if (!Constantes.RETOUR_COMMAREA_OK.equals(response
					.getCodeRetourSimple())) {
				throw new SavTechnicalException("Code retour du service UP : "
						+ response.getCodeRetourSimple());
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
