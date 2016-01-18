package com.natixis.financement.middlesav.commun.exceptions;

public enum SavError {

    // LimitationActeSavBusinessException
    LIMITATION_TAMO("05", "limitation.tamo"),    
    LIMITATION_REPORT("07", "limitation.report"),
    LIMITATION_QUANTIEME("08", "limitation.quantieme"),
    LIMITATION_REGULARISATION("09", "limitation.regularisation"),
    FINANCEMENT_IMPOSSIBLE("1","financement.impossible"),
    LIMITATION_DEBLOCAGE("2", "limitation.deblocage"),
    // ActeSavProposeBusinessException
    ACCES_ETABLISSEMENT_MANQUANT("1", "acces.operation.etablissement.absent"),
    // AccessActeSavBusinessException
    ACCES_POSITION_MANQUANT("2", "acces.operation.position.absent"),    
    // EligibiliteSavBusinessException
    ROLE_INCORRECT("13", "eligibilite.role.incorrect"), 
    PARTI_SANS_ADRESSE("14", "eligibilite.parti.sans.adresse"), 
    SURENDETTEMENT_BDF("15", "eligibilite.surendettement.bdf"), 
    POSITION_INCORRECTE("16", "eligibilite.position.incorrecte"),
    // ContratNonTrouveException
    CONTRAT_NON_TROUVE_MESSAGE("1","contrat.non.trouve.message"),
    NUM_SIM_NON_TROUVE_MESSAGE("2","num.simulation.non.trouve.message"),
    // ComptabiliteActeSavBusinessException
    INCOMPATIBILITE_TAMO_DEBLOCAGE("1", "incompatibilite.deblocage"),    
    INCOMPATIBILITE_REPORT_DEBLOCAGE("1","incompatibilite.deblocage"),
    INCOMPATIBILITE_REPORT_REDUCTION_CAPITAL("2","incompatibilite.reduction.capital"),
    INCOMPATIBILITE_REPORT_TAMO("3","incompatibilite.tamo"),
    INCOMPATIBILITE_DEBLOCAGE_REPORT("1","incompatibilite.report"),
    INCOMPATIBILITE_DEBLOCAGE_TAMO("2","incompatibilite.tamo"),
    INCOMPATIBILITE_DEBLOCAGE_QUANTIEME("3","incompatibilite.quantieme"),
    INCOMPATIBILITE_DEBLOCAGE_REDUCTION_CAPITAL("4","incompatibilite.reduction.capital"),
    // ContratEnDiffereAmortissementBusinessException
    CONTRAT_EN_DIFFERE_AMORTISSEMENT("28","contrat.en.differe.amortissement"),
    // ClientNonTrouveException
    CLIENT_NON_TROUVE_MESSAGE("29","client.non.trouve.message"),
    // RefecenceDemandeBusinessException
    ACTE_SAV_NON_TROUVE("32", "acte.sav.non.trouve"),
    // HistoriqueOperationsBusinessException
    HISTORIQUE_OPERATIONS_PARAMETRAGE("33","historique.operations.parametrage"),
    HISTORIQUE_OPERATIONS_TYPE_ACTE("34","historique.operations.type.acte"),
    // RachatBusinessException
    RACHAT_CALCUL_IRA_ERREUR("1","rachat.calcul.IRA.erreur"),
    RACHAT_DATE_INVALIDE_ERREUR("2","rachat.date.invalide.erreur"),
    // DomiciliationBancaireNonTrouveeBusinessException
    DOMICILIATION_BANCAIRE_NON_TROUVEE_MESSAGE("1","domiciliation.bancaire.non.trouve.message"),
    MANDAT_NON_TROUVE_MESSAGE("2","mandat.non.trouve.message"),
    // ReportBusinessException
    UNITED_REPORT_MAXIMUM_DEPASSE("100", "united.report.maximum.depasse"),
    // DeblocageDemandeException
    DEBLOCAGE_MONTANT_SUPERIER_MESSAGE("1","deblocage.montant.superieur.message"),
    DEBLOCAGE_MONTANT_INFERIEUR_MESSAGE("2","deblocage.montant.inferieur.message"),
    DEBLOCAGE_REDUCTION_OBLIGATOIRE_MESSAGE("3","deblocage.reduction.obligatoire.message"),
    DEBLOCAGE_DATE_SUPERIER_MESSAGE("4","deblocage.date.superieur.message"),
    DEBLOCAGE_DATE_INFERIEUR_MESSAGE("5","deblocage.date.inferieur.message"),        
    // DeblocageDemandeException:supprimerDeblocage
    DEBLOCAGE_NON_TROUVE_MESSAGE("1","deblocage.non.trouve.message"),
    DEBLOCAGE_NON_SUPPRIMABLE_MESSAGE("2","deblocage.non.supprimable.erreur"),
    //ReductionCapitalException
    DEBLOCAGE_REDUCTION_DATE_SUPERIER_MESSAGE("1","deblocage.reduction.date.superieur.message"),
    DEBLOCAGE_REDUCTION_DATE_INFERIEUR_MESSAGE("2","deblocage.reduction.date.inferieur.message"), 
    
    // ContextNonInitialiseException
    SAV_CONTEXT_MANQUANT("200", "sav.context.manquant"),
    SAV_CONTEXT_CONTRAT_MANQUANT("201", "sav.context.contrat.manquant"),
    SAV_CONTEXT_CLIENT_MANQUANT("201", "sav.context.client.manquant"),
    
    // Erreurs techniques
    UNITED_VALEUR_INTROUVABLE("01", "missing.value"),
    UNITED_VALEUR_MANQUANTE("02", "empty.value"),
    INFOS_CONTRAT_FORMAT("03", "numero.dossier.format"),
    INCOMPATIBILITE_NO_OPERATION("18", "incompatibilite.no.operation"),
    INCOMPATIBILITE_NO_CONTROLE_OPERATION("19", "incompatibilite.no.controle.operation"),
    LIMITATION_NO_OPERATION("20", "limitation.no.operation"),
    LIMITATION_NO_CONTROLE_OPERATION("21", "limitation.no.controle.operation"),
    IUN_REF_TIERS_VIDE("28","eligibilite.iun.ref.tiers.vide"),
    UNITED_ERREUR_AUTHENTIFICATION("29", "united.erreur.authentification"),
    UNITED_REPORT_ERREUR("30", "united.report.erreur"),
    UNITED_HISTORIQUE_OPERATIONS_ERREUR("31", "united.historique.operations.erreur"),
    PROCESSUS_ERREUR_ENTREE_INCORRECTE("196", "processus.erreur.entree.incorrecte"),
    ERREUR_MAJ_MIDDLE("197", "erreur.maj.middle"),
    JOURNAL_ERREUR_ENTREE_INTROUVABLE("198", "journal.erreur.entree.introuvable"),
    CCO_ERREUR_AUTHENTIFICATION("199", "cco.erreur.authentification"),
    TYPE_ACTION_IMPREVU("202", "type.action.imprevu"),
    UNITED_TECHNIQUE("203", "united.erreur.technique"),
    DONNEES_INVALIDES("204", "donnees.invalides"),
    ERREUR_ENVOI_MAIL_CRC("205", "erreur.envoi.mail.crc"),
    CLIENT_EMAIL_NON_TROUVE("206", "client.email.non.trouve"),
    OCTROI_RECUPERATION_OPERATIONS_DEBLOCAGE("210", "erreur.traitement.deblocage.donnee.invalide"),
    TRANSCO_SIOCID_IS_NAN("211", "siocid.is.not.a.number"),
    INCOHERENCE_TYPE_ACTE_PROCESSUS("206", "incoherence.type.acte.processus"),
    SAV_TECHNIQUE_ERREUR("999", "sav.technique.erreur");

    private String code;

    private String messageKey;

    private SavError(final String code, final String messageKey) {
        this.code = code;
        this.messageKey = messageKey;
    }

    public String getCode() {
        return code;
    }

    public String getMessageKey() {
        return messageKey;
    }
}
