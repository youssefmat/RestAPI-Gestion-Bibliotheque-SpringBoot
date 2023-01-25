package com.formation.mvc.requests;

import java.util.Date;


public class AdherentRequest {
	
	
	private String nom;
	private String addresse;
	private String cin;
	private Date dateNaissance;
	//private List<EmpruntRequest> emprunts;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
	
	

}
