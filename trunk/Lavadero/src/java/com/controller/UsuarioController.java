/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Administrador;
import com.entity.Lavadero;
import com.entity.Propietario;
import com.entity.Usuario;
import com.services.PropietarioServices;
import com.services.UsuarioServices;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jcmm
 */
@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {

    private Usuario usuario = new Usuario();
    private Propietario propietario = new Propietario();
    private String usu = new String();
    private String pasword = new String();

    @ManagedProperty("#{administradorController}")
    private AdministradorController admcon = new AdministradorController();
    @ManagedProperty("#{automovilController}")
    private AutomovilController autcon = new AutomovilController();
    @ManagedProperty("#{clienteController}")
    private ClienteController clicon = new ClienteController();
    @ManagedProperty("#{entradaController}")
    private EntradaController entcon = new EntradaController();

    UsuarioServices us = new UsuarioServices();
    PropietarioServices ps = new PropietarioServices();

    String PAGINALAVADERO = "../Procesos/LavaderosUsuario.xhtml";
    String PLAVADEROACTUAL = "../Parametrizacion/GestionLavadero.xhtml";
    String PGAUTOMOVIL = "../Parametrizacion/GestionAutomoviles.xhtml";
    String PCUBLAVADER = "../Procesos/CubiculosLavadero.xhtml";
    String PINSCRIPCION = "../Procesos/Inscripcion.xhtml";
    String MISAUTOS = "../Procesos/MisAutomoviles.xhtml";
    String MISLAVADOS = "../Procesos/MisLavados.xhtml";
    String LAVADOSCLIENTE = "../Procesos/LavadosCliente.xhtml";
    String GMAPLAVADEROS = "../Procesos/Gmap.xhtml";
    private String PAGINAACTUALI = "";
    private String PAGINAACTUALC = "";
    String MENUADMINISTRADOR = "../Plantillas/menuAdministrador.xhtml";

    private boolean mostPL = true;
    private boolean mostrarInscrip;
    private boolean mostrarPAI;

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
        mostPL = true;
    }

    public void inscribir() {
        verInscripcion();
        mostPL = false;
    }

    public void direcionarGPS() throws IOException {
        FacesContext contex = FacesContext.getCurrentInstance();
        contex.getExternalContext().redirect("Vistas/Procesos/Gmap.xhtml");
    }
     public void direcionarInscripcion() throws IOException {
        FacesContext contex = FacesContext.getCurrentInstance();
        contex.getExternalContext().redirect("Vistas/Procesos/Inscripcion.xhtml");
    }

    public void direcionarInicio() throws IOException {
        FacesContext contex = FacesContext.getCurrentInstance();
        contex.getExternalContext().redirect("../../index.xhtml");
        
    }

    public void escogerLavadero(Lavadero l) {
        getAdmcon().escogerLavadro(l);
        setPAGINAACTUALI(MENUADMINISTRADOR);
        setPAGINAACTUALC("");
        mostrarPAI = true;

    }

    public void iniciar() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = us.ingresar(getUsu(), getPasword());
        if (usuario != null) {
            if (usuario.getPerfil().equals("Administrador")) {
                getAdmcon().setAdmin(getAdmcon().adser.consultar(Administrador.class, usuario.getId()));
                getAdmcon().listarLavaderos(usuario.getId());
                //setPAGINAACTUALI(PAGINALAVADERO);
                setPAGINAACTUALC(PAGINALAVADERO);
                entcon.listarLavadosEP();
                mostrarInscrip = false;
                mostrarPAI = false;
            }
            if (usuario.getPerfil().equals("Cliente")) {
                propietario = ps.consultar(Propietario.class, usuario.getId());
                autcon.setPropietario(propietario);
                clicon.setCliente(propietario);
                autcon.listarAutomoviles(propietario.getId());
                clicon.listarLavadosCliente();
                PAGINAACTUALI = MISAUTOS;
                entcon.listarLavadosCliente(propietario);
                setPAGINAACTUALC(LAVADOSCLIENTE);
                mostrarPAI = true;
            }

            mostPL = false;
        } else {
            usuario = null;
            context.addMessage(null, new FacesMessage("Error de Autenticacion", "-" + "Usuario o Contraseña Incorrectos"));
        }

    }

    public void cerrar() {
        admcon = new AdministradorController();
        usuario = new Usuario();
        mostPL = true;
        getAdmcon().setLavaderos(new LinkedList());
        setPAGINAACTUALI("");
        setPAGINAACTUALC("");
    }

    public void verLavadero() {
        PAGINAACTUALC = PLAVADEROACTUAL;
    }

    public void verInscripcion() {
        PAGINAACTUALC = PINSCRIPCION;
    }

    public void verGAutomovil() {
        PAGINAACTUALC = PGAUTOMOVIL;
    }

    public void verCubiculos() {
        PAGINAACTUALI = PAGINALAVADERO;
        PAGINAACTUALC = PCUBLAVADER;
    }

    public void verEntrada() {
        setPAGINAACTUALC("../Procesos/Entrada.xhtml");
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the mostPL
     */
    public boolean isMostPL() {
        return mostPL;
    }

    /**
     * @param mostPL the mostPL to set
     */
    public void setMostPL(boolean mostPL) {
        this.mostPL = mostPL;
    }

    /**
     * @return the PAGINAACTUAL
     */
    public String getPAGINAACTUALI() {
        return PAGINAACTUALI;
    }

    /**
     * @param PAGINAACTUAL the PAGINAACTUAL to set
     */
    public void setPAGINAACTUALI(String PAGINAACTUAL) {
        this.PAGINAACTUALI = PAGINAACTUAL;
    }

    /**
     * @return the admcon
     */
    public AdministradorController getAdmcon() {
        return admcon;
    }

    /**
     * @param admcon the admcon to set
     */
    public void setAdmcon(AdministradorController admcon) {
        this.admcon = admcon;
    }

    /**
     * @return the PAGINAACTUALC
     */
    public String getPAGINAACTUALC() {
        return PAGINAACTUALC;
    }

    /**
     * @param PAGINAACTUALC the PAGINAACTUALC to set
     */
    public void setPAGINAACTUALC(String PAGINAACTUALC) {
        this.PAGINAACTUALC = PAGINAACTUALC;
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
     * @return the mostrarInscrip
     */
    public boolean isMostrarInscrip() {
        return mostrarInscrip;
    }

    /**
     * @param mostrarInscrip the mostrarInscrip to set
     */
    public void setMostrarInscrip(boolean mostrarInscrip) {
        this.mostrarInscrip = mostrarInscrip;
    }

    /**
     * @return the autcon
     */
    public AutomovilController getAutcon() {
        return autcon;
    }

    /**
     * @param autcon the autcon to set
     */
    public void setAutcon(AutomovilController autcon) {
        this.autcon = autcon;
    }

    /**
     * @return the mostrarPAI
     */
    public boolean isMostrarPAI() {
        return mostrarPAI;
    }

    /**
     * @param mostrarPAI the mostrarPAI to set
     */
    public void setMostrarPAI(boolean mostrarPAI) {
        this.mostrarPAI = mostrarPAI;
    }

    /**
     * @return the clicon
     */
    public ClienteController getClicon() {
        return clicon;
    }

    /**
     * @param clicon the clicon to set
     */
    public void setClicon(ClienteController clicon) {
        this.clicon = clicon;
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

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
