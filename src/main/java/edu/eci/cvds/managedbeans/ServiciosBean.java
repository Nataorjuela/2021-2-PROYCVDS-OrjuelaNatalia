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

import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.ServicioCategoria;


@ManagedBean(name = "serviciosBean")
@SessionScoped
public class ServiciosBean extends BasePageBean{
	
	@Inject
	private ServicioCategoria servicioCategoria;

	private int idCategoria;
	private String nombreCategoria;
	private	 String	descripcion;

	private Date fechaModif;
	private Date fechaCreacion;

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

	public int getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public ServicioCategoria getServicioCategoria() {
		return servicioCategoria;
	}

	public void setServicioCategoria(ServicioCategoria servicioCategoria) {
		this.servicioCategoria = servicioCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Categoria> consultarCategorias() throws  PersistenceException
	{
		List<Categoria> categorias = null;
		
		try
		{	
			System.out.println("Entra a consular ");
			categorias = servicioCategoria.consultarCategorias();
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar Categoria", "No se pudo encontrar las categorias registrados"));
		}
		return categorias;
	}
	public void crearCategoria()throws  PersistenceException{

		try
		{
			System.out.println("entra a querer crear categ");

			LocalDate localDate = LocalDate.now();
			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			servicioCategoria.crearCategoria(nombreCategoria,descripcion,date,date);
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Crear categoria", "No se pudo crear la categoria"));
		}

	}
	
	public void eliminarCategoria()  throws  PersistenceException{
		
		try
		{	
			System.out.println("entra a querer eliminar");
			servicioCategoria.eliminarCategotia(idCategoria);
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Eliminar categoria", "No se pudo eliminar la categoria"));
		}
		
	}
	public void actualizarCategoria()  throws  PersistenceException{

		try
		{
			System.out.println("entra a querer actualizar");
			servicioCategoria.actualizarCategotia(idCategoria,nombreCategoria,descripcion);
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Actualizar categoria", "No se pudo actualizar la categoria"));
		}

	}


}
