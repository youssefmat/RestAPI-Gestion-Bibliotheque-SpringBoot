package com.formation.mvc.dto;

import java.io.Serializable;

public class RevueDto implements Serializable {

	
	private static final long serialVersionUID = -5066834808214938374L;
	
	private String ref;
	private String documentId;
	private long annee; 
	private float prix;
	private String titre;
	
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
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

}
