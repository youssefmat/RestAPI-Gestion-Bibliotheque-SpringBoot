package com.formation.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.mvc.dto.AdherentDto;

@Service
public interface AdherentService {
   AdherentDto createAdherent(AdherentDto adherentDto);
   AdherentDto getAdherentByCin(String cin);
   AdherentDto getAdherentById(String id);
   AdherentDto updateAdherent(String id ,AdherentDto adherentDto);        
   void deleteAdherent(String id);
   List<AdherentDto> getAllAdherents(int page,int limite);
}
