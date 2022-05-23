package com.ibm.academia.apirest.ruleta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.ruleta.entities.Apuesta;
import com.ibm.academia.apirest.ruleta.entities.Ruleta;
import com.ibm.academia.apirest.ruleta.exceptions.NotFoundException;
import com.ibm.academia.apirest.ruleta.repositories.ApuestaRepository;

@Service
public class ApuestaDAOImpl extends GenericoDAOImpl<Apuesta, ApuestaRepository> implements ApuestaDAO
{
	@Autowired
	private RuletaDAO ruletaDao;
	
	@Autowired
	public ApuestaDAOImpl(ApuestaRepository repository) 
	{
		super(repository);
	}

	@Override
    @Transactional
    public Apuesta setRuleta(Long idRuleta, Long idApuesta) {
        Optional<Apuesta> oApuesta = repository.findById(idApuesta);
        if(!oApuesta.isPresent())
            throw new NotFoundException(String.format("La Apuesta con Id %d no existe", idApuesta));

        Optional<Ruleta> oRuleta = ruletaDao.buscarPorId(idRuleta);
        if(!oApuesta.isPresent())
            throw new NotFoundException(String.format("La Ruleta con Id %d no existe", idRuleta));

        ((Apuesta)oApuesta.get()).setRuleta(oRuleta.get());
        return repository.save(oApuesta.get());
    }
	
	@Override
    public Apuesta buscarPorIdRuleta(Long idRuleta) {
        return null;
    }
}