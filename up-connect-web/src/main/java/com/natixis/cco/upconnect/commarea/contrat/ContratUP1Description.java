package com.natixis.cco.upconnect.commarea.contrat;

import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

public class ContratUP1Description {
	/* Partie commune */		
	
	/**
	 * EIMVCTR-OUT-EUGC
	 * </br>
	 * Valeur possible : SU, ES, EP, CX ou SN.
	 */
	@UnitedCommareaField(position =	1, longueur = 2)
	private String 	gestionContrat; 
	
	/**
	 * EIMVCTR-OUT-TYPEPROD
	 */
	@UnitedCommareaField(position = 2, longueur = 3)
	private String 	typeProduit;
	
	/**
	 * EIMVCTR-OUT-CPOSA
	 */
	@UnitedCommareaField(position = 3, longueur = 3)
	private String 	positionActuelle;
	
	/**
	 * EIMVCTR-OUT-NSOCFIN
	 */
	@UnitedCommareaField(position = 4, longueur = 3)
	private String 	numeroSocieteFinanciere;
	
	/**
	 * EIMVCTR-OUT-CPRODCOM
	 */
	@UnitedCommareaField(position = 5, longueur = 4)
	private String 	codeProduitCommercial;
	
	/**
	 * EIMVCTR-OUT-MNTFINANC
	 */
	@UnitedCommareaField(position = 6, longueur = 13)
	private String 	montantFinance;
	
	/**
	 * EIMVCTR-OUT-MNTOFFRE
	 */
	@UnitedCommareaField(position = 7, longueur = 13)
	private String 	montantOffre;
	
	/**
	 * EIMVCTR-OUT-DFINANCTR
	 * </br>
	 * Date de signature ou Date du premier finacement.
	 */
	@UnitedCommareaField(position = 8, longueur = 10)
	private String 	dateSignature;
	
	/**
	 * EIMVCTR-OUT-MNTTODU
	 */
	@UnitedCommareaField(position = 9, longueur = 13)
	private String 	montantTotalDu;
	
	/**
	 * EIMVCTR_OUT-NREPREACT
	 */
	@UnitedCommareaField(position = 10, longueur = 2)
	private String 	nombreReportsEffectues;
	
	/**
	 * EIMVCTR-OUT-TNC
	 */
	@UnitedCommareaField(position = 11, longueur = 9)
	private String 	tncAnnuel;
	
	/**
	 * EIMVCTR-OUT-TAEG
	 */
	@UnitedCommareaField(position = 12, longueur = 5)
	private String 	taegActuel;
	
	/**
	 * EIMVCTR-OUT-NARCHIV
	 */
	@UnitedCommareaField(position = 13, longueur = 15)
	private String 	numeroArchivage;
	
	/**
	 * EIMVCTR-OUT-CAPRESTDU
	 */
	@UnitedCommareaField(position = 14, longueur = 13)
	private String 	capitalRestantDu;
	
	/**
	 * EIMVCTR-OUT-MNTMENSENC
	 * </br>
	 * Montant de la mensualité du mois en cours.
	 */
	@UnitedCommareaField(position = 15, longueur = 13)
	private String 	mensualiteEnCours;
	
	/**
	 * EIMVCTR-OUT-SOLDRECOUV
	 */
	@UnitedCommareaField(position = 16, longueur = 13)
	private String 	soldeRecouvrement;
	
	/**
	 * EIMVCTR-OUT-QUANT
	 * </br>
	 * Quantième de prélèvement
	 */
	@UnitedCommareaField(position = 17, longueur = 3)
	private String 	quantiemePrelevement;
	
	/**
	 * EIMVCTR-OUT-CODEAGCCOM
	 */
	@UnitedCommareaField(position = 18, longueur = 3)
	private String 	codeAgenceCommerciale;
	
	/**
	 * EIMVCTR-OUT-CODEAGCOCT
	 */
	@UnitedCommareaField(position = 19, longueur = 3)
	private String 	codeAgenceOctroi;
	
	/**
	 * EIMVCTR-OUT-CODEAGCSAV
	 */
	@UnitedCommareaField(position = 20, longueur = 3)
	private String 	codeAgenceSAV;
	
	/**
	 * EIMVCTR-OUT-CODEAGCGC
	 */
	@UnitedCommareaField(position = 21, longueur = 3)
	private String 	codeAgenceGC;
	
	/**
	 * EIMVCTR-OUT-PERIOD
	 * </br>
	 * Valeurs possibles : M, B, T, Q, S, A, 0, 2, 3, 4, 5
	 */
	@UnitedCommareaField(position = 22, longueur = 1)
	private String 	periodicite;
	
	/**
	 * EIMVCTR-OUT-SOCAGR
	 * </br>
	 * Numéro de société du vendeur d'origine
	 */
	@UnitedCommareaField(position = 23, longueur = 3)
	private String 	numeroSocieteVendeur;
	
	/**
	 * EIMVCTR-OUT-NAGR
	 * </br>
	 * Numéro d'agrément du vendeur d'origine
	 */
	@UnitedCommareaField(position = 24, longueur = 7)
	private String 	numeroAgrementVendeur;
	
	/**
	 * EIMVCTR-OUT-FINORIG
	 * </br>
	 * Nombre de financements depuis origine
	 */
	@UnitedCommareaField(position = 25, longueur = 5)
	private String 	nombreFinancements;
	
	/**
	 * EIMVCTR-OUT-DECH1
	 * </br>
	 * Date de première échéance
	 */
	@UnitedCommareaField(position = 26, longueur = 10)
	private String 	datePremiereEcheance;
	
	/* Partie revolving */				
	
	/**
	 * EIMVCTR-OUT-DPRJK
	 */
	@UnitedCommareaField(position = 27, longueur = 10)
	private String 	dateProchainJoker;
	
	/**
	 * EIMVCTR-OUT-INDDTS
	 * </br>
	 * Valeurs possibles : O ou N
	 */
	@UnitedCommareaField(position = 28, longueur = 1)
	private String 	indicateurDtsActif;
	
	/**
	 * EIMVCTR-OUT-INDFINANC
	 */
	@UnitedCommareaField(position = 29, longueur = 15)
	private String 	indicateurFinancabilite;
	
	/**
	 * EIMVCTR-OUT-MNTDUDISPO
	 */
	@UnitedCommareaField(position = 30, longueur = 13)
	private String 	montantDisponible;
	
	/**
	 * EIMVCTR-OUT-NDMA
	 */
	@UnitedCommareaField(position = 31, longueur = 13)
	private String 	nouveauDMA;
	
	/**
	 * EIMVCTR-OUT-MNTDMA
	 */
	@UnitedCommareaField(position = 32, longueur = 13)
	private String 	montantDMA;
	
	/**
	 * EIMVCTR-OUT-INDRECOCTR
	 * </br>
	 * Indicateur de contrat en reconduction
	 */
	@UnitedCommareaField(position = 33, longueur = 1)
	private String 	indicateurReconduction;
	
	/**
	 * EIMVCTR-OUT-DRECONDCTR
	 */
	@UnitedCommareaField(position = 34, longueur = 10)
	private String 	dateProchaineReconduction;
	
	/**
	 * EIMVCTR-OUT-DAVDERN-ARRET;
	 * </br>
	 * Date avant dernier arrêté de compte
	 */
	@UnitedCommareaField(position = 35, longueur = 10)
	private String 	dateAvantDernierArreteCompte;
	
	/**
	 * EIMVCTR-OUT-DDERN-ARRET
	 * </br>
	 * Date du dernier arrêté de compte
	 */
	@UnitedCommareaField(position = 36, longueur = 10)
	private String 	dateDernierArreteCompte;
	
	/**
	 * EIMVCTR-OUT-DPROCH-ARRET
	 * </br>
	 * Date du prochain arrêté de compte
	 */
	@UnitedCommareaField(position = 37, longueur = 10)
	private String 	dateProchainArreteCompte;
	
	/**
	 * EIMVCTR-OUT-MNTMENSMIN
	 */
	@UnitedCommareaField(position = 38, longueur = 13)
	private String 	montantMensualiteMinimum;
	
	/**
	 * EIMVCTR-OUT-MNTAVDERNARRET
	 */
	@UnitedCommareaField(position = 39, longueur = 13)
	private String 	montantAvantDernierArreteCompte;
	
	/**
	 * EIMVCTR-OUT-MNTDERNARRET
	 */
	@UnitedCommareaField(position = 40, longueur = 13)
	private String 	montantDernierArreteCompte;
	
	/**
	 * EIMVCTR-OUT-MNTMENSCLI
	 * </br>
	 * Montant de la mensualité choisie par le client.
	 */
	@UnitedCommareaField(position = 41, longueur = 13)
	private String 	montantMensualiteClient;
	
	/* Partie classique */		
	
	/**
	 * EIMVCTR-OUT-MNTNDEBLQ
	 */
	@UnitedCommareaField(position = 42, longueur = 13)
	private String 	montantNonDebloque;
	
	/**
	 * EIMVCTR-OUT-TINICTR
	 * </br>
	 * Durée initiale du contrat
	 */
	@UnitedCommareaField(position = 43, longueur = 3)
	private String 	dureeInitiale;
	
	/**
	 * EIMVCTR-OUT-TRESCTR
	 * </br>
	 * Durée restante
	 */
	@UnitedCommareaField(position = 44, longueur = 3)
	private String 	dureeRestante;
	
	/**
	 * EIMVCTR-OUT-DFINCTR
	 * </br>
	 * Date de fin du contrat
	 */
	@UnitedCommareaField(position = 45, longueur = 10)
	private String 	dateFin;
	
	/**
	 * EIMVCTR-OUT-DPROCHEMENS
	 */
	@UnitedCommareaField(position = 46, longueur = 10)
	private String 	dateProchaineEcheance;
	
	/**
	 * EIMVCTR-OUT-MNTPROCHEME-NS
	 */
	@UnitedCommareaField(position = 47, longueur = 13)
	private String 	montantProchaineEcheance;
	
	/**
	 * EIMVCTR-OUT-INDECH
	 * </br>
	 * Indicateur contrat échelonné
	 */
	@UnitedCommareaField(position = 48, longueur = 1)
	private String 	indicateurEchelonne;
	
	/**
	 * EIMVCTR-OUT-INDDIFF
	 * </br>
	 * Indicateur contrat différé
	 */
	@UnitedCommareaField(position = 49, longueur = 1)
	private String 	indicateurDiffere;

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

	public String getTncAnnuel() {
		return tncAnnuel;
	}

	public void setTncAnnuel(String tncAnnuel) {
		this.tncAnnuel = tncAnnuel;
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

	public void setDateAvantDernierArreteCompte(String dateAvantDernierArreteCompte) {
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

	public void setDureeInitial(String dureeInitiale) {
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

	@Override
	public String toString() {
		return "ContratUP1Description [gestionContrat=" + gestionContrat
				+ ", typeProduit=" + typeProduit + ", positionActuelle="
				+ positionActuelle + ", numeroSocieteFinanciere="
				+ numeroSocieteFinanciere + ", codeProduitCommercial="
				+ codeProduitCommercial + ", montantFinance=" + montantFinance
				+ ", montantOffre=" + montantOffre + ", dateSignature="
				+ dateSignature + ", montantTotalDu=" + montantTotalDu
				+ ", nombreReportsEffectues=" + nombreReportsEffectues
				+ ", tncAnnuel=" + tncAnnuel + ", taegActuel=" + taegActuel
				+ ", numeroArchivage=" + numeroArchivage
				+ ", capitalRestantDu=" + capitalRestantDu
				+ ", mensualiteEnCours=" + mensualiteEnCours
				+ ", soldeRecouvrement=" + soldeRecouvrement
				+ ", quantiemePrelevement=" + quantiemePrelevement
				+ ", codeAgenceCommerciale=" + codeAgenceCommerciale
				+ ", codeAgenceOctroi=" + codeAgenceOctroi + ", codeAgenceSAV="
				+ codeAgenceSAV + ", codeAgenceGC=" + codeAgenceGC
				+ ", periodicite=" + periodicite + ", numeroSocieteVendeur="
				+ numeroSocieteVendeur + ", numeroAgrementVendeur="
				+ numeroAgrementVendeur + ", nombreFinancements="
				+ nombreFinancements + ", datePremiereEcheance="
				+ datePremiereEcheance + ", dateProchainJoker="
				+ dateProchainJoker + ", indicateurDtsActif="
				+ indicateurDtsActif + ", indicateurFinancabilite="
				+ indicateurFinancabilite + ", montantDisponible="
				+ montantDisponible + ", nouveauDMA=" + nouveauDMA
				+ ", montantDMA=" + montantDMA + ", indicateurReconduction="
				+ indicateurReconduction + ", dateProchaineReconduction="
				+ dateProchaineReconduction + ", dateAvantDernierArreteCompte="
				+ dateAvantDernierArreteCompte + ", dateDernierArreteCompte="
				+ dateDernierArreteCompte + ", dateProchainArreteCompte="
				+ dateProchainArreteCompte + ", montantMensualiteMinimum="
				+ montantMensualiteMinimum
				+ ", montantAvantDernierArreteCompte="
				+ montantAvantDernierArreteCompte
				+ ", montantDernierArreteCompte=" + montantDernierArreteCompte
				+ ", montantMensualiteClient=" + montantMensualiteClient
				+ ", montantNonDebloque=" + montantNonDebloque
				+ ", dureeInitiale=" + dureeInitiale + ", dureeRestante="
				+ dureeRestante + ", dateFin=" + dateFin
				+ ", dateProchaineEcheance=" + dateProchaineEcheance
				+ ", montantProchaineEcheance=" + montantProchaineEcheance
				+ ", indicateurEchelonne=" + indicateurEchelonne
				+ ", indicateurDiffere=" + indicateurDiffere + "]";
	}
	
	
}
