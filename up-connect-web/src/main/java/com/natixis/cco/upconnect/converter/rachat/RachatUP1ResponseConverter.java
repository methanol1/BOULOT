package com.natixis.cco.upconnect.converter.rachat;

import com.natixis.cco.upconnect.commarea.rachat.RachatUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP1;
import com.natixis.cco.upconnect.modelUP.rachat.OutputRachatUP1;

public class RachatUP1ResponseConverter implements
		OutputConverter<RachatUP1CommareaDescriptionResponse, OutputRachatUP1> {

	public OutputRachatUP1 extract(
			RachatUP1CommareaDescriptionResponse outputUP)
			throws ConverterException {

		OutputRachatUP1 output = 
				new OutputRachatUP1();
		//header
		output.setCodePaysISO(outputUP.getCodePaysISO());
		output.setCodeRetourPrecis(outputUP.getCodeRetourPrecis());
		output.setCodeRetourSimple(outputUP.getCodeRetourSimple());
		output.setIdCanal(outputUP.getIdCanal());
		output.setIdErreurMainframe(outputUP.getIdErreurMainframe());
		output.setIdFctAppelee(outputUP.getIdFctAppelee());
		output.setIdPartenaire(outputUP.getIdPartenaire());
		output.setIdRequete(outputUP.getIdRequete());
		output.setNumVersionEntete(outputUP.getNumVersionEntete());
		output.setProgrammeJavaAppelant(outputUP.getProgrammeJavaAppelant());
		output.setProgrammeMainframeAppele(outputUP.getProgrammeMainframeAppele());
		output.setTypeMessage(outputUP.getTypeMessage());
		output.setTypePasserelle(outputUP.getTypePasserelle());
		
		//Body
		output.setMontantSoldeAnti(outputUP.getRachat().getMontantSoldeAnti());
		output.setMontantTheoIra(outputUP.getRachat().getMontantTheoIra());
		output.setTauxIra(outputUP.getRachat().getTauxIraNegoc());
		
		return output;
	}

}
