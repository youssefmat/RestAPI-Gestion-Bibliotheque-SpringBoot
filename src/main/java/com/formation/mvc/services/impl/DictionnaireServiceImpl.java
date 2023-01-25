package com.formation.mvc.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.formation.mvc.dto.DictionnaireDto;
import com.formation.mvc.dto.Utils;
import com.formation.mvc.entities.DictionnaireEntity;
import com.formation.mvc.repository.DictionnaireRepository;
import com.formation.mvc.services.DictionnaireService;


@Service
public class DictionnaireServiceImpl implements DictionnaireService {

	@Autowired
	Utils util;
    @Autowired
    DictionnaireRepository dictionnaireRepository;
	
	@Override
	public DictionnaireDto createDictionnaire(DictionnaireDto dictionnaire) {
		ModelMapper modelMapper = new  ModelMapper();
		DictionnaireEntity dictionnaireEntity = modelMapper.map(dictionnaire,DictionnaireEntity.class);
		dictionnaireEntity.setDocumentId(util.generateStringId(32));
		DictionnaireEntity newRevueEntity =  dictionnaireRepository.save(dictionnaireEntity);
		DictionnaireDto dictionnaireDto = modelMapper.map(newRevueEntity, DictionnaireDto.class);
		return dictionnaireDto;
	}

	@Override
	public DictionnaireDto updateDictionnaire(String id, DictionnaireDto dictionnaire) {
		DictionnaireEntity dictionnaireEntity = dictionnaireRepository.findByDocumentId(id);
		if(dictionnaireEntity == null) throw new RuntimeException("user il n'existe pas  !");
		dictionnaireEntity.setTitre(dictionnaire.getTitre());
		dictionnaireEntity.setPrix(dictionnaire.getPrix());
		dictionnaireEntity.setLangue(dictionnaire.getLangue());
		
		DictionnaireEntity dictionnaireUpdeted = dictionnaireRepository.save(dictionnaireEntity);
		ModelMapper modelMapper = new ModelMapper();
		
		DictionnaireDto dictionnaireDto = modelMapper.map(dictionnaireUpdeted, DictionnaireDto.class);
		
		return dictionnaireDto;
	}

	@Override
	public void deleteDictionnaire(String id) {
		DictionnaireEntity dictionnaireEntity = dictionnaireRepository.findByDocumentId(id);
		if(dictionnaireEntity == null) throw new RuntimeException("user il n'existe pas  !");
		dictionnaireRepository.delete(dictionnaireEntity);
		
	}

	@Override
	public DictionnaireDto getDictionnaireById(String id) {
		DictionnaireEntity dictionnaireEntity = dictionnaireRepository.findByDocumentId(id);
		if(dictionnaireEntity == null) throw new RuntimeException("user il n'existe pas  !");
		
		ModelMapper modelMapper = new  ModelMapper();
		DictionnaireDto dictionnaireDto = modelMapper.map(dictionnaireEntity, DictionnaireDto.class);
		
		return dictionnaireDto;
	}

	@Override
	public List<DictionnaireDto> getAllDictionnaire(int page, int limite) {
		ModelMapper modelMapper = new ModelMapper();
		if(page >0) page -=1 ;
		List<DictionnaireDto> dictionnairesDto = new ArrayList<>();
		Pageable pageableRequest = PageRequest.of(page, limite);
		
		Page<DictionnaireEntity> dictionnairePage = dictionnaireRepository.findAll(pageableRequest);
		List<DictionnaireEntity> dictionnairesEntity = new ArrayList<DictionnaireEntity>();
		
		dictionnairesEntity = dictionnairePage.getContent();
       for(DictionnaireEntity dictionnaires :dictionnairesEntity) {
            
    	   DictionnaireDto dictionnaireDto = modelMapper.map(dictionnaires, DictionnaireDto.class);
    	   dictionnairesDto.add(dictionnaireDto);
		}
		
		return dictionnairesDto;
	
	}

}
