package com.formation.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.mvc.dto.LivreDto;

@Service
public interface LivreService {
	LivreDto createLivre(LivreDto livreDto);
	LivreDto updateLiver(String id,LivreDto livreDto);
	void deleteLiver(String id);
	LivreDto getLiverById(String id);
	List<LivreDto> getAllLivres(int page, int limite);

}
