package com.natixis.cco.upconnect.converter.domban;

import static com.natixis.cco.upconnect.converter.ConstantesConverterField.*;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.UPResponseConverter;
import com.natixis.cco.upconnect.modelUP.domban.OutputDomBanUP1;
import com.natixis.cco.upconnect.modelnfi.domban.DomBanV1;

public class DomBanV1UP1OutputConverter extends
		UPResponseConverter<OutputDomBanUP1, DomBanV1> {

	public DomBanV1 extract(OutputDomBanUP1 outputUP) throws ConverterException {
		String field = "";
		try {
			DomBanV1 res = new DomBanV1();
			// Partie header
			field = CodePaysISO;
			res.getHeader().setCodePaysISO(outputUP.getCodePaysISO());
			field = codeRetourSimple;
			res.getHeader().setCodeRetourSimple(outputUP.getCodeRetourSimple());
			field = codeRetourPrecis;
			res.getHeader().setCodeRetourPrecis(outputUP.getCodeRetourPrecis());
			field = idCanal;
			res.getHeader().setIdCanal(outputUP.getIdCanal());
			field = idErreurMainframe;
			res.getHeader().setIdErreurMainframe(
					outputUP.getIdErreurMainframe());
			field = idFctAppelee;
			res.getHeader().setIdFctAppelee(outputUP.getIdFctAppelee());
			field = idPartenaire;
			res.getHeader().setIdPartenaire(outputUP.getIdPartenaire());
			field = idRequete;
			res.getHeader().setIdRequete(outputUP.getIdRequete());
			field = numVersionEntete;
			res.getHeader().setNumVersionEntete(outputUP.getNumVersionEntete());
			field = programmeJavaAppelant;
			res.getHeader().setProgrammeJavaAppelant(
					outputUP.getProgrammeJavaAppelant());
			field = programmeMainframeAppele;
			res.getHeader().setProgrammeMainframeAppele(
					outputUP.getProgrammeMainframeAppele());
			field = typeMessage;
			res.getHeader().setTypeMessage(outputUP.getTypeMessage());
			field = typePasserelle;
			res.getHeader().setTypePasserelle(outputUP.getTypePasserelle());

			field=anneeOuverture;
			res.setAnneeOuverture(getInteger(outputUP.getAnneeOuverture()));
			field=codeBic;
			res.setCodeBic(outputUP.getCodeBic());
			field=codeIban;
			res.setCodeIban(outputUP.getCodeIban());
			field=codeIdentifiant;
			res.setCodeIdentifiant(getLong(outputUP.getCodeIdentifiant()));
			field=codeRum;
			res.setCodeRum(outputUP.getCodeRum());
			field=codeTitulaire;
			res.setCodeTitulaire(outputUP.getCodeTitulaire());
			field=dateCreation;
			res.setDateCreation(outputUP.getDateCreation());
			field=libelleDomiciliation;
			res.setLibelleDomiciliation(outputUP.getLibelleDomiciliation());
			field=nomTitulaire;
			res.setNomTitulaire(outputUP.getNomTitulaire());
			field=statutMandat;
			res.setStatutMandat(outputUP.getStatutMandat());
			field=typeCarte;
			res.setTypeCarte(outputUP.getTypeCarte());

			return res;
		} catch (Exception e) {
			throw new ConverterException(
					"Erreur de conversion OutputDomBanUP1 -> DomBanV1 : sur le champ "
							+ field,field);
		}
	}

}
