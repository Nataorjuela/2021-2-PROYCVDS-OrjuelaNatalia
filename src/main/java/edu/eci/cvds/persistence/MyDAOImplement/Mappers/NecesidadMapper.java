package edu.eci.cvds.persistence.MyDAOImplement.Mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Necesidad;

public interface NecesidadMapper {

    public List<Necesidad> consultarNecesidad();

    public void actualizarNecesidad(@Param("idNecesidad") int idNecesidad,@Param("estado") String estado);
}
