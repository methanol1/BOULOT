package com.natixis.cco.upconnect.commarea.historique;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescriptionHeader;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;

public class HistoUP1CommareaDescriptionRequest extends UnitedCommareaDescriptionHeader {
	
	/**
	 * EIMDCDO0-INNDOSSIER
	 */
	@UnitedCommareaField(position=17, longueur=14)
	private String numeroContrat;
	
	/**
	 * EIMDCDO-INTIMESTAMPOP
	 * 2011-01-01-00.00.00.000000
	 */
	@UnitedCommareaField(position=18, longueur=26)
	private String idOperation;
	
	/**
	 * EIMDCDO-INNBROPEAREST 
	 */
	@UnitedCommareaField(position=19, longueur=2)
	private String nombreOperationMaxARestituer;
	
	/**
	 * EIMDCDO-INSENSAREST
	 * Liste de valeur: SUIV ou PREC
	 */
	@UnitedCommareaField(position=20, longueur=4)
	private String sensRestition;
	
	/**
	 * FILLER 
	 */
	@UnitedCommareaField(position=21, longueur=5195)
	private String filler;

	public String getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(String numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	public String getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(String idOperation) {
		this.idOperation = idOperation;
	}

	public String getNombreOperationMaxARestituer() {
		return nombreOperationMaxARestituer;
	}

	public void setNombreOperationMaxARestituer(String nombreOperationMaxARestituer) {
		this.nombreOperationMaxARestituer = nombreOperationMaxARestituer;
	}

	public String getSensRestition() {
		return sensRestition;
	}

	public void setSensRestition(String sensRestition) {
		this.sensRestition = sensRestition;
	}

	public String getFiller() {
		return filler;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}
	
	
	

}
