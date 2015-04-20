/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.portafolio.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUsusario", query = "SELECT u FROM Usuarios u WHERE u.idUsusario = :idUsusario"),
    @NamedQuery(name = "Usuarios.findByNombres", query = "SELECT u FROM Usuarios u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuarios.findByDireccion", query = "SELECT u FROM Usuarios u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByFechaNac", query = "SELECT u FROM Usuarios u WHERE u.fechaNac = :fechaNac"),
    @NamedQuery(name = "Usuarios.findBySexo", query = "SELECT u FROM Usuarios u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    //Campo id_usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ususario")
    private Integer idUsusario;

    //Campo nombres
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String nombres;

    //Campo apellidos
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    private String apellidos;

    //Campo telefono
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    private String telefono;
    
    //Campo direccion
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String direccion;

    //Campo email
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String email;
   
    //Campo fecha_nac
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
   
    //Campo sexo
    @Basic(optional = false)
    @NotNull
    private Character sexo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    private String password;
    
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")})
    @ManyToOne(optional = false)
    private Ciudades ciudades;
    
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Roles idRol;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<CalificacionesServicio> calificacionesServicioList;

    public Usuarios() {
    }

    public Usuarios(Integer idUsusario) {
        this.idUsusario = idUsusario;
    }

    public Usuarios(Integer idUsusario, String nombres, String apellidos, String telefono, String direccion, String email, Date fechaNac, Character sexo, String password) {
        this.idUsusario = idUsusario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.password = password;
    }

    public Integer getIdUsusario() {
        return idUsusario;
    }

    public void setIdUsusario(Integer idUsusario) {
        this.idUsusario = idUsusario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Ciudades getCiudades() {
        return ciudades;
    }

    public void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }

    public Roles getIdRol() {
        return idRol;
    }

    public void setIdRol(Roles idRol) {
        this.idRol = idRol;
    }

    @XmlTransient
    public List<CalificacionesServicio> getCalificacionesServicioList() {
        return calificacionesServicioList;
    }

    public void setCalificacionesServicioList(List<CalificacionesServicio> calificacionesServicioList) {
        this.calificacionesServicioList = calificacionesServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsusario != null ? idUsusario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsusario == null && other.idUsusario != null) || (this.idUsusario != null && !this.idUsusario.equals(other.idUsusario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.portafolio.jpa.entities.Usuarios[ idUsusario=" + idUsusario + " ]";
    }
    
}
