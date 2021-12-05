package edu.eci.cvds.persistence.MyDAOImplement.Mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Categoria;

public interface CategoriaMapper {

	public List<Categoria> consultarCategoria();

	public void eliminarCategoria(@Param("idCategoria") int idCategoria);

	public void actualizarCategoria(@Param("idCategoria") int idCategoria, @Param("nombreCategoria") String nombreCategoria, @Param("descripcion") String descripcion);

}
