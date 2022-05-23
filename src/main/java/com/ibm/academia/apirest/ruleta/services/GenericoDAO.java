package com.ibm.academia.apirest.ruleta.services;

import java.util.Optional;

public interface GenericoDAO<Entidad>
{
    public Optional<Entidad> buscarPorId(Long id);
    public Entidad guardar(Entidad entidad);
    public Iterable<Entidad> mostrarTodos();
    public void eliminar(Long id);
}