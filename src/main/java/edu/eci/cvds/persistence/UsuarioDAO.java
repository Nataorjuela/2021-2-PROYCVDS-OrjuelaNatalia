package edu.eci.cvds.persistence;

import java.util.Date;

public interface UsuarioDAO {
     public void crearCategoria(int idCategoria, String nombreCategoria, String descripcion, Date fechaCreacion, Date fechaModif);
     public void registrarNecesidad(int idNecesidad,int idCategoria, String nombreNecesidad, String descripcion,String urgencia,String estado, Date fechaCreacion, Date fechaModif);
     public void actualizarCategoria(int idCategoria,String nombreCategoria,String descripcion);
     public void actualizarNecesidad(int idNecesidad,String estado);
}
