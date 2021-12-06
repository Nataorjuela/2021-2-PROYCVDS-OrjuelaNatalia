package edu.eci.cvds.persistence.MyDAOImplement.Mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Necesidad;

public interface NecesidadMapper {

    public List<Necesidad> consultarNecesidad();

    public void crearNecesidad(@Param("idCategoria")int idCategoria, @Param("nombreNec")String nombreNec, @Param("descripcion") String descripcion, @Param("urgencia") String urgencia, @Param("fechaCreacion") Date fechaCreacion, @Param("estado") String estado, @Param("fechaModif") Date fechaModif);


    public void actualizarNecesidad(@Param("idNecesidad") int idNecesidad,@Param("estado") String estado);
}
