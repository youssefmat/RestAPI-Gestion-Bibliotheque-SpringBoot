package com.formation.mvc.responses;

public class RevueResponse {

	private String titre;
	private String ref;
	private String documentId;
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
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
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
