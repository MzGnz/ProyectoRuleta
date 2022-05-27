package com.ibm.academia.apirest.ruleta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.ruleta.entities.Apuesta;
import com.ibm.academia.apirest.ruleta.entities.Ruleta;
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
	public Apuesta guardar(Apuesta entidad) {

	    return repository.save(entidad);
	}
	
	@Override
	public Apuesta crearApuesta(String valorApuesta, Double cantidadApuesta, Ruleta ruleta) {
	    Apuesta apuestaGuardada;
	        Apuesta nuevaApuesta = new Apuesta(valorApuesta, cantidadApuesta, ruleta);
	        apuestaGuardada = guardar(nuevaApuesta);
	                apuestaGuardada = guardar(nuevaApuesta);
	    return apuestaGuardada;
	}

	@Override
	public Iterable<Apuesta> cerrarApuesta(Long ruletaid) {
		return repository.findApuestaById(ruletaid);
	}
	
}