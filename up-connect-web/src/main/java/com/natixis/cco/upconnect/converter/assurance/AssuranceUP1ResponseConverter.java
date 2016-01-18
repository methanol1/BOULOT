package com.natixis.cco.upconnect.converter.assurance;

import com.natixis.cco.upconnect.commarea.assurance.AssuranceUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.modelUP.assurance.OutputAssuranceUP1;

public class AssuranceUP1ResponseConverter
		implements
		OutputConverter<AssuranceUP1CommareaDescriptionResponse, OutputAssuranceUP1> {

	public OutputAssuranceUP1 extract(
			AssuranceUP1CommareaDescriptionResponse outputUP)
			throws ConverterException {
		OutputAssuranceUP1 output = new OutputAssuranceUP1();
		// header
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
		output.setProgrammeMainframeAppele(outputUP
				.getProgrammeMainframeAppele());
		output.setTypeMessage(outputUP.getTypeMessage());
		output.setTypePasserelle(outputUP.getTypePasserelle());

		// Body
		output.setOptionCoSous(outputUP.getAssurance().getOptionCoSous());
		output.setOptionSous(outputUP.getAssurance().getOptionSous());
		output.setPrimeSous(outputUP.getAssurance().getPrimeSous());
		output.setPrimeCoSous(outputUP.getAssurance().getPrimeCoSous());
		output.setTauxMensSousc(outputUP.getAssurance().getTauxMenSous());
		output.setTauxMensCoSousc(outputUP.getAssurance().getTauxMenCoSous());
		output.setCodeConvention(outputUP.getAssurance().getCodeConv());
		output.setDateSous(outputUP.getAssurance().getDateSous());
		output.setDateCoSous(outputUP.getAssurance().getDateCoSous());
		
		return output;
	}

}
