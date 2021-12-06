package edu.eci.cvds.persistence.MyDAOImplement;

import java.util.Date;
import java.util.List;


import com.google.inject.Inject;

import edu.eci.cvds.entities.Oferta;
import edu.eci.cvds.persistence.OfertaDao;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.MyDAOImplement.Mappers.OfertaMapper;
import org.apache.ibatis.annotations.Param;

public class OfertaDaoImpl implements OfertaDao {


    @Inject
    private OfertaMapper ofertaMapper;

    @Override
    public List<Oferta> obtenerOfertas() throws PersistenceException {
        try {
            return ofertaMapper.consultarOfertas();
        } catch (Exception e) {
            System.out.println(e);
            throw new PersistenceException("Error al consultar las ofertas:", e);
        }
    }

    @Override
    public void crearOferta(int idCategoria,String nombreOferta, String descripcion, String estado, Date fechaCreacion, Date fechaModif) throws PersistenceException {
        try {
            ofertaMapper.crearOferta(idCategoria,nombreOferta, descripcion, estado, fechaCreacion, fechaModif);
        } catch (Exception e) {
            System.out.println(e);
            throw new PersistenceException("Error al crear la oferta:", e);
        }

    }
    @Override
    public void actualizarOferta(int idOferta,String estado) throws PersistenceException{
        try{
            ofertaMapper.actualizarOferta(idOferta,estado);
        }
        catch(Exception e){
            System.out.println(e);
            throw new PersistenceException("Error al actualizar la oferta:",e);
        }

    }
}