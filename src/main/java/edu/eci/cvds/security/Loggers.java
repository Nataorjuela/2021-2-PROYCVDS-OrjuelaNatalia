package edu.eci.cvds.security;

import edu.eci.cvds.security.exception.ExceptionLogin;

public interface Loggers {
    
    /**
     * Method for login as a User of the web app
     * @param email
     * @param password
     */
    public void login(String email, String password, boolean remember) throws ExceptionLogin;

    /**
     * Mehot to logout for the web app
     */
    public void logout();

    /**
     * This method return if the user are logged 
     * @return boolean 
     */
    public boolean isLogged();

    /**
     * This method return if the user logged is a admin user in the app 
     * @return boolean 
     */
    public boolean isAdmin();

    /**
     * This methid return if the administrativo loggerd is a normal user in the app
     * @return
     */
    public boolean isAdministrativo();
    
    
    /**
     * This methid return if the estudiante loggerd is a normal user in the app
     * @return
     */
    public boolean isEstudiante();
    
    
    /**
     * This methid return if the profesor loggerd is a normal user in the app
     * @return
     */
    public boolean isProfesor();
    
    /**
     * This methid return if the Egresado loggerd is a normal user in the app
     * @return
     */
    public boolean isEgresado();
}