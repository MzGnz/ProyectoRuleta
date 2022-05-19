package com.ibm.academia.apirest.ruleta.services;

import java.util.Optional;

import com.ibm.academia.apirest.ruleta.entities.Apuesta;

public interface ApuestaDAO 
{
	Optional<Apuesta>findByIdApuesta(Long id);
}