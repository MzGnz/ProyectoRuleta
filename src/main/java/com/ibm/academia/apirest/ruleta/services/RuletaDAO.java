package com.ibm.academia.apirest.ruleta.services;

import com.ibm.academia.apirest.ruleta.entities.Apuesta;
import com.ibm.academia.apirest.ruleta.entities.Ruleta;

public interface RuletaDAO extends GenericoDAO<Ruleta>
{
	public Long crearRuleta();
    public Ruleta abrirRuleta(Long id);
    public Long guardarRuleta(Ruleta ruleta);
    public Ruleta cerrarRuleta(Long ruleta);
	public Apuesta crearApuesta(String valorApuesta, Double cantidadApuesta, Ruleta ruleta);
}