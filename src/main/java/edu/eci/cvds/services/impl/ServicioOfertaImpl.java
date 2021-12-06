package edu.eci.cvds.services.impl;

import java.util.Date;
import java.util.List;


import com.google.inject.Inject;


import edu.eci.cvds.entities.Oferta;
import edu.eci.cvds.persistence.OfertaDao;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.ServicioOferta;

public class ServicioOfertaImpl implements ServicioOferta {
    @Inject
    private OfertaDao ofertaDao;

    @Override
    public List<Oferta> consultarOfertas() throws PersistenceException {
        return ofertaDao.obtenerOfertas();
    }
    @Override
    public void crearOferta(int idCategoria,String nombreOferta, String descripcion, String estado, Date fechaCreacion, Date fechaModif) throws PersistenceException {
        ofertaDao.crearOferta(idCategoria,nombreOferta, descripcion, estado, fechaCreacion, fechaModif);
    }
    @Override
    public void actualizarOferta(int idOferta,String estado) throws PersistenceException{
        ofertaDao.actualizarOferta(idOferta,estado);
    }

}