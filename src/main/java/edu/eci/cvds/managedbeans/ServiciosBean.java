package edu.eci.cvds.managedbeans;

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
	
	
	public int getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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
	
	

}
