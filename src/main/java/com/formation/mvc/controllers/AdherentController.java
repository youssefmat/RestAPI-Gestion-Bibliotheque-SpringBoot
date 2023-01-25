package com.formation.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
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


import com.formation.mvc.dto.AdherentDto;
import com.formation.mvc.requests.AdherentRequest;
import com.formation.mvc.responses.AdherentResponse;
import com.formation.mvc.services.AdherentService;

//@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/adherents") //localhost:8080/adherents
public class AdherentController {
   
	@Autowired
	AdherentService adherentService;
	
	@GetMapping(path="/{cin}")
	public ResponseEntity<AdherentResponse> getAdherent(@PathVariable String cin) {
		
		AdherentDto adherentDto = adherentService.getAdherentByCin(cin);
		AdherentResponse adherentResponse = new AdherentResponse();
		
		BeanUtils.copyProperties(adherentDto, adherentResponse);
		return new ResponseEntity<AdherentResponse>( adherentResponse,HttpStatus.OK);
	}
	
	//@RequestMapping("/adherentId")
	/*@GetMapping(path="/{id}")
	public ResponseEntity<AdherentResponse> getAdherentById(@PathVariable String id) {
		
		AdherentDto adherentDto = adherentService.getAdherentById(id);
		AdherentResponse adherentResponse = new AdherentResponse();
		
		BeanUtils.copyProperties(adherentDto, adherentResponse);
		return new ResponseEntity<AdherentResponse>( adherentResponse,HttpStatus.OK);
	}*/
	
	
	@GetMapping
	public List<AdherentResponse> getAllAdherents(@RequestParam(value="page", defaultValue="1") int page,@RequestParam(value="limite",defaultValue="5") int limite) {
		ModelMapper modelMapper = new ModelMapper();
		List<AdherentResponse>  adherentResponses = new ArrayList<>();
		
		List<AdherentDto> adherents = adherentService.getAllAdherents(page,limite) ;
		
		for(AdherentDto adherentDto :adherents) {
			AdherentResponse adherentResponse =modelMapper.map(adherentDto, AdherentResponse.class);
			
			adherentResponses.add(adherentResponse);
			
		}
		return adherentResponses;
		}
	
	@PostMapping
	public ResponseEntity<AdherentResponse> addAdherent(@RequestBody AdherentRequest requestAdherent ) {
		
		ModelMapper modelMapper = new ModelMapper();
		AdherentDto adherentDto = modelMapper.map(requestAdherent, AdherentDto.class);
		AdherentDto createAdherent= adherentService.createAdherent(adherentDto);
		AdherentResponse adherentResponse = modelMapper.map(createAdherent, AdherentResponse.class);
		
	    return  new ResponseEntity<AdherentResponse>( adherentResponse,HttpStatus.CREATED);	
	}
	
	@PutMapping(path="/{id}")
    public ResponseEntity<AdherentResponse> updtateAdherent(@PathVariable String id, @RequestBody AdherentRequest requestAdherent) {
		ModelMapper modelMapper = new ModelMapper();
		
		//UserDto userDto = new UserDto();
    	//BeanUtils.copyProperties(userRequest, userDto);
    	AdherentDto adherentDto = modelMapper.map(requestAdherent, AdherentDto.class);
    	AdherentDto createAdherent =adherentService.updateAdherent(id,adherentDto);
    	AdherentResponse  adherentResponse = modelMapper.map(createAdherent, AdherentResponse.class) ;
    	
		return new ResponseEntity<AdherentResponse>( adherentResponse,HttpStatus.ACCEPTED);
    }
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {
		adherentService.deleteAdherent(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
    
	
	
}
