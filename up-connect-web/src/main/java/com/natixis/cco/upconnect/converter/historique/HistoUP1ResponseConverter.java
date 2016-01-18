package com.natixis.cco.upconnect.converter.historique;

import com.natixis.cco.upconnect.commarea.historique.HistoResponseDescription;
import com.natixis.cco.upconnect.commarea.historique.HistoUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.COBOLDecimal;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.modelUP.historique.HistoUP1Header;
import com.natixis.cco.upconnect.modelUP.historique.OutputHistoDescription;
import com.natixis.cco.upconnect.modelUP.historique.OutputHistoUP1;

public class HistoUP1ResponseConverter implements OutputConverter<HistoUP1CommareaDescriptionResponse, OutputHistoUP1> {

	@Override
	public OutputHistoUP1 extract(HistoUP1CommareaDescriptionResponse outputUP)
			throws ConverterException {
		OutputHistoUP1 output = new OutputHistoUP1();
		// header
		HistoUP1Header header = new HistoUP1Header();
		header.setCodePaysISO(outputUP.getCodePaysISO());
		header.setCodeRetourPrecis(outputUP.getCodeRetourPrecis());
		header.setCodeRetourSimple(outputUP.getCodeRetourSimple());
		header.setIdCanal(outputUP.getIdCanal());
		header.setIdErreurMainframe(outputUP.getIdErreurMainframe());
		header.setIdFctAppelee(outputUP.getIdFctAppelee());
		header.setIdPartenaire(outputUP.getIdPartenaire());
		header.setIdRequete(outputUP.getIdRequete());
		header.setNumVersionEntete(outputUP.getNumVersionEntete());
		header.setProgrammeJavaAppelant(outputUP.getProgrammeJavaAppelant());
		header.setProgrammeMainframeAppele(outputUP
				.getProgrammeMainframeAppele());
		header.setTypeMessage(outputUP.getTypeMessage());
		header.setTypePasserelle(outputUP.getTypePasserelle());
		output.setHeader(header);
		

		for(HistoResponseDescription op :outputUP.getTableauDonneesSpecifiquesCB()){
			
			OutputHistoDescription opDescription = new OutputHistoDescription();
			opDescription.setCodeOperation(op.getCodeOperation());
			opDescription.setDateOperation(op.getDateOperation());
			opDescription.setDateFonctionnelle2(op.getDateFonctionnelle2());
			opDescription.setMontantOperation(op.getMontantOperation());
			opDescription.setNumeroCheque(op.getNumeroCheque());
			opDescription.setIdOperation(op.getIdOperation());
	
			output.getOperations().add(opDescription );
			
		}
		output.setFinDeListe(outputUP.getFinDeListe());
		return output;
	}

}
