/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Cubiculo;
import com.entity.Lavadero;
import com.entity.TipoCubiculo;
import com.services.CubiculoServices;
import com.services.TipoCubiculoServices;
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
public class CubiculoController implements Serializable{

    private Lavadero lavadero=new Lavadero();
    private Cubiculo cubiculo=new Cubiculo();
    
    @ManagedProperty("#{usuarioController}")
    private UsuarioController usucon=new UsuarioController();
   
    
    CubiculoServices cubser=new CubiculoServices();
    TipoCubiculoServices tcs=new TipoCubiculoServices();
    
    private List<TipoCubiculo> tcubiculos=new LinkedList();
    private TipoCubiculo tipoescogido=new TipoCubiculo();
    private List<Cubiculo> cubiculos=new LinkedList();
    private boolean habBregistrar;
    
    /**
     * Creates a new instance of CubiculoController
     */
    public CubiculoController() {
        habBregistrar=false;
//        lavadero.setNombre("Lavadero Perimetral");
//        lavadero.setCiudad("Cartagena");
//        lavadero.setNit("98348722");
//        lavadero.setId(Long.parseLong("1"));
//        listarTCubiculos();
    }

    public void elegirTC(TipoCubiculo tc){
        setTipoescogido(tc);
        habBregistrar=true;
    }
    
    public void consultarCubiculo(Cubiculo c){
        cubiculo=c;
    }
    
    public void anclarLavadero(Lavadero l){        
        lavadero=l;
        listarTCubiculos();
        cubiculosLavadero();
        usucon.setPAGINAACTUALI("../Plantillas/menuAdministrador.xhtml");
        usucon.setPAGINAACTUALC("../Parametrizacion/GestionCubiculos.xhtml");
    }
    
    
    public void cubiculosLavadero(){
        cubiculos=cubser.listarXLavadero(lavadero.getId());        
        //getUsucon().verCubiculos();
    }
    
  
    
    public void registrar(){
        cubiculo.setEstado(true);
        cubiculo.setEstadoUtilizacion("Disponible");
        if(lavadero!=null){
            cubiculo.setLavadero(lavadero);
            if(getTipoescogido()!=null){
                cubiculo.setTipoCubiculo(getTipoescogido());
                cubser.crear(cubiculo);
                habBregistrar=false;
                cubiculo=new Cubiculo();
                cubiculosLavadero();
            }else{
                FacesUtil.addErrorMessage("no hay tipo de cubiculo escogido para este cubiculo");  
            }
        }else{
            FacesUtil.addErrorMessage("no hay lavadero gestionado para este cubiculo");
        }
    }
    
    public void listarTCubiculos(){
        tcubiculos=tcs.consultarTodo(TipoCubiculo.class);
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
     * @return the cubiculo
     */
    public Cubiculo getCubiculo() {
        return cubiculo;
    }

    /**
     * @param cubiculo the cubiculo to set
     */
    public void setCubiculo(Cubiculo cubiculo) {
        this.cubiculo = cubiculo;
    }

    /**
     * @return the tcubiculos
     */
    public List<TipoCubiculo> getTcubiculos() {
        return tcubiculos;
    }

    /**
     * @param tcubiculos the tcubiculos to set
     */
    public void setTcubiculos(List<TipoCubiculo> tcubiculos) {
        this.tcubiculos = tcubiculos;
    }

    /**
     * @return the habBregistrar
     */
    public boolean isHabBregistrar() {
        return habBregistrar;
    }

    /**
     * @param habBregistrar the habBregistrar to set
     */
    public void setHabBregistrar(boolean habBregistrar) {
        this.habBregistrar = habBregistrar;
    }

    /**
     * @return the tipoescogido
     */
    public TipoCubiculo getTipoescogido() {
        return tipoescogido;
    }

    /**
     * @param tipoescogido the tipoescogido to set
     */
    public void setTipoescogido(TipoCubiculo tipoescogido) {
        this.tipoescogido = tipoescogido;
    }

    /**
     * @return the cubiculos
     */
    public List<Cubiculo> getCubiculos() {
        return cubiculos;
    }

    /**
     * @param cubiculos the cubiculos to set
     */
    public void setCubiculos(List<Cubiculo> cubiculos) {
        this.cubiculos = cubiculos;
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
