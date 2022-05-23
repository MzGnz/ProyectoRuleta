package com.ibm.academia.apirest.ruleta.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.ruleta.entities.Ruleta;

public interface RuletaRepository extends CrudRepository<Ruleta, Long>
{

}