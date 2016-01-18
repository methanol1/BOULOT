package com.natixis.cco.upconnect.converter.dcrl;

import static com.natixis.cco.upconnect.converter.ConstantesConverterField.CodePaysISO;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeRetourPrecis;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeRetourSimple;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.idCanal;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.idErreurMainframe;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.idFctAppelee;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.idPartenaire;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.idRequete;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.numVersionEntete;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.programmeJavaAppelant;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.programmeMainframeAppele;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.typeMessage;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.typePasserelle;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantMensCalc;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.nbEcheanceCalc;	
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.coutTotalInteret;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.coutTotalAssurance;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.taea;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantAssurancePremiereMens;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantFinancable;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeRetCalc;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantDerniereMens;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.taegs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.natixis.cco.upconnect.commarea.dcrl.TaegUP1Description;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.UPResponseConverter;
import com.natixis.cco.upconnect.modelUP.dcrl.OutputDCrlUP1;
import com.natixis.cco.upconnect.modelUP.dcrl.OutputDCrlUP1Description;
import com.natixis.cco.upconnect.modelnfi.dcrl.DCrlDescriptionV1;
import com.natixis.cco.upconnect.modelnfi.dcrl.DCrlV1;
import com.natixis.cco.upconnect.modelnfi.dcrl.DCrlV1Header;


public class DCrlV1UP1OutputConverter extends UPResponseConverter<OutputDCrlUP1, DCrlV1>{

	@Override
	public DCrlV1 extract(OutputDCrlUP1 outputUP) throws ConverterException {
		
		DCrlV1 dCrlV1 = new DCrlV1();
		String field = "";
		try{
			// Partie header
			DCrlV1Header header = new DCrlV1Header();
			field = CodePaysISO;
			header.setCodePaysISO(outputUP.getHeader().getCodePaysISO());
			field = codeRetourSimple;
			header.setCodeRetourSimple(outputUP.getHeader().getCodeRetourSimple());
			field = codeRetourPrecis;
			header.setCodeRetourPrecis(outputUP.getHeader().getCodeRetourPrecis());
			field = idCanal;
			header.setIdCanal(outputUP.getHeader().getIdCanal());
			field = idErreurMainframe;
			header.setIdErreurMainframe(
					outputUP.getHeader().getIdErreurMainframe());
			field = idFctAppelee;
			header.setIdFctAppelee(outputUP.getHeader().getIdFctAppelee());
			field = idPartenaire;
			header.setIdPartenaire(outputUP.getHeader().getIdPartenaire());
			field = idRequete;
			header.setIdRequete(outputUP.getHeader().getIdRequete());
			field = numVersionEntete;
			header.setNumVersionEntete(outputUP.getHeader().getNumVersionEntete());
			field = programmeJavaAppelant;
			header.setProgrammeJavaAppelant(
					outputUP.getHeader().getProgrammeJavaAppelant());
			field = programmeMainframeAppele;
			header.setProgrammeMainframeAppele(
					outputUP.getHeader().getProgrammeMainframeAppele());
			field = typeMessage;
			header.setTypeMessage(outputUP.getHeader().getTypeMessage());
			field = typePasserelle;
			header.setTypePasserelle(outputUP.getHeader().getTypePasserelle());
			dCrlV1.setHeader(header);
			
			for( OutputDCrlUP1Description out: outputUP.getOutputs()){
				
				DCrlDescriptionV1 res = new DCrlDescriptionV1();
				field = montantMensCalc;
				res.setMontantMensCalc(getBigDecFromString(out.getMontantMensCalc(),100));
				
				field = nbEcheanceCalc;	
				res.setNbEcheanceCalc(getInteger(out.getNbEcheanceCalc()));
				
				field = coutTotalInteret;
				res.setCoutTotalInteret(getBigDecFromString(out.getCoutTotalInteret(),100));
				
				field = coutTotalAssurance;
				res.setCoutTotalAssurance(getBigDecFromString(out.getCoutTotalAssurance(),100));
				
				field = taea;
				res.setTaea(getBigDecFromTaux(out.getTaea(),100));
				
				field = montantAssurancePremiereMens;
				res.setMontantAssurancePremiereMens(getBigDecFromString(out.getMontantAssurancePremiereMens(),100));
				
				field=montantDerniereMens;
				res.setMontantDerniereMens(getBigDecFromString(out.getMontantDerniereMens(),100));
				
				field = montantFinancable;
				res.setMontantFinancable(getBigDecFromString(out.getMontantFinancable(),100));
				
				field = codeRetCalc;
				res.setCodeRetCalc(out.getCodeRetCalc());
				field = taegs;
				List<BigDecimal> taegs = new ArrayList<BigDecimal>();
				for(TaegUP1Description taeg : out.getTaegs()){
					taegs.add(getBigDecFromTaux(taeg.getValue(),1000000));			
				}
				res.setTaegs(taegs);
				dCrlV1.getDcrlsResponses().add(res);
			}
		}catch(Exception e){
			
			throw new ConverterException(
					"Erreur de conversion OutputDCrlUP1 -> DCrlV1 : sur le champ "
							+ field,field);
		}
		return dCrlV1;
	}

}
