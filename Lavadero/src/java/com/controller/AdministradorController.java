/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Administrador;
import com.entity.Lavadero;
import com.services.AdministradorServices;
import com.services.LavaderoServices;
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
public class AdministradorController implements Serializable{

    private Administrador admin=new Administrador();
    private String passw;
    
    //Servicios
    AdministradorServices adser;
    LavaderoServices lavser;
    
    //colecciones
    private List<Lavadero> lavaderos=new LinkedList();
    private Lavadero lavaderoA=new Lavadero();
    
    /**
     * Creates a new instance of AdministradorController
     */
    public AdministradorController() {
        adser=new AdministradorServices();
        lavser=new LavaderoServices();

    }

    public void escogerLavadro(Lavadero l){
        lavaderoA=l;
    }
    
    public void listarLavaderos(Long id){
        lavaderos=lavser.listarXAdministrador(id);
    }
    
    public void guardar(){
        if(admin.getPassword().equals(passw)){
            admin.setEstado(true);        
            adser.crear(admin);
            admin=new Administrador();
        }else{
            FacesUtil.addErrorMessage("El password suministrado no coincide ");
        }
    }
    
    
    /**
     * @return the admin
     */
    public Administrador getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    /**
     * @return the passw
     */
    public String getPassw() {
        return passw;
    }

    /**
     * @param passw the passw to set
     */
    public void setPassw(String passw) {
        this.passw = passw;
    }

    /**
     * @return the lavaderos
     */
    public List<Lavadero> getLavaderos() {
        return lavaderos;
    }

    /**
     * @param lavaderos the lavaderos to set
     */
    public void setLavaderos(List<Lavadero> lavaderos) {
        this.lavaderos = lavaderos;
    }

    /**
     * @return the lavaderoA
     */
    public Lavadero getLavaderoA() {
        return lavaderoA;
    }

    /**
     * @param lavaderoA the lavaderoA to set
     */
    public void setLavaderoA(Lavadero lavaderoA) {
        this.lavaderoA = lavaderoA;
    }
}
