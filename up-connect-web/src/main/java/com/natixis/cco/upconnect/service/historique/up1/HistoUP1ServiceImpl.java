package com.natixis.cco.upconnect.service.historique.up1;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.commarea.historique.HistoResponseDescription;
import com.natixis.cco.upconnect.commarea.historique.HistoUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.commarea.historique.HistoUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.historique.HistoUP1RequestConverter;
import com.natixis.cco.upconnect.converter.historique.HistoUP1ResponseConverter;
import com.natixis.cco.upconnect.modelUP.historique.InputHistoUP1;
import com.natixis.cco.upconnect.modelUP.historique.OutputHistoUP1;
import com.natixis.cco.upconnect.service.dcrl.up1.DCrlUP1ServiceImpl;
import com.natixis.financement.middlesav.commun.exceptions.HistoriqueNonTrouveException;
import com.natixis.financement.middlesav.commun.exceptions.SavError;
import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;
import com.natixis.financement.middlesav.united.exception.UnitedAuthentificationException;
import com.natixis.financement.middlesav.united.exception.UnitedTechnicalException;
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

@Alternative
public class HistoUP1ServiceImpl extends HistoUP1Service{

	
	private final Logger logger = LoggerFactory.getLogger(DCrlUP1ServiceImpl.class);
	
	private static final String VERSION_SERVICE = "UP1";
	
	public HistoUP1ServiceImpl() {
		inputConverter = new HistoUP1RequestConverter();
		outputConverter = new HistoUP1ResponseConverter();
	}
	
	@Override
	public OutputHistoUP1 execute(InputHistoUP1 input)
			throws ConverterException, HistoriqueNonTrouveException {		
		return historiques(input);
	}




	@Override
	protected String getVersionUP() {
		return VERSION_SERVICE;
	}

	@Override
	protected TypeTransaction getTypeTransaction() {
		
		return TypeTransaction.HISTORIQUE_OPERATIONS;
	}



	@Override
	public HistoUP1CommareaDescriptionResponse getHistoriques(
			HistoUP1CommareaDescriptionRequest inputUP) throws HistoriqueNonTrouveException{
		try {
			// Appel United
			HistoUP1CommareaDescriptionResponse response = (HistoUP1CommareaDescriptionResponse) unitedDao
					.callUnited(inputUP,HistoUP1CommareaDescriptionResponse.class);
			//Gestion des exception
			if (null == response) {
				logger.error("Objet réponse de l'appel UP est nul.");
				throw new SavTechnicalException(SavError.SAV_TECHNIQUE_ERREUR," Objet réponse de l'appel UP est nul.");
			}
			if ("0".equals(response.getCodeRetourSimple())) {
				
				int nbmax = Integer.parseInt(inputUP.getNombreOperationMaxARestituer());
				List<HistoResponseDescription> histos = getHistoriquesRenseignes(response.getTableauDonneesSpecifiquesCB());
				
				if(histos.size() > nbmax) {
					throw new SavTechnicalException("Le nombre d'historiques retournés par UP est supérieur au nombre d'opérations max ( "+nbmax+" ) à restituer");
				}
				response.setTableauDonneesSpecifiquesCB(histos);
			
			}
			if ("1".equals(response.getCodeRetourSimple())) {
				if("DCDO16".equals(response.getCodeRetourPrecis())){
					throw new HistoriqueNonTrouveException("Code retour (simple, précis) du service UP : ("	+ response.getCodeRetourSimple()+","+response.getCodeRetourPrecis()+")",response.getCodeRetourPrecis());
				}
				else{
					throw new SavTechnicalException("Code retour (simple, précis) du service UP : ("
							+ response.getCodeRetourSimple()+","+response.getCodeRetourPrecis()+")");
				}
			}
			if ("2".equals(response.getCodeRetourSimple())) {
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
		}
	}

	private List<HistoResponseDescription> getHistoriquesRenseignes(
			List<HistoResponseDescription> tableauDonneesSpecifiquesCB) {
		
		List<HistoResponseDescription> listRenseignes = new ArrayList<HistoResponseDescription>();
		
		for(HistoResponseDescription histo : tableauDonneesSpecifiquesCB){			
			if(StringUtils.isNotEmpty(histo.getIdOperation()) && StringUtils.isNotEmpty(histo.getMontantOperation()) && StringUtils.isNotEmpty(histo.getCodeOperation())){
				listRenseignes.add(histo);
			}
		}
		return listRenseignes;
	}

}
