/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Lavadero;
import com.entity.Servicio;
import com.services.LavaderoServices;
import com.services.ServicioServices;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jcmm
 */
@ManagedBean
@SessionScoped
public class ServicioController implements Serializable{
    private Servicio servicio=new Servicio();
    private List<Servicio> servicios=new LinkedList();
    Lavadero lavadero=new Lavadero();
    
    @ManagedProperty("#{usuarioController}")
    private UsuarioController usucon=new UsuarioController();
    
    
    ServicioServices ss=new ServicioServices();
    LavaderoServices ls=new LavaderoServices();
    /**
     * Creates a new instance of ServicioController
     */
    public ServicioController() {
        
    }

    public void anclarLavadero(Lavadero l){
        lavadero=l;
        listarServicios();
        getUsucon().setPAGINAACTUALI("../Plantillas/menuAdministrador.xhtml");
        getUsucon().setPAGINAACTUALC("../Parametrizacion/GestionServicios.xhtml");
    }
    
    public void registrar(){        
        //Lavadero lavadero= ls.consultar(Lavadero.class, Long.parseLong("1"));
        servicio.setLavadero(lavadero);
        servicio.setEstado(true);        
        ss.crear(servicio);
        servicio=new Servicio();
        listarServicios();
    }
    
    
    public void serviciosLavadero(Lavadero l){
        lavadero=l;
        listarServicios();
        getUsucon().setPAGINAACTUALI("../Plantillas/menuAdministrador.xhtml");
        getUsucon().setPAGINAACTUALC("../Parametrizacion/gestionFaces.xhtml");
    }
    
    public void listarServicios(){
        servicios=ss.listarXLavadero(lavadero.getId());
    }
    /**
     * @return the servicio
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    /**
     * @return the servicios
     */
    public List<Servicio> getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    /**
     * @return the usucon
     */
    public UsuarioController getUsucon() {
        return usucon;
    }

    /**
     * @param usucon the usucon to set
     */
    public void setUsucon(UsuarioController usucon) {
        this.usucon = usucon;
    }
}
