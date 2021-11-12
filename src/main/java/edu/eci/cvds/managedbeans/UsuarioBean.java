package edu.eci.cvds.managedbeans;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;

@SessionScoped
@ManagedBean(name="usuarioBean")
public class UsuarioBean implements Serializable{
    private String usuarioId;
    private static final Logger logger = LoggerFactory.getLogger(UsuarioBean.class);
    private String contraseña;
    private Subject usuarioActual;
    private boolean recordar=false;
    private String redireccionURL="/faces/inicio.xhtml";

    public void entrar(){
        UsernamePasswordToken token = new UsernamePasswordToken(getUsuarioId(),new Sha256Hash(getContraseña()).toHex());
        usuarioActual = SecurityUtils.getSubject();

        try{
            usuarioActual.login(token);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Session session = usuarioActual.getSession();
            session.setAttribute("usuarioId",usuarioId);
            session.setAttribute("usuarioActual",usuarioActual);
            if(usuarioActual.hasRole("Administrador")){
                facesContext.getExternalContext().redirect("/faces/inicio1.xhtml");
            } else if(usuarioActual.hasRole("Estudiante") || usuarioActual.hasRole("Profesor") || usuarioActual.hasRole("Egresado") || usuarioActual.hasRole("Administrativo")  ){
                facesContext.getExternalContext().redirect("/faces/inicio2.xhtml");
            }
        }
        catch ( UnknownAccountException e ) {
            //username wasn't in the system, show them an error message?
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sign in Error", "Incorrect Credentials"));
            logger.error(e.getMessage(),e);
        } catch ( IncorrectCredentialsException e ) {
            //password didn't match, try again?
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sign in Error", "Incorrect Credentials"));
            logger.error(e.getMessage(),e);
        } catch ( LockedAccountException e ) {
            //account for that username is locked - can't login.  Show them a message?
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sign in Error", "Sign in Error"));
            logger.error(e.getMessage(),e);
        } catch ( AuthenticationException e ) {
            //unexpected condition - error?
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sign in Error", "Sign in Error"));
            logger.error(e.getMessage(),e);
        }catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sign in Error", "Sign in Error"));
            logger.error(e.getMessage(),e);
        }
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
}