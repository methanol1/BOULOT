package com.natixis.cco.upconnect.converter.domban;

import com.natixis.cco.upconnect.commarea.domban.DomBanUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP1;
import com.natixis.cco.upconnect.modelUP.domban.OutputDomBanUP1;

public class DomBanUP1ResponseConverter implements
		OutputConverter<DomBanUP1CommareaDescriptionResponse, OutputDomBanUP1> {

	public OutputDomBanUP1 extract(
			DomBanUP1CommareaDescriptionResponse outputUP)
			throws ConverterException {

		OutputDomBanUP1 output = 
				new OutputDomBanUP1();
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
		output.setAnneeOuverture(outputUP.getDomban().getAnneeOuverture());
		output.setCodeBic(outputUP.getDomban().getCodeBic());
		output.setCodeIban(outputUP.getDomban().getCodeIban());
		output.setCodeIdentifiant(outputUP.getDomban().getCodeIdentifiant());
		output.setCodeRum(outputUP.getDomban().getCodeRum());
		output.setCodeTitulaire(outputUP.getDomban().getCodeTitulaireCompte());
		output.setDateCreation(outputUP.getDomban().getDateCreation());
		output.setLibelleDomiciliation(outputUP.getDomban().getLibelleDomiciliation());
		output.setNomTitulaire(outputUP.getDomban().getNomTitulaire());
		output.setStatutMandat(outputUP.getDomban().getStatutMandat());
		output.setTypeCarte(outputUP.getDomban().getTypeCarte());
		return output;
	}

}
