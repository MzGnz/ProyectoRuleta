package com.ibm.academia.apirest.ruleta.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.ruleta.entities.Apuesta;
import com.ibm.academia.apirest.ruleta.entities.Ruleta;
import com.ibm.academia.apirest.ruleta.exceptions.NotFoundException;
import com.ibm.academia.apirest.ruleta.services.ApuestaDAO;
import com.ibm.academia.apirest.ruleta.services.RuletaDAO;

@RestController
@RequestMapping("/ruleta") 
public class RuletaController
{
	@Autowired
	private RuletaDAO ruletaDAO;
	
	@Autowired 
	private ApuestaDAO apuestaDAO;
	
	Logger logger = LoggerFactory.getLogger(RuletaController.class);

	
	@PostMapping("/crearRuleta")
	public ResponseEntity<?>save()
	{	
		return new ResponseEntity<>(ruletaDAO.crearRuleta(),HttpStatus.OK);
	}
	
	@PutMapping("aperturaRuleta/{ruletaId}")
    public ResponseEntity<?> aperturaRuleta(@PathVariable Long ruletaId){
        Optional<Ruleta> oRuleta = ruletaDAO.buscarPorId(ruletaId);
        if(!oRuleta.isPresent())
            throw new NotFoundException(String.format("La ruleta con Id %d no existe", ruletaId));

        if (oRuleta.get().getEstadoRuleta()==true)
            throw new NotFoundException(String.format("La ruleta con Id %d ya esta abierta", ruletaId));

        Ruleta ruletaAbierta = null;
        try{
            ruletaAbierta = ruletaDAO.abrirRuleta(ruletaId);
        }catch (Exception e){
            logger.info(e.getMessage());
            throw e;
        }
        return new ResponseEntity<>("Operacion exitosa", HttpStatus.OK);
    }
	
	@PutMapping("/cerrarRuleta/{ruletaId}")
    public ResponseEntity<?> cerrarRuleta(@PathVariable Long ruletaId){
        Optional<Ruleta> oRuleta = ruletaDAO.buscarPorId(ruletaId);
        if(!oRuleta.isPresent())
            throw new NotFoundException(String.format("La ruleta con Id %d no existe", ruletaId));

        if (oRuleta.get().getEstadoRuleta()==false)
            throw new NotFoundException(String.format("La ruleta con Id %d ya esta cerrada", ruletaId));

        Ruleta ruletaCerrada = null;
        try{
            ruletaCerrada = ruletaDAO.cerrarRuleta(ruletaId);
        }catch (Exception e){
            logger.info(e.getMessage());
            throw e;
        }

        //List<Apuesta> apuestas = (List<Apuesta>) ruletaDAO.buscarPorIdRuleta(ruletaId);

        return new ResponseEntity<>(apuestaDAO.cerrarApuesta(oRuleta.get().getId()), HttpStatus.OK);
    }
	
	@GetMapping("/listarRuletas")
    public List<Ruleta> listarTodas()
    {
        List<Ruleta> ruletas = (List<Ruleta>) ruletaDAO.mostrarTodos();
        return ruletas;
    }
		
	@PostMapping("/apostar")
	public ResponseEntity<?> apostarRuleta(@RequestParam Long idRuleta, @RequestParam String valorApuesta, @RequestParam Double montoApuesta) {
	    return new ResponseEntity<>(ruletaDAO.apostar(idRuleta, valorApuesta, montoApuesta), HttpStatus.ACCEPTED);

	}
	
}