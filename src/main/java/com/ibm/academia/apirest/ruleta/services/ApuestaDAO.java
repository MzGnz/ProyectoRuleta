package com.ibm.academia.apirest.ruleta.services;

import com.ibm.academia.apirest.ruleta.entities.Apuesta;

public interface ApuestaDAO extends GenericoDAO<Apuesta>
{	
	public Apuesta apuesta(Apuesta apuesta);
}