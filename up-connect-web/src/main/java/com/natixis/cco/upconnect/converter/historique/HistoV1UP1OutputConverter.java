package com.natixis.cco.upconnect.converter.historique;

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
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeOperation;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dateOperation;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dateFonctionnelle2;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantOperation;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.numeroCheque;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.idOperation;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.nomBanqueDePrelevement;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.lieuEtNumeroMobile;


import com.natixis.cco.upconnect.converter.COBOLDecimal;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.UPResponseConverter;
import com.natixis.cco.upconnect.modelUP.historique.OutputHistoDescription;
import com.natixis.cco.upconnect.modelUP.historique.OutputHistoUP1;
import com.natixis.cco.upconnect.modelnfi.historique.HistoDescriptionV1;
import com.natixis.cco.upconnect.modelnfi.historique.HistoV1;
import com.natixis.cco.upconnect.modelnfi.historique.HistoV1Header;


public class HistoV1UP1OutputConverter extends UPResponseConverter<OutputHistoUP1, HistoV1> {

	@Override
	public HistoV1 extract(OutputHistoUP1 outputUP) throws ConverterException {
		
		HistoV1 histo = new HistoV1();
		
		
		String field = "";
		try{
			// header
			HistoV1Header header = new HistoV1Header();
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
			histo.setHeader(header);
			
			//Beady
			
			for (OutputHistoDescription out : outputUP.getOperations()) {
				
				HistoDescriptionV1 opV1 = new HistoDescriptionV1();
				
				field = codeOperation;
				opV1.setCodeOperation(out.getCodeOperation());
				
				field = dateOperation;
				opV1.setDateOperation(out.getDateOperation());
				
				field = dateFonctionnelle2;
				opV1.setDateFonctionnelle2(out.getDateFonctionnelle2());
				
				field = montantOperation;
				opV1.setMontantOperation(getBigDec(out.getMontantOperation(),COBOLDecimal.S9_11_V9_0) );
				
				field = numeroCheque;
				opV1.setNumeroCheque(out.getNumeroCheque());
				
				field = idOperation;
				opV1.setIdOperation(out.getIdOperation());
				
				field = nomBanqueDePrelevement;
				opV1.setNomBanqueDePrelevement(out.getNomBanqueDePrelevement());
				
				field = lieuEtNumeroMobile;
				opV1.setLieuEtNumeroMobile(out.getLieuEtNumeroMobile());
				
				histo.getOperations().add(opV1 );			
				
			}
			
			histo.setFinDeListe(outputUP.getFinDeListe());
		}catch(Exception e){
			throw new ConverterException(
					"Erreur de conversion OutputHistoUP1 -> HistoV1 : sur le champ "
							+ field,field);
		}
		return histo;
	}

}
