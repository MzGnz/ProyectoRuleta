package com.ibm.academia.apirest.ruleta.services;

import java.util.Optional;

import com.ibm.academia.apirest.ruleta.entities.Ruleta;

public interface RuletaDAO 
{
	Optional<Ruleta>findById(Long id);
	
}