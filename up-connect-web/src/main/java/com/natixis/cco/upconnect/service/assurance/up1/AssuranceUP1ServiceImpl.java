package com.natixis.cco.upconnect.service.assurance.up1;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.commarea.assurance.AssuranceUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.assurance.AssuranceUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.assurance.AssuranceUP1RequestConverter;
import com.natixis.cco.upconnect.converter.assurance.AssuranceUP1ResponseConverter;
import com.natixis.cco.upconnect.modelUP.assurance.InputAssuranceUP1;
import com.natixis.cco.upconnect.modelUP.assurance.OutputAssuranceUP1;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP1;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP1;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SavError;
import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;
import com.natixis.financement.middlesav.united.exception.UnitedAuthentificationException;
import com.natixis.financement.middlesav.united.exception.UnitedTechnicalException;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

/**
 * Appel du bloc Assurance UP
 * 
 * @author steph
 *
 */
@Default
@Alternative
public class AssuranceUP1ServiceImpl extends AssuranceUP1Service {

	private final Logger logger = LoggerFactory
			.getLogger(AssuranceUP1ServiceImpl.class);

	private static final String VERSION_SERVICE = "UP1";

	public AssuranceUP1ServiceImpl() {
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
			AssuranceUP1CommareaDescriptionRequest inputUP) throws ContratNonTrouveBusinessException {
		try {
			// Appel United
			AssuranceUP1CommareaDescriptionResponse response = (AssuranceUP1CommareaDescriptionResponse) unitedDao
					.callUnited(inputUP,
							AssuranceUP1CommareaDescriptionResponse.class);
			// Gestion des exception
			if (null == response) {
				logger.error("Objet réponse de l'appel UP est nul.");
				throw new SavTechnicalException(SavError.UNITED_TECHNIQUE);
			}

			// Les cas où le contrat est considéré non-trouvé : Cf
			// codesContratNonTrouve
			if (Constantes.RETOUR_COMMAREA_KO.equals(response
					.getCodeRetourSimple())) {
				if (codesContratNonTrouve.contains(response
						.getCodeRetourPrecis())) {
					throw new ContratNonTrouveBusinessException(
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
