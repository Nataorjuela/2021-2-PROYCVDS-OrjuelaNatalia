package edu.eci.cvds.persistence.MyDAOImplement.Mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Usuario;

public interface UsuarioMapper {

	public List<Usuario> consultarUsuarios();

    public void crearCategoria(@Param("idCategoria") int idCategoria, @Param("nombreCategoria") String nombreCategoria, @Param("descripcion") String descripcion);

    public void actualizarCategoria(@Param("idCategoria") int idCategoria);

    public void crearNecesidad(@Param("idNecesidad") int idNecesidad,@Param("idCategoria")int idCategoria, @Param("nombreNec")String nombreNec, @Param("descripcion") String descripcion, @Param("urgencia") String urgencia, @Param("estado") String estado);


    public void actualizarNecesidad(@Param("idNecesidad") int idNecesidad);

    public void crearOferta(@Param("idOferta") int idOferta,@Param("idCategoria")int idCategoria,@Param("nombreOferta") String nombreOferta, @Param("descripcion") String descripcion,@Param("estado") String estado);

}
