package com.formation.mvc.responses;

import java.util.Date;
import java.util.List;




public class AdherentResponse {
	

	private String adherentId;
	private String nom;
	private String addresse;
	private String cin;
	private Date dateNaissance;
	private List<EmpruntResponse> emprunts;
   
	public String getAdherentId() {
		return adherentId;
	}
	public void setAdherentId(String adherentId) {
		this.adherentId = adherentId;
	}
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
	public List<EmpruntResponse> getEmprunts() {
		return emprunts;
	}
	public void setEmprunts(List<EmpruntResponse> emprunts) {
		this.emprunts = emprunts;
	}
	
	
	
	
}
