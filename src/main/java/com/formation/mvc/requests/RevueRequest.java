package com.formation.mvc.requests;

public class RevueRequest {

	private String titre;
	private String ref;
	private long annee; 
	private float prix;
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public long getAnnee() {
		return annee;
	}
	public void setAnnee(long annee) {
		this.annee = annee;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
}
