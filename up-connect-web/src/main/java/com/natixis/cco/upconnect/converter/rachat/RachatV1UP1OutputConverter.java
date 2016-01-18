package com.natixis.cco.upconnect.converter.rachat;

import static com.natixis.cco.upconnect.converter.ConstantesConverterField.*;

import com.natixis.cco.upconnect.converter.COBOLDecimal;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.UPResponseConverter;
import com.natixis.cco.upconnect.modelUP.rachat.OutputRachatUP1;
import com.natixis.cco.upconnect.modelnfi.rachat.RachatV1;

public class RachatV1UP1OutputConverter extends
		UPResponseConverter<OutputRachatUP1, RachatV1> {

	public RachatV1 extract(OutputRachatUP1 outputUP) throws ConverterException {
		String field="";
		try{
		RachatV1 res = new RachatV1();
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
		res.getHeader().setIdErreurMainframe(outputUP.getIdErreurMainframe());
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

		field=montantSoldeAnti;
		res.setMontantSoldeAnti(getBigDec(outputUP.getMontantSoldeAnti(),
				COBOLDecimal.S9_11_V9_2));
		field=montantTheoIra;
		res.setMontantTheoIra(getBigDec(outputUP.getMontantTheoIra(),
				COBOLDecimal.S9_11_V9_2));
		field=tauxIra;
		res.setTauxIra(getBigDec(outputUP.getTauxIra(), COBOLDecimal.S9_5_V9_2));

		return res;
		}catch(Exception e) {
			throw new ConverterException(
					"Erreur de conversion OutputRachatUP1 -> RachatV1 : sur le champ "
							+ field,field);
		}
	}

}
