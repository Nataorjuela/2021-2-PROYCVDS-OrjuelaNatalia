package edu.eci.cvds.entities;

public class Usuario {

    private String idUsuario;
    private int idRol;
    private String tipoRol;
    private boolean estado;
    private String correo;
    private String contraseña;


    public Usuario() {
        super();
    }

    public Usuario(String idUsuario, int idRol, String tipoRol, boolean estado, String correo, String contraseña) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.tipoRol = tipoRol;
        this.estado = estado;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}