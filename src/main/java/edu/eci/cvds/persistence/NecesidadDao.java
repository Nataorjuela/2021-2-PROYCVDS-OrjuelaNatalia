package edu.eci.cvds.persistence;

import java.util.Date;
import java.util.List;

import edu.eci.cvds.entities.Necesidad;

public interface NecesidadDao {

    public List<Necesidad> obtenerNecesidad() throws PersistenceException;
    public void crearNecesidad(int idCategoria, String nombreNec, String descripcion, String urgencia , Date fechaCreacion, String estado, Date fechaModif)throws PersistenceException;
    public void actualizarNecesidad(int idNecesidad,String estado) throws PersistenceException;

}