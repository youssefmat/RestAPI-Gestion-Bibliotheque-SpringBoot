package com.formation.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.mvc.entities.LivreEntity;


public interface LiverRepository extends JpaRepository<LivreEntity, Long> {
	
	LivreEntity findByDocumentId(String id);

}
