package com.formation.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formation.mvc.dto.LivreDto;
import com.formation.mvc.requests.LivreRequest;
import com.formation.mvc.responses.LivreResponse;
import com.formation.mvc.services.LivreService;

@RestController
@RequestMapping("/livres")
public class LivreController {
	
	@Autowired
	LivreService livreService;

	
	
	
	@GetMapping
	public List<LivreResponse> getAllAdherents(@RequestParam(value="page", defaultValue="1") int page,@RequestParam(value="limite",defaultValue="10") int limite) {
		ModelMapper modelMapper = new ModelMapper();
		List<LivreResponse>  livreResponses = new ArrayList<>();
		
		List<LivreDto> livres = livreService.getAllLivres(page,limite);
		
		for(LivreDto livreDto :livres) {
			LivreResponse livreResponse =modelMapper.map(livreDto, LivreResponse.class);
			livreResponses.add(livreResponse);
			
		}
		return livreResponses;
		}
	
	
	@GetMapping(path="/{id}")
	public ResponseEntity<LivreResponse> getLivre(@PathVariable String id) {
		
		LivreDto livreDto = livreService.getLiverById(id);
	
		ModelMapper modelMapper = new ModelMapper();
		LivreResponse livreResponse = modelMapper.map(livreDto, LivreResponse.class);
		return new ResponseEntity<LivreResponse>( livreResponse,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<LivreResponse> addLivre(@RequestBody LivreRequest requestLivre ) {
		
		ModelMapper modelMapper = new ModelMapper();
		LivreDto livreDto = modelMapper.map(requestLivre, LivreDto.class);
		LivreDto createLivre= livreService.createLivre(livreDto);
		LivreResponse livreResponse = modelMapper.map(createLivre, LivreResponse.class);
		
	    return  new ResponseEntity<LivreResponse>( livreResponse,HttpStatus.CREATED);	
	}
	
	@PutMapping(path="/{id}")
    public ResponseEntity<LivreResponse> updtateLiver(@PathVariable String id, @RequestBody LivreRequest requestLivre) {
		
		ModelMapper modelMapper = new ModelMapper();
		LivreDto livreDto = modelMapper.map(requestLivre, LivreDto.class);
		LivreDto createLivre =livreService.updateLiver(id,livreDto);
		LivreResponse  livreResponse = modelMapper.map(createLivre, LivreResponse.class) ;
    	
		return new ResponseEntity<LivreResponse>( livreResponse,HttpStatus.ACCEPTED);
    }
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteLivre(@PathVariable String id) {
		livreService.deleteLiver(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
