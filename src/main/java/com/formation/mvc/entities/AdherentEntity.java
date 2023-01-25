package com.formation.mvc.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="adherents")
public class AdherentEntity {
	@Id
    @GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String adherentId;
	
	@Column(nullable=false,length=50)
	private String nom;
	
	@Column(nullable=false,length=100)
	private String addresse;
	
	@Column(nullable=false,length=50,unique=true)
	private String cin;
	
	private Date dateNaissance;
	@OneToMany(mappedBy="adherent",fetch= FetchType.EAGER,cascade = CascadeType.ALL)
	private List<EmpruntEntity> empruntes;
	
	
	
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

	public List<EmpruntEntity> getEmprunte() {
		return empruntes;
	}
	public void setEmprunte(List<EmpruntEntity> empruntes) {
		this.empruntes = empruntes;
	}
	
}
