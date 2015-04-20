/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.portafolio.jsf.controllers;

import com.example.portafolio.jpa.entities.Ciudades;
import com.example.portafolio.jpa.entities.CiudadesPK;
import com.example.portafolio.jpa.entities.Roles;
import com.example.portafolio.jpa.entities.Usuarios;
import com.example.portafolio.jpa.sessions.CiudadesFacade;
import com.example.portafolio.jpa.sessions.UsuariosFacade;
import java.io.Serializable;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author leoandresm
 */
@Named(value = "usuariosController")
@ViewScoped
public class UsuariosController implements Serializable {

    private static final Logger log = Logger.getLogger(UsuariosController.class.getName());

    private Usuarios currentUser;
    private int idCiudad;
    private int idDepartamento;
    @EJB
    private UsuariosFacade ejbFacadeUser;
    @EJB
    private CiudadesFacade ejbFacadeCiudades;

    /**
     * Creates a new instance of UsuariosController
     */
    public UsuariosController() {
        currentUser = new Usuarios();
    }

    public Usuarios getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Usuarios currentUser) {
        this.currentUser = currentUser;
    }

    public String getCiudad() {
        try {
            return getCiudadesFacade().find(new CiudadesPK(idCiudad, idDepartamento)).toString();
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Error converter ciudad: {0}", ex);
            return "";
        }
    }

    public void setCiudad(String ciudad) {
        StringTokenizer tokens = new StringTokenizer(ciudad, ",");
        idCiudad = Integer.parseInt(tokens.nextToken());
        idDepartamento = Integer.parseInt(tokens.nextToken());
    }

    private UsuariosFacade getUserFacade() {
        return ejbFacadeUser;
    }

    private CiudadesFacade getCiudadesFacade() {
        return ejbFacadeCiudades;
    }

    public String create() {
        try {
            currentUser.setCiudades(new Ciudades(new CiudadesPK(idCiudad, idDepartamento)));
            currentUser.setIdRol(new Roles("USER"));
            getUserFacade().create(currentUser);
            return "/index";
        } catch (Exception ex) {
            log.log(Level.INFO, "Persistence Error: {0}", ex.getMessage());
            return "";
        }
    }

    public List<Usuarios> getUsuariosList() {
        return getUserFacade().findAll();
    }

    public List<Ciudades> getCiudadesList(String query) {
        try {
            return getCiudadesFacade().findByNombre(query);
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Error consultando ciudades: {0}", ex);
            return null;
        }
    }

}
