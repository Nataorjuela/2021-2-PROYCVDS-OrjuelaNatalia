package edu.eci.cvds.services;
import java.util.List;


import edu.eci.cvds.entities.Necesidad;
import edu.eci.cvds.persistence.PersistenceException;

public interface ServicioNecesidad {
    public List<Necesidad> consultarNecesidad() throws  PersistenceException;

    void actualizarNecesidad(int idNecesidad,String estado) throws PersistenceException;
}

