package com.ibm.academia.apirest.ruleta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.ruleta.entities.Apuesta;
import com.ibm.academia.apirest.ruleta.repositories.ApuestaRepository;

@Service
public class ApuestaDAOImpl extends GenericoDAOImpl<Apuesta, ApuestaRepository> implements ApuestaDAO
{	
	@Autowired
	public ApuestaDAOImpl(ApuestaRepository repository) 
	{
		super(repository);
	}

	@Override
	public Apuesta apuesta(Apuesta apuesta) {
		return repository.save(apuesta);
	}	
}