package com.formation.mvc.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.formation.mvc.dto.RevueDto;
import com.formation.mvc.dto.Utils;
import com.formation.mvc.entities.RevueEntity;
import com.formation.mvc.repository.RevueRepository;
import com.formation.mvc.services.RevueService;

@Service
public class RevueServiceImpl implements RevueService {
    @Autowired
	Utils util;
    @Autowired
    RevueRepository revueRepository;
	
	@Override
	public RevueDto createRevue(RevueDto revue) {
		
        RevueEntity checkRef = revueRepository.findByRef(revue.getRef());
		if(checkRef !=null) throw new RuntimeException("cette Reference d'eja existe !");
		
		ModelMapper modelMapper = new  ModelMapper();
		RevueEntity revueEntity = modelMapper.map(revue,RevueEntity.class);
		revueEntity.setDocumentId(util.generateStringId(32));
		RevueEntity newRevueEntity =  revueRepository.save(revueEntity);
		RevueDto revueDto = modelMapper.map(newRevueEntity, RevueDto.class);
		return revueDto;
	}

	@Override
	public RevueDto updateRevue(String id, RevueDto revue) {
		RevueEntity checkRef = revueRepository.findByRef(revue.getRef());
		if(checkRef !=null) throw new RuntimeException("cette Reference d'eja existe !");
		
		RevueEntity revueEntity = revueRepository.findByDocumentId(id);
		if(revueEntity == null) throw new RuntimeException("user il n'existe pas  !");
		revueEntity.setAnnee(revue.getAnnee());
		revueEntity.setRef(revue.getRef());
		revueEntity.setPrix(revue.getPrix());
		revueEntity.setTitre(revue.getTitre());
		RevueEntity revueUpdeted = revueRepository.save(revueEntity);
		ModelMapper modelMapper = new ModelMapper();
		
		RevueDto revueDto = modelMapper.map(revueUpdeted, RevueDto.class);
		
		return revueDto;
	}

	@Override
	public void deleteRevue(String id) {
		RevueEntity revueEntity = revueRepository.findByDocumentId(id);
		if(revueEntity == null) throw new RuntimeException("user il n'existe pas  !");
		revueRepository.delete(revueEntity);
	}

	@Override
	public RevueDto getRevueById(String id) {
		RevueEntity revueEntity = revueRepository.findByDocumentId(id);
		if(revueEntity == null) throw new RuntimeException("user il n'existe pas  !");
		
		ModelMapper modelMapper = new  ModelMapper();
		RevueDto revueDto = modelMapper.map(revueEntity, RevueDto.class);
		
		return revueDto;
	}

	@Override
	public List<RevueDto> getAllRevues(int page, int limite) {
		ModelMapper modelMapper = new ModelMapper();
		if(page >0) page -=1 ;
		List<RevueDto> revuesDto = new ArrayList<>();
		Pageable pageableRequest = PageRequest.of(page, limite);
		
		Page<RevueEntity> revuesPage = revueRepository.findAll(pageableRequest);
		List<RevueEntity> revuesEntity = new ArrayList<RevueEntity>();
		//List<RevueEntity>  listRevue = documentRepository.findAllByTitre("java", pageableRequest);
		//System.out.println(listRevue);
		revuesEntity = revuesPage.getContent();
       for(RevueEntity revues :revuesEntity) {
            
    	   RevueDto revueDto = modelMapper.map(revues, RevueDto.class);
    	   revuesDto.add(revueDto);
		}
		
		return revuesDto;
	}

}
