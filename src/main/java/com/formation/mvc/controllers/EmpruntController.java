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

import com.formation.mvc.dto.EmpruntDto;
import com.formation.mvc.requests.EmpruntRequest;
import com.formation.mvc.responses.EmpruntResponse;
import com.formation.mvc.services.EmpruntService;


@RestController
@RequestMapping("/emprunts")
public class EmpruntController {


	@Autowired
	EmpruntService  empruntService;
	
	
	@GetMapping
	public List<EmpruntResponse> getAllEmprunts(@RequestParam(value="page", defaultValue="1") int page,@RequestParam(value="limite",defaultValue="5") int limite) {
		ModelMapper modelMapper = new ModelMapper();
		List<EmpruntResponse>  empruntsResponses = new ArrayList<>();
		
		List<EmpruntDto> emprunts = empruntService.getAllEmprunts(page,limite);
		
		for(EmpruntDto empruntDto :emprunts) {
			EmpruntResponse empruntResponse =modelMapper.map(empruntDto, EmpruntResponse.class);
			System.out.println(empruntResponse.getNom());
			System.out.println(empruntResponse.getTitre())
;			empruntsResponses.add(empruntResponse);
			
		}
		return empruntsResponses;
		 
		/*List<EmpruntDto> emprunts = empruntService.getAllEmprunts();
		Type listType = new TypeToken<List<EmpruntResponse>>() {}.getType();
		List<EmpruntResponse> empruntResponse = new ModelMapper().map(emprunts, listType);
		
		
		return new ResponseEntity<List<EmpruntResponse>>(empruntResponse,HttpStatus.OK);*/
		}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<EmpruntResponse> getEmprunt(@PathVariable String id) {
		
		EmpruntDto empruntDto = empruntService.getEmpruntById(id);
	
		ModelMapper modelMapper = new ModelMapper();
		EmpruntResponse empruntResponse = modelMapper.map(empruntDto, EmpruntResponse.class);
		return new ResponseEntity<EmpruntResponse>( empruntResponse,HttpStatus.OK);
	}
	
	
	@PostMapping(path="/{adherentId}/{documentId}")
	public ResponseEntity<EmpruntResponse> addEmprunt(@RequestBody EmpruntRequest requestEmprunt ,@PathVariable String adherentId, @PathVariable String documentId ) {
		
		ModelMapper modelMapper = new ModelMapper();
		EmpruntDto empruntDto = modelMapper.map(requestEmprunt, EmpruntDto.class);
		EmpruntDto createEmprunt= empruntService.createEmprunt(empruntDto,adherentId,documentId);
		EmpruntResponse empruntResponse = modelMapper.map(createEmprunt, EmpruntResponse.class);
		
	    return  new ResponseEntity<EmpruntResponse>( empruntResponse,HttpStatus.CREATED);	
	}
	

	@PutMapping(path="/{id}")
    public ResponseEntity<EmpruntResponse> updtateEmprunt(@PathVariable String id, @RequestBody EmpruntRequest requestEmprunt) {
		
		ModelMapper modelMapper = new ModelMapper();
		EmpruntDto empruntDto = modelMapper.map(requestEmprunt, EmpruntDto.class);
		EmpruntDto createEmprunt =empruntService.updateEmprunt(id,empruntDto);
		EmpruntResponse  empruntResponse = modelMapper.map(createEmprunt, EmpruntResponse.class) ;
    	
		return new ResponseEntity<EmpruntResponse>( empruntResponse,HttpStatus.ACCEPTED);
    }
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteEmprunt(@PathVariable String id) {
		empruntService.deleteEmprunt(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
