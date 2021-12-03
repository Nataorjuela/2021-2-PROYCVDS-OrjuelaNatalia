package edu.eci.cvds.services;

import java.util.List;

import javax.persistence.PersistenceException;

import edu.eci.cvds.entities.Categoria;

public interface ServicioCategoria {
	
	public List<Categoria> consultarCategorias() throws  PersistenceException;

}
