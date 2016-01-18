package com.natixis.cco.upconnect.converter.agence;

import com.natixis.cco.upconnect.commarea.agence.AgenceUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.modelUP.agence.OutputAgenceUP1;

public class AgenceUP1ResponseConverter
		implements
		OutputConverter<AgenceUP1CommareaDescriptionResponse, OutputAgenceUP1> {

	public OutputAgenceUP1 extract(
			AgenceUP1CommareaDescriptionResponse outputUP)
			throws ConverterException {
		OutputAgenceUP1 output = new OutputAgenceUP1();
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
		output.setFermetureApresMidi1(outputUP.getAgence().getFermetureApresMidi1());
		output.setFermetureApresMidi2(outputUP.getAgence().getFermetureApresMidi2());
		output.setFermetureMatin1(outputUP.getAgence().getFermetureMatin1());
		output.setFermetureMatin2(outputUP.getAgence().getFermetureMatin2());
		output.setNomAgence(outputUP.getAgence().getNomAgence());
		output.setNumeroFax(outputUP.getAgence().getNumeroFax());
		output.setNumeroTel(outputUP.getAgence().getNumeroTel());
		output.setOuvertureApresMidi1(outputUP.getAgence().getOuvertureApresMidi1());
		output.setOuvertureApresMidi2(outputUP.getAgence().getOuvertureApresMidi2());
		output.setOuvertureMatin1(outputUP.getAgence().getOuvertureMatin1());
		output.setOuvertureMatin2(outputUP.getAgence().getOuvertureMatin2());
		output.setPlage1(outputUP.getAgence().getPlage1());
		output.setPlage2(outputUP.getAgence().getPlage2());
		
		return output;
	}

}
