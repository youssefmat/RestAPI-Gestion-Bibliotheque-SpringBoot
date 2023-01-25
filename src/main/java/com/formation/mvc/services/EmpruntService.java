package com.formation.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.mvc.dto.EmpruntDto;

@Service
public interface EmpruntService {

	EmpruntDto createEmprunt(EmpruntDto empruntDto,String adherentId, String documentId);
	EmpruntDto updateEmprunt(String id,EmpruntDto empruntDto);
	void deleteEmprunt(String id);
	EmpruntDto getEmpruntById(String id);
	List<EmpruntDto> getAllEmprunts(int page, int limite);
}
