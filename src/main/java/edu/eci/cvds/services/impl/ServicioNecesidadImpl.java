package edu.eci.cvds.services.impl;

import java.util.List;


import com.google.inject.Inject;


import edu.eci.cvds.entities.Necesidad;
import edu.eci.cvds.persistence.NecesidadDao;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.ServicioNecesidad;

public class ServicioNecesidadImpl implements ServicioNecesidad {
    @Inject
    private NecesidadDao necesidadDao;

    @Override
    public List<Necesidad> consultarNecesidad() throws PersistenceException {
        return necesidadDao.obtenerNecesidad();
    }

    @Override
    public void actualizarNecesidad(int idNecesidad,String estado) throws PersistenceException {
        necesidadDao.actualizarNecesidad(idNecesidad,estado);

    }
}
