package com.natixis.cco.upconnect.converter;

import java.math.BigDecimal;
import java.util.List;

public class ConstantesConverterField {

	/* HEADER FIELDS */
	public static final String CodePaysISO = "CodePaysISO";
	public static final String idErreurMainframe="idErreurMainframe";
	public static final String idFctAppelee="idFctAppelee";
	public static final String codeRetourSimple="codeRetourSimple";
	public static final String codeRetourPrecis="codeRetourPrecis";
	public static final String typeMessage="typeMessage";
	public static final String numVersionEntete="numVersionEntete";
	public static final String programmeJavaAppelant="programmeJavaAppelant";
	public static final String programmeMainframeAppele="programmeMainframeAppele";
	public static final String idRequete="idRequete";
	public static final String typePasserelle="typePasserelle";
	public static final String idPartenaire="idPartenaire";
	public static final String idCanal="idCanal";
	
	/* ASSURANCE FIELDS */
	public static final String tauxMensSousc="tauxMensSousc";
	public static final String tauxMensCoSousc="tauxMensCoSousc";
	public static final String optionSous="optionSous";
	public static final String optionCoSous="optionCoSous";
	public static final String primeSous="primeSous";
	public static final String primeCoSous="primeCoSous";
	public static final String codeConvention="codeConvention";
	public static final String dateSous="dateSous";
	public static final String dateCoSous="dateCoSous";
	
	/* AGENCE FIELD */
	public static final String nomAgence="nomAgence";
	public static final String numeroTel="numeroTel";
	public static final String numeroFax="numeroFax";
	public static final String plage1="plage1";
	public static final String ouvertureMatin1="ouvertureMatin1";
	public static final String fermetureMatin1= "fermetureMatin1";
	public static final String ouvertureApresMidi1="ouvertureApresMidi1";
	public static final String fermetureApresMidi1="fermetureApresMidi1";
	public static final String plage2="plage2";
	public static final String ouvertureMatin2="ouvertureMatin2";
	public static final String fermetureMatin2="fermetureMatin2";
	public static final String ouvertureApresMidi2="ouvertureApresMidi2";
	public static final String fermetureApresMidi2="fermetureApresMidi2";
	
	/* DOMICILIATION BANCAIRE */
	public static final String codeBic="codeBic";
	public static final String codeIban="codeIban";
	public static final String nomTitulaire="nomTitulaire";
	public static final String dateCreation="dateCreation";
	public static final String anneeOuverture="anneeOuverture";
	public static final String typeCarte="typeCarte";
	public static final String libelleDomiciliation="libelleDomiciliation";
	public static final String codeTitulaire="codeTitulaire";
	public static final String codeIdentifiant="codeIdentifiant";
	public static final String codeRum="codeRum";
	public static final String statutMandat="statutMandat";
	
	
	/* RACHAT */
	public static final String montantTheoIra="montantTheoIra";
	public static final String montantSoldeAnti="montantSoldeAnti";
	public static final String tauxIra="tauxIra";
	
	/* CONTRAT FIELD */
	public static final String usineGestion="usineGestion";
	public static final String typeProduit="typeProduit";
	public static final String positionActuelle="positionActuelle";
	public static final String numeroSocieteFinanciere="numeroSocieteFinanciere";
	public static final String codeProduitCommercial="codeProduitCommercial";
	public static final String montantFinance="montantFinance";
	public static final String montantOffre="montantOffre";
	public static final String dateSignatureOuPremierFin="dateSignatureOuPremierFin";
	public static final String montantTotalDu="montantTotalDu";
	public static final String nombreReportsEffectues="nombreReportsEffectues";
	public static final String tncAnnuel="tncAnnuel";
	public static final String taegActuel="taegActuel";
	public static final String numeroArchivage="numeroArchivage";
	public static final String capitalRestantDu="capitalRestantDu";
	public static final String mensualiteEnCours="mensualiteEnCours";
	public static final String soldeRecouvrement="soldeRecouvrement";
	public static final String quantiemePrelevement="quantiemePrelevement";
	public static final String codeAgenceCommerciale="codeAgenceCommerciale";
	public static final String codeAgenceOctroi="codeAgenceOctroi";
	public static final String codeAgenceSAV="codeAgenceSAV";
	public static final String codeAgenceGC="codeAgenceGC";
	public static final String periodicite="periodicite";
	public static final String numeroSocieteVendeur="numeroSocieteVendeur";
	public static final String numeroAgrementVendeur="numeroAgrementVendeur";
	public static final String nombreFinancements="nombreFinancements";
	public static final String datePremiereEcheance="datePremiereEcheance";
	public static final String numSocieteCommercial="numSocieteCommercial";
	public static final String codeBareme="codeBareme";
	public static final String dateProchainJoker="dateProchainJoker";
	public static final String indicateurDtsActif="indicateurDtsActif";
	public static final String indicateurFinancabilite="indicateurFinancabilite";
	public static final String montantDisponible="montantDisponible";
	public static final String nouveauDMA="nouveauDMA";
	public static final String montantDMA="montantDMA";
	public static final String indicateurReconduction="indicateurReconduction";
	public static final String dateProchaineReconduction="dateProchaineReconduction";
	public static final String dateAvantDernierArreteCompte="dateAvantDernierArreteCompte";
	public static final String dateDernierArreteCompte="dateDernierArreteCompte";
	public static final String dateProchainArreteCompte="dateProchainArreteCompte";
	public static final String montantMensualiteMinimum="montantMensualiteMinimum";
	public static final String montantAvantDernierArreteCompte="montantAvantDernierArreteCompte";
	public static final String montantDernierArreteCompte="montantDernierArreteCompte";
	public static final String montantMensualiteClient="montantMensualiteClient";
	public static final String dateDernierJoker="dateDernierJoker";
	public static final String nbJokerDejaPose="nbJokerDejaPose";
	public static final String codeDegressivite="codeDegressivite";
	public static final String montantNonDebloque="montantNonDebloque";
	public static final String dureeInitiale="dureeInitiale";
	public static final String dureeRestante="dureeRestante";
	public static final String dateFin="dateFin";
	public static final String dateProchaineEcheance="dateProchaineEcheance";
	public static final String montantProchaineEcheance="montantProchaineEcheance";
	public static final String indicateurEchelonne="indicateurEchelonne";
	public static final String indicateurDiffere="indicateurDiffere";
	
	/* DMEN FIELDS */
	public static final String codeRetourGal="codeRetourGal";
	public static final String codeRetourCompl="codeRetourCompl";
	public static final String coutTotalAssur="coutTotalAssur";
	public static final String coutTotalInterets="coutTotalInterets";
	public static final String dureeRecalculee="dureeRecalculee";
	public static final String montantDerniereMens="montantDerniereMens";
	public static final String montantMensAAppliq="montantMensAAppliq";
	public static final String montantMensCalculee="montantMensCalculee";
	public static final String montantMensMaxi="montantMensMaxi";
	public static final String libelleInformatif="libelleInformatif";
	public static final String codeInformatif="codeInformatif";
	
	
	/* DMEN Messages informatifs */
	public static final String messageInformatifVide="";
	public static final String messageInformatif44="La durée en entrée n’est compatible RCC";
	public static final String messageInformatif50="La mensualité appliquée est la mensualité plancher";
	public static final String messageInformatif51="La mensualité appliquée est la mensualité maximale autorisée";
	public static final String messageInformatif53="Mensualité Calculée";
	public static final String messageInformatif57="Mensualité réajustée";
	public static final String messageInformatif82="Pas de la mensualité non renseigné,forcé à 1";
	public static final String messageInformatif84="Nb d’échéance < au nombre d’échéance demandé";
	
	/*DCRL FIELD */

	public static final String montantMensCalc="montantMensCalc";	
	public static final String nbEcheanceCalc="nbEcheanceCalc";	
	public static final String coutTotalInteret="coutTotalInteret";	
	public static final String coutTotalAssurance="coutTotalAssurance";		
	public static final String taea="taea";	
	public static final String montantAssurancePremiereMens="montantAssurancePremiereMens";	
	public static final String montantFinancable="montantFinancable";	
	public static final String codeRetCalc="codeRetCalc"; 
	public static final String taegs="taegs";
	
	
	/* HISTORIQUE FIELD*/
	
	
	public static final String codeOperation="codeOperation";
	public static final String dateOperation="dateOperation";
	public static final String dateFonctionnelle2="dateFonctionnelle2";
	public static final String montantOperation="montantOperation";
	public static final String numeroCheque="numeroCheque";
	public static final String idOperation="idOperation";
	public static final String nomBanqueDePrelevement="nomBanqueDePrelevement";	
	public static final String lieuEtNumeroMobile="lieuEtNumeroMobile";
	
}

