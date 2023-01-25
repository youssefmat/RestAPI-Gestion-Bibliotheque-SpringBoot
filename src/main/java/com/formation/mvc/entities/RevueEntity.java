package com.formation.mvc.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;


@Entity(name="revues")
@DiscriminatorColumn(name="REVUE")
public class RevueEntity extends DocumentEntity{
  
	private static final long serialVersionUID = 7244783529397477941L;

	
	@Column(nullable=false,length=50,unique=true)
	private String ref;
	
	@Column(nullable=false,length=50)
	private long annee; 
	
	@Column(nullable=false,length=50)
	private float prix;
	
	
	
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
	
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
}
