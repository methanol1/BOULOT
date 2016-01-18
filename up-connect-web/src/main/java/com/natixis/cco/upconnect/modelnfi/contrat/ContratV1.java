package com.natixis.cco.upconnect.modelnfi.contrat;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;
import com.wordnik.swagger.annotations.ApiModelProperty;


/**
 * Cette classe rassemble l'exhaustivité des champs du service UP pour
 * lequel elle a été construite.
 * 
 * @author steph
 *
 */
@XmlRootElement(name="ContratV1")
public class ContratV1 {
	
	public ContratV1Header getHeader() {
		return header;
	}

	public void setHeader(ContratV1Header header) {
		this.header = header;
	}

	/**
	 * Partie header
	 */
	ContratV1Header header = new ContratV1Header();

	/**
	 * Etat et usine de gestion du contrat
	 */
	@XmlElement(name="usineGestion")
	@ApiModelProperty(value="Usine de Gestion du contrat",required=true)
	private String usineGestion;
	
	/**
	 * Type de produit (Classique/Permanent)
	 */
	private String typeProduit;
	
	/**
	 * Code position actuelle
	 */
	private String codePositionActuel;
	
	/**
	 * Numéro de société financière
	 */
	private String numSocFin;
	
	/**
	 * Code produit commercial 
	 */
	private String codeProduitComm;
	
	private BigDecimal montantFinance;
	
	/**
	 * 
	 */
	private BigDecimal 	montantOffre;
	
	/**
	 * EIMVCTR-OUT-DFINANCTR
	 * </br>
	 * Date de signature ou Date du premier finacement.
	 */
	private String 	dateSignature;
	
	/**
	 * EIMVCTR-OUT-MNTTODU
	 */
	private BigDecimal 	montantTotalDu;
	
	/**
	 * EIMVCTR_OUT-NREPREACT
	 */
	private int	nombreReportsEffectues;
	
	/**
	 * EIMVCTR-OUT-TNC
	 */
	private BigDecimal tncAnnuel;
	
	/**
	 * EIMVCTR-OUT-TAEG
	 */
	private BigDecimal taegActuel;
	
	/**
	 * EIMVCTR-OUT-NARCHIV
	 */
	private String 	numeroArchivage;
	
	/**
	 * EIMVCTR-OUT-CAPRESTDU
	 */
	private BigDecimal 	capitalRestantDu;
	
	/**
	 * EIMVCTR-OUT-MNTMENSENC
	 * </br>
	 * Montant de la mensualité du mois en cours.
	 */
	private BigDecimal 	mensualiteEnCours;
	
	/**
	 * EIMVCTR-OUT-SOLDRECOUV
	 */
	private BigDecimal 	soldeRecouvrement;
	
	/**
	 * EIMVCTR-OUT-QUANT
	 * </br>
	 * Quantième de prélèvement
	 */
	private String 	quantiemePrelevement;
	
	/**
	 * EIMVCTR-OUT-CODEAGCCOM
	 */
	private String 	codeAgenceCommerciale;
	
	/**
	 * EIMVCTR-OUT-CODEAGCOCT
	 */
	private String 	codeAgenceOctroi;
	
	/**
	 * EIMVCTR-OUT-CODEAGCSAV
	 */
	private String 	codeAgenceSAV;
	
	/**
	 * EIMVCTR-OUT-CODEAGCGC
	 */
	private String 	codeAgenceGC;
	
	/**
	 * EIMVCTR-OUT-PERIOD
	 * </br>
	 * Valeurs possibles : M, B, T, Q, S, A, 0, 2, 3, 4, 5
	 */
	private String 	periodicite;
	
	/**
	 * EIMVCTR-OUT-SOCAGR
	 * </br>
	 * Numéro de société du vendeur d'origine
	 */
	private String 	numeroSocieteVendeur;
	
	/**
	 * EIMVCTR-OUT-NAGR
z	 * </br>
	 * Numéro d'agrément du vendeur d'origine
	 */
	private String 	numeroAgrementVendeur;
	
	/**
	 * EIMVCTR-OUT-FINORIG
	 * </br>
	 * Nombre de financements depuis origine
	 */
	private int 	nombreFinancements;
	
	/**
	 * EIMVCTR-OUT-DECH1
	 * </br>
	 * Date de première échéance
	 */
	private String 	datePremiereEcheance;
	
	/* Partie revolving */				
	
	/**
	 * EIMVCTR-OUT-DPRJK
	 */
	private String 	dateProchainJoker;
	
	/**
	 * EIMVCTR-OUT-INDDTS
	 * </br>
	 * Valeurs possibles : O ou N
	 */
	private String 	indicateurDtsActif;
	
	/**
	 * EIMVCTR-OUT-INDFINANC
	 */
	private String 	indicateurFinancabilite;
	
	/**
	 * EIMVCTR-OUT-MNTDUDISPO
	 */
	private BigDecimal 	montantDisponible;
	
	/**
	 * EIMVCTR-OUT-NDMA
	 */
	private BigDecimal 	nouveauDMA;
	
	/**
	 * EIMVCTR-OUT-MNTDMA
	 */
	private BigDecimal 	montantDMA;
	
	/**
	 * EIMVCTR-OUT-INDRECOCTR
	 * </br>
	 * Indicateur de contrat en reconduction
	 */
	private String 	indicateurReconduction;
	
	/**
	 * EIMVCTR-OUT-DRECONDCTR
	 */
	private String 	dateProchaineReconduction;
	
	/**
	 * EIMVCTR-OUT-DAVDERN-ARRET;
	 * </br>
	 * Date avant dernier arrêté de compte
	 */
	private String 	dateAvantDernierArreteCompte;
	
	/**
	 * EIMVCTR-OUT-DDERN-ARRET
	 * </br>
	 * Date du dernier arrêté de compte
	 */
	private String 	dateDernierArreteCompte;
	
	/**
	 * EIMVCTR-OUT-DPROCH-ARRET
	 * </br>
	 * Date du prochain arrêté de compte
	 */
	private String 	dateProchainArreteCompte;
	
	/**
	 * EIMVCTR-OUT-MNTMENSMIN
	 */
	private BigDecimal 	montantMensualiteMinimum;
	
	/**
	 * EIMVCTR-OUT-MNTAVDERNARRET
	 */
	private BigDecimal 	montantAvantDernierArreteCompte;
	
	/**
	 * EIMVCTR-OUT-MNTDERNARRET
	 */
	private BigDecimal 	montantDernierArreteCompte;
	
	/**
	 * EIMVCTR-OUT-MNTMENSCLI
	 * </br>
	 * Montant de la mensualité choisie par le client.
	 */
	private BigDecimal 	montantMensualiteClient;
	
	/* Partie classique */		
	
	/**
	 * EIMVCTR-OUT-MNTNDEBLQ
	 */
	private BigDecimal 	montantNonDebloque;
	
	/**
	 * EIMVCTR-OUT-TINICTR
	 * </br>
	 * Durée initiale du contrat
	 */
	private int 	dureeInitiale;
	
	/**
	 * EIMVCTR-OUT-TRESCTR
	 * </br>
	 * Durée restante
	 */
	private int	dureeRestante;
	
	/**
	 * EIMVCTR-OUT-DFINCTR
	 * </br>
	 * Date de fin du contrat
	 */
	private String 	dateFin;
	
	/**
	 * EIMVCTR-OUT-DPROCHEMENS
	 */
	private String 	dateProchaineEcheance;
	
	/**
	 * EIMVCTR-OUT-MNTPROCHEME-NS
	 */
	private BigDecimal 	montantProchaineEcheance;
	
	/**
	 * EIMVCTR-OUT-INDECH
	 * </br>
	 * Indicateur contrat échelonné
	 */
	private String 	indicateurEchelonne;
	
	/**
	 * EIMVCTR-OUT-INDDIFF
	 * </br>
	 * Indicateur contrat différé
	 */
	private String 	indicateurDiffere;
	
	

	public String getUsineGestion() {
		return usineGestion;
	}

	public void setUsineGestion(String usineGestion) {
		this.usineGestion = usineGestion;
	}

	public String getTypeProduit() {
		return typeProduit;
	}

	public void setTypeProduit(String typeProduit) {
		this.typeProduit = typeProduit;
	}

	public String getCodePositionActuel() {
		return codePositionActuel;
	}

	public void setCodePositionActuel(String codePositionActuel) {
		this.codePositionActuel = codePositionActuel;
	}

	public String getNumSocFin() {
		return numSocFin;
	}

	public void setNumSocFin(String numSocFin) {
		this.numSocFin = numSocFin;
	}

	public String getCodeProduitComm() {
		return codeProduitComm;
	}

	public void setCodeProduitComm(String codeProduitComm) {
		this.codeProduitComm = codeProduitComm;
	}

	public BigDecimal getMontantFinance() {
		return montantFinance;
	}

	public void setMontantFinance(BigDecimal montantFinance) {
		this.montantFinance = montantFinance;
	}

	public BigDecimal getMontantOffre() {
		return montantOffre;
	}

	public void setMontantOffre(BigDecimal montantOffre) {
		this.montantOffre = montantOffre;
	}

	public String getDateSignature() {
		return dateSignature;
	}

	public void setDateSignature(String dateSignature) {
		this.dateSignature = dateSignature;
	}

	public BigDecimal getMontantTotalDu() {
		return montantTotalDu;
	}

	public void setMontantTotalDu(BigDecimal montantTotalDu) {
		this.montantTotalDu = montantTotalDu;
	}

	public int getNombreReportsEffectues() {
		return nombreReportsEffectues;
	}

	public void setNombreReportsEffectues(int nombreReportsEffectues) {
		this.nombreReportsEffectues = nombreReportsEffectues;
	}

	public BigDecimal getTncAnnuel() {
		return tncAnnuel;
	}

	public void setTncAnnuel(BigDecimal tncAnnuel) {
		this.tncAnnuel = tncAnnuel;
	}

	public BigDecimal getTaegActuel() {
		return taegActuel;
	}

	public void setTaegActuel(BigDecimal taegActuel) {
		this.taegActuel = taegActuel;
	}

	public String getNumeroArchivage() {
		return numeroArchivage;
	}

	public void setNumeroArchivage(String numeroArchivage) {
		this.numeroArchivage = numeroArchivage;
	}

	public BigDecimal getCapitalRestantDu() {
		return capitalRestantDu;
	}

	public void setCapitalRestantDu(BigDecimal capitalRestantDu) {
		this.capitalRestantDu = capitalRestantDu;
	}

	public BigDecimal getMensualiteEnCours() {
		return mensualiteEnCours;
	}

	public void setMensualiteEnCours(BigDecimal mensualiteEnCours) {
		this.mensualiteEnCours = mensualiteEnCours;
	}

	public BigDecimal getSoldeRecouvrement() {
		return soldeRecouvrement;
	}

	public void setSoldeRecouvrement(BigDecimal soldeRecouvrement) {
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

	public int getNombreFinancements() {
		return nombreFinancements;
	}

	public void setNombreFinancements(int nombreFinancements) {
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

	public BigDecimal getMontantDisponible() {
		return montantDisponible;
	}

	public void setMontantDisponible(BigDecimal montantDisponible) {
		this.montantDisponible = montantDisponible;
	}

	public BigDecimal getNouveauDMA() {
		return nouveauDMA;
	}

	public void setNouveauDMA(BigDecimal nouveauDMA) {
		this.nouveauDMA = nouveauDMA;
	}

	public BigDecimal getMontantDMA() {
		return montantDMA;
	}

	public void setMontantDMA(BigDecimal montantDMA) {
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

	public BigDecimal getMontantMensualiteMinimum() {
		return montantMensualiteMinimum;
	}

	public void setMontantMensualiteMinimum(BigDecimal montantMensualiteMinimum) {
		this.montantMensualiteMinimum = montantMensualiteMinimum;
	}

	public BigDecimal getMontantAvantDernierArreteCompte() {
		return montantAvantDernierArreteCompte;
	}

	public void setMontantAvantDernierArreteCompte(
			BigDecimal montantAvantDernierArreteCompte) {
		this.montantAvantDernierArreteCompte = montantAvantDernierArreteCompte;
	}

	public BigDecimal getMontantDernierArreteCompte() {
		return montantDernierArreteCompte;
	}

	public void setMontantDernierArreteCompte(BigDecimal montantDernierArreteCompte) {
		this.montantDernierArreteCompte = montantDernierArreteCompte;
	}

	public BigDecimal getMontantMensualiteClient() {
		return montantMensualiteClient;
	}

	public void setMontantMensualiteClient(BigDecimal montantMensualiteClient) {
		this.montantMensualiteClient = montantMensualiteClient;
	}

	public BigDecimal getMontantNonDebloque() {
		return montantNonDebloque;
	}

	public void setMontantNonDebloque(BigDecimal montantNonDebloque) {
		this.montantNonDebloque = montantNonDebloque;
	}

	public int getDureeInitiale() {
		return dureeInitiale;
	}

	public void setDureeInitiale(int dureeInitiale) {
		this.dureeInitiale = dureeInitiale;
	}

	public int getDureeRestante() {
		return dureeRestante;
	}

	public void setDureeRestante(int dureeRestante) {
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

	public BigDecimal getMontantProchaineEcheance() {
		return montantProchaineEcheance;
	}

	public void setMontantProchaineEcheance(BigDecimal montantProchaineEcheance) {
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
		return "ContratV1 [header=" + header + ", usineGestion=" + usineGestion
				+ ", typeProduit=" + typeProduit + ", codePositionActuel="
				+ codePositionActuel + ", numSocFin=" + numSocFin
				+ ", codeProduitComm=" + codeProduitComm + ", montantFinance="
				+ montantFinance + ", montantOffre=" + montantOffre
				+ ", dateSignature=" + dateSignature + ", montantTotalDu="
				+ montantTotalDu + ", nombreReportsEffectues="
				+ nombreReportsEffectues + ", tncAnnuel=" + tncAnnuel
				+ ", taegActuel=" + taegActuel + ", numeroArchivage="
				+ numeroArchivage + ", capitalRestantDu=" + capitalRestantDu
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
