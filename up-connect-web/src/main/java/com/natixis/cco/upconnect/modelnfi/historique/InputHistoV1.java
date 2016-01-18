package com.natixis.cco.upconnect.modelnfi.historique;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.wordnik.swagger.annotations.ApiModelProperty;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "request")
public class InputHistoV1 {
	public enum Sens {PREC, SUIV };
	
	@XmlElement(name="numeroContrat")
	@ApiModelProperty(value="numeroContrat", required=true)
	@NotNull
	@Pattern(regexp="[0-9]{14}",message="Le numéro de dossier doit être composé de 14 chiffres.")
	private String numeroContrat;	
	
	@XmlElement(name="idOperation")
	@ApiModelProperty(value="idOperation", required=true)
	@NotNull
	@Size(min=26,max=26,message=" doit être sur exactement 26 caractères.")
	@Pattern(regexp="(\\d{4}-\\d{2}-\\d{2}-\\d{2}.\\d{2}.\\d{2}\\.\\d{6})",message=" doit au format aaaa-mm-jj-HH.mm.ss.nnnnnn, ex :2015-07-28-11.45.58.741788 ")
	private String idOperation;	
	
	@XmlElement(name="nombreOperationMaxARestituer")
	@ApiModelProperty(value="nombreOperationMaxARestituer", required=true)
	@NotNull
	@Min(value=1,message="Valeur min : {value}") @Max(value=40, message=" Valeur max : {value}")
	private int nombreOperationMaxARestituer;	
	
	@XmlElement(name="sensRestitution")
	@NotNull
	@Pattern(regexp="PREC|SUIV",message="sensRestitution : ne peut prendre que deux valeurs : PREC ou SUIV")
	@ApiModelProperty(value="PREC",allowableValues = "PREC, SUIV", required=true)	
	private String sensRestitution;

	
	public InputHistoV1() {
		super();		
	}

	public InputHistoV1(String numeroContrat, String idOperation,
			int nombreOperationMaxARestituer, String sensRestitution) {
		super();
		this.numeroContrat = numeroContrat;
		this.idOperation = idOperation;
		this.nombreOperationMaxARestituer = nombreOperationMaxARestituer;
		this.sensRestitution = sensRestitution;
	}

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

	public int getNombreOperationMaxARestituer() {
		return nombreOperationMaxARestituer;
	}

	public void setNombreOperationMaxARestituer(int nombreOperationMaxARestituer) {
		this.nombreOperationMaxARestituer = nombreOperationMaxARestituer;
	}

	public String getSensRestitution() {
		return sensRestitution;
	}

	public void setSensRestitution(String sensRestitution) {
		this.sensRestitution = sensRestitution;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InputHistoV1 [numeroContrat=");
		builder.append(numeroContrat);
		builder.append(", idOperation=");
		builder.append(idOperation);
		builder.append(", nombreOperationMaxARestituer=");
		builder.append(nombreOperationMaxARestituer);
		builder.append(", sensRestitution=");
		builder.append(sensRestitution);
		builder.append("]");
		return builder.toString();
	}

	

	

	
	
}
