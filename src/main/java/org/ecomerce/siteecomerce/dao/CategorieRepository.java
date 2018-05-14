package org.ecomerce.siteecomerce.dao;

import org.ecomerce.siteecomerce.entities.Categorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {

    @Query("select c from Categorie c where c.description like :x")
    public Page<Categorie> chercher(@Param("x") String mc, Pageable pageable);

}
