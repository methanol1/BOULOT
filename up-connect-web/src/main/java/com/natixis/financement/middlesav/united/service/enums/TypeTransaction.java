package com.natixis.financement.middlesav.united.service.enums;

public enum TypeTransaction {
    ASSURANCE("assurance"),
    DOMICILIATION_BANCAIRE("banque"),
    HISTORIQUE_OPERATIONS("historique"),
    RACHAT("rachat"),
    REPORT("report"),
    CONTRAT("contrat"),
    AGENCE("agence"),
    DMEN("dmen"),
    DCRL("dcrl");
 
    
    private String cle;

    private TypeTransaction(String cle) {
        this.cle = cle;
    }

    /**
     * @return la racine des clés dans united-infos.properties pour la transaction voulue.
     * Exemple: 
     * contrat.prog.appelant=MIDSAV-CONTRAT
     * contrat.program.name=IMDCTR0
     * ==> cle doit valoir "contrat"
     */
    public String getCle(){
        return cle;
    }
}
