/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.portafolio.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leoandresm
 */
@Embeddable
public class CalificacionesServicioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_ususario")
    private int idUsusario;
    @Basic(optional = false)
    @Column(name = "id_servicio")
    private int idServicio;

    public CalificacionesServicioPK() {
    }

    public CalificacionesServicioPK(int idUsusario, int idServicio) {
        this.idUsusario = idUsusario;
        this.idServicio = idServicio;
    }

    public int getIdUsusario() {
        return idUsusario;
    }

    public void setIdUsusario(int idUsusario) {
        this.idUsusario = idUsusario;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsusario;
        hash += (int) idServicio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificacionesServicioPK)) {
            return false;
        }
        CalificacionesServicioPK other = (CalificacionesServicioPK) object;
        if (this.idUsusario != other.idUsusario) {
            return false;
        }
        if (this.idServicio != other.idServicio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.portafolio.jpa.entities.CalificacionesServicioPK[ idUsusario=" + idUsusario + ", idServicio=" + idServicio + " ]";
    }
    
}
