package com.natixis.cco.upconnect.converter.dmen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.UPRequestConverter;
import com.natixis.cco.upconnect.modelUP.dmen.InputBaremeUP1;
import com.natixis.cco.upconnect.modelUP.dmen.InputDMenUP1;
import com.natixis.cco.upconnect.modelnfi.dmen.BaremeV1;
import com.natixis.cco.upconnect.modelnfi.dmen.InputDMenV1;

public class DMenV1UP1InputConverter extends UPRequestConverter<InputDMenV1, InputDMenUP1> {

	@Override
	public InputDMenUP1 extractInput(InputDMenV1 input)
			throws ConverterException {
		InputDMenUP1 res = new InputDMenUP1();
		res.setCma(getStringValueFromBigDec(input.getCma(),8));
		res.setCodeBareme(getString3ValueFromInt(input.getCodeBareme()));
		res.setCodeDegressivite(getString3ValueFromInt(input.getDegressivite()));
		res.setCodeSocComm(String.valueOf(input.getCodeSocieteComm()));
		res.setDureeMaxFormule(getString3ValueFromInt(input.getDureeMaxFormule()));
		res.setModeAppel(input.getModeAppel());
		res.setMontantFinancement(getStringValueFromBigDec(input.getMontantFinancement(),8));
		res.setMontantReglement(getStringValueFromBigDec(input.getMontantReglement(),8));
		res.setNbEcheances(getString3ValueFromInt(input.getNbEchSouhaitee()));
		res.setNbJokerReport(String.valueOf(input.getNbJokerReport()));
		res.setNumeroDossier(input.getNumeroDossier());
		res.setTauxAssurance(getTauxFromBigDec(input.getTauxAssurance()));
		//res.setBaremes();
		List<InputBaremeUP1> baremes = new ArrayList<InputBaremeUP1>();
		for (BaremeV1 baremeV1 : input.getBaremes()) {
			InputBaremeUP1 baremeUP1 = new InputBaremeUP1();
			baremeUP1.setDecouvertMax(getStringValueFromBigDec(baremeV1.getDecouvertMax(),8));
			baremeUP1.setDecouvertMin(getStringValueFromBigDec(baremeV1.getDecouvertMin(),8));
			baremeUP1.setTncAnnuel(getTauxFromBigDec(baremeV1.getTncAnnuel()));
			baremes.add(baremeUP1);
		}
		res.setBaremes(baremes);
		return res;
	}

}
