package edu.eci.cvds.services;
import java.util.Date;
import java.util.List;


import edu.eci.cvds.entities.Necesidad;
import edu.eci.cvds.persistence.PersistenceException;

public interface ServicioNecesidad {

    public List<Necesidad> consultarNecesidad() throws  PersistenceException;
    public void crearNecesidad(int idCategoria, String nombreNec, String descripcion,String urgencia , Date fechaCreacion,String estado, Date fechaModif)throws PersistenceException;
    public void actualizarNecesidad(int idNecesidad,String estado) throws PersistenceException;
}

