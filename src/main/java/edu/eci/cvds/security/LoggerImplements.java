package edu.eci.cvds.security;

import org.apache.shiro.SecurityUtils;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.AuthenticationException;

import edu.eci.cvds.managedbeans.UsuarioBean;
import edu.eci.cvds.security.exception.ExceptionLogin;


public class LoggerImplements implements Loggers {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioBean.class);

    @Override
    public void login(String email, String password, boolean remember) throws ExceptionLogin{
        try {
            System.out.println("Hola entre 3");
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(email,password, remember);
            subject.getSession().setAttribute("correo", email);
            subject.login(token);
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
        
        }
    }

    @Override
    public void logout() {
        SecurityUtils.getSubject().logout();

    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    @Override
    public boolean isAdmin() {
        return SecurityUtils.getSubject().hasRole("Administrador");
    }

    @Override
    public boolean isAdministrativo() {
        return SecurityUtils.getSubject().hasRole("Administrativo");
    }

	@Override
	public boolean isEstudiante() {
		return SecurityUtils.getSubject().hasRole("Estudiante");
	}

	@Override
	public boolean isProfesor() {
		return SecurityUtils.getSubject().hasRole("Profesor");
	}

	@Override
	public boolean isEgresado() {
		return SecurityUtils.getSubject().hasRole("Egresado");
	}

	
    
}