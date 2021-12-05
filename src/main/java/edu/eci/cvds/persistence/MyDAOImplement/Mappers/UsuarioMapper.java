package edu.eci.cvds.persistence.MyDAOImplement.Mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Usuario;

public interface UsuarioMapper {

	public List<Usuario> consultarUsuarios();

    public void crearCategoria(@Param("idCategoria") int idCategoria, @Param("nombreCategoria") String nombreCategoria, @Param("descripcion") String descripcion, @Param("fechaCreacion") Date fechaCreacion, @Param("fechaModif") Date fechaModif);

    public void actualizarCategoria(@Param("idCategoria") int idCategoria);

    public void registrarNecesidad(@Param("idNecesidad") int idNecesidad, @Param("idCategoria") int idCategoria, @Param("nombreNec") String nombreNec, @Param("descripcion") String descripcion, @Param("urgencia") String urgencia, @Param("estado") boolean estado);

    public void actualizarNecesidad(@Param("idNecesidad") int idNecesidad);


}
