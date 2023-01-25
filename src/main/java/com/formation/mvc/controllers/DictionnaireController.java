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

import com.formation.mvc.dto.DictionnaireDto;
import com.formation.mvc.requests.DictionnaireRequest;
import com.formation.mvc.responses.DictionnaireResponse;
import com.formation.mvc.services.DictionnaireService;

@RestController
@RequestMapping("/dictionnaires")
public class DictionnaireController {


	@Autowired
	DictionnaireService  dictionnaireService;
	
	
	@GetMapping
	public List<DictionnaireResponse> getAllDictionnaires(@RequestParam(value="page", defaultValue="1") int page,@RequestParam(value="limite",defaultValue="3") int limite) {
		ModelMapper modelMapper = new ModelMapper();
		List<DictionnaireResponse>  dictionnairesResponses = new ArrayList<>();
		
		List<DictionnaireDto> dictionnaires = dictionnaireService.getAllDictionnaire(page,limite);
		
		for(DictionnaireDto dictionnaireDto :dictionnaires) {
			DictionnaireResponse revueResponse =modelMapper.map(dictionnaireDto, DictionnaireResponse.class);
			dictionnairesResponses.add(revueResponse);
			
		}
		return dictionnairesResponses;
		}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<DictionnaireResponse> getDictionnaire(@PathVariable String id) {
		
		DictionnaireDto dictionnaireDto = dictionnaireService.getDictionnaireById(id);
	
		ModelMapper modelMapper = new ModelMapper();
		DictionnaireResponse dictionnaireResponse = modelMapper.map(dictionnaireDto, DictionnaireResponse.class);
		return new ResponseEntity<DictionnaireResponse>( dictionnaireResponse,HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<DictionnaireResponse> addDictionnaire(@RequestBody DictionnaireRequest requestDictionnaire ) {
		
		ModelMapper modelMapper = new ModelMapper();
		DictionnaireDto dictionnaireDto = modelMapper.map(requestDictionnaire, DictionnaireDto.class);
		DictionnaireDto createDictionnaire= dictionnaireService.createDictionnaire(dictionnaireDto);
		DictionnaireResponse dictionnaireResponse = modelMapper.map(createDictionnaire, DictionnaireResponse.class);
		
	    return  new ResponseEntity<DictionnaireResponse>(dictionnaireResponse,HttpStatus.CREATED);	
	}
	

	@PutMapping(path="/{id}")
    public ResponseEntity<DictionnaireResponse> updtateDictionnaire(@PathVariable String id, @RequestBody DictionnaireRequest requestDictionnaire) {
		
		ModelMapper modelMapper = new ModelMapper();
		DictionnaireDto dictionnaireDto = modelMapper.map(requestDictionnaire, DictionnaireDto.class);
		DictionnaireDto createDictionnaire =dictionnaireService.updateDictionnaire(id,dictionnaireDto);
		DictionnaireResponse  dictionnaireResponse = modelMapper.map(createDictionnaire, DictionnaireResponse.class) ;
    	
		return new ResponseEntity<DictionnaireResponse>(dictionnaireResponse,HttpStatus.ACCEPTED);
    }
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteDictionnaire(@PathVariable String id) {
		dictionnaireService.deleteDictionnaire(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
