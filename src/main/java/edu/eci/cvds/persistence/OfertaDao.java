package edu.eci.cvds.persistence;

import java.util.Date;
import java.util.List;

import edu.eci.cvds.entities.Oferta;

public interface OfertaDao {

    public List<Oferta> obtenerOfertas() throws PersistenceException;

    public void crearOferta(int idCategoria,String nombreOferta, String descripcion, String estado, Date fechaCreacion, Date fechaModif) throws PersistenceException;

    public void actualizarOferta(int idOferta,String estado) throws PersistenceException;
}