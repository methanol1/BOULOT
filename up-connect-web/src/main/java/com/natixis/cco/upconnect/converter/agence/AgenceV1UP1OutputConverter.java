package com.natixis.cco.upconnect.converter.agence;

import static com.natixis.cco.upconnect.converter.ConstantesConverterField.*;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.UPResponseConverter;
import com.natixis.cco.upconnect.modelUP.agence.OutputAgenceUP1;
import com.natixis.cco.upconnect.modelnfi.agence.AgenceV1;

public class AgenceV1UP1OutputConverter extends
		UPResponseConverter<OutputAgenceUP1, AgenceV1> {

	public AgenceV1 extract(OutputAgenceUP1 outputUP) throws ConverterException {
		String field = "";
		try {
			AgenceV1 res = new AgenceV1();

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

			// Partie fonctionnelle
			field = fermetureApresMidi1;
			res.setFermetureApresMidi1(outputUP.getFermetureApresMidi1());
			field = fermetureApresMidi2;
			res.setFermetureApresMidi2(outputUP.getFermetureApresMidi2());
			field = fermetureMatin1;
			res.setFermetureMatin1(outputUP.getFermetureMatin1());
			field = fermetureMatin2;
			res.setFermetureMatin2(outputUP.getFermetureMatin2());
			field = nomAgence;
			res.setNomAgence(outputUP.getNomAgence());
			field = numeroFax;
			res.setNumeroFax(outputUP.getNumeroFax());
			field = numeroTel;
			res.setNumeroTel(outputUP.getNumeroTel());
			field = ouvertureApresMidi1;
			res.setOuvertureApresMidi1(outputUP.getOuvertureApresMidi1());
			field = ouvertureApresMidi2;
			res.setOuvertureApresMidi2(outputUP.getOuvertureApresMidi2());
			field = ouvertureMatin1;
			res.setOuvertureMatin1(outputUP.getOuvertureMatin1());
			field = ouvertureMatin2;
			res.setOuvertureMatin2(outputUP.getOuvertureMatin2());
			field = plage1;
			res.setPlage1(outputUP.getPlage1());
			field = plage2;
			res.setPlage2(outputUP.getPlage2());

			return res;
		} catch (Exception e) {
			throw new ConverterException(
					"Erreur de conversion OutputAgenceUP1 -> AgenceV1 : sur le champ "
							+ field, field);
		}
	}

}
