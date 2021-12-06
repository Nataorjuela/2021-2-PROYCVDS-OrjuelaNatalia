package edu.eci.cvds.managedbeans;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import edu.eci.cvds.security.Loggers;
import edu.eci.cvds.security.exception.ExceptionLogin;


import com.google.inject.Inject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.io.IOException;

@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioBean extends BasePageBean{
	@Inject
    private Loggers logger;
    private String usuarioId;
    private String message;
    private String contraseña;
    private Subject usuarioActual;
    private boolean recordar=false;
    
    private String redireccionURL="/inicio.xhtml";

    public void entrar() throws IOException, ExceptionLogin{
    	System.out.println("Hola entre en el login");
        System.out.println(getUsuarioId());
        System.out.println(getContraseña());
        boolean isLogger = logger.isLogged();
        if(!isLogger){
            System.out.println("Hola entre allll 2");
            logger.login(usuarioId, contraseña, false);
            redirectHomeUser();
        } else{
            existingSession();
        }

    }

    public void existingSession() throws IOException{
        this.message = "Another user with those credentials already exists";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("");
    }
    
    public void salir() {
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(redireccionURL);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Subject getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Subject usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public boolean isRecordar() {
        return recordar;
    }

    public void setRecordar(boolean recordar) {
        this.recordar = recordar;
    }

    public String getRedireccionURL() {
        return redireccionURL;
    }

    public void setRedireccionURL(String redireccionURL) {
        this.redireccionURL = redireccionURL;
    }


   
    public void redirectHomeUser() throws IOException {
    	FacesContext facesContext = FacesContext.getCurrentInstance();
        if(logger.isAdmin()){
            System.out.println("Entre a admin");
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            session.setAttribute("usuarioid", usuarioId);
            facesContext.getExternalContext().redirect("../administrador.xhtml");
        }
        
        if(logger.isAdministrativo()){
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            session.setAttribute("usuarioid", usuarioId);
            facesContext.getExternalContext().redirect("../administrativo.xhtml");
        }
        
        if(logger.isEstudiante()){
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            session.setAttribute("usuarioid", usuarioId);
            facesContext.getExternalContext().redirect("../estudiante.xhtml");
        }
        
        if(logger.isProfesor()){
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            session.setAttribute("usuarioid", usuarioId);
            facesContext.getExternalContext().redirect("../profesor.xhtml");
        }
        
        if(logger.isEgresado()){
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            session.setAttribute("usuarioid", usuarioId);
            facesContext.getExternalContext().redirect("../egresado.xhtml");
        }


    }
}

