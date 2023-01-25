package com.formation.mvc.dto;

import java.util.Date;


public class EmpruntDto {

	private long id;
	private String empruntId;
	private Date dateEmprunt;
	private Date dateRetour;
	private String adherentId;
	private String documentId;
	private String nom;
	private String titre;
	private AdherentDto adherentDto;
	private DocumentDto documentDto;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmpruntId() {
		return empruntId;
	}
	public void setEmpruntId(String empuntId) {
		this.empruntId = empuntId;
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
	public AdherentDto getAdherentDto() {
		return adherentDto;
	}
	public void setAdherentDto(AdherentDto adherentDto) {
		this.adherentDto = adherentDto;
	}
	public DocumentDto getDocumentDto() {
		return documentDto;
	}
	public void setDocumentDto(DocumentDto documentDto) {
		this.documentDto = documentDto;
	}
	public String getAdherentId() {
		return adherentId;
	}
	public void setAdherentId(String adherentId) {
		this.adherentId = adherentId;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	
	
	
	
	

	
	
	
}
