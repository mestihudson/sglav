/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.TipoCubiculo;
import com.services.TipoCubiculoServices;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jcmm
 */
@ManagedBean
@SessionScoped
public class TipoCubiculoController implements Serializable{

    private TipoCubiculo tipocubiculo=new TipoCubiculo();
    
    TipoCubiculoServices tcs=new TipoCubiculoServices();
    
    /**
     * Creates a new instance of TipoCubiculoController
     */
    public TipoCubiculoController() {
    }

    public void almacenar(){
        tcs.crear(tipocubiculo);
        tipocubiculo=new TipoCubiculo();
    }
    
    /**
     * @return the tipocubiculo
     */
    public TipoCubiculo getTipocubiculo() {
        return tipocubiculo;
    }

    /**
     * @param tipocubiculo the tipocubiculo to set
     */
    public void setTipocubiculo(TipoCubiculo tipocubiculo) {
        this.tipocubiculo = tipocubiculo;
    }
}
