package com.ibm.academia.apirest.ruleta.services;

import com.ibm.academia.apirest.ruleta.entities.Apuesta;
import com.ibm.academia.apirest.ruleta.entities.Ruleta;

public interface ApuestaDAO extends GenericoDAO<Apuesta>
{	
	Apuesta crearApuesta(String valorApuesta, Double monto, Ruleta ruleta);
	Apuesta guardar(Apuesta entidad);
	Iterable<Apuesta> cerrarApuesta(Long ruletaid);
}