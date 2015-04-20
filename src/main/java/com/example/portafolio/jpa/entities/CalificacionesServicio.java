/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.portafolio.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "CALIFICACIONES_SERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalificacionesServicio.findAll", query = "SELECT c FROM CalificacionesServicio c"),
    @NamedQuery(name = "CalificacionesServicio.findByIdUsusario", query = "SELECT c FROM CalificacionesServicio c WHERE c.calificacionesServicioPK.idUsusario = :idUsusario"),
    @NamedQuery(name = "CalificacionesServicio.findByIdServicio", query = "SELECT c FROM CalificacionesServicio c WHERE c.calificacionesServicioPK.idServicio = :idServicio"),
    @NamedQuery(name = "CalificacionesServicio.findByPuntuacion", query = "SELECT c FROM CalificacionesServicio c WHERE c.puntuacion = :puntuacion"),
    @NamedQuery(name = "CalificacionesServicio.findByComentario", query = "SELECT c FROM CalificacionesServicio c WHERE c.comentario = :comentario"),
    @NamedQuery(name = "CalificacionesServicio.findByFecha", query = "SELECT c FROM CalificacionesServicio c WHERE c.fecha = :fecha")})
public class CalificacionesServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalificacionesServicioPK calificacionesServicioPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntuacion")
    private short puntuacion;
    @Size(max = 140)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicios servicios;
    @JoinColumn(name = "id_ususario", referencedColumnName = "id_ususario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public CalificacionesServicio() {
    }

    public CalificacionesServicio(CalificacionesServicioPK calificacionesServicioPK) {
        this.calificacionesServicioPK = calificacionesServicioPK;
    }

    public CalificacionesServicio(CalificacionesServicioPK calificacionesServicioPK, short puntuacion, Date fecha) {
        this.calificacionesServicioPK = calificacionesServicioPK;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }

    public CalificacionesServicio(int idUsusario, int idServicio) {
        this.calificacionesServicioPK = new CalificacionesServicioPK(idUsusario, idServicio);
    }

    public CalificacionesServicioPK getCalificacionesServicioPK() {
        return calificacionesServicioPK;
    }

    public void setCalificacionesServicioPK(CalificacionesServicioPK calificacionesServicioPK) {
        this.calificacionesServicioPK = calificacionesServicioPK;
    }

    public short getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(short puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calificacionesServicioPK != null ? calificacionesServicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificacionesServicio)) {
            return false;
        }
        CalificacionesServicio other = (CalificacionesServicio) object;
        if ((this.calificacionesServicioPK == null && other.calificacionesServicioPK != null) || (this.calificacionesServicioPK != null && !this.calificacionesServicioPK.equals(other.calificacionesServicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.portafolio.jpa.entities.CalificacionesServicio[ calificacionesServicioPK=" + calificacionesServicioPK + " ]";
    }
    
}
