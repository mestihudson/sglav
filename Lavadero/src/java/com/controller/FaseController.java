/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Fase;
import com.entity.Servicio;
import com.services.FaseServices;
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
public class FaseController implements Serializable{

    private List<Fase> fases=new LinkedList();
    private Fase face=new Fase();
    private Servicio servicio=new Servicio();
    private String nombre;
    
    FaseServices fs=new FaseServices();
    
    /**
     * Creates a new instance of FaseController
     */
    public FaseController() {
        face.setServicio(servicio);
       // orden=0;
    }
    
    public void posicionar(List<Fase> fases,Fase fase){             
//        if((fases.get(fases.indexOf(fase)).getPosicion()==0)){
//            
//            fases.get(fases.indexOf(fase)).setPosicion(orden);       
//        }else{
//            fases.get(fases.indexOf(fase)).setPosicion(0);     
//        }
//        System.out.println(fases.get(fases.indexOf(fase)).getPosicion()+"  "+fase.getPosicion()+" "+fases.size()+" "+fase.getNombre()+orden);
    }
    
    public void moverI(){
        
    }
    public void moverd(List<Fase> fases,Fase fase){
        fases.get(fases.lastIndexOf(fase)).setPosicion(fase.getPosicion());
        fases.get(fases.indexOf(fase)).setPosicion(fase.getPosicion()+1);        
    }
    
    public void eliminar(Fase fase){
        fases.remove(fase);
    }
    
    public void agregarServicio(Servicio s){
        face.setServicio(s);
        setServicio(s);      
        listarFases();
        //System.out.println("Agregue el servicio "+ s.getNombre());
    }

    public void listarFases(){
        fases=fs.listarXServicio(servicio.getId());
    }
    
    public void agregarFase(){
       //orden=orden+1;
       //face.setPosicion(orden);
       //System.out.println(""+face.getPosicion());
        if(existefase(face)){
            FacesUtil.addErrorMessage("Ya existe la fase para este servicio");
        }else{
            fases.add(face);
            face=new Fase();
            face.setServicio(servicio);
        }
    }

    public boolean existefase(Fase f){
        boolean existe=false;
        for(Fase fa:fases){
            if(fa.getNombre().equals(f.getNombre())){
                existe=true;
            }
        }return existe;
    }
    
    public void guardarFases(){
        int orden=0;
        for(Fase f:fases){
            orden=orden+1;
            f.setPosicion(orden);
            fs.crear(f);
        }
    }
    
    public void agregarNom(){
        face.setNombre(nombre);
    }
    
    /**
     * @return the fases
     */
    public List<Fase> getFases() {
        return fases;
    }

    /**
     * @param fases the fases to set
     */
    public void setFases(List<Fase> fases) {
        this.fases = fases;
    }

    /**
     * @return the face
     */
    public Fase getFace() {
        return face;
    }

    /**
     * @param face the face to set
     */
    public void setFace(Fase face) {
        this.face = face;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
