package edu.eci.cvds.persistence.MyDAOImplement.Mappers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Oferta;

public interface OfertaMapper {

    public List<Oferta> consultarOfertas();

    public void crearOferta(@Param("idCategoria")int idCategoria,@Param("nombreOferta")String nombreOferta, @Param("descripcion") String descripcion, @Param("estado") String estado,@Param("fechaCreacion") Date fechaCreacion,@Param("fechaModif") Date fechaModif);

    public void actualizarOferta(@Param("idOferta") int idOferta,@Param("estado") String estado);
}