package com.formation.mvc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;




public class AdherentDto implements Serializable {

	
	private static final long serialVersionUID = -7159090856336077466L;
    
	private long id;
	private String adherentId;
	private String nom;
	private String addresse;
	private String cin;
	private Date dateNaissance;
	private List<EmpruntDto> emprunts;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public List<EmpruntDto> getEmprunts() {
		return emprunts;
	}
	public void setEmprunts(List<EmpruntDto> emprunts) {
		this.emprunts = emprunts;
	}
	
	
	
}
