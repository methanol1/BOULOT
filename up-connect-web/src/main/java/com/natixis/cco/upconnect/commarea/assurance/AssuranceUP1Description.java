package com.natixis.cco.upconnect.commarea.assurance;

import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

public class AssuranceUP1Description {

	/**
     * EIMDASU-OUT-TXMENSSOUS
     * Taux menusuel d'assurance souscripteur
     */
    @UnitedCommareaField(position = 1, longueur = 7)
    private String tauxMenSous;
    
    /**
     * EIMDASU-OUT-TXMENSCOSO
     * Taux menusuel d'assurance co-souscripteur
     */
    @UnitedCommareaField(position = 2, longueur = 7)
    private String tauxMenCoSous;
    
    /**
     * EIMDASU-OUT-OPTASSSOUS
     * Option assurance souscripteur
     */
    @UnitedCommareaField(position = 3, longueur = 5)
    private String optionSous;    
    
    /**
     * EIMDASU-OUT-OPTASSCOSO
     */
    @UnitedCommareaField(position = 4, longueur = 5)
    private String optionCoSous;
    
    /**
     * EIMDASU-OUT-PRIMESOUS
     * Prime forfaitaire assurance souscripteur
     */
    @UnitedCommareaField(position = 5, longueur = 13)
    private String primeSous;
    
    /**
     * EIMDASU-OUT-PRIMECOSO
     * Prime forfaitaire assurance souscripteur
     */
    @UnitedCommareaField(position = 6, longueur = 13)
    private String primeCoSous;
    
    /**
     * EIMDASU-OUT-CODCONV
     */
    @UnitedCommareaField(position = 7, longueur = 5)
    private String codeConv;
    
    /**
     * EIMDASU-OUT-DATSOUS
     */
    @UnitedCommareaField(position = 8, longueur = 10)
    private String dateSous;
    
    /**
     * EIMDASU-OUT-DATCOSO
     */
    @UnitedCommareaField(position = 9, longueur = 10)
    private String dateCoSous;

    /**
     * @return the tauxMenSous
     */
    public String getTauxMenSous() {
        return tauxMenSous;
    }

    /**
     * @param tauxMenSous the tauxMenSous to set
     */
    public void setTauxMenSous(String tauxMenSous) {
        this.tauxMenSous = tauxMenSous;
    }

    /**
     * @return the tauxMenCoSous
     */
    public String getTauxMenCoSous() {
        return tauxMenCoSous;
    }

    /**
     * @param tauxMenCoSous the tauxMenCoSous to set
     */
    public void setTauxMenCoSous(String tauxMenCoSous) {
        this.tauxMenCoSous = tauxMenCoSous;
    }

    /**
     * @return the optionSous
     */
    public String getOptionSous() {
        return optionSous;
    }

    /**
     * @param optionSous the optionSous to set
     */
    public void setOptionSous(String optionSous) {
        this.optionSous = optionSous;
    }

    /**
     * @return the optionCoSous
     */
    public String getOptionCoSous() {
        return optionCoSous;
    }

    /**
     * @param optionCoSous the optionCoSous to set
     */
    public void setOptionCoSous(String optionCoSous) {
        this.optionCoSous = optionCoSous;
    }

    /**
     * @return the primeSous
     */
    public String getPrimeSous() {
        return primeSous;
    }

    /**
     * @param primeSous the primeSous to set
     */
    public void setPrimeSous(String primeSous) {
        this.primeSous = primeSous;
    }

    /**
     * @return the primeCoSous
     */
    public String getPrimeCoSous() {
        return primeCoSous;
    }

    /**
     * @param primeCoSous the primCoSous to set
     */
    public void setPrimeCoSous(String primeCoSous) {
        this.primeCoSous = primeCoSous;
    }

    /**
     * @return the codeConv
     */
    public String getCodeConv() {
        return codeConv;
    }

    /**
     * @param codeConv the codeConv to set
     */
    public void setCodeConv(String codeConv) {
        this.codeConv = codeConv;
    }

    /**
     * @return the dateSous
     */
    public String getDateSous() {
        return dateSous;
    }

    /**
     * @param dateSous the dateSous to set
     */
    public void setDateSous(String dateSous) {
        this.dateSous = dateSous;
    }

    /**
     * @return the dateCoSous
     */
    public String getDateCoSous() {
        return dateCoSous;
    }

    /**
     * @param dateCoSous the dateCoSous to set
     */
    public void setDateCoSous(String dateCoSous) {
        this.dateCoSous = dateCoSous;
    }

}
