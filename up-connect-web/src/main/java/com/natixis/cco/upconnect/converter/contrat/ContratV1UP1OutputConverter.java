package com.natixis.cco.upconnect.converter.contrat;

import com.natixis.cco.upconnect.converter.COBOLDecimal;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.UPResponseConverter;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP1;
import com.natixis.cco.upconnect.modelnfi.contrat.ContratV1;

public class ContratV1UP1OutputConverter extends
        UPResponseConverter<OutputContratUP1, ContratV1> {

    public ContratV1 extract(OutputContratUP1 outputUP)
            throws ConverterException {
        ContratV1 res = new ContratV1();
        // Partie header
        res.getHeader().setCodePaysISO(outputUP.getCodePaysISO());
        res.getHeader().setCodeRetourSimple(outputUP.getCodeRetourSimple());
        res.getHeader().setCodeRetourPrecis(outputUP.getCodeRetourPrecis());
        res.getHeader().setIdCanal(outputUP.getIdCanal());
        res.getHeader().setIdErreurMainframe(outputUP.getIdErreurMainframe());
        res.getHeader().setIdFctAppelee(outputUP.getIdFctAppelee());
        res.getHeader().setIdPartenaire(outputUP.getIdPartenaire());
        res.getHeader().setIdRequete(outputUP.getIdRequete());
        res.getHeader().setNumVersionEntete(outputUP.getNumVersionEntete());
        res.getHeader().setProgrammeJavaAppelant(
                outputUP.getProgrammeJavaAppelant());
        res.getHeader().setProgrammeMainframeAppele(
                outputUP.getProgrammeMainframeAppele());
        res.getHeader().setTypeMessage(outputUP.getTypeMessage());
        res.getHeader().setTypePasserelle(outputUP.getTypePasserelle());

        res.setCapitalRestantDu(getBigDec(outputUP.getCapitalRestantDu(), COBOLDecimal.S9_11_V9_2));
        res.setCodeAgenceCommerciale(outputUP.getCodeAgenceCommerciale());
        res.setCodeAgenceGC(outputUP.getCodeAgenceGC());
        res.setCodeAgenceOctroi(outputUP.getCodeAgenceOctroi());
        res.setCodeAgenceSAV(outputUP.getCodeAgenceSAV());
        res.setCodePositionActuel(outputUP.getPositionActuelle());
        res.setCodeProduitComm(outputUP.getCodeProduitCommercial());
        res.setDateAvantDernierArreteCompte(outputUP
                .getDateAvantDernierArreteCompte());
        res.setDateDernierArreteCompte(outputUP.getDateDernierArreteCompte());
        res.setDateFin(outputUP.getDateFin());
        res.setDatePremiereEcheance(outputUP.getDatePremiereEcheance());
        res.setDateProchainArreteCompte(outputUP.getDateProchainArreteCompte());
        res.setDateProchaineEcheance(outputUP.getDateProchaineEcheance());
        res.setDateProchaineReconduction(outputUP
                .getDateProchaineReconduction());
        res.setDateProchainJoker(outputUP.getDateProchainJoker());
        res.setDateSignature(outputUP.getDateSignature());
        res.setDureeInitiale(getInteger(outputUP.getDureeInitiale()));
        res.setDureeRestante(getInteger(outputUP.getDureeRestante()));
        res.setIndicateurDiffere(outputUP.getIndicateurDiffere());
        res.setIndicateurDtsActif(outputUP.getIndicateurDtsActif());
        res.setIndicateurEchelonne(outputUP.getIndicateurEchelonne());
        res.setIndicateurFinancabilite(outputUP.getIndicateurFinancabilite());
        res.setIndicateurReconduction(outputUP.getIndicateurReconduction());
        res.setMensualiteEnCours(getBigDec(outputUP.getMensualiteEnCours(), COBOLDecimal.S9_11_V9_2));
        res.setMontantAvantDernierArreteCompte(getBigDec(outputUP
                .getMontantAvantDernierArreteCompte(), COBOLDecimal.S9_11_V9_2));
        res.setMontantDernierArreteCompte(getBigDec(outputUP
                .getMontantDernierArreteCompte(), COBOLDecimal.S9_11_V9_2));
        res.setMontantDisponible(getBigDec(outputUP.getMontantDisponible(), COBOLDecimal.S9_11_V9_2));
        res.setMontantDMA(getBigDec(outputUP.getMontantDMA(), COBOLDecimal.S9_11_V9_2));
        res.setMontantFinance(getBigDec(outputUP.getMontantFinance(), COBOLDecimal.S9_11_V9_2));
        res.setMontantMensualiteClient(getBigDec(outputUP.getMontantMensualiteClient(), COBOLDecimal.S9_11_V9_2));
        res.setMontantMensualiteMinimum(getBigDec(outputUP.getMontantMensualiteMinimum(), COBOLDecimal.S9_11_V9_2));
        res.setMontantNonDebloque(getBigDec(outputUP.getMontantNonDebloque(), COBOLDecimal.S9_11_V9_2));
        res.setMontantOffre(getBigDec(outputUP.getMontantOffre(), COBOLDecimal.S9_11_V9_2));
        res.setMontantProchaineEcheance(getBigDec(outputUP.getMontantProchaineEcheance(), COBOLDecimal.S9_11_V9_2));
        res.setMontantTotalDu(getBigDec(outputUP.getMontantTotalDu(), COBOLDecimal.S9_11_V9_2));
        res.setNombreFinancements(Integer.parseInt(outputUP.getNombreFinancements()));
        res.setNombreReportsEffectues(Integer.parseInt(outputUP
                .getNombreReportsEffectues()));
        res.setNouveauDMA(getBigDec(outputUP.getNouveauDMA(), COBOLDecimal.S9_11_V9_2));
        res.setNumeroAgrementVendeur(outputUP.getNumeroAgrementVendeur());
        res.setNumeroArchivage(outputUP.getNumeroArchivage());
        res.setNumeroSocieteVendeur(outputUP.getNumeroSocieteVendeur());
        res.setNumSocFin(outputUP.getNumeroSocieteFinanciere());
        res.setPeriodicite(outputUP.getPeriodicite());
        res.setQuantiemePrelevement(outputUP.getQuantiemePrelevement());
        res.setSoldeRecouvrement(getBigDec(outputUP.getSoldeRecouvrement(), COBOLDecimal.S9_11_V9_2));
        res.setTaegActuel(getBigDec(outputUP.getTaegActuel(), COBOLDecimal.S9_3_V9_2));
        res.setTncAnnuel(getBigDec(outputUP.getTncActuel(), COBOLDecimal.S9_2_V9_7));
        res.setTypeProduit(outputUP.getTypeProduit());
        res.setUsineGestion(outputUP.getGestionContrat());

        return res;
    }

}
