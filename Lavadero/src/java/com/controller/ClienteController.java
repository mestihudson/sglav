/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Cliente;
import com.entity.Lavado;
import com.services.LavadoServices;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jcmm
 */
@ManagedBean
@SessionScoped
public class ClienteController implements Serializable{

    private List<Lavado> lavados=new LinkedList();
    private Cliente cliente=new Cliente();
    
    LavadoServices ls;
    
    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {
        ls=new LavadoServices();
    }
    
     public void listarLavadosCliente(){
         setLavados(ls.listarXCliente(cliente.getId()));
     }

    /**
     * @return the lavados
     */
    public List<Lavado> getLavados() {
        return lavados;
    }

    /**
     * @param lavados the lavados to set
     */
    public void setLavados(List<Lavado> lavados) {
        this.lavados = lavados;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
            
    
}
