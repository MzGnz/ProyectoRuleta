package com.ibm.academia.apirest.ruleta.services;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public class GenericoDAOImpl <Entidad, R extends CrudRepository<Entidad, Long>> implements GenericoDAO<Entidad>
{

	protected final R repository;
	
	public GenericoDAOImpl(R repository) 
	{
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Entidad> buscarPorId(Long id)
	{
		return repository.findById(id);
	}

	@Override
	public Entidad guardar(Entidad entidad)
	{

		return repository.save(entidad);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Entidad> mostrarTodos()
	{
		return repository.findAll();
	}

	@Override
	public void eliminar(Long id)
	{
		repository.deleteById(id);
	}
}