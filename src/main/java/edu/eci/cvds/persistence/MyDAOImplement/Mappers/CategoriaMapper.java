package edu.eci.cvds.persistence.MyDAOImplement.Mappers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Categoria;

public interface CategoriaMapper {

	public List<Categoria> consultarCategoria();

	public void crearCategoria(@Param("nombreCategoria") String nombreCategoria, @Param("descripcion") String descripcion, @Param("fechaCreacion") Date fechaCreacion, @Param("fechaModif") Date fechaModif);

	public void eliminarCategoria(@Param("idCategoria") int idCategoria);

	public void actualizarCategoria(@Param("idCategoria") int idCategoria, @Param("nombreCategoria") String nombreCategoria, @Param("descripcion") String descripcion);

}
