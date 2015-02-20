// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(5) braces fieldsfirst noctor nonlb space lnc 
// Source File Name:   EntradaController.java

package com.controller;

import com.entity.Automovil;
import com.entity.Cliente;
import com.entity.Cubiculo;
import com.entity.EtapaLavado;
import com.entity.Fase;
import com.entity.Lavadero;
import com.entity.Lavado;
import com.entity.Lavador;
import com.entity.Servicio;
import com.services.AutomovilServices;
import com.services.ClienteServices;
import com.services.CubiculoServices;
import com.services.EtapaLavadoServices;
import com.services.FaseServices;
import com.services.LavaderoServices;
import com.services.LavadoServices;
import com.services.LavadorServices;
import com.services.ServicioServices;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EntradaController implements Serializable {
            Lavadero lavadero=new Lavadero();
            private Automovil auto;
            private Cliente cliente;
            private Lavado lavado;
            private String placa;
            private String identificacion;
            private boolean mosOAgregar;
            private boolean mosOAgregarA;
            private boolean mstCagregado;
            private boolean mstLagregado;
            private boolean mstCubagregado;
            
//            @ManagedProperty("#{usuarioController}")
//            private UsuarioController usucon=new UsuarioController();
                        
            
            private List<EtapaLavado> etapas=new LinkedList();
            private List<Fase> fases=new LinkedList();
            private List<Cubiculo> cubiculos=new LinkedList();
            private List<Servicio> servicios=new LinkedList();
            private List<Lavador> lavadores=new LinkedList();
            private List<Lavado> lavados=new LinkedList();
            
            
            AutomovilServices as;
            ClienteServices cs;
            CubiculoServices cubser;
            LavadoServices ls;
            EtapaLavadoServices els;
            ServicioServices ss;
            LavadorServices opes;
            
            public EntradaController() {
/*  24*/        auto = new Automovil();
/*  25*/        cliente = new Cliente();
/*  26*/        lavado = new Lavado();
/*  34*/        as = new AutomovilServices();
/*  35*/        cs = new ClienteServices();
                cubser=new CubiculoServices();
                els=new EtapaLavadoServices();
                ls=new LavadoServices();
                ss=new ServicioServices();
                opes=new LavadorServices();
               // lavados=ls.consultarTodo(Lavado.class);
                //cubiculosLavadero();
            }
            
           public void listarLavadosAutomovil(Automovil a,UsuarioController ucont){
                   lavados=ls.listarXAutomovil(a.getId());
                   ucont.setPAGINAACTUALC("../Procesos/LavadosCliente.xhtml");
           }
           
           public void listarLavadosCliente(Cliente a){
                   lavados=ls.listarXCliente(a.getId());
           }
           
            public void prepararLavado(Lavadero l,UsuarioController ucont){
                lavadero=l;
                cubiculosLavadero(lavadero);
                listarServicios();
                ListarLavadores(); 
                lavado.setAdministrador(l.getAdministrador());
               ucont.setPAGINAACTUALI("../Plantillas/menuAdministrador.xhtml");
               ucont.setPAGINAACTUALC("../Procesos/IniciarLavado.xhtml");
            }
            
             public void ListarLavadores(){
                setLavadores(opes.listarXLavadero(lavadero.getId()));
            }
            
            public void listarServicios(){                
                setServicios(ss.listarXLavadero(lavadero.getId()));
            }
            
            public void cubiculosLavadero(Lavadero l){
                //LavaderoServices ls=new LavaderoServices();                
                cubiculos=cubser.listarXLavadero(l.getId());        
                //getUsucon().verCubiculos();
            }
            
            public void consultar() {
                //liberarCliente();
/*  43*/        setAuto(as.consultarXPlaca(getPlaca()));
/*  44*/        if (auto.getPlaca() != null) {
/*  45*/            mosOAgregarA = false;
/*  46*/            getLavado().setAutomovil(auto);                    
                    Date hoy=Calendar.getInstance().getTime();
                    lavado.setFecha(hoy);
                    lavado.setHoraEntrada(hoy.getHours()+":"+hoy.getMinutes());
                } else {
/*  48*/            mosOAgregarA = true;
                }
            }
            
            public void agregarLavador(Lavador l){
                lavado.setLavador(l);                
                mstLagregado=true;
            }
            public void agregarCubiculo(Cubiculo c){
                //lavado.                
                etapas.get(0).setCubiculo(c);
                mstCubagregado=true;
            }
            
            public void agregarServicio(Servicio s){
                listarFases(s);
            }
            
            public void iniciarlavado(){
                if(etapas.size()>0){
                //lavado.setAdministrador(null);
                    Date hoy=Calendar.getInstance().getTime();                    
                    lavado.setHoraEntrada(hoy.getHours()+":"+hoy.getMinutes());                    
                    lavado.setLavadero(lavadero);
//                    lavado.setAdministrador(usucon.getAdmcon().getAdmin());
                    lavado.setEstado("poriniciar");
                    lavado=ls.modificar(lavado);                    
                    for(EtapaLavado el:etapas){
                        el.setLavado(lavado);                        
                        els.crear(el);
                    }
                    etapas=new LinkedList();
                    lavado=new Lavado();
                    auto=new Automovil();
                    listarLavadosEP(); 
                }else{
                    FacesUtil.addErrorMessage("Debes elegir un servicio para el lavado");
                }
            }
            
            public void listarLavadosEP(){
                lavados=ls.listarEnProceso(lavadero.getId());
            }
            
            
            
              public void listarFases(Servicio s){
                  etapas=new LinkedList();
                  FaseServices fs=new FaseServices();
                  fases=fs.listarXServicio(s.getId());
                  for(Fase f:fases){
                      EtapaLavado etapa=new EtapaLavado();
                      etapa.setFase(f);
                      etapa.setLavado(lavado);
                      etapa.setEstado("poriniciar"); 
                      etapas.add(etapa);
                  }
              }
            
            public void liberarCliente(){
                cliente = new Cliente();
                mstCagregado = true;
            }
            
            public void consultarCliente() {
/*  53*/        cliente = cs.consultarXIdentificacion(identificacion);
/*  54*/        if (cliente.getIdentificacion() != null) {
/*  55*/            mosOAgregar = true;
                } else {
/*  57*/            mosOAgregar = false;
                    FacesUtil.addErrorMessage("No existe este cliente en el sistema");
                }
            }

            public void asignarCliente() {
/*  62*/        agregarCliente(cliente);
            }

            public void agregarCliente() {
/*  66*/        formarUsuario(identificacion);
/*  67*/        cliente=cs.modificar(cliente);
/*  68*/        agregarCliente(cliente);
            }

            public void eselPropietario(){
                cliente=auto.getPropietario();
                agregarCliente(cliente);
            }
            public void otroLavador() {
/*  72*/        mstLagregado = false;
/*  73*/        //identificacion = "";
/*  74*/        lavado.setLavador(new Lavador());
            }
            public void otroCliente() {
/*  72*/        mstCagregado = false;
/*  73*/        identificacion = "";
/*  74*/        cliente = new Cliente();
            }

            public void agregarCliente(Cliente c) {
/*  78*/        getLavado().setCliente(cliente);
/*  79*/        mstCagregado = true;
            }

            public void formarUsuario(String ide) {
/*  83*/        cliente.setIdentificacion(ide);
/*  84*/        cliente.setPerfil("Cliente");
/*  85*/        cliente.setLogin((new StringBuilder()).append(cliente.getNombres().substring(0, 3)).append(cliente.getApellidos().substring(0, 3)).append(ide.substring(ide.length() - 3)).toString());
/*  86*/        cliente.setPassword(cliente.getIdentificacion());
/*  87*/        cliente.setEstado(true);
            }

            public String getPlaca() {
/*  95*/        return placa;
            }

            public void setPlaca(String placa) {
/* 102*/        this.placa = placa;
            }

            public Automovil getAuto() {
/* 109*/        return auto;
            }

            public void setAuto(Automovil auto) {
/* 116*/        this.auto = auto;
            }

            public Cliente getCliente() {
/* 123*/        return cliente;
            }

            public void setCliente(Cliente cliente) {
/* 130*/        this.cliente = cliente;
            }

            public String getIdentificacion() {
/* 137*/        return identificacion;
            }

            public void setIdentificacion(String identificacion) {
/* 144*/        this.identificacion = identificacion;
            }

            public boolean isMosOAgregar() {
/* 151*/        return mosOAgregar;
            }

            public void setMosOAgregar(boolean mosOAgregar) {
/* 158*/        this.mosOAgregar = mosOAgregar;
            }

            public boolean isMstCagregado() {
/* 165*/        return mstCagregado;
            }

            public void setMstCagregado(boolean mstCagregado) {
/* 172*/        this.mstCagregado = mstCagregado;
            }



            public boolean isMosOAgregarA() {
/* 193*/        return mosOAgregarA;
            }

            public void setMosOAgregarA(boolean mosOAgregarA) {
/* 200*/        this.mosOAgregarA = mosOAgregarA;
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
     * @return the mstLagregado
     */
    public boolean isMstLagregado() {
        return mstLagregado;
    }

    /**
     * @param mstLagregado the mstLagregado to set
     */
    public void setMstLagregado(boolean mstLagregado) {
        this.mstLagregado = mstLagregado;
    }

    /**
     * @return the etapas
     */
    public List<EtapaLavado> getEtapas() {
        return etapas;
    }

    /**
     * @param etapas the etapas to set
     */
    public void setEtapas(List<EtapaLavado> etapas) {
        this.etapas = etapas;
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
     * @return the cubiculos
     */
    public List<Cubiculo> getCubiculos() {
        return cubiculos;
    }

    /**
     * @param cubiculos the cubiculos to set
     */
    public void setCubiculos(List<Cubiculo> cubiculos) {
        this.cubiculos = cubiculos;
    }

    /**
     * @return the mstCubagregado
     */
    public boolean isMstCubagregado() {
        return mstCubagregado;
    }

    /**
     * @param mstCubagregado the mstCubagregado to set
     */
    public void setMstCubagregado(boolean mstCubagregado) {
        this.mstCubagregado = mstCubagregado;
    }

    /**
     * @return the usucon
     */
//    public UsuarioController getUsucon() {
//        return usucon;
//    }
//
//    /**
//     * @param usucon the usucon to set
//     */
//    public void setUsucon(UsuarioController usucon) {
//        this.usucon = usucon;
//    }

    /**
     * @return the servicios
     */
    public List<Servicio> getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
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
}
