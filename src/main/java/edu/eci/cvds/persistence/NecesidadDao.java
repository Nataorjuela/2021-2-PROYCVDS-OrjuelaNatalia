package edu.eci.cvds.persistence;

import java.util.List;

import edu.eci.cvds.entities.Necesidad;

public interface NecesidadDao {

    public List<Necesidad> obtenerNecesidad() throws PersistenceException;

    public void actualizarNecesidad(int idNecesidad,String estado) throws PersistenceException;

}