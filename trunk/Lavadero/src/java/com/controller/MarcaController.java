/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Marca;
import com.services.MarcaServices;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Luigie
 */
@ManagedBean
@RequestScoped
public class MarcaController {

    //objetos de negocio
     private Marca marca= new Marca();
    
     //coleciones
     private List<Marca>marcas=new LinkedList();

     //servicios
     MarcaServices marcaservices= new MarcaServices();
     
     //variable de control
     
     
     
    /**
     * Creates a new instance of MarcaController
     */
    public MarcaController() {
    }

    public void crearmarca(){
    marcaservices.crear(marca);
    marca=new Marca();
    
    }
    
    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * @return the marcas
     */
    public List<Marca> getMarcas() {
        return marcas=marcaservices.listarXOrden();
    }

    /**
     * @param marcas the marcas to set
     */
    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

   
     
}
