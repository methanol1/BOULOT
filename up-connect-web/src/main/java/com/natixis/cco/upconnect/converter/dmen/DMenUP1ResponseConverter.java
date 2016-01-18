package com.natixis.cco.upconnect.converter.dmen;

import com.natixis.cco.upconnect.commarea.dmen.DMenUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.modelUP.dmen.OutputDMenUP1;

public class DMenUP1ResponseConverter implements OutputConverter<DMenUP1CommareaDescriptionResponse, OutputDMenUP1> {

	@Override
	public OutputDMenUP1 extract(DMenUP1CommareaDescriptionResponse outputUP)
			throws ConverterException {
		OutputDMenUP1 output = new OutputDMenUP1();
		
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
		
		output.setCodeRetourGal(outputUP.getDmen().getCodeRetour());
		output.setCodeRetourCompl(outputUP.getDmen().getCodeRetourComp());
		output.setCoutTotAssur(outputUP.getDmen().getCoutTotAssurance());
		output.setCoutTotInterets(outputUP.getDmen().getCoutTotInterets());
		output.setDureeCalculee(outputUP.getDmen().getDuree());
		output.setMensAAppliquer(outputUP.getDmen().getMensAAppliquer());
		output.setMensCalculee(outputUP.getDmen().getMensCalculee());
		output.setMensMax(outputUP.getDmen().getMensMax());
		output.setMontantDerniereMens(outputUP.getDmen().getMontantDerniereMens());
		
		return output;
	}

}
