package com.formation.mvc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.formation.mvc.entities.EmpruntEntity;
@Repository
public interface EmpruntRepository extends JpaRepository<EmpruntEntity, Long> {
 
	EmpruntEntity findById(String id);
	//where emprunts.adherent_id = adherents.id and  ,adherents
	
	@Query(value="SELECT titre, date_emprunt, date_retour,emprunts.id, empunt_id,emprunts.adherent_id,emprunts.document_id FROM  emprunts,documents,adherents where emprunts.adherent_id = adherents.id and  emprunts.document_id = documents.id",nativeQuery = true)
	Page<EmpruntEntity> findAllEmprunts(Pageable pageableRequest);
}
