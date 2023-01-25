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
import com.formation.mvc.dto.Utils;
import com.formation.mvc.entities.AdherentEntity;
import com.formation.mvc.repository.AdherentRepository;
import com.formation.mvc.services.AdherentService;


@Service
public class AdherentServiceImpl implements AdherentService{

	
	  @Autowired
		AdherentRepository adherentRepository ;
	  
	  @Autowired
	    Utils util;

	@Override
	public AdherentDto createAdherent(AdherentDto adherent) {
		

   /*   for(int i=0; i<adherent.getEmprunts().size();i++) {
			
			EmpruntDto emprunts = adherent.getEmprunts().get(i);
			System.out.println("--------------------");
			
			System.out.println("date emprunt 1 : "+emprunts.getDateEmprunt());
			System.out.println("date emprunt 2 : "+emprunts.getDateRetour());
			
			System.out.println("--------------------");
			emprunts.setEmpruntId(util.generateStringId(32));
			System.out.println("id emprunt : "+util.generateStringId(32));
			emprunts.setAdherentDto(adherent);
			adherent.getEmprunts().set(i, emprunts);
			System.out.println("--------------------");
			System.out.println("id : "+emprunts.getId());
			System.out.println("adherent object : "+emprunts.getAdherentDto().toString());
			System.out.println("empruntID : "+emprunts.getEmpruntId());
			System.out.println("date emprunt : "+emprunts.getDateEmprunt());
			System.out.println("date retour : "+emprunts.getDateRetour());
			System.out.println("--------------------");
		}*/
		AdherentEntity checkCIN = adherentRepository.findByCin(adherent.getCin());
		
		if(checkCIN !=null) throw new RuntimeException("cette CIN d'eja existe !");
      
      ModelMapper modelMapper = new ModelMapper();
      AdherentEntity adherentEntity = modelMapper.map(adherent, AdherentEntity.class);
      adherentEntity.setAdherentId(util.generateStringId(32));
       // adherentEntity.setDateNaissance(new Date());
        System.out.println("liste: "+adherentEntity.getDateNaissance());
		AdherentEntity newAdherentEnity = adherentRepository.save(adherentEntity);
		
		AdherentDto adherentDto =  modelMapper.map(newAdherentEnity, AdherentDto.class);
		
		
		return adherentDto;
	}

	@Override
	public AdherentDto getAdherentByCin(String cin) {
		AdherentEntity userEntity = adherentRepository.findByCin(cin);
		if(userEntity == null) throw new RuntimeException("user il n'existe pas  !");
		 ModelMapper modelMapper = new ModelMapper();
		 AdherentDto adherentDto = modelMapper.map(userEntity, AdherentDto.class);
	
		return adherentDto;
	}

	@Override
	public AdherentDto updateAdherent(String id, AdherentDto adherentDto) {
		AdherentEntity adherentEntity = adherentRepository.findByCin(id);
		if(adherentEntity == null) throw new RuntimeException("user il n'existe pas  !");
		adherentEntity.setNom(adherentDto.getNom());
		adherentEntity.setAddresse(adherentDto.getAddresse());
		adherentEntity.setCin(adherentDto.getCin());
		adherentEntity.setDateNaissance(adherentDto.getDateNaissance());
		AdherentEntity adherentEnityUpadated = adherentRepository.save(adherentEntity);
		ModelMapper modelMapper = new ModelMapper();
		AdherentDto adherentUpdated = modelMapper.map(adherentEnityUpadated, AdherentDto.class);
		 
		return adherentUpdated;
	}

	@Override
	public void deleteAdherent(String id) {
		AdherentEntity adherentEntity = adherentRepository.findByAdherentId(id);
		if(adherentEntity == null) throw new RuntimeException("user il n'existe pas  !");
		adherentRepository.delete(adherentEntity);
	}

	@Override
	public List<AdherentDto> getAllAdherents(int page, int limite) {
		ModelMapper modelMapper = new ModelMapper();
		if(page >0) page -=1 ;
		List<AdherentDto> AdherentsDto = new ArrayList<>();
		Pageable pageableRequest = PageRequest.of(page, limite);
		Page<AdherentEntity> AdherentsPage = adherentRepository.findAll(pageableRequest);
		List<AdherentEntity> adherentsEntity = new ArrayList<AdherentEntity>();
		adherentsEntity = AdherentsPage.getContent();
		
		
		for(AdherentEntity adherents :adherentsEntity) {
			AdherentDto adherentDto = modelMapper.map(adherents, AdherentDto.class);
			
			AdherentsDto.add(adherentDto);
		}
		
		
		return AdherentsDto;
	}

	@Override
	public AdherentDto getAdherentById(String id) {
		AdherentEntity userEntity = adherentRepository.findByAdherentId(id);
		if(userEntity == null) throw new RuntimeException("user il n'existe pas  !");
		 ModelMapper modelMapper = new ModelMapper();
		 AdherentDto adherentDto = modelMapper.map(userEntity, AdherentDto.class);
	
		return adherentDto;
	}

}
