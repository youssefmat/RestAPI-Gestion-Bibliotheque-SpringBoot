package com.formation.mvc.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.formation.mvc.dto.LivreDto;
import com.formation.mvc.dto.Utils;
import com.formation.mvc.entities.LivreEntity;
import com.formation.mvc.repository.LiverRepository;
import com.formation.mvc.services.LivreService;

@Service
public class LivreServiceImpl implements LivreService{
	 @Autowired
	 LiverRepository liverRepository;
	 @Autowired
	 Utils util;

	@Override
	public LivreDto createLivre(LivreDto livre) {
		ModelMapper modelMapper = new  ModelMapper();
		LivreEntity livreEntity = modelMapper.map(livre,LivreEntity.class );
		livreEntity.setDocumentId(util.generateStringId(32));
		
		LivreEntity newLivreEntity =  liverRepository.save(livreEntity);
		LivreDto LivreDto = modelMapper.map(newLivreEntity, LivreDto.class);
		return LivreDto;
	}

	@Override
	public LivreDto updateLiver(String id, LivreDto livre) {
		
		LivreEntity livreEntity = liverRepository.findByDocumentId(id);
		if(livreEntity == null) throw new RuntimeException("user il n'existe pas  !");
		livreEntity.setAuteur(livre.getAuteur());
		livreEntity.setNbPage(livre.getNbPage());
		livreEntity.setPrix(livre.getPrix());
		livreEntity.setTitre(livre.getTitre());
		LivreEntity livreUpdeted = liverRepository.save(livreEntity);
		ModelMapper modelMapper = new ModelMapper();
		
		LivreDto livreDto = modelMapper.map(livreUpdeted, LivreDto.class);
		
		return livreDto;
	}

	@Override
	public void deleteLiver(String id) {
		
		LivreEntity livreEntity = liverRepository.findByDocumentId(id);
		if(livreEntity == null) throw new RuntimeException("user il n'existe pas  !");
		liverRepository.delete(livreEntity);
		
	}

	@Override
	public LivreDto getLiverById(String id) {
		LivreEntity livreEntity = liverRepository.findByDocumentId(id);
		if(livreEntity == null) throw new RuntimeException("user il n'existe pas  !");
		
		ModelMapper modelMapper = new  ModelMapper();
		LivreDto livreDto = modelMapper.map(livreEntity, LivreDto.class);
		
		return livreDto;
	}

	@Override
	public List<LivreDto> getAllLivres(int page, int limite) {
        
		ModelMapper modelMapper = new ModelMapper();
		if(page >0) page -=1 ;
		List<LivreDto> livresDto = new ArrayList<>();
		Pageable pageableRequest = PageRequest.of(page, limite);
		Page<LivreEntity> livresPage = liverRepository.findAll(pageableRequest);
		List<LivreEntity> livresEntity = new ArrayList<LivreEntity>();
		livresEntity = livresPage.getContent();
       for(LivreEntity livres :livresEntity) {
			
    	   LivreDto livreDto = modelMapper.map(livres, LivreDto.class);
    	   livresDto.add(livreDto);
		}
		
		
		return livresDto;
	}

}
