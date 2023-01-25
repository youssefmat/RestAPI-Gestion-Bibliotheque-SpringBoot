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

import com.formation.mvc.dto.RevueDto;
import com.formation.mvc.requests.RevueRequest;
import com.formation.mvc.responses.RevueResponse;
import com.formation.mvc.services.RevueService;

@RestController
@RequestMapping("/revues")
public class RevueController {

	
	@Autowired
	RevueService  revueService;
	
	
	@GetMapping
	public List<RevueResponse> getAllAdherents(@RequestParam(value="page", defaultValue="1") int page,@RequestParam(value="limite",defaultValue="10") int limite) {
		ModelMapper modelMapper = new ModelMapper();
		List<RevueResponse>  revuesResponses = new ArrayList<>();
		
		List<RevueDto> revues = revueService.getAllRevues(page,limite);
		
		for(RevueDto revueDto :revues) {
			RevueResponse revueResponse =modelMapper.map(revueDto, RevueResponse.class);
			revuesResponses.add(revueResponse);
			
		}
		return revuesResponses;
		}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<RevueResponse> getRevue(@PathVariable String id) {
		
		RevueDto revueDto = revueService.getRevueById(id);
	
		ModelMapper modelMapper = new ModelMapper();
		RevueResponse revueResponse = modelMapper.map(revueDto, RevueResponse.class);
		return new ResponseEntity<RevueResponse>( revueResponse,HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<RevueResponse> addRevue(@RequestBody RevueRequest requestRevue ) {
		
		ModelMapper modelMapper = new ModelMapper();
		RevueDto revueDto = modelMapper.map(requestRevue, RevueDto.class);
		RevueDto createRevue= revueService.createRevue(revueDto);
		RevueResponse revueResponse = modelMapper.map(createRevue, RevueResponse.class);
		
	    return  new ResponseEntity<RevueResponse>( revueResponse,HttpStatus.CREATED);	
	}
	

	@PutMapping(path="/{id}")
    public ResponseEntity<RevueResponse> updtateRevue(@PathVariable String id, @RequestBody RevueRequest requestRevue) {
		
		ModelMapper modelMapper = new ModelMapper();
		RevueDto revueDto = modelMapper.map(requestRevue, RevueDto.class);
		RevueDto createRevue =revueService.updateRevue(id,revueDto);
		RevueResponse  revueResponse = modelMapper.map(createRevue, RevueResponse.class) ;
    	
		return new ResponseEntity<RevueResponse>( revueResponse,HttpStatus.ACCEPTED);
    }
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteRevue(@PathVariable String id) {
		revueService.deleteRevue(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
