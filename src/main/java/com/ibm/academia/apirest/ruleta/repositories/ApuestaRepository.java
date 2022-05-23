package com.ibm.academia.apirest.ruleta.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.ruleta.entities.Apuesta;

@Repository
public interface ApuestaRepository extends CrudRepository<Apuesta, Long>
{
	@Query("select a from Apuesta a where a.ruleta.id=?1")
    Iterable<Apuesta> findApuestaById(Integer idRuleta);
	
}