package com.formation.mvc.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;


@Entity(name="dictionnaires")
@DiscriminatorColumn(name="DICT")
public class DictionnaireEntity extends DocumentEntity {


	private static final long serialVersionUID = -4017194837862975148L;

	
	private String langue;
	private float prix;



	public String getLangue() {
		return langue;
	}


	public void setLangue(String langue) {
		this.langue = langue;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}
	
}
