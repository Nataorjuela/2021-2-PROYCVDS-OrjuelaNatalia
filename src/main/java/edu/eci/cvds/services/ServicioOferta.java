package edu.eci.cvds.services;

import java.util.Date;
import java.util.List;


import edu.eci.cvds.entities.Oferta;
import edu.eci.cvds.persistence.PersistenceException;

public interface ServicioOferta {
    public List<Oferta> consultarOfertas() throws  PersistenceException;
    public void crearOferta(int idCategoria,String nombreOferta, String descripcion, String estado, Date fechaCreacion, Date fechaModif)throws PersistenceException;
    public void actualizarOferta(int idOferta,String estado) throws PersistenceException;
}
