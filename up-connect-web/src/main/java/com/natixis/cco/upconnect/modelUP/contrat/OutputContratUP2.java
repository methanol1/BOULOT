package com.natixis.cco.upconnect.modelUP.contrat;

import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

/**
 * Cette classe rassemble toutes les données issues du service Contrat UP
 * version 2 (bloc dossier) telles qu'elles sont lues depuis la commarea de
 * sortie.
 * 
 * C'est une image objet Java de la commarea du service UP version 2.
 * 
 * C'est donc la classe correspondant à ContratDescription de l'ancien code.
 * Avec en plus la notion de version.
 * 
 * @author steph
 *
 */
public class OutputContratUP2 {

	private String typeMessage;
	
	private String numVersionEntete;
	
	private String programmeJavaAppelant;
	
	private String programmeMainframeAppele;
	
	private String idRequete;
	
	private String typePasserelle;
	
	private String idPartenaire;
	
	private String idCanal;
	
	private String idErreurMainframe;
	
	private String idFctAppelee;
	
	private String codePaysISO;
	
	private String codeRetourSimple;
	
	private String codeRetourPrecis;

	private String gestionContrat;

	private String typeProduit;

	private String positionActuelle;

	private String numeroSocieteFinanciere;

	private String codeProduitCommercial;

	private String montantFinance;

	private String montantOffre;

	private String dateSignature;

	private String montantTotalDu;

	private String nombreReportsEffectues;

	private String tncActuel;

	private String taegActuel;

	private String numeroArchivage;

	private String capitalRestantDu;

	private String mensualiteEnCours;

	private String soldeRecouvrement;

	private String quantiemePrelevement;

	private String codeAgenceCommerciale;

	private String codeAgenceOctroi;

	private String codeAgenceSAV;

	private String codeAgenceGC;

	private String periodicite;

	private String numeroSocieteVendeur;

	private String numeroAgrementVendeur;

	private String nombreFinancements;

	/**
	 * EIMVCTR-OUT-DECH1 </br> Date de première échéance
	 */
	private String datePremiereEcheance;
	
	private String numeroSocieteCommerciale;
	
	private String codeBareme;

	/**
	 * EIMVCTR-OUT-DPRJK
	 */
	private String dateProchainJoker;

	/**
	 * EIMVCTR-OUT-INDDTS </br> Valeurs possibles : O ou N
	 */
	private String indicateurDtsActif;

	private String indicateurFinancabilite;

	private String montantDisponible;

	private String nouveauDMA;

	private String montantDMA;

	/**
	 * </br> Indicateur de contrat en reconduction
	 */
	private String indicateurReconduction;

	private String dateProchaineReconduction;

	/**
	 * Date avant dernier arrêté de compte
	 */
	private String dateAvantDernierArreteCompte;

	/**
	 * </br> Date du dernier arrêté de compte
	 */
	private String dateDernierArreteCompte;

	/**
	 * Date du prochain arrêté de compte
	 */
	private String dateProchainArreteCompte;

	private String montantMensualiteMinimum;

	private String montantAvantDernierArreteCompte;

	private String montantDernierArreteCompte;

	/**
	 * Montant de la mensualité choisie par le client.
	 */
	private String montantMensualiteClient;
	
	private String dateDernierJoker;
	
	private String nbJokerDejaPose;
	
	private String codeDegressivite;

	private String montantNonDebloque;

	/**
	 * Durée initiale du contrat
	 */
	private String dureeInitiale;

	/**
	 * Durée restante
	 */
	private String dureeRestante;

	/**
	 * Date de fin du contrat
	 */
	private String dateFin;

	private String dateProchaineEcheance;

	private String montantProchaineEcheance;

	private String indicateurEchelonne;

	public String getIdErreurMainframe() {
		return idErreurMainframe;
	}

	public void setIdErreurMainframe(String idErreurMainframe) {
		this.idErreurMainframe = idErreurMainframe;
	}

	public String getIdFctAppelee() {
		return idFctAppelee;
	}

	public void setIdFctAppelee(String idFctAppelee) {
		this.idFctAppelee = idFctAppelee;
	}

	public String getCodePaysISO() {
		return codePaysISO;
	}

	public void setCodePaysISO(String codePaysISO) {
		this.codePaysISO = codePaysISO;
	}

	public String getCodeRetourSimple() {
		return codeRetourSimple;
	}

	public void setCodeRetourSimple(String codeRetourSimple) {
		this.codeRetourSimple = codeRetourSimple;
	}

	public String getCodeRetourPrecis() {
		return codeRetourPrecis;
	}

	public void setCodeRetourPrecis(String codeRetourPrecis) {
		this.codeRetourPrecis = codeRetourPrecis;
	}

	/**
	 * Indicateur contrat différé
	 */
	private String indicateurDiffere;

	public String getGestionContrat() {
		return gestionContrat;
	}

	public void setGestionContrat(String gestionContrat) {
		this.gestionContrat = gestionContrat;
	}

	public String getTypeProduit() {
		return typeProduit;
	}

	public void setTypeProduit(String typeProduit) {
		this.typeProduit = typeProduit;
	}

	public String getPositionActuelle() {
		return positionActuelle;
	}

	public void setPositionActuelle(String positionActuelle) {
		this.positionActuelle = positionActuelle;
	}

	public String getNumeroSocieteFinanciere() {
		return numeroSocieteFinanciere;
	}

	public void setNumeroSocieteFinanciere(String numeroSocieteFinanciere) {
		this.numeroSocieteFinanciere = numeroSocieteFinanciere;
	}

	public String getCodeProduitCommercial() {
		return codeProduitCommercial;
	}

	public void setCodeProduitCommercial(String codeProduitCommercial) {
		this.codeProduitCommercial = codeProduitCommercial;
	}

	public String getMontantFinance() {
		return montantFinance;
	}

	public void setMontantFinance(String montantFinance) {
		this.montantFinance = montantFinance;
	}

	public String getMontantOffre() {
		return montantOffre;
	}

	public void setMontantOffre(String montantOffre) {
		this.montantOffre = montantOffre;
	}

	public String getDateSignature() {
		return dateSignature;
	}

	public void setDateSignature(String dateSignature) {
		this.dateSignature = dateSignature;
	}

	public String getMontantTotalDu() {
		return montantTotalDu;
	}

	public void setMontantTotalDu(String montantTotalDu) {
		this.montantTotalDu = montantTotalDu;
	}

	public String getNombreReportsEffectues() {
		return nombreReportsEffectues;
	}

	public void setNombreReportsEffectues(String nombreReportsEffectues) {
		this.nombreReportsEffectues = nombreReportsEffectues;
	}

	public String getTncActuel() {
		return tncActuel;
	}

	public void setTncActuel(String tncActuel) {
		this.tncActuel = tncActuel;
	}

	public String getTaegActuel() {
		return taegActuel;
	}

	public void setTaegActuel(String taegActuel) {
		this.taegActuel = taegActuel;
	}

	public String getNumeroArchivage() {
		return numeroArchivage;
	}

	public void setNumeroArchivage(String numeroArchivage) {
		this.numeroArchivage = numeroArchivage;
	}

	public String getCapitalRestantDu() {
		return capitalRestantDu;
	}

	public void setCapitalRestantDu(String capitalRestantDu) {
		this.capitalRestantDu = capitalRestantDu;
	}

	public String getMensualiteEnCours() {
		return mensualiteEnCours;
	}

	public void setMensualiteEnCours(String mensualiteEnCours) {
		this.mensualiteEnCours = mensualiteEnCours;
	}

	public String getSoldeRecouvrement() {
		return soldeRecouvrement;
	}

	public void setSoldeRecouvrement(String soldeRecouvrement) {
		this.soldeRecouvrement = soldeRecouvrement;
	}

	public String getQuantiemePrelevement() {
		return quantiemePrelevement;
	}

	public void setQuantiemePrelevement(String quantiemePrelevement) {
		this.quantiemePrelevement = quantiemePrelevement;
	}

	public String getCodeAgenceCommerciale() {
		return codeAgenceCommerciale;
	}

	public void setCodeAgenceCommerciale(String codeAgenceCommerciale) {
		this.codeAgenceCommerciale = codeAgenceCommerciale;
	}

	public String getCodeAgenceOctroi() {
		return codeAgenceOctroi;
	}

	public void setCodeAgenceOctroi(String codeAgenceOctroi) {
		this.codeAgenceOctroi = codeAgenceOctroi;
	}

	public String getCodeAgenceSAV() {
		return codeAgenceSAV;
	}

	public void setCodeAgenceSAV(String codeAgenceSAV) {
		this.codeAgenceSAV = codeAgenceSAV;
	}

	public String getCodeAgenceGC() {
		return codeAgenceGC;
	}

	public void setCodeAgenceGC(String codeAgenceGC) {
		this.codeAgenceGC = codeAgenceGC;
	}

	public String getPeriodicite() {
		return periodicite;
	}

	public void setPeriodicite(String periodicite) {
		this.periodicite = periodicite;
	}

	public String getNumeroSocieteVendeur() {
		return numeroSocieteVendeur;
	}

	public void setNumeroSocieteVendeur(String numeroSocieteVendeur) {
		this.numeroSocieteVendeur = numeroSocieteVendeur;
	}

	public String getNumeroAgrementVendeur() {
		return numeroAgrementVendeur;
	}

	public void setNumeroAgrementVendeur(String numeroAgrementVendeur) {
		this.numeroAgrementVendeur = numeroAgrementVendeur;
	}

	public String getNombreFinancements() {
		return nombreFinancements;
	}

	public void setNombreFinancements(String nombreFinancements) {
		this.nombreFinancements = nombreFinancements;
	}

	public String getDatePremiereEcheance() {
		return datePremiereEcheance;
	}

	public void setDatePremiereEcheance(String datePremiereEcheance) {
		this.datePremiereEcheance = datePremiereEcheance;
	}

	public String getDateProchainJoker() {
		return dateProchainJoker;
	}

	public void setDateProchainJoker(String dateProchainJoker) {
		this.dateProchainJoker = dateProchainJoker;
	}

	public String getIndicateurDtsActif() {
		return indicateurDtsActif;
	}

	public void setIndicateurDtsActif(String indicateurDtsActif) {
		this.indicateurDtsActif = indicateurDtsActif;
	}

	public String getIndicateurFinancabilite() {
		return indicateurFinancabilite;
	}

	public void setIndicateurFinancabilite(String indicateurFinancabilite) {
		this.indicateurFinancabilite = indicateurFinancabilite;
	}

	public String getMontantDisponible() {
		return montantDisponible;
	}

	public void setMontantDisponible(String montantDisponible) {
		this.montantDisponible = montantDisponible;
	}

	public String getNouveauDMA() {
		return nouveauDMA;
	}

	public void setNouveauDMA(String nouveauDMA) {
		this.nouveauDMA = nouveauDMA;
	}

	public String getMontantDMA() {
		return montantDMA;
	}

	public void setMontantDMA(String montantDMA) {
		this.montantDMA = montantDMA;
	}

	public String getIndicateurReconduction() {
		return indicateurReconduction;
	}

	public void setIndicateurReconduction(String indicateurReconduction) {
		this.indicateurReconduction = indicateurReconduction;
	}

	public String getDateProchaineReconduction() {
		return dateProchaineReconduction;
	}

	public void setDateProchaineReconduction(String dateProchaineReconduction) {
		this.dateProchaineReconduction = dateProchaineReconduction;
	}

	public String getDateAvantDernierArreteCompte() {
		return dateAvantDernierArreteCompte;
	}

	public void setDateAvantDernierArreteCompte(
			String dateAvantDernierArreteCompte) {
		this.dateAvantDernierArreteCompte = dateAvantDernierArreteCompte;
	}

	public String getDateDernierArreteCompte() {
		return dateDernierArreteCompte;
	}

	public void setDateDernierArreteCompte(String dateDernierArreteCompte) {
		this.dateDernierArreteCompte = dateDernierArreteCompte;
	}

	public String getDateProchainArreteCompte() {
		return dateProchainArreteCompte;
	}

	public void setDateProchainArreteCompte(String dateProchainArreteCompte) {
		this.dateProchainArreteCompte = dateProchainArreteCompte;
	}

	public String getMontantMensualiteMinimum() {
		return montantMensualiteMinimum;
	}

	public void setMontantMensualiteMinimum(String montantMensualiteMinimum) {
		this.montantMensualiteMinimum = montantMensualiteMinimum;
	}

	public String getMontantAvantDernierArreteCompte() {
		return montantAvantDernierArreteCompte;
	}

	public void setMontantAvantDernierArreteCompte(
			String montantAvantDernierArreteCompte) {
		this.montantAvantDernierArreteCompte = montantAvantDernierArreteCompte;
	}

	public String getMontantDernierArreteCompte() {
		return montantDernierArreteCompte;
	}

	public void setMontantDernierArreteCompte(String montantDernierArreteCompte) {
		this.montantDernierArreteCompte = montantDernierArreteCompte;
	}

	public String getMontantMensualiteClient() {
		return montantMensualiteClient;
	}

	public void setMontantMensualiteClient(String montantMensualiteClient) {
		this.montantMensualiteClient = montantMensualiteClient;
	}

	public String getMontantNonDebloque() {
		return montantNonDebloque;
	}

	public void setMontantNonDebloque(String montantNonDebloque) {
		this.montantNonDebloque = montantNonDebloque;
	}

	public String getDureeInitiale() {
		return dureeInitiale;
	}

	public void setDureeInitiale(String dureeInitiale) {
		this.dureeInitiale = dureeInitiale;
	}

	public String getDureeRestante() {
		return dureeRestante;
	}

	public void setDureeRestante(String dureeRestante) {
		this.dureeRestante = dureeRestante;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getDateProchaineEcheance() {
		return dateProchaineEcheance;
	}

	public void setDateProchaineEcheance(String dateProchaineEcheance) {
		this.dateProchaineEcheance = dateProchaineEcheance;
	}

	public String getMontantProchaineEcheance() {
		return montantProchaineEcheance;
	}

	public void setMontantProchaineEcheance(String montantProchaineEcheance) {
		this.montantProchaineEcheance = montantProchaineEcheance;
	}

	public String getIndicateurEchelonne() {
		return indicateurEchelonne;
	}

	public void setIndicateurEchelonne(String indicateurEchelonne) {
		this.indicateurEchelonne = indicateurEchelonne;
	}

	public String getIndicateurDiffere() {
		return indicateurDiffere;
	}

	public void setIndicateurDiffere(String indicateurDiffere) {
		this.indicateurDiffere = indicateurDiffere;
	}

	public String getNumeroSocieteCommerciale() {
		return numeroSocieteCommerciale;
	}

	public void setNumeroSocieteCommerciale(String numeroSocieteCommerciale) {
		this.numeroSocieteCommerciale = numeroSocieteCommerciale;
	}

	public String getDateDernierJoker() {
		return dateDernierJoker;
	}

	public void setDateDernierJoker(String dateDernierJoker) {
		this.dateDernierJoker = dateDernierJoker;
	}

	public String getNbJokerDejaPose() {
		return nbJokerDejaPose;
	}

	public void setNbJokerDejaPose(String nbJokerDejaPose) {
		this.nbJokerDejaPose = nbJokerDejaPose;
	}

	public String getCodeDegressivite() {
		return codeDegressivite;
	}

	public void setCodeDegressivite(String codeDegressivite) {
		this.codeDegressivite = codeDegressivite;
	}

	public String getTypeMessage() {
		return typeMessage;
	}

	public void setTypeMessage(String typeMessage) {
		this.typeMessage = typeMessage;
	}

	public String getNumVersionEntete() {
		return numVersionEntete;
	}

	public void setNumVersionEntete(String numVersionEntete) {
		this.numVersionEntete = numVersionEntete;
	}

	public String getProgrammeJavaAppelant() {
		return programmeJavaAppelant;
	}

	public void setProgrammeJavaAppelant(String programmeJavaAppelant) {
		this.programmeJavaAppelant = programmeJavaAppelant;
	}

	public String getProgrammeMainframeAppele() {
		return programmeMainframeAppele;
	}

	public void setProgrammeMainframeAppele(String programmeMainframeAppele) {
		this.programmeMainframeAppele = programmeMainframeAppele;
	}

	public String getIdRequete() {
		return idRequete;
	}

	public void setIdRequete(String idRequete) {
		this.idRequete = idRequete;
	}

	public String getTypePasserelle() {
		return typePasserelle;
	}

	public void setTypePasserelle(String typePasserelle) {
		this.typePasserelle = typePasserelle;
	}

	public String getIdPartenaire() {
		return idPartenaire;
	}

	public void setIdPartenaire(String idPartenaire) {
		this.idPartenaire = idPartenaire;
	}

	public String getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}

	public String getCodeBareme() {
		return codeBareme;
	}

	public void setCodeBareme(String codeBareme) {
		this.codeBareme = codeBareme;
	}

}
