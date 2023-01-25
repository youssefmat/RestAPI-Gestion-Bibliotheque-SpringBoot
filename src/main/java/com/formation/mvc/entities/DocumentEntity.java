package com.formation.mvc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="documents")
//@DiscriminatorColumn(name="TYPE")
public class DocumentEntity  implements Serializable {
	
	private static final long serialVersionUID = -7496350880176613855L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false , length = 50)
	private String documentId;
	
	@Column(nullable = false , length = 100)
	private String titre;
	
	
	@OneToMany(mappedBy="document",fetch= FetchType.EAGER,cascade = CascadeType.ALL)
	private List<EmpruntEntity> documents;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public List<EmpruntEntity> getDocuments() {
		return documents;
	}
	public void setDocuments(List<EmpruntEntity> documents) {
		this.documents = documents;
	}
	
	

}
