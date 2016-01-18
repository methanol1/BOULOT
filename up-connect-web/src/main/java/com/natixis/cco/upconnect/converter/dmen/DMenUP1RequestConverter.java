package com.natixis.cco.upconnect.converter.dmen;

import java.util.ArrayList;
import java.util.List;

import com.natixis.cco.upconnect.commarea.dmen.BaremeUP1Description;
import com.natixis.cco.upconnect.commarea.dmen.DMenUP1CommareaDescriptionRequest;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.modelUP.dmen.InputBaremeUP1;
import com.natixis.cco.upconnect.modelUP.dmen.InputDMenUP1;

public class DMenUP1RequestConverter implements InputConverter<InputDMenUP1, DMenUP1CommareaDescriptionRequest>  {

	@Override
	public DMenUP1CommareaDescriptionRequest extractInput(InputDMenUP1 input)
			throws ConverterException {
		DMenUP1CommareaDescriptionRequest request = new DMenUP1CommareaDescriptionRequest();
		
		request.setModeAppel(input.getModeAppel());
		request.setCodeBareme(input.getCodeBareme());
		request.setCodeDegressivite(input.getCodeDegressivite());
		request.setCodeSocComm(input.getCodeSocComm());
		request.setCma(input.getCma());
		request.setTauxAssurance(input.getTauxAssurance());
		request.setMontantFinancement(input.getMontantFinancement());
		request.setMontantReglement(input.getMontantReglement());
		request.setNbEcheancesSouhaitees(input.getNbEcheances());
		request.setDureeMaxFormule(input.getDureeMaxFormule());
		request.setNumroDossier(input.getNumeroDossier());
		request.setNbJokerReports(input.getNbJokerReport());
		
		/* Les baremes */
		List<BaremeUP1Description> liste = new ArrayList<BaremeUP1Description>();
		BaremeUP1Description baremeUP1;
		int count= 0;
		for (InputBaremeUP1 bareme : input.getBaremes()) {
			if(count == 20){
				break;//Il faut une iteration de 20 blocs de bareme.
			}
			baremeUP1 = new BaremeUP1Description();
			baremeUP1.setTnc(bareme.getTncAnnuel());
			baremeUP1.setDecouvertMax(bareme.getDecouvertMax());
			baremeUP1.setDecouvertMin(bareme.getDecouvertMin());
			liste.add(baremeUP1);
			count++;
		}
		while(count < 20){
			baremeUP1 = new BaremeUP1Description();
			baremeUP1.setTnc("00000000");
			baremeUP1.setDecouvertMax("00000000");
			baremeUP1.setDecouvertMin("00000000");
			liste.add(baremeUP1);
			count++;
		}
		
		for (int i = 0; i < liste.size(); i++) {
			BaremeUP1Description bd = liste.get(i);
		}
		
		
		request.setBaremes(liste);
		
		return request;
	}

}
