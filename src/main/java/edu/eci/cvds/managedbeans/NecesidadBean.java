package edu.eci.cvds.managedbeans;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;


import edu.eci.cvds.entities.Necesidad;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.ServicioNecesidad;

@ManagedBean(name = "necesidadBean")
@SessionScoped
public class NecesidadBean extends BasePageBean{

    @Inject
    private ServicioNecesidad servicioNecesidad;

    private int idNecesidad;
    private String estado;

    public ServicioNecesidad getServicioNecesidad() {
        return servicioNecesidad;
    }

    public void setServicioNecesidad(ServicioNecesidad servicioNecesidad) {
        this.servicioNecesidad = servicioNecesidad;
    }

    public int getIdNecesidad() {
        return idNecesidad;
    }

    public void setIdNecesidad(int idNecesidad) {
        this.idNecesidad = idNecesidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    public List<Necesidad> consultarNecesidad() throws  PersistenceException
    {
        List<Necesidad> necesidades = null;

        try
        {
            System.out.println("Entra a consultar");
            necesidades = servicioNecesidad.consultarNecesidad();
        } catch(PersistenceException e)
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar Necesidad", "No se pudo encontrar las necesidades registradas"));
        }
        return necesidades;
    }



    public void actualizarNecesidad()  throws  PersistenceException{

        try
        {
            System.out.println("entra a querer actualizar necesidad");
            servicioNecesidad.actualizarNecesidad(idNecesidad,estado);
        } catch(PersistenceException e)
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Actualizar necesidad", "No se pudo actualizar la necesidad"));
        }

    }


}
