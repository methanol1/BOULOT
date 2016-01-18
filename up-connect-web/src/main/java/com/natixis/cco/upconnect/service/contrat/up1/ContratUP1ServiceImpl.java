package com.natixis.cco.upconnect.service.contrat.up1;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.contrat.ContratUP1RequestConverter;
import com.natixis.cco.upconnect.converter.contrat.ContratUP1ResponseConverter;
import com.natixis.cco.upconnect.modelUP.contrat.InputContratUP1;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP1;
import com.natixis.cco.upconnect.service.contrat.AbstractContratService;
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
public class ContratUP1ServiceImpl extends ContratUP1Service {
		
	private final Logger logger = LoggerFactory
			.getLogger(ContratUP1ServiceImpl.class);

	private static final String VERSION_SERVICE = "UP1";

	public ContratUP1ServiceImpl() {
		inputConverter = new ContratUP1RequestConverter();
		outputConverter = new ContratUP1ResponseConverter();
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		return TypeTransaction.CONTRAT;
	}

	

	@Override
	public ContratUP1CommareaDescriptionResponse doGetContrat(
			ContratUP1CommareaDescriptionRequest requestUP) throws ContratNonTrouveBusinessException {
		try {
			// Appel United
			ContratUP1CommareaDescriptionResponse response = (ContratUP1CommareaDescriptionResponse) unitedDao
					.callUnited(requestUP,
							ContratUP1CommareaDescriptionResponse.class);
			// Gestion des exceptions
			if(null == response){
				logger.error("Objet réponse de l'appel UP est nul.");
				throw new SavTechnicalException(SavError.UNITED_TECHNIQUE);
			}
			
			// Les cas où le contrat est considéré non-trouvé : Cf codesContratNonTrouve
			if(Constantes.RETOUR_COMMAREA_KO.equals(response.getCodeRetourSimple())){
				if(codesContratNonTrouve.contains(response.getCodeRetourPrecis())){
					throw new ContratNonTrouveBusinessException("Code retour précis = "+response.getCodeRetourPrecis(),response.getCodeRetourPrecis());
				}
				throw new SavTechnicalException("Retour KO du service UP avec "+response.getCodeRetourPrecis()+" en code retour précis.");
			}
			else if(!Constantes.RETOUR_COMMAREA_OK.equals(response.getCodeRetourSimple())){
				throw new SavTechnicalException("Code retour du service UP : "+response.getCodeRetourSimple());
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

	public OutputContratUP1 execute(InputContratUP1 input)
			throws ConverterException, ContratNonTrouveBusinessException {
		return getContrat(input);
	}

	@Override
	protected String getVersionUP() {
		return VERSION_SERVICE;
	}

}
