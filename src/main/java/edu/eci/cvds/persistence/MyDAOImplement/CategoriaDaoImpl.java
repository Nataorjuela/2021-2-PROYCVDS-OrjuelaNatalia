package edu.eci.cvds.persistence.MyDAOImplement;

import java.util.List;


import com.google.inject.Inject;

import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.persistence.CategoriaDao;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.MyDAOImplement.Mappers.CategoriaMapper;

public class CategoriaDaoImpl implements CategoriaDao {
	
	
	@Inject
    private CategoriaMapper categoriaMapper;

	@Override
	public List<Categoria> obtenerCategoria() throws PersistenceException {
		try{
            return categoriaMapper.consultarCategoria();
        }
        catch(Exception e){
            System.out.println(e);
            throw new PersistenceException("Error al consultar las categorias:",e);
        }	
	}

	@Override
	public void eliminarCategotia(int idCategoria) throws PersistenceException{
		try{
            categoriaMapper.eliminarCategoria(idCategoria);
        }
        catch(Exception e){
            System.out.println(e);
            throw new PersistenceException("Error al eliminar la categoria:",e);
        }	
		
	}

    @Override
    public void actualizarCategotia(int idCategoria,String nombreCategoria, String descripcion) throws PersistenceException{
        try{
            categoriaMapper.actualizarCategoria(idCategoria,nombreCategoria,descripcion);
        }
        catch(Exception e){
            System.out.println(e);
            throw new PersistenceException("Error al actualizar la categoria:",e);
        }

    }


}
