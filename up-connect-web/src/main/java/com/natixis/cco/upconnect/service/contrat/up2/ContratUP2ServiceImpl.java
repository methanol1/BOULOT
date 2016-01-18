package com.natixis.cco.upconnect.service.contrat.up2;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.commarea.contrat.ContratUP2CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP2CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.contrat.ContratUP2RequestConverter;
import com.natixis.cco.upconnect.converter.contrat.ContratUP2ResponseConverter;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP2;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP2;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SavError;
import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;
import com.natixis.financement.middlesav.united.exception.UnitedAuthentificationException;
import com.natixis.financement.middlesav.united.exception.UnitedTechnicalException;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

/**
 * Appel du bloc Dossier UP
 * 
 * @author steph
 *
 */
@Default
@Alternative
public class ContratUP2ServiceImpl extends ContratUP2Service {

	private final Logger logger = LoggerFactory
			.getLogger(ContratUP2ServiceImpl.class);

	protected static String VERSION_SERVICE = "UP2";

	public ContratUP2ServiceImpl() {
		inputConverter = new ContratUP2RequestConverter();
		outputConverter = new ContratUP2ResponseConverter();
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		return TypeTransaction.CONTRAT;
	}

	public OutputContratUP2 execute(InputContratUP2 input)
			throws ConverterException, ContratNonTrouveBusinessException {
		return getContrat(input);

	}

	@Override
	protected String getVersionUP() {
		return VERSION_SERVICE;
	}

	@Override
	public ContratUP2CommareaDescriptionResponse doGetContrat(
			ContratUP2CommareaDescriptionRequest requestUP) throws ContratNonTrouveBusinessException {
		try {
			// Appel United
			ContratUP2CommareaDescriptionResponse response = (ContratUP2CommareaDescriptionResponse) unitedDao
					.callUnited(requestUP,
							ContratUP2CommareaDescriptionResponse.class);
			// Gestion des exceptions
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
							"Due to code retour = "
									+ response.getCodeRetourPrecis(),response.getCodeRetourPrecis());
				}
				throw new SavTechnicalException("Retour KO du service UP avec "
						+ response.getCodeRetourPrecis()
						+ " en ccode retour précis.");
			} else if (!Constantes.RETOUR_COMMAREA_OK.equals(response
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
