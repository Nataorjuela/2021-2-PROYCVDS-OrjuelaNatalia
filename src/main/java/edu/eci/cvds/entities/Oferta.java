package edu.eci.cvds.entities;

import java.util.Date;

public class Oferta {
    private int idOferta;
    private int idCategoria;
    private String nombreOferta;
    private String descripcion;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModif;

    public Oferta(int idOferta, int idCategoria, String nombreOferta, String descripcion, boolean estado, Date fechaCreacion, Date fechaModif) {
        this.idOferta = idOferta;
        this.idCategoria = idCategoria;
        this.nombreOferta = nombreOferta;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModif = fechaModif;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
}
