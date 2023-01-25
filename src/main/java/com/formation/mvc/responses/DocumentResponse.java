package com.formation.mvc.responses;

public class DocumentResponse {

	
	    
	private String documentId;
	private String livreId;
	private String dictionnaireId;
    private String revueId;
    private String auteur;
	private String titre;
	private int nbPage;
	private float prix;
	private String langue;
    private String ref;
	private long annee;
	
	
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getLivreId() {
		return livreId;
	}
	public void setLivreId(String livreId) {
		this.livreId = livreId;
	}
	public String getDictionnaireId() {
		return dictionnaireId;
	}
	public void setDictionnaireId(String dictionnaireId) {
		this.dictionnaireId = dictionnaireId;
	}
	public String getRevueId() {
		return revueId;
	}
	public void setRevueId(String revueId) {
		this.revueId = revueId;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
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
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
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
}
