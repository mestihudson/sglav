/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Cubiculo;
import com.entity.EtapaLavado;
import com.entity.Lavadero;
import com.entity.Lavado;
import com.services.EtapaLavadoServices;
import com.services.LavadoServices;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
public class ProcesoLavado implements Serializable{

    private Lavado lavado=new Lavado();
    private EtapaLavado etapa=new EtapaLavado();
    
    String PROCESOlAVADO="../Procesos/VerificarLavado.xhtml";
    String CONSULTAlAVADO="../Procesos/ConsultarLavado.xhtml";
    
    
    @ManagedProperty("#{usuarioController}")
    private UsuarioController usucon=new UsuarioController();
    @ManagedProperty("#{entradaController}")
    private EntradaController entcon=new EntradaController();
    
    LavadoServices lavs=new LavadoServices();
    EtapaLavadoServices etls=new EtapaLavadoServices();
    
    private boolean mostEtapa;
    
    /**
     * Creates a new instance of ProcesoLavado
     */
    public ProcesoLavado() {

    }

    public void agregarCubiculo(Cubiculo c){
                etapa.setCubiculo(c);    
    }
    
    public void escogerEtapa(EtapaLavado eta){
        etapa=eta;
        mostEtapa=true;                
    }
    
    
    
    
    public boolean esUltima(EtapaLavado et){
      boolean esult=false;    
      int r=lavado.getEtapaLavados().size()-lavado.getEtapaLavados().indexOf(et);    
        System.out.println(lavado.getEtapaLavados().size()+" "+lavado.getEtapaLavados().indexOf(et));
         if(r==1){
              esult=true;                
         }
       return esult;        
    }
    
    public void finalizarEtapa(EtapaLavado eta){
        eta.setEstado("terminado");               
        if(esUltima(eta)){            
            lavado.setEstado("terminado");
            actualizarLavado();
        }
        etls.modificar(eta);
    }

    
    public void actualizarEstapa(){
        etapa.setEstado("iniciado");
        lavado.setEstado("enproceso");
        etapa=etls.modificar(etapa);
        lavado=lavs.modificar(lavado);
        mostEtapa=false;
    }    
    
    public void terminarLavado(){
        for(EtapaLavado et:lavado.getEtapaLavados()){
            et.setEstado("terminado");
            etls.modificar(et);
        }
        lavado.setEstado("terminado");
        actualizarLavado();
    }    
    
    public void actualizarLavado(){
        Date hoy=Calendar.getInstance().getTime();                    
        lavado.setHoraSalida(hoy.getHours()+":"+hoy.getMinutes());                    
        lavado.setObsevaciones("Sin Novedades");
        lavado.setVistoBuenoAdministrador(true);
        lavado.setVistoBuenoCliente(5);
        lavado.setValor(lavado.getEtapaLavados().get(0).getFase().getServicio().getPrecio());
        lavado=lavs.modificar(lavado);
    }
    
    public boolean estaIniciado(EtapaLavado eta){
        if(eta.getEstado().equals("iniciado")){
            return true;
        }else{
            return false;
        }
    }
    
    public void anclarLavado(Lavado l){
        lavado=l;
        entcon.cubiculosLavadero(lavado.getLavadero());
        usucon.setPAGINAACTUALI("../Plantillas/menuAdministrador.xhtml");
        usucon.setPAGINAACTUALC(PROCESOlAVADO);
    }
    
       
    public void verLavado(Lavado l){
        lavado=l;
        //entcon.cubiculosLavadero(lavado.getLavadero());
        usucon.setPAGINAACTUALI("../Procesos/MisAutomoviles.xhtml");
        usucon.setPAGINAACTUALC(CONSULTAlAVADO);
    }
    
    
    /**
     * @return the lavado
     */
    public Lavado getLavado() {
        return lavado;
    }

    /**
     * @param lavado the lavado to set
     */
    public void setLavado(Lavado lavado) {
        this.lavado = lavado;
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

    /**
     * @return the etapa
     */
    public EtapaLavado getEtapa() {
        return etapa;
    }

    /**
     * @param etapa the etapa to set
     */
    public void setEtapa(EtapaLavado etapa) {
        this.etapa = etapa;
    }

    /**
     * @return the mostEtapa
     */
    public boolean isMostEtapa() {
        return mostEtapa;
    }

    /**
     * @param mostEtapa the mostEtapa to set
     */
    public void setMostEtapa(boolean mostEtapa) {
        this.mostEtapa = mostEtapa;
    }

    /**
     * @return the entcon
     */
    public EntradaController getEntcon() {
        return entcon;
    }

    /**
     * @param entcon the entcon to set
     */
    public void setEntcon(EntradaController entcon) {
        this.entcon = entcon;
    }
}
