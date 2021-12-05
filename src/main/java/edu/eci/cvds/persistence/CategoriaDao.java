package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.Categoria;

public interface CategoriaDao {
	
	public List<Categoria> obtenerCategoria() throws PersistenceException;
	
	public void eliminarCategotia(int idCategoria) throws PersistenceException;

    public void actualizarCategotia(int idCategoria,String nombreCategoria,String descripcion) throws PersistenceException;

}
