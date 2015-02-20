/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Lavadero;
import com.services.LavaderoServices;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Jcmm
 */
@ManagedBean
@SessionScoped
public class LavaderoController implements Serializable {

    //objetod de negocio
    private Lavadero lavadero = new Lavadero();

    //servicios
    LavaderoServices lavser = new LavaderoServices();

    @ManagedProperty("#{usuarioController}")
    private UsuarioController usucon = new UsuarioController();

    //varable de control
    private MapModel simpleModel;  
    private Marker marker;

    /**
     * Creates a new instance of LavaderoController
     */
    public LavaderoController() {
    }

    public void editarLavadero(Lavadero l) {
        lavadero = l;
        getUsucon().setPAGINAACTUALI("../Plantillas/menuAdministrador.xhtml");
        getUsucon().setPAGINAACTUALC("../Parametrizacion/GestionLavadero.xhtml");
        //usucon.verLavadero();
    }

    public void onPointSelect(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        lavadero.setCorrdenadax(latlng.getLat());
        lavadero.setCorrdenaday(latlng.getLng());
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Point Selected", "Lat:" + latlng.getLat() + ", Lng:" + latlng.getLng()));
    }

    public void guardar() {
        lavadero.setEstado("En Funcionamiento");
        lavser.crear(lavadero);
        //lavadero=new Lavadero();
    }

    public void deshabilitar() {
        lavadero.setEstado("Deshabilitado");
        lavser.crear(lavadero);
        //lavadero=new Lavadero();
    }

    public void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the lavadero
     */
    public Lavadero getLavadero() {
        return lavadero;
    }

    /**
     * @param lavadero the lavadero to set
     */
    public void setLavadero(Lavadero lavadero) {
        this.lavadero = lavadero;
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

   @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
         
        //Shared coordinates
        LatLng coord1 = new LatLng(36.879466, 30.667648);
        LatLng coord2 = new LatLng(36.883707, 30.689216);
        LatLng coord3 = new LatLng(36.879703, 30.706707);
        LatLng coord4 = new LatLng(36.885233, 30.702323);
          
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
        simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
        simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
        simpleModel.addOverlay(new Marker(coord4, "Kaleici"));
    }
      
    public MapModel getSimpleModel() {
        return simpleModel;
    }
      
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
         
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
    }
      
    public Marker getMarker() {
        return marker;
    }
}
