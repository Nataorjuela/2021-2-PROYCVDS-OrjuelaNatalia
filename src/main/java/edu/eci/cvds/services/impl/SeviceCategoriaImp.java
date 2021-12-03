package edu.eci.cvds.services.impl;

import java.util.List;


import com.google.inject.Inject;

import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.persistence.CategoriaDao;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.ServicioCategoria;

public class SeviceCategoriaImp implements ServicioCategoria {
	
	@Inject 
	private CategoriaDao categoriaDao;

	@Override
	public List<Categoria> consultarCategorias() throws PersistenceException {
		return categoriaDao.obtenerCategoria();
	}

	@Override
	public void eliminarCategotia(int idCategoria) throws PersistenceException {
		categoriaDao.eliminarCategotia(idCategoria);
		
	}

}
