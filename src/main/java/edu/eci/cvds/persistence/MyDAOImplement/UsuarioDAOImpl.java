package edu.eci.cvds.persistence.MyDAOImplement;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.MyDAOImplement.Mappers.UsuarioMapper;
import edu.eci.cvds.persistence.UsuarioDAO;

import java.util.Date;

public class UsuarioDAOImpl implements UsuarioDAO {
    @Inject
    private UsuarioMapper usuarioMapper;

    @Override
    public void crearCategoria(int idCategoria, String nombreCategoria, String descripcion, Date fechaCreacion, Date fechaModif) {
        usuarioMapper.crearCategoria(idCategoria,nombreCategoria,descripcion,fechaCreacion,fechaModif);
    }

    @Override
    public void registrarNecesidad(int idNecesidad, int idCategoria, String nombreNecesidad, String descripcion, String urgencia, String estado, Date fechaCreacion, Date fechaModif) {

    }

    @Override
    public void actualizarCategoria(int idCategoria,String nombreCategoria,String descripcion) {
        usuarioMapper.actualizarCategoria(idCategoria);
    }


    @Override
    public void actualizarNecesidad(int idNecesidad,String estado) {
        usuarioMapper.actualizarNecesidad(idNecesidad);
    }
}
