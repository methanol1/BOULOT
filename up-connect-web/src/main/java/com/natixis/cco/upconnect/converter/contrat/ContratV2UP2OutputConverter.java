package com.natixis.cco.upconnect.converter.contrat;

import static com.natixis.cco.upconnect.converter.ConstantesConverterField.CodePaysISO;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.capitalRestantDu;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeAgenceCommerciale;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeAgenceGC;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeAgenceOctroi;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeAgenceSAV;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeBareme;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeDegressivite;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeProduitCommercial;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeRetourPrecis;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.codeRetourSimple;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dateAvantDernierArreteCompte;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dateDernierArreteCompte;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dateDernierJoker;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dateFin;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.datePremiereEcheance;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dateProchainArreteCompte;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dateProchainJoker;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dateProchaineEcheance;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dateProchaineReconduction;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dateSignatureOuPremierFin;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dureeInitiale;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.dureeRestante;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.idCanal;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.idErreurMainframe;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.idFctAppelee;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.idPartenaire;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.idRequete;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.indicateurDiffere;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.indicateurDtsActif;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.indicateurEchelonne;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.indicateurFinancabilite;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.indicateurReconduction;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.mensualiteEnCours;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantAvantDernierArreteCompte;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantDMA;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantDernierArreteCompte;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantDisponible;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantFinance;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantMensualiteClient;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantMensualiteMinimum;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantNonDebloque;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantOffre;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantProchaineEcheance;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.montantTotalDu;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.nbJokerDejaPose;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.nombreFinancements;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.nombreReportsEffectues;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.nouveauDMA;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.numSocieteCommercial;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.numVersionEntete;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.numeroAgrementVendeur;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.numeroArchivage;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.numeroSocieteFinanciere;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.numeroSocieteVendeur;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.periodicite;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.positionActuelle;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.programmeJavaAppelant;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.programmeMainframeAppele;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.quantiemePrelevement;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.soldeRecouvrement;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.taegActuel;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.tncAnnuel;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.typeMessage;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.typePasserelle;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.typeProduit;
import static com.natixis.cco.upconnect.converter.ConstantesConverterField.usineGestion;

import com.natixis.cco.upconnect.converter.COBOLDecimal;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.UPResponseConverter;
import com.natixis.cco.upconnect.modelUP.contrat.OutputContratUP2;
import com.natixis.cco.upconnect.modelnfi.contrat.ContratV2;

public class ContratV2UP2OutputConverter extends
        UPResponseConverter<OutputContratUP2, ContratV2> {

    public ContratV2 extract(OutputContratUP2 outputUP)
            throws ConverterException {
        String field = "";
        try {
            ContratV2 res = new ContratV2();
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

            field = capitalRestantDu;
            res.setCapitalRestantDu(getBigDec(outputUP.getCapitalRestantDu(),
                    COBOLDecimal.S9_11_V9_2));
            field = codeAgenceCommerciale;
            res.setCodeAgenceCommerciale(outputUP.getCodeAgenceCommerciale());
            field = codeAgenceGC;
            res.setCodeAgenceGC(outputUP.getCodeAgenceGC());
            field = codeAgenceOctroi;
            res.setCodeAgenceOctroi(outputUP.getCodeAgenceOctroi());
            field = codeAgenceSAV;
            res.setCodeAgenceSAV(outputUP.getCodeAgenceSAV());
            field = codeBareme;
            res.setCodeBareme(getInteger(outputUP.getCodeBareme()));
            field = codeDegressivite;
            res.setCodeDegressivite(outputUP.getCodeDegressivite());
            field = codeProduitCommercial;
            res.setCodeProduitCommercial(outputUP.getCodeProduitCommercial());
            field = dateAvantDernierArreteCompte;
            res.setDateAvantDernierArreteCompte(outputUP
                    .getDateAvantDernierArreteCompte());
            field = dateDernierArreteCompte;
            res.setDateDernierArreteCompte(outputUP
                    .getDateDernierArreteCompte());
            field = dateFin;
            res.setDateFin(outputUP.getDateFin());
            field = datePremiereEcheance;
            res.setDatePremiereEcheance(outputUP.getDatePremiereEcheance());
            field = dateDernierJoker;
            res.setDateDernierJoker(outputUP.getDateDernierJoker());
            field = dateProchainArreteCompte;
            res.setDateProchainArreteCompte(outputUP
                    .getDateProchainArreteCompte());
            field = dateProchaineEcheance;
            res.setDateProchaineEcheance(outputUP.getDateProchaineEcheance());
            field = dateProchaineReconduction;
            res.setDateProchaineReconduction(outputUP
                    .getDateProchaineReconduction());
            field = dateProchainJoker;
            res.setDateProchainJoker(outputUP.getDateProchainJoker());
            field = dateSignatureOuPremierFin;
            res.setDateSignatureOuPremierFin(outputUP.getDateSignature());
            field = dureeInitiale;
            res.setDureeInitiale(getInteger(outputUP.getDureeInitiale()));
            field = dureeRestante;
            res.setDureeRestante(getInteger(outputUP.getDureeRestante()));
            field = indicateurDiffere;
            res.setIndicateurDiffere(outputUP.getIndicateurDiffere());
            field = indicateurDtsActif;
            res.setIndicateurDtsActif(outputUP.getIndicateurDtsActif());
            field = indicateurEchelonne;
            res.setIndicateurEchelonne(outputUP.getIndicateurEchelonne());
            field = indicateurFinancabilite;
            res.setIndicateurFinancabilite(outputUP
                    .getIndicateurFinancabilite());
            field = indicateurReconduction;
            res.setIndicateurReconduction(outputUP.getIndicateurReconduction());
            field = mensualiteEnCours;
            res.setMensualiteEnCours(getBigDec(outputUP.getMensualiteEnCours(),
                    COBOLDecimal.S9_11_V9_2));
            field = montantAvantDernierArreteCompte;
            res.setMontantAvantDernierArreteCompte(getBigDec(
                    outputUP.getMontantAvantDernierArreteCompte(),
                    COBOLDecimal.S9_11_V9_2));
            field = montantDernierArreteCompte;
            res.setMontantDernierArreteCompte(getBigDec(
                    outputUP.getMontantDernierArreteCompte(),
                    COBOLDecimal.S9_11_V9_2));
            field = montantDisponible;
            res.setMontantDisponible(getBigDec(outputUP.getMontantDisponible(),
                    COBOLDecimal.S9_11_V9_2));
            field = montantDMA;
            res.setMontantDMA(getBigDec(outputUP.getMontantDMA(),
                    COBOLDecimal.S9_11_V9_2));
            field = montantFinance;
            res.setMontantFinance(getBigDec(outputUP.getMontantFinance(),
                    COBOLDecimal.S9_11_V9_2));
            field = montantMensualiteClient;
            res.setMontantMensualiteClient(getBigDec(
                    outputUP.getMontantMensualiteClient(),
                    COBOLDecimal.S9_11_V9_2));
            field = montantMensualiteMinimum;
            res.setMontantMensualiteMinimum(getBigDec(
                    outputUP.getMontantMensualiteMinimum(),
                    COBOLDecimal.S9_11_V9_2));
            field = montantNonDebloque;
            res.setMontantNonDebloque(getBigDec(
                    outputUP.getMontantNonDebloque(), COBOLDecimal.S9_11_V9_2));
            field = montantOffre;
            res.setMontantOffre(getBigDec(outputUP.getMontantOffre(),
                    COBOLDecimal.S9_11_V9_2));
            field = montantProchaineEcheance;
            res.setMontantProchaineEcheance(getBigDec(
                    outputUP.getMontantProchaineEcheance(),
                    COBOLDecimal.S9_11_V9_2));
            field = montantTotalDu;
            res.setMontantTotalDu(getBigDec(outputUP.getMontantTotalDu(),
                    COBOLDecimal.S9_11_V9_2));
            field = nbJokerDejaPose;
            res.setNbJokerDejaPose(getInteger(outputUP.getNbJokerDejaPose()));
            field = nombreFinancements;
            res.setNombreFinancements(getInteger(outputUP
                    .getNombreFinancements()));
            field = nombreReportsEffectues;
            res.setNombreReportsEffectues(getInteger(outputUP
                    .getNombreReportsEffectues()));
            field = nouveauDMA;
            res.setNouveauDMA(getBigDec(outputUP.getNouveauDMA(),
                    COBOLDecimal.S9_11_V9_2));
            field = numeroAgrementVendeur;
            res.setNumeroAgrementVendeur(outputUP.getNumeroAgrementVendeur());
            field = numeroArchivage;
            res.setNumeroArchivage(outputUP.getNumeroArchivage());
            field = numSocieteCommercial;
            res.setNumSocieteCommercial(outputUP.getNumeroSocieteCommerciale());
            field = numeroSocieteVendeur;
            res.setNumeroSocieteVendeur(outputUP.getNumeroSocieteVendeur());
            field = numeroSocieteFinanciere;
            res.setNumeroSocieteFinanciere(outputUP
                    .getNumeroSocieteFinanciere());
            field = positionActuelle;
            res.setPositionActuelle(outputUP.getPositionActuelle());
            field = periodicite;
            res.setPeriodicite(outputUP.getPeriodicite());
            field = quantiemePrelevement;
            res.setQuantiemePrelevement(getInteger(outputUP.getQuantiemePrelevement()));
            field = soldeRecouvrement;
            res.setSoldeRecouvrement(getBigDec(outputUP.getSoldeRecouvrement(),
                    COBOLDecimal.S9_11_V9_2));
            field = taegActuel;
            res.setTaegActuel(getBigDec(outputUP.getTaegActuel(),
                    COBOLDecimal.S9_3_V9_2));
            field = tncAnnuel;
            res.setTncAnnuel(getBigDec(outputUP.getTncActuel(),
                    COBOLDecimal.S9_2_V9_7));
            field = typeProduit;
            res.setTypeProduit(outputUP.getTypeProduit());
            field = usineGestion;
            res.setUsineGestion(outputUP.getGestionContrat());

            return res;
        } catch (Exception e) {
            throw new ConverterException(
                    "Erreur de conversion OutputContratUP2 -> ContratV2 : sur le champ "
                            + field, field);
        }
    }

}
