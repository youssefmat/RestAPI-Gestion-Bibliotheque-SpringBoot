package com.formation.mvc.controllers;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.formation.mvc.dto.DocumentDto;
import com.formation.mvc.requests.DocumentRequest;
import com.formation.mvc.responses.DocumentResponse;
import com.formation.mvc.services.DocumentService;

@RestController
@RequestMapping("/documents")
public class DocumentController {
	
	@Autowired
	DocumentService  documentService;
	

	
	@GetMapping
	public List<DocumentResponse> getAllDocuments(@RequestParam(value="page", defaultValue="1") int page,@RequestParam(value="limite",defaultValue="5") int limite,@RequestParam(value="typeDocument",defaultValue="") String typeDocument) {
		ModelMapper modelMapper = new ModelMapper();
		List<DocumentResponse>  documentResponses = new ArrayList<>();
		
		List<DocumentDto> documents = documentService.getAllDocuments(page,limite, typeDocument) ;
		
		for(DocumentDto documentDto :documents) {
			DocumentResponse adherentResponse =modelMapper.map(documentDto, DocumentResponse.class);
			
			documentResponses.add(adherentResponse);
			
		}
		return documentResponses;
		}
	
	@PostMapping
	public ResponseEntity<DocumentResponse> addDocument(@RequestBody DocumentRequest requestDocument ) {
		ModelMapper modelMapper = new ModelMapper();
		DocumentDto documentDto = modelMapper.map(requestDocument, DocumentDto.class);
		DocumentDto createDocument = documentService.createDocument(documentDto);
		DocumentResponse documentResponse= modelMapper.map(createDocument, DocumentResponse.class);
		
	return new ResponseEntity<DocumentResponse>(documentResponse, HttpStatus.CREATED);
		
	}
	@PutMapping
    public String updtateAdherent() {
    	return "modifier adhernet ";
    }
    @DeleteMapping
	public String deleteAdherent() {
		return "supprimer adherent";
	}

}
