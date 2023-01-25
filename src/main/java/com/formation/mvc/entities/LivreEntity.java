package com.formation.mvc.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;


@Entity(name="livres")
@DiscriminatorColumn(name="LIVRE")
public class LivreEntity extends DocumentEntity{
	
	
	private static final long serialVersionUID = 1595560137102606738L;

	
	private String auteur;
	private int nbPage;
	private float prix;
	
	

	
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
