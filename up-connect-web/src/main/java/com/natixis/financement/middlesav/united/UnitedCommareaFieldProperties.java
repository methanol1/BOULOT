package com.natixis.financement.middlesav.united;

public class UnitedCommareaFieldProperties {

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnitedCommareaFieldProperties [longueur=");
		builder.append(longueur);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", valeur=");
		builder.append(valeur);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append("]");
		return builder.toString();
	}

	private Integer longueur;
	private String nom;
	private String valeur;
	private Integer nombre;
	
	public UnitedCommareaFieldProperties(Integer aLongueur, String aNom, Integer aNombre, String aValeur){
		longueur = aLongueur;
		nom = aNom;
		nombre = aNombre;
		valeur = aValeur;
	}
	
	public UnitedCommareaFieldProperties(Integer aLongueur, String aNom, Integer aNombre){
		longueur = aLongueur;
		nom = aNom;
		nombre = aNombre;
	}

	public UnitedCommareaFieldProperties(Integer aLongueur, String aNom, String aValeur){
		longueur = aLongueur;
		nom = aNom;
		valeur = aValeur;
	}
	
	public UnitedCommareaFieldProperties(Integer aLongueur, String aNom){
		longueur = aLongueur;
		nom = aNom;
	}
	
	public Integer getLongueur() {
		return longueur;
	}
	public void setLongueur(Integer longueur) {
		this.longueur = longueur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Integer getNombre() {
		return nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}
}
