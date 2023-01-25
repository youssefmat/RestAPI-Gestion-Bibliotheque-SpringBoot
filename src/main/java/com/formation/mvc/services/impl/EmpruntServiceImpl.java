package com.formation.mvc.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.formation.mvc.dto.AdherentDto;
import com.formation.mvc.dto.DocumentDto;
import com.formation.mvc.dto.EmpruntDto;
import com.formation.mvc.dto.Utils;
import com.formation.mvc.entities.AdherentEntity;
import com.formation.mvc.entities.DocumentEntity;
import com.formation.mvc.entities.EmpruntEntity;
import com.formation.mvc.repository.AdherentRepository;
import com.formation.mvc.repository.DocumentRepository;
import com.formation.mvc.repository.EmpruntRepository;
import com.formation.mvc.services.EmpruntService;

@Service
public class EmpruntServiceImpl implements EmpruntService{
   
	@Autowired
	EmpruntRepository empruntRepository;
	
	@Autowired
	AdherentRepository adherentRepository;
	
	@Autowired
	DocumentRepository documentRepository;
	
	@Autowired
	Utils util;
	
	
	@Override
	public EmpruntDto createEmprunt(EmpruntDto emprunt ,String adherentId, String documentId) {
		ModelMapper modelMapper = new  ModelMapper();
		/*
		System.out.println("---------------emprunt-------------");
		System.out.println("adherentId: "+emprunt.getAdherentId());
		
		System.out.println("---------------adherentID-------------");
		System.out.println("address: "+adherent.getAddresse());
		System.out.println("adherentId: "+adherent.getAdherentId());
		System.out.println("CIN: "+adherent.getCin());
		System.out.println("Id: "+adherent.getId());
		System.out.println("dateNaissance: "+adherent.getDateNaissance());
		System.out.println("-----------------adherentID-----------");
		empruntEntity.setDateEmprunt(new Date());
		empruntEntity.setDateRetour(new Date());*/
		
		AdherentEntity adherent= adherentRepository.findByAdherentId(adherentId);
		
		AdherentDto adherentDto = modelMapper.map(adherent, AdherentDto.class);
		System.out.println("nom: "+adherentDto.getNom());
		
		DocumentEntity document =documentRepository.findByDocumentId(documentId);
		
		DocumentDto documentDto = modelMapper.map(document, DocumentDto.class);
		System.out.println("titre: "+documentDto.getTitre());
		
		emprunt.setAdherentDto(adherentDto);
		emprunt.setDocumentDto(documentDto);
		System.out.println("adherent->"+emprunt.getAdherentDto().getCin());
		System.out.println("document->"+emprunt.getDocumentDto().getDictionnaireId());
		EmpruntEntity empruntEntity = modelMapper.map(emprunt,EmpruntEntity.class);
		empruntEntity.setEmpuntId(util.generateStringId(32));
		
		EmpruntEntity newEmpruntEntity =  empruntRepository.save(empruntEntity);
		EmpruntDto empruntDto = modelMapper.map(newEmpruntEntity, EmpruntDto.class);
		return empruntDto;
	}

	@Override   
	public EmpruntDto updateEmprunt(String id, EmpruntDto emprunt) {
		EmpruntEntity empruntEntity = empruntRepository.findById(id);
		if(empruntEntity == null) throw new RuntimeException("user il n'existe pas  !");
		empruntEntity.setDateEmprunt(emprunt.getDateEmprunt());
		empruntEntity.setDateRetour(emprunt.getDateRetour());
		
		EmpruntEntity empruntUpdeted = empruntRepository.save(empruntEntity);
		ModelMapper modelMapper = new ModelMapper();
		
		EmpruntDto revueDto = modelMapper.map(empruntUpdeted, EmpruntDto.class);
		
		return revueDto;
	}

	@Override
	public void deleteEmprunt(String id) {
		
		EmpruntEntity revueEntity = empruntRepository.findById(id);
		if(revueEntity == null) throw new RuntimeException("user il n'existe pas  !");
		empruntRepository.delete(revueEntity);
		
	}

	@Override
	public EmpruntDto getEmpruntById(String id) {
		EmpruntEntity empruntEntity = empruntRepository.findById(id);
		if(empruntEntity == null) throw new RuntimeException("user il n'existe pas  !");
		
		ModelMapper modelMapper = new  ModelMapper();
		EmpruntDto empruntDto = modelMapper.map(empruntEntity, EmpruntDto.class);
		
		return empruntDto;
	}

	@Override
	public List<EmpruntDto> getAllEmprunts(int page, int limite) {
		ModelMapper modelMapper = new ModelMapper();
		if(page >0) page -=1 ;
		List<EmpruntDto> empruntsDto = new ArrayList<>();
		Pageable pageableRequest = PageRequest.of(page, limite);
		
		Page<EmpruntEntity> empruntsPage = empruntRepository.findAllEmprunts(pageableRequest);
		List<EmpruntEntity> empruntsEntity = new ArrayList<EmpruntEntity>();
	
		empruntsEntity = empruntsPage.getContent();
       for(EmpruntEntity emprunts :empruntsEntity) {
    	   String nom = emprunts.getAdherent().getNom();
    	   String titre = emprunts.getDocument().getTitre();
    	   
    	   EmpruntDto empruntDto = modelMapper.map(emprunts, EmpruntDto.class);
    	   empruntDto.setNom(nom);
    	   empruntDto.setTitre(titre);
    	  // System.out.println(empruntDto.getNom());
    	  // System.out.println(empruntDto.getTitre());
    	   empruntsDto.add(empruntDto);
    	   
		}
		
		//List<EmpruntEntity> emprunts = (List<EmpruntEntity>) empruntRepository.findAll();
		//Type listType = new TypeToken<List<EmpruntDto>>() {}.getType();
		//List<EmpruntDto> empruntsDto = new ModelMapper().map(emprunts, listType);
		
		return empruntsDto;
	}

}
