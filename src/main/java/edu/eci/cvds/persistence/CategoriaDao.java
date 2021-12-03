package edu.eci.cvds.persistence;

import java.util.List;

import javax.persistence.PersistenceException;

import edu.eci.cvds.entities.Categoria;

public interface CategoriaDao {
	
	public List<Categoria> obtenerUsuarios() throws PersistenceException;

}
