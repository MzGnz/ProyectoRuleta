package com.ibm.academia.apirest.ruleta.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.ruleta.entities.Ruleta;
import com.ibm.academia.apirest.ruleta.exceptions.NotFoundException;
import com.ibm.academia.apirest.ruleta.repositories.RuletaRepository;

@Service
public class RuletaDAOImpl extends GenericoDAOImpl<Ruleta, RuletaRepository> implements RuletaDAO
{

	@Autowired
	public RuletaDAOImpl(RuletaRepository repository)
	{
		super(repository);
	}

	@Override
	public void crearRuleta()
		{
			Ruleta ruleta = new Ruleta();
			ruleta.setEstadoRuleta(true);
			guardar(ruleta);
			
		}
	
	@Override
	@Transactional
	public Ruleta abrirRuleta(Long id) {
        Optional<Ruleta> oRuleta = repository.findById(id);
        if (!oRuleta.isPresent())
            throw new NotFoundException(String.format("La ruleta con id %d no existe", id));

        Ruleta ruletaAbierta = null;
        oRuleta.get().setEstadoRuleta(true);
        ruletaAbierta = repository.save(oRuleta.get());
        return ruletaAbierta;
    }

	@Override
	public Long guardarRuleta(Ruleta ruleta)
	{
		Long ruletaId = repository.save(ruleta).getId();
		return ruletaId;
	}

	@Override
	public Ruleta cerrarRuleta(Long id) 
	{
		Optional<Ruleta> oRuleta = repository.findById(id);
        if (!oRuleta.isPresent())
            throw new NotFoundException(String.format("La ruleta con id %d no existe", id));

        Ruleta ruletaCerrada = null;
        oRuleta.get().setEstadoRuleta(false);
        ruletaCerrada = repository.save(oRuleta.get());
        return ruletaCerrada;
	}

}