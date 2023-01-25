package com.formation.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.mvc.dto.DictionnaireDto;

@Service
public interface DictionnaireService {

	
	DictionnaireDto createDictionnaire(DictionnaireDto dictionnaireDto);
	DictionnaireDto updateDictionnaire(String id,DictionnaireDto dictionnaireDto);
	void deleteDictionnaire(String id);
	DictionnaireDto getDictionnaireById(String id);
	List<DictionnaireDto> getAllDictionnaire(int page, int limite);
}
