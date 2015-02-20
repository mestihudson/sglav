/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Automovil;
import com.entity.Marca;
import com.entity.Municipio;
import com.entity.Propietario;
import com.entity.TipoAutomovil;
import com.entity.TipoServicio;
import com.services.AutomovilServices;
import com.services.MarcaServices;
import com.services.MunicipioServices;
import com.services.PropietarioServices;
import com.services.TipoAutomovilServices;
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
public class AutomovilController implements Serializable{

    private Automovil auto=new Automovil();
    private Propietario propietario=new Propietario();
    
    
    private List<Municipio> municipios=new LinkedList();
    private List<TipoAutomovil> tiposAutomovil=new LinkedList();
    private List<Marca> marcas=new LinkedList();
    private List<Integer> puertas=new LinkedList();
    private List<Automovil> automoviles=new LinkedList();
    
//    @ManagedProperty("#{usuarioController}")
//    private UsuarioController usucon=new UsuarioController();

    private String password;
    private boolean sigPanel;
    private boolean verResumen;
    
    
    
    /**
     * Creates a new instance of AutomovilController
     */
    PropietarioServices ps=new PropietarioServices();
    MunicipioServices ms=new MunicipioServices();
    MarcaServices mars=new MarcaServices();
    TipoAutomovilServices tas=new TipoAutomovilServices();
    AutomovilServices as=new AutomovilServices();
    
    public AutomovilController() {
        listarMunicipios();
        listarMarcas();
        listarTiposA();
        listarPuertas();
    }

    public void agregarPropietario(){
        if(propietario.getPassword().equals(password)){
            //sigPanel=true;            
            Propietario pro=ps.consultarXIdentificacion(propietario.getIdentificacion());
            if(pro!=null){
                propietario=pro;
                FacesUtil.addInfoMessage("ya existe el propietario cliente "+pro.getNombres()+" "+pro.getApellidos());
            }else{
                propietario.setPerfil("Cliente");
                propietario=ps.modificar(propietario);
                auto.setPropietario(propietario);
            }
            //usucon.setUsuario(propietario);
            //usucon.setMostPL(false);             
        }else{
            FacesUtil.addErrorMessage("la confirmacion del password no concuerda..");
        }
    }
    
    public void listarPuertas(){
        for(int i=2;i<7;i++){
            puertas.add(i);
        }
    }

    public void agregarMarca(Marca m){
        auto.setMarca(m);
    }
    
    public void listarAutomoviles(Long id){
        setAutomoviles(as.listarXPropietario(id));
    }
    
    public void agregarTipo(TipoAutomovil t){
        auto.setTipoAutomovil(t);
    }
    
    public void agregarNP(String np){
        auto.setNumeroPuertas(np);
    }
            
    public void registrar(){
//        Automovil aut=as.consultarXPlaca(auto.getPlaca());
//        if(aut!=null){
//            auto=aut;
//            auto.setPropietario(propietario);
//            auto.setEstadoLavado("LIBRE"); 
//            auto.setTipoServicio(new TipoServicio(Long.parseLong("2"),"PRIVADO"));
//            auto=as.modificar(auto);                    
//        }else{
            auto.setPropietario(propietario);
            auto.setEstadoLavado("LIBRE"); 
            auto.setTipoServicio(new TipoServicio(Long.parseLong("2"),"PRIVADO"));
            auto=as.modificar(auto);                    
////        }
////        verResumen=true;
        listarAutomoviles(propietario.getId());
    }        
    
    public void listarMunicipios(){
        municipios=ms.listarXOrden();
    }
    public void listarTiposA(){
        tiposAutomovil=tas.listarXOrden();
    }
    public void listarMarcas(){
        marcas=mars.listarXOrden();
    }
            
    
    /**
     * @return the municipios
     */
    public List<Municipio> getMunicipios() {
        return municipios;
    }

    /**
     * @param municipios the municipios to set
     */
    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    /**
     * @return the auto
     */
    public Automovil getAuto() {
        return auto;
    }

    /**
     * @param auto the auto to set
     */
    public void setAuto(Automovil auto) {
        this.auto = auto;
    }

    /**
     * @return the marcas
     */
    public List<Marca> getMarcas() {
        return marcas;
    }

    /**
     * @param marcas the marcas to set
     */
    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    /**
     * @return the tiposAutomovil
     */
    public List<TipoAutomovil> getTiposAutomovil() {
        return tiposAutomovil;
    }

    /**
     * @param tiposAutomovil the tiposAutomovil to set
     */
    public void setTiposAutomovil(List<TipoAutomovil> tiposAutomovil) {
        this.tiposAutomovil = tiposAutomovil;
    }

    /**
     * @return the puertas
     */
    public List<Integer> getPuertas() {
        return puertas;
    }

    /**
     * @param puertas the puertas to set
     */
    public void setPuertas(List<Integer> puertas) {
        this.puertas = puertas;
    }


    /**
     * @return the propietario
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
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
     * @return the sigPanel
     */
    public boolean isSigPanel() {
        return sigPanel;
    }

    /**
     * @param sigPanel the sigPanel to set
     */
    public void setSigPanel(boolean sigPanel) {
        this.sigPanel = sigPanel;
    }

    /**
     * @return the verResumen
     */
    public boolean isVerResumen() {
        return verResumen;
    }

    /**
     * @param verResumen the verResumen to set
     */
    public void setVerResumen(boolean verResumen) {
        this.verResumen = verResumen;
    }

    /**
     * @return the automoviles
     */
    public List<Automovil> getAutomoviles() {
        return automoviles;
    }

    /**
     * @param automoviles the automoviles to set
     */
    public void setAutomoviles(List<Automovil> automoviles) {
        this.automoviles = automoviles;
    }
}
