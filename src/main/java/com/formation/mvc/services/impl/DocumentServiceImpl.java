package com.formation.mvc.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.formation.mvc.dto.DocumentDto;
import com.formation.mvc.entities.DocumentEntity;
import com.formation.mvc.repository.DocumentRepository;
import com.formation.mvc.services.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService{
	@Autowired
	DocumentRepository  documentRepository;

	@Override
	public DocumentDto createDocument(DocumentDto cocumentDto) {
		
		return null;
	}

	@Override
	public List<DocumentDto> getAllDocuments(int page, int limite, String typeDocument) {
		ModelMapper modelMapper = new ModelMapper();
		if(page >0) page -=1 ;
		List<DocumentDto> DocumentsDto = new ArrayList<>();
		Pageable pageableRequest = PageRequest.of(page, limite);
		
		List<DocumentEntity> documentsEntity = new ArrayList<DocumentEntity>();
		Page<DocumentEntity> documentsPage;
		if(typeDocument.isEmpty()) {
			 documentsPage = documentRepository.findAllDocuments(pageableRequest);
			
		}else {
			 documentsPage = documentRepository.findAllLivres(pageableRequest,typeDocument);
			
		}
		
		
		documentsEntity = documentsPage.getContent();
		
		for(DocumentEntity documents :documentsEntity) {
			DocumentDto documentDto = modelMapper.map(documents, DocumentDto.class);
			
			DocumentsDto.add(documentDto);
		}
		
		
		return DocumentsDto;
	}

}
