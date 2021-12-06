package edu.eci.cvds.persistence.MyDAOImplement;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.MyDAOImplement.Mappers.UsuarioMapper;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public class UsuarioDAOImpl implements UsuarioDAO {
    @Inject
    private UsuarioMapper usuarioMapper;

    @Override
    public void crearCategoria(int idCategoria, String nombreCategoria, String descripcion) {
        usuarioMapper.crearCategoria(idCategoria,nombreCategoria,descripcion);
    }


    @Override
    public void actualizarCategoria(int idCategoria,String nombreCategoria,String descripcion) {
        usuarioMapper.actualizarCategoria(idCategoria);
    }
    @Override
    public void crearNecesidad(int idNecesidad,int idCategoria, String nombreNec, String descripcion,String urgencia, String estado) {
        usuarioMapper.crearNecesidad(idNecesidad,idCategoria,nombreNec,descripcion,urgencia, estado);


    }


    @Override
    public void actualizarNecesidad(int idNecesidad,String estado) {

        usuarioMapper.actualizarNecesidad(idNecesidad);
    }
    @Override
    public void crearOferta(int idOferta,int idCategoria,String nombreOferta, String descripcion, String estado){
        usuarioMapper.crearOferta(idOferta,idCategoria,nombreOferta, descripcion, estado);

    }
}
