package edu.eci.cvds.entities;

import java.util.Date;

public class Categoria {
    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaModif;
    
    
    public Categoria() {
        super();
    }

    public Categoria(int idCategoria, String nombreCategoria, String descripcion, Date fechaCreacion, Date fechaModif) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModif = fechaModif;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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
    
    @Override
    public String toString() {
        return "Categoria {idCategoria: " + idCategoria + ", nombreCategoria: " + nombreCategoria + " ,descripcion: " + descripcion + ", fechaCreacion: " + fechaCreacion + ", fechaModif : " + fechaModif+ "}\n";
    }

}
