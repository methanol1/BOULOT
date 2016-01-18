package com.natixis.cco.upconnect.converter.contrat;

import com.natixis.cco.upconnect.commarea.contrat.ContratUP1CommareaDescriptionResponse;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP1;

public class ContratUP1ResponseConverter 
	implements OutputConverter<ContratUP1CommareaDescriptionResponse, OutputContratUP1> {

	

	public OutputContratUP1 extract(
			ContratUP1CommareaDescriptionResponse outputUP)
			throws ConverterException {
		OutputContratUP1 output = 
				new OutputContratUP1();
		//header
		output.setCodePaysISO(outputUP.getCodePaysISO());
		output.setCodeRetourPrecis(outputUP.getCodeRetourPrecis());
		output.setCodeRetourSimple(outputUP.getCodeRetourSimple());
		output.setIdCanal(outputUP.getIdCanal());
		output.setIdErreurMainframe(outputUP.getIdErreurMainframe());
		output.setIdFctAppelee(outputUP.getIdFctAppelee());
		output.setIdPartenaire(outputUP.getIdPartenaire());
		output.setIdRequete(outputUP.getIdRequete());
		output.setNumVersionEntete(outputUP.getNumVersionEntete());
		output.setProgrammeJavaAppelant(outputUP.getProgrammeJavaAppelant());
		output.setProgrammeMainframeAppele(outputUP.getProgrammeMainframeAppele());
		output.setTypeMessage(outputUP.getTypeMessage());
		output.setTypePasserelle(outputUP.getTypePasserelle());
		
		//Body
		output.setCapitalRestantDu(outputUP.getContrat().getCapitalRestantDu());
		output.setCodeAgenceCommerciale(outputUP.getContrat().getCodeAgenceCommerciale());
		output.setCodeAgenceGC(outputUP.getContrat().getCodeAgenceGC());
		output.setCodeAgenceOctroi(outputUP.getContrat().getCodeAgenceOctroi());
		output.setCodeAgenceSAV(outputUP.getContrat().getCodeAgenceSAV());
		output.setCodeProduitCommercial(outputUP.getContrat().getCodeProduitCommercial());
		output.setDateAvantDernierArreteCompte(outputUP.getContrat().getDateAvantDernierArreteCompte());
		output.setDateDernierArreteCompte(outputUP.getContrat().getDateDernierArreteCompte());
		output.setDateFin(outputUP.getContrat().getDateFin());
		output.setDatePremiereEcheance(outputUP.getContrat().getDatePremiereEcheance());
		output.setDateProchainArreteCompte(outputUP.getContrat().getDateProchainArreteCompte());
		output.setDateProchaineEcheance(outputUP.getContrat().getDateProchaineEcheance());
		output.setDateProchaineReconduction(outputUP.getContrat().getDateProchaineReconduction());
		output.setDateProchainJoker(outputUP.getContrat().getDateProchainJoker());
		output.setDateSignature(outputUP.getContrat().getDateSignature());
		output.setDureeInitiale(outputUP.getContrat().getDureeInitiale());
		output.setDureeRestante(outputUP.getContrat().getDureeRestante());
		output.setGestionContrat(outputUP.getContrat().getGestionContrat());
		output.setIndicateurDiffere(outputUP.getContrat().getIndicateurDiffere());
		output.setIndicateurDtsActif(outputUP.getContrat().getIndicateurDtsActif());
		output.setIndicateurEchelonne(outputUP.getContrat().getIndicateurEchelonne());
		output.setIndicateurFinancabilite(outputUP.getContrat().getIndicateurFinancabilite());
		output.setIndicateurReconduction(outputUP.getContrat().getIndicateurReconduction());
		output.setMensualiteEnCours(outputUP.getContrat().getMensualiteEnCours());
		output.setMontantAvantDernierArreteCompte(outputUP.getContrat().getMontantAvantDernierArreteCompte());
		output.setMontantDernierArreteCompte(outputUP.getContrat().getMontantDernierArreteCompte());
		output.setMontantDisponible(outputUP.getContrat().getMontantDisponible());
		output.setMontantDMA(outputUP.getContrat().getMontantDMA());
		output.setMontantFinance(outputUP.getContrat().getMontantFinance());
		output.setMontantMensualiteClient(outputUP.getContrat().getMontantMensualiteClient());
		output.setMontantMensualiteMinimum(outputUP.getContrat().getMontantMensualiteMinimum());
		output.setMontantNonDebloque(outputUP.getContrat().getMontantNonDebloque());
		output.setMontantOffre(outputUP.getContrat().getMontantOffre());
		output.setMontantProchaineEcheance(outputUP.getContrat().getMontantProchaineEcheance());
		output.setMontantTotalDu(outputUP.getContrat().getMontantTotalDu());
		output.setNombreFinancements(outputUP.getContrat().getNombreFinancements());
		output.setNombreReportsEffectues(outputUP.getContrat().getNombreReportsEffectues());
		output.setNouveauDMA(outputUP.getContrat().getNouveauDMA());
		output.setNumeroAgrementVendeur(outputUP.getContrat().getNumeroAgrementVendeur());
		output.setNumeroArchivage(outputUP.getContrat().getNumeroArchivage());
		output.setNumeroSocieteVendeur(outputUP.getContrat().getNumeroSocieteVendeur());
		output.setNumeroSocieteFinanciere(outputUP.getContrat().getNumeroSocieteFinanciere());
		output.setPeriodicite(outputUP.getContrat().getPeriodicite());
		output.setPositionActuelle(outputUP.getContrat().getPositionActuelle());
		output.setQuantiemePrelevement(outputUP.getContrat().getQuantiemePrelevement());
		output.setSoldeRecouvrement(outputUP.getContrat().getSoldeRecouvrement());
		output.setTaegActuel(outputUP.getContrat().getTaegActuel());
		output.setTncActuel(outputUP.getContrat().getTncAnnuel());
		output.setTypeProduit(outputUP.getContrat().getTypeProduit());
		output.setGestionContrat(outputUP.getContrat().getGestionContrat());
		return output;
	}


}
