package com.formation.mvc.entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="emprunts")
public class EmpruntEntity  implements Serializable{
	
	private static final long serialVersionUID = 4194339090654148868L;

	@Id
    @GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String empuntId;
	private Date dateEmprunt;
	private Date dateRetour;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="adherent_id")
	private AdherentEntity adherent;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="document_id")
	private DocumentEntity document;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmpuntId() {
		return empuntId;
	}
	public void setEmpuntId(String empuntId) {
		this.empuntId = empuntId;
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
	public AdherentEntity getAdherent() {
		return adherent;
	}
	public void setAdherent(AdherentEntity adherent) {
		this.adherent = adherent;
	}
	public DocumentEntity getDocument() {
		return document;
	}
	public void setDocument(DocumentEntity document) {
		this.document = document;
	}
	
}
