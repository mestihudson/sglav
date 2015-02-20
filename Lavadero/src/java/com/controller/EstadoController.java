/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.EtapaLavado;
import com.entity.Lavado;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jcmm
 */
@ManagedBean
@SessionScoped
public class EstadoController implements Serializable{

    /**
     * Creates a new instance of EstadoController
     */
    public EstadoController() {
    }
    
    public String estadoEtapa(EtapaLavado el){
        String estado="poriniciar";
        if(el.getEstado().equals("iniciado")){
            estado="iniciado";
        }
        if(el.getEstado().equals("enproceso")){
            estado="enproceso";
        }
        if(el.getEstado().equals("terminado")){
            estado="terminado";
        }
        return estado;
    }
    
     public String estadoLavado(Lavado l){
        String estado="poriniciar";
        if(l.getEstado().equals("iniciado")){
            estado="iniciado";
        }
        if(l.getEstado().equals("enproceso")){
            estado="enproceso";
        }
        if(l.getEstado().equals("terminado")){
            estado="terminado";
        }
        return estado;
    }
    
}
