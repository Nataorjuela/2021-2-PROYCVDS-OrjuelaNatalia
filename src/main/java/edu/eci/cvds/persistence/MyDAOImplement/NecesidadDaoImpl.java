package edu.eci.cvds.persistence.MyDAOImplement;

import java.util.Date;
import java.util.List;


import com.google.inject.Inject;

import edu.eci.cvds.entities.Necesidad;
import edu.eci.cvds.persistence.NecesidadDao;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.MyDAOImplement.Mappers.NecesidadMapper;

public class NecesidadDaoImpl implements NecesidadDao {


    @Inject
    private NecesidadMapper necesidadMapper;

    @Override
    public List<Necesidad> obtenerNecesidad() throws PersistenceException {
        try{
            return necesidadMapper.consultarNecesidad();
        }
        catch(Exception e){
            System.out.println(e);
            throw new PersistenceException("Error al consultar las necesidades:",e);
        }
    }


    @Override
    public void crearNecesidad(int idCategoria, String nombreNec, String descripcion, String urgencia , Date fechaCreacion, String estado, Date fechaModif)throws PersistenceException{
        try {
            necesidadMapper.crearNecesidad(idCategoria,nombreNec, descripcion, urgencia, fechaCreacion,estado, fechaModif);
        } catch (Exception e) {
            System.out.println(e);
            throw new PersistenceException("Error al crear la necesidad:", e);
        }

    }
    @Override
    public void actualizarNecesidad(int idNecesidad,String estado) throws PersistenceException{
        try{
            necesidadMapper.actualizarNecesidad(idNecesidad,estado);
        }
        catch(Exception e){
            System.out.println(e);
            throw new PersistenceException("Error al actualizar la necesidad:",e);
        }

    }



}