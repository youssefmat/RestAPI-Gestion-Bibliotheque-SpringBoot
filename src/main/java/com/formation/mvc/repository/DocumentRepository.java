package com.formation.mvc.repository;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.formation.mvc.entities.DocumentEntity;



@Repository
public interface DocumentRepository extends PagingAndSortingRepository<DocumentEntity,Long>{
	
	DocumentEntity findByDocumentId(String documentId);
	
	@Query(value="select * from documents ",nativeQuery = true)
	Page<DocumentEntity> findAllDocuments(Pageable pageableRequest);
	
	@Query(value="select * from documents WHERE dtype= ?1",nativeQuery = true)
	Page<DocumentEntity> findAllLivres(Pageable pageableRequest, String typeDocument);
	
	/*@Query(value="select * from documents WHERE dtype='dictionnaires'",nativeQuery = true)
	Page<DocumentEntity> findAllDictionnaires(Pageable pageableRequest);
	
	@Query(value="select * from documents WHERE dtype='revues'",nativeQuery = true)
	Page<DocumentEntity> findAllRevuees(Pageable pageableRequest);*/

}
