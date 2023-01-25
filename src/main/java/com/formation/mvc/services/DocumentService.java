package com.formation.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.formation.mvc.dto.DocumentDto;

@Service
public interface DocumentService {
	DocumentDto createDocument(DocumentDto cocumentDto);
	List<DocumentDto> getAllDocuments(int page,int limite, String typeDocument);
}
