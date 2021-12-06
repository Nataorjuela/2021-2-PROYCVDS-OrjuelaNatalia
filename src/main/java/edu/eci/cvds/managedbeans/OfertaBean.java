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

import edu.eci.cvds.entities.Oferta;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.ServicioOferta;


@ManagedBean(name = "ofertaBean")
@SessionScoped
public class OfertaBean extends BasePageBean{
    @Inject
    private ServicioOferta servicioOferta;

    private int idOfer;
    private String nombreOferta;
    private	 String	descripcion;
    private String estado;
    private Date fechaModif;
    private Date fechaCreacion;
    private int idCategoria;


    public int getIdOfer() {
        return idOfer;
    }

    public void setIdOfer(int idOfer) {
        this.idOfer = idOfer;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public ServicioOferta getServicioOferta() {
        return servicioOferta;
    }

    public void setServicioOferta(ServicioOferta servicioOferta) {
        this.servicioOferta = servicioOferta;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaModif() {
        return fechaModif;
    }

    public void setFechaModif(Date fechaModif) {
        this.fechaModif = fechaModif;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



    public List<Oferta> consultarOfertas() throws  PersistenceException
    {
        List<Oferta> ofertas = null;

        try
        {
            System.out.println("Entra a consultar ");
            ofertas = servicioOferta.consultarOfertas();
        } catch(PersistenceException e)
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar Oferta", "No se pudo encontrar las ofertas registrados"));
        }
        return ofertas;
    }

    public void crearOferta()throws PersistenceException {
        try
        {
            System.out.println("entra a querer crear oferta");

            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            servicioOferta.crearOferta(idCategoria,nombreOferta,descripcion,estado,date,date);
        } catch(PersistenceException e)
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Crear oferta", "No se pudo crear la oferta"));
        }


    }
    public void actualizarOferta()  throws  PersistenceException{

        try
        {
            System.out.println("entra a querer actualizar oferta");
            servicioOferta.actualizarOferta(idOfer,estado);
        } catch(PersistenceException e)
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Actualizar oferta", "No se pudo actualizar la oferta"));
        }

    }
}
