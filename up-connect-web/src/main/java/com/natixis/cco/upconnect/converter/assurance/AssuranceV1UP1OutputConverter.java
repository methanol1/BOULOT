package com.natixis.cco.upconnect.converter.assurance;

import com.natixis.cco.upconnect.converter.COBOLDecimal;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.UPResponseConverter;
import com.natixis.cco.upconnect.modelUP.assurance.OutputAssuranceUP1;
import com.natixis.cco.upconnect.modelnfi.assurance.AssuranceV1;

import static com.natixis.cco.upconnect.converter.ConstantesConverterField.*;

public class AssuranceV1UP1OutputConverter extends
		UPResponseConverter<OutputAssuranceUP1, AssuranceV1> {

	public AssuranceV1 extract(OutputAssuranceUP1 outputUP)
			throws ConverterException {
		String field="";
		try {
			AssuranceV1 res = new AssuranceV1();
			// Partie header
			field=CodePaysISO;
			res.getHeader().setCodePaysISO(outputUP.getCodePaysISO());
			field=codeRetourSimple;
			res.getHeader().setCodeRetourSimple(outputUP.getCodeRetourSimple());
			field=codeRetourPrecis;
			res.getHeader().setCodeRetourPrecis(outputUP.getCodeRetourPrecis());
			field=idCanal;
			res.getHeader().setIdCanal(outputUP.getIdCanal());
			field=idErreurMainframe;
			res.getHeader().setIdErreurMainframe(
					outputUP.getIdErreurMainframe());
			field=idFctAppelee;
			res.getHeader().setIdFctAppelee(outputUP.getIdFctAppelee());
			field=idPartenaire;
			res.getHeader().setIdPartenaire(outputUP.getIdPartenaire());
			field=idRequete;
			res.getHeader().setIdRequete(outputUP.getIdRequete());
			field=numVersionEntete;
			res.getHeader().setNumVersionEntete(outputUP.getNumVersionEntete());
			field=programmeJavaAppelant;
			res.getHeader().setProgrammeJavaAppelant(
					outputUP.getProgrammeJavaAppelant());
			field=programmeMainframeAppele;
			res.getHeader().setProgrammeMainframeAppele(
					outputUP.getProgrammeMainframeAppele());
			field=typeMessage;
			res.getHeader().setTypeMessage(outputUP.getTypeMessage());
			field=typePasserelle;
			res.getHeader().setTypePasserelle(outputUP.getTypePasserelle());

			field=tauxMensSousc;
			res.setTauxMensSousc(getBigDec(outputUP.getTauxMensSousc(),
					COBOLDecimal.S9_2_V9_5));
			field=tauxMensCoSousc;
			res.setTauxMensCoSousc(getBigDec(outputUP.getTauxMensCoSousc(),
					COBOLDecimal.S9_2_V9_5));
			field=optionSous;
			res.setOptionSous(outputUP.getOptionSous());
			field=optionCoSous;
			res.setOptionCoSous(outputUP.getOptionCoSous());
			field=primeSous;
			res.setPrimeSous(getBigDec(outputUP.getPrimeSous(),
					COBOLDecimal.S9_11_V9_2));
			field=primeCoSous;
			res.setPrimeCoSous(getBigDec(outputUP.getPrimeCoSous(),
					COBOLDecimal.S9_11_V9_2));
			field=codeConvention;
			res.setCodeConvention(outputUP.getCodeConvention());
			field=dateSous;
			res.setDateSous(outputUP.getDateSous());
			field=dateCoSous;
			res.setDateCoSous(outputUP.getDateCoSous());
			return res;
		} catch (Exception e) {
			throw new ConverterException("Erreur de conversion OutputAssuranceUP1 -> AssuranceV1 : sur le champ "+field,field);
		}
	}

}
