package com.natixis.cco.upconnect.converter.dmen;

import static com.natixis.cco.upconnect.converter.ConstantesConverterField.*;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.UPResponseConverter;
import com.natixis.cco.upconnect.modelUP.dmen.OutputDMenUP1;
import com.natixis.cco.upconnect.modelnfi.dmen.DMenV1;

public class DMenV1UP1OutputConverter extends
		UPResponseConverter<OutputDMenUP1, DMenV1> {

	@Override
	public DMenV1 extract(OutputDMenUP1 outputUP) throws ConverterException {
		String field = "";
		try {
			DMenV1 res = new DMenV1();
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
			
			field=codeRetourGal;
			res.setCodeRetour(outputUP.getCodeRetourGal());
			field=codeRetourCompl;
			res.setCodeRetourComp(outputUP.getCodeRetourCompl());
			field=coutTotalAssur;
			res.setCoutTotalAssur(getBigDecFromString(outputUP.getCoutTotAssur(), 100));
			field=coutTotalInterets;
			res.setCoutTotalInterets(getBigDecFromString(outputUP.getCoutTotInterets(), 100));
			field=dureeRecalculee;
			res.setDureeRecalculee(getInteger(outputUP.getDureeCalculee()));
			field=montantDerniereMens;
			res.setMontantDerniereMens(getBigDecFromString(outputUP.getMontantDerniereMens(), 100));
			field=montantMensAAppliq;
			res.setMontantMensAAppliq(getBigDecFromString(outputUP.getMensAAppliquer(), 100));
			field=montantMensCalculee;
			res.setMontantMensCalculee(getBigDecFromString(outputUP.getMensCalculee(), 100));
			field=montantMensMaxi;
			res.setMontantMensMaxi(getBigDecFromString(outputUP.getMensMax(), 100));
			
			return res;
		} catch (Exception e) {
			throw new ConverterException(
					"Erreur de conversion OutputDMenUP1 -> DMenV1 : sur le champ "
							+ field,field);
		}
	}

}
