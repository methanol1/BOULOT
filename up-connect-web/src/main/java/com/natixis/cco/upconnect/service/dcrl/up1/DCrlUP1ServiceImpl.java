package com.natixis.cco.upconnect.service.dcrl.up1;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.commarea.dcrl.DCrlUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.dcrl.DCrlUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.dcrl.DCrlUP1ResponseDescription;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.dcrl.DCrlUP1RequestConverter;
import com.natixis.cco.upconnect.converter.dcrl.DCrlUP1ResponseConverter;
import com.natixis.cco.upconnect.modelUP.dcrl.InputDCrlUP1;
import com.natixis.cco.upconnect.modelUP.dcrl.OutputDCrlUP1;
import com.natixis.financement.middlesav.commun.exceptions.SavError;
import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;
import com.natixis.financement.middlesav.united.exception.UnitedAuthentificationException;
import com.natixis.financement.middlesav.united.exception.UnitedTechnicalException;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

@Alternative
public class DCrlUP1ServiceImpl extends DCrlUP1Service {

	
	private final Logger logger = LoggerFactory.getLogger(DCrlUP1ServiceImpl.class);
	
	private static final String VERSION_SERVICE = "UP1";
	
	public DCrlUP1ServiceImpl() {
		inputConverter = new DCrlUP1RequestConverter();
		outputConverter = new DCrlUP1ResponseConverter();
	}

	@Override
	public OutputDCrlUP1 execute(InputDCrlUP1 input) throws ConverterException {		
		return calculDCrl(input);
	}
	

	@Override
	public DCrlUP1CommareaDescriptionResponse doCalculDCrl(
			DCrlUP1CommareaDescriptionRequest inputUP) {
		try {
			// Appel United
			DCrlUP1CommareaDescriptionResponse response = (DCrlUP1CommareaDescriptionResponse) unitedDao
					.callUnited(inputUP,DCrlUP1CommareaDescriptionResponse.class);
			//Gestion des exception
			if (null == response) {
				logger.error("Objet réponse de l'appel UP est nul.");
				throw new SavTechnicalException(SavError.SAV_TECHNIQUE_ERREUR," Objet réponse de l'appel UP est nul.");
			}
			if ("0".equals(response.getCodeRetourSimple())){
				int nbRequete = inputUP.getDcrlsRequests().size();
				 List<DCrlUP1ResponseDescription> dcrls = getResponsesRenseignes(response.getDcrls());
				if(nbRequete != dcrls.size() ){
					throw new SavTechnicalException("Le nombre de réponses renvoyées par UP n'est pas égale au nombre de requêtes demandées");
				}
				response.setDcrls(dcrls);
				
			}
			if ("1".equals(response.getCodeRetourSimple()) || "2".equals(response.getCodeRetourSimple()) ) {
				throw new SavTechnicalException("Code retour (simple, précis) du service UP : ("
						+ response.getCodeRetourSimple()+","+response.getCodeRetourPrecis()+")");
			}
			return response;
		} catch (final UnitedTechnicalException e) {
			logger.error(e.getMessage());
			throw new SavTechnicalException(SavError.SAV_TECHNIQUE_ERREUR,
					e.getMessage());
		} catch (final UnitedAuthentificationException e) {
			logger.error(e.getMessage());
			throw new SavTechnicalException(
					SavError.UNITED_ERREUR_AUTHENTIFICATION, e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
			throw new SavTechnicalException(SavError.SAV_TECHNIQUE_ERREUR,
					e.getMessage());
		}
	}

	private List<DCrlUP1ResponseDescription> getResponsesRenseignes(
			List<DCrlUP1ResponseDescription> dcrls) {
		
		List<DCrlUP1ResponseDescription> list = new ArrayList<DCrlUP1ResponseDescription>();
		for(DCrlUP1ResponseDescription dcrl : dcrls){
			if(!"00000000".equals(dcrl.getMontantMensCalc()) && !"00".equals(dcrl.getNbEcheanceCalc())){
				list.add(dcrl);
			}			
		}
		return list;
	}

	@Override
	protected String getVersionUP() {
		return VERSION_SERVICE;
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		return TypeTransaction.DCRL;
	}

}
