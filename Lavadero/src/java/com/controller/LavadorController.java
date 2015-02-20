/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Especialidad;
import com.entity.Lavadero;
import com.entity.Lavador;
import com.services.EspecialidadServices;
import com.services.LavadorServices;
import com.utilidades.ImageUtils;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Jcmm
 */
@ManagedBean
@SessionScoped
public class LavadorController implements Serializable{
    private Lavadero lavadero=new Lavadero();
    private Lavador lavador=new Lavador();
    private List<Lavador> lavadores=new LinkedList();
    private String password;
    private List<Especialidad> especialidades=new LinkedList();
    LavadorServices ls=new LavadorServices();
    EspecialidadServices es=new EspecialidadServices();
    
    @ManagedProperty("#{usuarioController}")
    private UsuarioController usucon=new UsuarioController();
    
    
    /**
     * Creates a new instance of LavadorController
     */
    public LavadorController() {
    
    }
    
    public void anclarLavadero(Lavadero l){
        lavadero=l;
        ListarLavadores();
        listarEspecialidades();
        getUsucon().setPAGINAACTUALI("../Plantillas/menuAdministrador.xhtml");
        getUsucon().setPAGINAACTUALC("../Parametrizacion/GestionLavador.xhtml");
    }
    
    public void ListarLavadores(){
        setLavadores(ls.listarXLavadero(lavadero.getId()));
    }

    public void listarEspecialidades(){
        especialidades=es.consultarTodo(Especialidad.class);
        lavador.setEspecialidad(new Especialidad());
    }

    
    
     public void subirArchivo(FileUploadEvent event) {
        try {
            System.out.println("subire una imagen para "+lavador.getApellidos()+" "+lavador.getNombres());
            if(lavador.getIdentificacion()!=null){
               File destFile= new File(event.getFile().getFileName());
               System.out.println(destFile.getPath()+"  "+destFile.getName());
               ServletContext servletContext = (ServletContext) 
               FacesContext.getCurrentInstance().getExternalContext().getContext();
               String path=servletContext.getRealPath("/foto.jpeg").replace("foto.jpeg", "Imagenes\\Lavador\\");
               System.out.println(path);
               ImageUtils.copyFile(lavador.getIdentificacion()+".jpg", event.getFile().getInputstream(),path);
            }else{
                FacesUtil.addInfoMessage("Coloque el nombre de referencia de la Mercancia");
            }
        } catch (IOException ex) {
            Logger.getLogger(LavadorController.class.getName()).log(Level.SEVERE, null, ex);
        }	
    }
    
    public void registrar(){
        
        if(lavador.getPassword().equals(password)){
             lavador.setEstado(true);
             lavador.setEstadoLavadero("Libre");
             lavador.setPerfil("Lavador");
             lavador.setReputacion(5);             
             lavador.setLavadero(lavadero);
             //lavador.setEspecialidad(es.consultar(Especialidad.class, lavador.getEspecialidad().getId()));
             ls.crear(lavador);
             lavador=new Lavador();
         }else{
             FacesUtil.addErrorMessage("El password soministrado no coincide en su confirmacion");
         }
         
        
    }
    
    /**
     * @return the lavador
     */
    public Lavador getLavador() {
        return lavador;
    }

    /**
     * @param lavador the lavador to set
     */
    public void setLavador(Lavador lavador) {
        this.lavador = lavador;
    }

    /**
     * @return the lavadores
     */
    public List<Lavador> getLavadores() {
        return lavadores;
    }

    /**
     * @param lavadores the lavadores to set
     */
    public void setLavadores(List<Lavador> lavadores) {
        this.lavadores = lavadores;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the especialidades
     */
    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    /**
     * @param especialidades the especialidades to set
     */
    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
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
}
