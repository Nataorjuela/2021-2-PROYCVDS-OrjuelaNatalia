package edu.eci.cvds.entities;

public class Usuario {

    private String usuarioI;
    private String nombre;
    private boolean estado;
    private String correo;
    private String contraseña;
    private int tipoUsuario;

    public Usuario(){
        super();
    }

    public Usuario(String usuarioI, String nombre, boolean estado, String correo, String contraseña, int tipoUsuario) {
        this.usuarioI = usuarioI;
        this.nombre = nombre;
        this.estado = estado;
        this.correo = correo;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuarioI() {
        return usuarioI;
    }

    public void setUsuarioI(String usuarioI) {
        this.usuarioI = usuarioI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
