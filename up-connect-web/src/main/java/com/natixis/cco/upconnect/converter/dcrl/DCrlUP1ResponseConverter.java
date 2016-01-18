package com.natixis.cco.upconnect.converter.dcrl;


import com.natixis.cco.upconnect.commarea.dcrl.DCrlUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.commarea.dcrl.DCrlUP1ResponseDescription;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.modelUP.dcrl.DCrlUP1Header;
import com.natixis.cco.upconnect.modelUP.dcrl.OutputDCrlUP1;
import com.natixis.cco.upconnect.modelUP.dcrl.OutputDCrlUP1Description;



public class DCrlUP1ResponseConverter implements OutputConverter<DCrlUP1CommareaDescriptionResponse, OutputDCrlUP1>{

	@Override
	public OutputDCrlUP1 extract(DCrlUP1CommareaDescriptionResponse outputUP)
			throws ConverterException {
		
		OutputDCrlUP1 output = new OutputDCrlUP1();
		// header
		DCrlUP1Header header = new DCrlUP1Header();
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
		
		//beady
		for( DCrlUP1ResponseDescription dcrl :outputUP.getDcrls()){
			OutputDCrlUP1Description out = new OutputDCrlUP1Description();
			out.setMontantAssurancePremiereMens(dcrl.getMontantAssurancePremiereMens());
			out.setMontantDerniereMens(dcrl.getMontantDerniereMens());
			out.setMontantMensCalc(dcrl.getMontantMensCalc());
			out.setMontantFinancable(dcrl.getMontantFinancable());
			out.setNbEcheanceCalc(dcrl.getNbEcheanceCalc());
			out.setCoutTotalAssurance(dcrl.getCoutTotalAssurance());
			out.setCodeRetCalc(dcrl.getCodeRetCalc());
			out.setCoutTotalInteret(dcrl.getCoutTotalInteret());
			out.setTaea(dcrl.getTaea());
			out.setTaegs(dcrl.getTaegs());
			output.getOutputs().add(out);
		}
		
		return output;
	}

}
