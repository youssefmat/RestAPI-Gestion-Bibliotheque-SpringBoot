package com.formation.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.mvc.entities.RevueEntity;

public interface RevueRepository extends JpaRepository<RevueEntity, Long> {
  
	RevueEntity findByDocumentId(String id);
	RevueEntity findByRef(String ref);
}
