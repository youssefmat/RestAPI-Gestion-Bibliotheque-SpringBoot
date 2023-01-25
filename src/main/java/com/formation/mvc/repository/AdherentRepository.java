package com.formation.mvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.mvc.entities.AdherentEntity;



@Repository
public interface AdherentRepository extends JpaRepository<AdherentEntity, Long> {
	AdherentEntity findByCin(String cin);
	AdherentEntity findByAdherentId(String id);
}
