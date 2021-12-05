package edu.eci.cvds.entities;

import java.util.Date;

public class Necesidad {
    private int idNecesidad;
    private int idCategoria;
    private String nombreNec;
    private String descripcion;
    private String urgencia;
    private Date fechaCreacion;
    private String estado;
    private Date fechaModif;
    public Necesidad() {
        super();
    }

    public Necesidad(int idNecesidad, int idCategoria, String nombreNec, String descripcion, String urgencia,String estado, Date fechaCreacion, Date fechaModif) {
        this.idNecesidad = idNecesidad;
        this.idCategoria = idCategoria;
        this.nombreNec = nombreNec;
        this.descripcion = descripcion;
        this.urgencia = urgencia;
        this.estado=estado;
        this.fechaCreacion = fechaCreacion;
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

    public String isEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "Necesidad {idNecesidad: " + idNecesidad + "idCategoria: " + idCategoria +", nombreNecesidad: " + nombreNec + " ,descripcion: " + descripcion + ",urgencia: " + urgencia +",estado: "+estado+", fechaCreacion: " + fechaCreacion + ", fechaModif : " + fechaModif+ "}\n";
    }

}
