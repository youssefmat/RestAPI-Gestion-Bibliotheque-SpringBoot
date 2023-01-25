package com.formation.mvc.responses;

import java.util.Date;

public class EmpruntResponse {
  
	private long id;
	private String empruntId;
	private Date dateEmprunt;
	private Date dateRetour;
	private String nom;
	private String titre;
	
	//private List<AdherentResponse> adherents;
	//private List<DocumentResponse> documents;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmpruntId() {
		return empruntId;
	}
	public void setEmpruntId(String empruntId) {
		this.empruntId = empruntId;
	}
	public Date getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public Date getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	
	
	
	
}
