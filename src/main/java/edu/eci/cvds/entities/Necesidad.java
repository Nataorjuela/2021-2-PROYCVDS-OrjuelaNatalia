package edu.eci.cvds.entities;

import java.util.Date;

public class Necesidad {
    private int idNecesidad;
    private int idCategoria;
    private String nombreNec;
    private String descripcion;
    private String urgencia;
    private Date fechaCreacion;
    private boolean estado;
    private Date fechaModif;

    public Necesidad(int idNecesidad, int idCategoria, String nombreNec, String descripcion, String urgencia, Date fechaCreacion,boolean estado, Date fechaModif) {
        this.idNecesidad = idNecesidad;
        this.idCategoria = idCategoria;
        this.nombreNec = nombreNec;
        this.descripcion = descripcion;
        this.urgencia = urgencia;
        this.fechaCreacion = fechaCreacion;
        this.estado=estado;
        this.fechaModif = fechaModif;
    }

    public int getIdNecesidad() {
        return idNecesidad;
    }

    public void setIdNecesidad(int idNecesidad) {
        this.idNecesidad = idNecesidad;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreNec() {
        return nombreNec;
    }

    public void setNombreNec(String nombreNec) {
        this.nombreNec = nombreNec;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModif() {
        return fechaModif;
    }

    public void setFechaModif(Date fechaModif) {
        this.fechaModif = fechaModif;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
