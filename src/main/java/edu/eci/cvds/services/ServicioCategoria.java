package edu.eci.cvds.services;

import java.util.List;


import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.persistence.PersistenceException;

public interface ServicioCategoria {
	
	public List<Categoria> consultarCategorias() throws  PersistenceException;
	
	public void eliminarCategotia(int idCategoria) throws PersistenceException;

}
