/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Lavadero;
import com.services.LavaderoServices;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
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
    
    //colecciones
    private List<Lavadero> lavaderos=new LinkedList();

    //servicios
    LavaderoServices lavser = new LavaderoServices();
    
    //controladores
    @ManagedProperty("#{usuarioController}")
    private UsuarioController usucon = new UsuarioController();
    //Controladores servicies
    private LavaderoServices lavacon = new LavaderoServices();

    //varable de control
    private MapModel simpleModel;
    private Marker marker;
    private MapModel advancedModel;

    /**
     * Creates a new instance of LavaderoController
     */
    public LavaderoController() {
        advancedModel = new DefaultMapModel();

        //Shared coordinates
        LatLng coord1 = new LatLng(36.879466, 30.667648);
        LatLng coord2 = new LatLng(36.883707, 30.689216);
        LatLng coord3 = new LatLng(36.879703, 30.706707);
        LatLng coord4 = new LatLng(36.885233, 30.702323);

        //Icons and Data
        advancedModel.addOverlay(new Marker(coord1, "Konyaalti", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/red-pushpin.png" ));
        advancedModel.addOverlay(new Marker(coord2, "Ataturk Parki", "ataturkparki.png"));
        advancedModel.addOverlay(new Marker(coord4, "Kaleici", "kaleici.png", "http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));
        advancedModel.addOverlay(new Marker(coord3, "Karaalioglu Parki", "karaalioglu.png", "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));
        System.out.println("Este es La lista de lavaderos");
        for (Lavadero lavadero1 :getLavaderos()) {
            LatLng coord6 = new LatLng(lavadero1.getCorrdenadax(),lavadero1.getCorrdenaday());
            System.out.println(lavadero1.getNombre());
            advancedModel.addOverlay(new Marker(coord6,lavadero1.getNombre(),"", "http://maps.google.com/mapfiles/ms/micons/"+lavadero1.getEstado()+"-pushpin.png"));
        }
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
    public MapModel getAdvancedModel() {
        return advancedModel;
    }
/**
     * @return the lavaderos
     */
    public List<Lavadero> getLavaderos() {
        return lavacon.consultarTodo(Lavadero.class);
    }

    /**
     * @param lavaderos the lavaderos to set
     */
    public void setLavaderos(List<Lavadero> lavaderos) {
        this.lavaderos = lavaderos;
    }
}
