package edu.eci.cvds.persistence;

import java.util.Date;

public interface UsuarioDAO {
     public void crearCategoria(int idCategoria, String nombreCategoria, String descripcion);
     public void crearNecesidad(int idNecesidad,int idCategoria, String nombreNecesidad, String descripcion,String urgencia,String estado);
     public void actualizarCategoria(int idCategoria,String nombreCategoria,String descripcion);
     public void actualizarNecesidad(int idNecesidad,String estado);
     public void crearOferta(int idOferta,int idCategoria,String nombreOferta, String descripcion, String estado);
}
