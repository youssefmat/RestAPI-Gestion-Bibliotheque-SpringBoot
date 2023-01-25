package com.formation.mvc.requests;

import java.util.Date;






public class EmpruntRequest {
	
	private Date dateEmprunt;
	private Date dateRetour;
	

	
	
	

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
	
	
}
