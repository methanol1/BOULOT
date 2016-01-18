package com.natixis.cco.upconnect.converter.dcrl;

import java.util.ArrayList;
import java.util.List;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.UPRequestConverter;
import com.natixis.cco.upconnect.modelUP.dcrl.InputBaremeUP1;
import com.natixis.cco.upconnect.modelUP.dcrl.InputDCrlUP1;
import com.natixis.cco.upconnect.modelUP.dcrl.InputDCrlUP1Description;
import com.natixis.cco.upconnect.modelnfi.dcrl.InputDCrlDescriptionV1;
import com.natixis.cco.upconnect.modelnfi.dcrl.InputDCrlV1;


public class DCrlV1UP1InputConverter extends UPRequestConverter<InputDCrlV1, InputDCrlUP1>{

	@Override
	public InputDCrlUP1 extractInput(InputDCrlV1 input)
			throws ConverterException {
		InputDCrlUP1 responses = new InputDCrlUP1();
		for(InputDCrlDescriptionV1 in : input.getInDescriptionV1s()){
		
			InputDCrlUP1Description res = new InputDCrlUP1Description();
			res.setDate(in.getDate());
			res.setMontantCapitalDu(getStringValueFromBigDec(in.getMontantCapitalDu(),8));
			res.setMontantFinan(getStringValueFromBigDec(in.getMontantFinan(),8));
			res.setMontantMens(getStringValueFromBigDec(in.getMontantMens(),8));
			res.setNbEcheance(getStringNValueFromInt(in.getNbEcheance(),2));
			res.setNbJokers(getStringNValueFromInt(in.getNbJokers(),1));
			res.setPasMens(getStringValueFromBigDec(in.getPasMens(),4));
			res.setTauxAssurance(getStringValueFromBigDec(in.getTauxAssurance(),8));
			
			//res.setBaremes();
			List<InputBaremeUP1> baremes = new ArrayList<InputBaremeUP1>();
			for (com.natixis.cco.upconnect.modelnfi.dcrl.BaremeV1 baremeV1 : in.getBaremes()) {
				InputBaremeUP1 baremeUP1 = new InputBaremeUP1();
				baremeUP1.setDecouvertMax(getStringValueFromBigDec(baremeV1.getDecouvertMax(),8));
				baremeUP1.setDecouvertMin(getStringValueFromBigDec(baremeV1.getDecouvertMin(),8));
				baremeUP1.setTncAnnuel(getTauxFromBigDec(baremeV1.getTncAnnuel()));
				baremes.add(baremeUP1);
			}
			res.setBaremes(baremes);
			responses.getIntputs().add(res);
		}
		return responses;
	}

}
