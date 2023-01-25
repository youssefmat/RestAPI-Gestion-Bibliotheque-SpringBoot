package com.formation.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.mvc.dto.RevueDto;

@Service
public interface RevueService {

	RevueDto createRevue(RevueDto revueDto);
	RevueDto updateRevue(String id,RevueDto revueDto);
	void deleteRevue(String id);
	RevueDto getRevueById(String id);
	List<RevueDto> getAllRevues(int page, int limite);
}
