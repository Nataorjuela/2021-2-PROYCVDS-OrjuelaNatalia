package edu.eci.cvds.managedbeans;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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

    private int idNec;
    private String estado;
    private int idCateg;
    private String nombreNecesidad,descripcion,urgencia;

    public int getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(int idCateg) {
        this.idCateg = idCateg;
    }

    public String getNombreNecesidad() {
        return nombreNecesidad;
    }

    public void setNombreNecesidad(String nombreNecesidad) {
        this.nombreNecesidad = nombreNecesidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }


    public ServicioNecesidad getServicioNecesidad() {
        return servicioNecesidad;
    }

    public void setServicioNecesidad(ServicioNecesidad servicioNecesidad) {
        this.servicioNecesidad = servicioNecesidad;
    }

    public int getIdNec() {
        return idNec;
    }

    public void setIdNec(int idNec) {
        this.idNec = idNec;
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
    public void crearNecesidad()throws PersistenceException {
        try
        {
            System.out.println("entra a querer crear necesidad");

            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            servicioNecesidad.crearNecesidad(idCateg,nombreNecesidad,descripcion,urgencia,date,estado,date);
        } catch(PersistenceException e)
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Crear necesidad", "No se pudo crear la necesidad"));
        }
    }
    public void actualizarNecesidad()  throws  PersistenceException{

        try
        {
            System.out.println("entra a querer actualizar necesidad");
            servicioNecesidad.actualizarNecesidad(idNec,estado);
        } catch(PersistenceException e)
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Actualizar necesidad", "No se pudo actualizar la necesidad"));
        }

    }

}
