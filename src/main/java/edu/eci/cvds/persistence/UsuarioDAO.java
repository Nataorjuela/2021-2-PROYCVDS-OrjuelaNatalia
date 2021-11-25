package edu.eci.cvds.persistence;

import java.util.Date;

public interface UsuarioDAO {
     public void crearCategoria(int idCategoria, String nombreCategoria, String descripcion, Date fechaCreacion, Date fechaModif);
     public void actualizarCategoria();
     public void registrarNecesidad(int idNecesidad, int idCategoria, String nombreNec, String descripcion, String urgencia, Date fechaCreacion, boolean estado, Date fechaModif);



}
