package com.ibm.academia.apirest.ruleta.services;

import org.springframework.data.jpa.repository.Query;

import com.ibm.academia.apirest.ruleta.entities.Apuesta;

public interface ApuestaDAO extends GenericoDAO<Apuesta>
{	
	public Apuesta setRuleta(Long idRuleta, Long idApuesta);
	
	@Query(value = "select * from juegos.apuestas where ruleta_id = 1;", nativeQuery=true)
    public Apuesta buscarPorIdRuleta(Long idRuleta);
}