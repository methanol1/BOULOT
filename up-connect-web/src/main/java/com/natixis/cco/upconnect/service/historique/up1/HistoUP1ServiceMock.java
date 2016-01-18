package com.natixis.cco.upconnect.service.historique.up1;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

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
import com.natixis.financement.middlesav.united.service.enums.TypeTransaction;

@Alternative
public class HistoUP1ServiceMock extends HistoUP1Service{

	
	private final Logger logger = LoggerFactory.getLogger(DCrlUP1ServiceImpl.class);
	
	private static final String VERSION_SERVICE = "UP1";
	
	public HistoUP1ServiceMock() {
		inputConverter = new HistoUP1RequestConverter();
		outputConverter = new HistoUP1ResponseConverter();
	}
	
	@Override
	public OutputHistoUP1 execute(InputHistoUP1 input)
			throws ConverterException,HistoriqueNonTrouveException{
		
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
			HistoUP1CommareaDescriptionRequest inputUP) {
		HistoUP1CommareaDescriptionResponse res = new HistoUP1CommareaDescriptionResponse();
		List<HistoResponseDescription> operations = new ArrayList<HistoResponseDescription>();
		try{
			HistoResponseDescription histo = new HistoResponseDescription();
			histo.setCodeOperation("108");
			histo.setDateOperation("20150707");
			histo.setDateFonctionnelle2("20150608");
			histo.setMontantOperation("0000004183L");
			histo.setIdOperation("2015-07-07-07.19.58.741788");
			histo.setNumeroCheque("000");
			histo.setNomBanqueDePrelevement("");
			histo.setLieuEtNumeroMobile("");
			operations.add(histo);
			
			histo = new HistoResponseDescription();
			histo.setCodeOperation("028");
			histo.setDateOperation("20150707");
			histo.setDateFonctionnelle2("20150608");
			histo.setMontantOperation("0000004183C");
			histo.setIdOperation("2015-07-07-07.19.58.741952");
			histo.setNumeroCheque("000");
			histo.setNomBanqueDePrelevement("");
			histo.setLieuEtNumeroMobile("");
			operations.add(histo);
			
			res.setTableauDonneesSpecifiquesCB(operations);
			
	}catch (Exception e) {
		logger.error(e.getMessage());
		throw new SavTechnicalException(SavError.SAV_TECHNIQUE_ERREUR,
				e.getMessage());
	}
		return res;
	}

}
