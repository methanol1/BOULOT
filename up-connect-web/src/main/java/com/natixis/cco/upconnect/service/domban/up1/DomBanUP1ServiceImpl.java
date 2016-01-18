package com.natixis.cco.upconnect.service.domban.up1;

import javax.enterprise.inject.Alternative;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.domban.DomBanUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.domban.DomBanUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.domban.DomBanUP1RequestConverter;
import com.natixis.cco.upconnect.converter.domban.DomBanUP1ResponseConverter;
import com.natixis.cco.upconnect.converter.domban.DomBanV1UP1InputConverter;
import com.natixis.cco.upconnect.converter.domban.DomBanV1UP1OutputConverter;
import com.natixis.cco.upconnect.modelUP.domban.InputDomBanUP1;
import com.natixis.cco.upconnect.modelUP.domban.OutputDomBanUP1;
import com.natixis.cco.upconnect.service.contrat.up1.ContratUP1ServiceImpl;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.DomBanBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SavError;
import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;
import com.natixis.financement.middlesav.united.exception.UnitedAuthentificationException;
import com.natixis.financement.middlesav.united.exception.UnitedTechnicalException;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

@Alternative
public class DomBanUP1ServiceImpl extends DomBanUP1Service {
	
	private final Logger logger = LoggerFactory
			.getLogger(DomBanUP1ServiceImpl.class);

	private static final String VERSION_SERVICE = "UP1";
	
	public DomBanUP1ServiceImpl() {
		inputConverter = new DomBanUP1RequestConverter();
		outputConverter = new DomBanUP1ResponseConverter();
	}

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
			DomBanUP1CommareaDescriptionRequest requestUP) throws DomBanBusinessException {
		try {
			// Appel United
			DomBanUP1CommareaDescriptionResponse response = (DomBanUP1CommareaDescriptionResponse) unitedDao
					.callUnited(requestUP,
							DomBanUP1CommareaDescriptionResponse.class);
			//Gestion des exception
			if (null == response) {
				logger.error("Objet réponse de l'appel UP est nul.");
				throw new SavTechnicalException(SavError.UNITED_TECHNIQUE);
			}

			// Les cas où le contrat est considéré non-trouvé : Cf
			// codesContratNonTrouve
			if (Constantes.RETOUR_COMMAREA_KO.equals(response
					.getCodeRetourSimple())) {
				if (codesDomBanNonTrouve.contains(response
						.getCodeRetourPrecis())) {
					throw new DomBanBusinessException("DomBan non trouvé",response
							.getCodeRetourPrecis());
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
