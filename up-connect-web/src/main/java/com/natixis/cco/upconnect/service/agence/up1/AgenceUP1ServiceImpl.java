package com.natixis.cco.upconnect.service.agence.up1;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.commarea.agence.AgenceUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.agence.AgenceUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.agence.AgenceUP1RequestConverter;
import com.natixis.cco.upconnect.converter.agence.AgenceUP1ResponseConverter;
import com.natixis.cco.upconnect.modelUP.agence.InputAgenceUP1;
import com.natixis.cco.upconnect.modelUP.agence.OutputAgenceUP1;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.exceptions.AgenceNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SavError;
import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;
import com.natixis.financement.middlesav.united.exception.UnitedAuthentificationException;
import com.natixis.financement.middlesav.united.exception.UnitedTechnicalException;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

/**
 * Appel du bloc Agence UP
 * 
 * @author steph
 *
 */
@Default
@Alternative
public class AgenceUP1ServiceImpl extends AgenceUP1Service {

	private final Logger logger = LoggerFactory
			.getLogger(AgenceUP1ServiceImpl.class);

	private static final String VERSION_SERVICE = "UP1";

	public AgenceUP1ServiceImpl() {
		inputConverter = new AgenceUP1RequestConverter();
		outputConverter = new AgenceUP1ResponseConverter();
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		return TypeTransaction.AGENCE;
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
			AgenceUP1CommareaDescriptionRequest inputUP) throws AgenceNonTrouveBusinessException {
		try {
			// Appel United
			AgenceUP1CommareaDescriptionResponse response = (AgenceUP1CommareaDescriptionResponse) unitedDao
					.callUnited(inputUP,
							AgenceUP1CommareaDescriptionResponse.class);
			// Gestion des exception
			if (null == response) {
				logger.error("Objet réponse de l'appel UP est nul.");
				throw new SavTechnicalException(SavError.UNITED_TECHNIQUE);
			}

			// Les cas où le contrat est considéré non-trouvé : Cf
			// codesContratNonTrouve
			if (Constantes.RETOUR_COMMAREA_KO.equals(response
					.getCodeRetourSimple())) {
				if (codesAgenceNonTrouve.contains(response
						.getCodeRetourPrecis())) {
					throw new AgenceNonTrouveBusinessException(
							"Code retour précis = "
									+ response.getCodeRetourPrecis(),response.getCodeRetourPrecis());
				}
				//TODO : Tester les codes retours précis donnant lieu à une erreur fonctionnelle autre que ContratNonTrouve.
				// else if...
				
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
