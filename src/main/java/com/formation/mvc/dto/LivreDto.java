package com.formation.mvc.dto;

import java.io.Serializable;

public class LivreDto implements Serializable {

	
	private static final long serialVersionUID = 4565878671833648810L;
	
	private String documentId;
	private String titre;
	private String auteur;
	private int nbPage;
	private float prix;
	
	
	
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getNbPage() {
		return nbPage;
	}
	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}

}
