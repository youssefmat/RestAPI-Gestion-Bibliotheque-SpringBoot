package com.formation.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.mvc.entities.DictionnaireEntity;

public interface DictionnaireRepository extends JpaRepository<DictionnaireEntity, Long> {
	DictionnaireEntity findByDocumentId(String id);
}
