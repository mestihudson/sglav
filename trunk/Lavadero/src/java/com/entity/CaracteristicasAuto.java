/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Jcmm
 */
@Entity
public class CaracteristicasAuto implements Serializable {
         
        @OneToOne
        private TipoAutomovil tipoauto;
        private String techo;
	private String parabrisas;
	private String retrovisorI;
	private String retrovisorD;
	private String limpiabrisasI;
	private String limpiabrisasD;
	private String capo;
	private String parrilla;
	private String luzdelanteraI;
	private String luzdelanteraD;
	private String placa;
	private String defensa;
	private String luzindicadoraI;
	private String luzindicadoraD;
	private String guardabarrosDI;
	private String guardabarrosDD;
	private String guardabarrosTI;
	private String guardabarrosTD;
	private String ruedaDI;
	private String ruedaDD;
	private String ruedaTI;
	private String ruedaTD;
	private String tapaCubosDI;
	private String tapacubosDD;
	private String tapaCubosTI;
	private String tapaCubosTD;
	private String ventanillaDI;
	private String ventanillaDD;
	private String ventanillaTI;
	private String ventanillaTD;
	private String lucesTI;
	private String lucesTD;
	private String coginDI;
	private String coginDD;
	private String coginT;
	private String tablero;
	private String baul;
	private String ventanillaT;
        private String compuerta;
        private String puertaTracera;
        
        @Id
        private Long id;
        @OneToMany(mappedBy = "caracteristicas")
        private List<Revision> revisions;


        public CaracteristicasAuto(TipoAutomovil tipoauto, String techo, String parabrisas, String retrovisorI, String retrovisorD, String limpiabrisasI, String limpiabrisasD, String capo, String parrilla, String luzdelanteraI, String luzdelanteraD, String placa, String defensa, String luzindicadoraI, String luzindicadoraD, String guardabarrosDI, String guardabarrosDD, String guardabarrosTI, String guardabarrosTD, String ruedaDI, String ruedaDD, String ruedaTI, String ruedaTD, String tapaCubosDI, String tapacubosDD, String tapaCubosTI, String tapaCubosTD, String ventanillaDI, String ventanillaDD, String ventanillaTI, String ventanillaTD, String lucesTI, String lucesTD, String coginDI, String coginDD, String coginT, String tablero, String baul, String ventanillaT, String compuerta) {
        this.tipoauto = tipoauto;
        this.techo = techo;
        this.parabrisas = parabrisas;
        this.retrovisorI = retrovisorI;
        this.retrovisorD = retrovisorD;
        this.limpiabrisasI = limpiabrisasI;
        this.limpiabrisasD = limpiabrisasD;
        this.capo = capo;
        this.parrilla = parrilla;
        this.luzdelanteraI = luzdelanteraI;
        this.luzdelanteraD = luzdelanteraD;
        this.placa = placa;
        this.defensa = defensa;
        this.luzindicadoraI = luzindicadoraI;
        this.luzindicadoraD = luzindicadoraD;
        this.guardabarrosDI = guardabarrosDI;
        this.guardabarrosDD = guardabarrosDD;
        this.guardabarrosTI = guardabarrosTI;
        this.guardabarrosTD = guardabarrosTD;
        this.ruedaDI = ruedaDI;
        this.ruedaDD = ruedaDD;
        this.ruedaTI = ruedaTI;
        this.ruedaTD = ruedaTD;
        this.tapaCubosDI = tapaCubosDI;
        this.tapacubosDD = tapacubosDD;
        this.tapaCubosTI = tapaCubosTI;
        this.tapaCubosTD = tapaCubosTD;
        this.ventanillaDI = ventanillaDI;
        this.ventanillaDD = ventanillaDD;
        this.ventanillaTI = ventanillaTI;
        this.ventanillaTD = ventanillaTD;
        this.lucesTI = lucesTI;
        this.lucesTD = lucesTD;
        this.coginDI = coginDI;
        this.coginDD = coginDD;
        this.coginT = coginT;
        this.tablero = tablero;
        this.baul = baul;
        this.ventanillaT = ventanillaT;
        this.compuerta = compuerta;
    }

    public CaracteristicasAuto() {
    }

        
        
        
    /**
     * @return the tipoauto
     */
    public TipoAutomovil getTipoauto() {
        return tipoauto;
    }

    /**
     * @param tipoauto the tipoauto to set
     */
    public void setTipoauto(TipoAutomovil tipoauto) {
        this.tipoauto = tipoauto;
    }

    /**
     * @return the techo
     */
    public String getTecho() {
        return techo;
    }

    /**
     * @param techo the techo to set
     */
    public void setTecho(String techo) {
        this.techo = techo;
    }

    /**
     * @return the parabrisas
     */
    public String getParabrisas() {
        return parabrisas;
    }

    /**
     * @param parabrisas the parabrisas to set
     */
    public void setParabrisas(String parabrisas) {
        this.parabrisas = parabrisas;
    }

    /**
     * @return the retrovisorI
     */
    public String getRetrovisorI() {
        return retrovisorI;
    }

    /**
     * @param retrovisorI the retrovisorI to set
     */
    public void setRetrovisorI(String retrovisorI) {
        this.retrovisorI = retrovisorI;
    }

    /**
     * @return the retrovisorD
     */
    public String getRetrovisorD() {
        return retrovisorD;
    }

    /**
     * @param retrovisorD the retrovisorD to set
     */
    public void setRetrovisorD(String retrovisorD) {
        this.retrovisorD = retrovisorD;
    }

    /**
     * @return the limpiabrisasI
     */
    public String getLimpiabrisasI() {
        return limpiabrisasI;
    }

    /**
     * @param limpiabrisasI the limpiabrisasI to set
     */
    public void setLimpiabrisasI(String limpiabrisasI) {
        this.limpiabrisasI = limpiabrisasI;
    }

    /**
     * @return the limpiabrisasD
     */
    public String getLimpiabrisasD() {
        return limpiabrisasD;
    }

    /**
     * @param limpiabrisasD the limpiabrisasD to set
     */
    public void setLimpiabrisasD(String limpiabrisasD) {
        this.limpiabrisasD = limpiabrisasD;
    }

    /**
     * @return the capo
     */
    public String getCapo() {
        return capo;
    }

    /**
     * @param capo the capo to set
     */
    public void setCapo(String capo) {
        this.capo = capo;
    }

    /**
     * @return the parrilla
     */
    public String getParrilla() {
        return parrilla;
    }

    /**
     * @param parrilla the parrilla to set
     */
    public void setParrilla(String parrilla) {
        this.parrilla = parrilla;
    }

    /**
     * @return the luzdelanteraI
     */
    public String getLuzdelanteraI() {
        return luzdelanteraI;
    }

    /**
     * @param luzdelanteraI the luzdelanteraI to set
     */
    public void setLuzdelanteraI(String luzdelanteraI) {
        this.luzdelanteraI = luzdelanteraI;
    }

    /**
     * @return the luzdelanteraD
     */
    public String getLuzdelanteraD() {
        return luzdelanteraD;
    }

    /**
     * @param luzdelanteraD the luzdelanteraD to set
     */
    public void setLuzdelanteraD(String luzdelanteraD) {
        this.luzdelanteraD = luzdelanteraD;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the defensa
     */
    public String getDefensa() {
        return defensa;
    }

    /**
     * @param defensa the defensa to set
     */
    public void setDefensa(String defensa) {
        this.defensa = defensa;
    }

    /**
     * @return the luzindicadoraI
     */
    public String getLuzindicadoraI() {
        return luzindicadoraI;
    }

    /**
     * @param luzindicadoraI the luzindicadoraI to set
     */
    public void setLuzindicadoraI(String luzindicadoraI) {
        this.luzindicadoraI = luzindicadoraI;
    }

    /**
     * @return the luzindicadoraD
     */
    public String getLuzindicadoraD() {
        return luzindicadoraD;
    }

    /**
     * @param luzindicadoraD the luzindicadoraD to set
     */
    public void setLuzindicadoraD(String luzindicadoraD) {
        this.luzindicadoraD = luzindicadoraD;
    }

    /**
     * @return the guardabarrosDI
     */
    public String getGuardabarrosDI() {
        return guardabarrosDI;
    }

    /**
     * @param guardabarrosDI the guardabarrosDI to set
     */
    public void setGuardabarrosDI(String guardabarrosDI) {
        this.guardabarrosDI = guardabarrosDI;
    }

    /**
     * @return the guardabarrosDD
     */
    public String getGuardabarrosDD() {
        return guardabarrosDD;
    }

    /**
     * @param guardabarrosDD the guardabarrosDD to set
     */
    public void setGuardabarrosDD(String guardabarrosDD) {
        this.guardabarrosDD = guardabarrosDD;
    }

    /**
     * @return the guardabarrosTI
     */
    public String getGuardabarrosTI() {
        return guardabarrosTI;
    }

    /**
     * @param guardabarrosTI the guardabarrosTI to set
     */
    public void setGuardabarrosTI(String guardabarrosTI) {
        this.guardabarrosTI = guardabarrosTI;
    }

    /**
     * @return the guardabarrosTD
     */
    public String getGuardabarrosTD() {
        return guardabarrosTD;
    }

    /**
     * @param guardabarrosTD the guardabarrosTD to set
     */
    public void setGuardabarrosTD(String guardabarrosTD) {
        this.guardabarrosTD = guardabarrosTD;
    }

    /**
     * @return the ruedaDI
     */
    public String getRuedaDI() {
        return ruedaDI;
    }

    /**
     * @param ruedaDI the ruedaDI to set
     */
    public void setRuedaDI(String ruedaDI) {
        this.ruedaDI = ruedaDI;
    }

    /**
     * @return the ruedaDD
     */
    public String getRuedaDD() {
        return ruedaDD;
    }

    /**
     * @param ruedaDD the ruedaDD to set
     */
    public void setRuedaDD(String ruedaDD) {
        this.ruedaDD = ruedaDD;
    }

    /**
     * @return the ruedaTI
     */
    public String getRuedaTI() {
        return ruedaTI;
    }

    /**
     * @param ruedaTI the ruedaTI to set
     */
    public void setRuedaTI(String ruedaTI) {
        this.ruedaTI = ruedaTI;
    }

    /**
     * @return the ruedaTD
     */
    public String getRuedaTD() {
        return ruedaTD;
    }

    /**
     * @param ruedaTD the ruedaTD to set
     */
    public void setRuedaTD(String ruedaTD) {
        this.ruedaTD = ruedaTD;
    }

    /**
     * @return the tapaCubosDI
     */
    public String getTapaCubosDI() {
        return tapaCubosDI;
    }

    /**
     * @param tapaCubosDI the tapaCubosDI to set
     */
    public void setTapaCubosDI(String tapaCubosDI) {
        this.tapaCubosDI = tapaCubosDI;
    }

    /**
     * @return the tapacubosDD
     */
    public String getTapacubosDD() {
        return tapacubosDD;
    }

    /**
     * @param tapacubosDD the tapacubosDD to set
     */
    public void setTapacubosDD(String tapacubosDD) {
        this.tapacubosDD = tapacubosDD;
    }

    /**
     * @return the tapaCubosTI
     */
    public String getTapaCubosTI() {
        return tapaCubosTI;
    }

    /**
     * @param tapaCubosTI the tapaCubosTI to set
     */
    public void setTapaCubosTI(String tapaCubosTI) {
        this.tapaCubosTI = tapaCubosTI;
    }

    /**
     * @return the tapaCubosTD
     */
    public String getTapaCubosTD() {
        return tapaCubosTD;
    }

    /**
     * @param tapaCubosTD the tapaCubosTD to set
     */
    public void setTapaCubosTD(String tapaCubosTD) {
        this.tapaCubosTD = tapaCubosTD;
    }

    /**
     * @return the ventanillaDI
     */
    public String getVentanillaDI() {
        return ventanillaDI;
    }

    /**
     * @param ventanillaDI the ventanillaDI to set
     */
    public void setVentanillaDI(String ventanillaDI) {
        this.ventanillaDI = ventanillaDI;
    }

    /**
     * @return the ventanillaDD
     */
    public String getVentanillaDD() {
        return ventanillaDD;
    }

    /**
     * @param ventanillaDD the ventanillaDD to set
     */
    public void setVentanillaDD(String ventanillaDD) {
        this.ventanillaDD = ventanillaDD;
    }

    /**
     * @return the ventanillaTI
     */
    public String getVentanillaTI() {
        return ventanillaTI;
    }

    /**
     * @param ventanillaTI the ventanillaTI to set
     */
    public void setVentanillaTI(String ventanillaTI) {
        this.ventanillaTI = ventanillaTI;
    }

    /**
     * @return the ventanillaTD
     */
    public String getVentanillaTD() {
        return ventanillaTD;
    }

    /**
     * @param ventanillaTD the ventanillaTD to set
     */
    public void setVentanillaTD(String ventanillaTD) {
        this.ventanillaTD = ventanillaTD;
    }

    /**
     * @return the lucesTI
     */
    public String getLucesTI() {
        return lucesTI;
    }

    /**
     * @param lucesTI the lucesTI to set
     */
    public void setLucesTI(String lucesTI) {
        this.lucesTI = lucesTI;
    }

    /**
     * @return the lucesTD
     */
    public String getLucesTD() {
        return lucesTD;
    }

    /**
     * @param lucesTD the lucesTD to set
     */
    public void setLucesTD(String lucesTD) {
        this.lucesTD = lucesTD;
    }

    /**
     * @return the coginDI
     */
    public String getCoginDI() {
        return coginDI;
    }

    /**
     * @param coginDI the coginDI to set
     */
    public void setCoginDI(String coginDI) {
        this.coginDI = coginDI;
    }

    /**
     * @return the coginDD
     */
    public String getCoginDD() {
        return coginDD;
    }

    /**
     * @param coginDD the coginDD to set
     */
    public void setCoginDD(String coginDD) {
        this.coginDD = coginDD;
    }

    /**
     * @return the coginT
     */
    public String getCoginT() {
        return coginT;
    }

    /**
     * @param coginT the coginT to set
     */
    public void setCoginT(String coginT) {
        this.coginT = coginT;
    }

    /**
     * @return the tablero
     */
    public String getTablero() {
        return tablero;
    }

    /**
     * @param tablero the tablero to set
     */
    public void setTablero(String tablero) {
        this.tablero = tablero;
    }

    /**
     * @return the baul
     */
    public String getBaul() {
        return baul;
    }

    /**
     * @param baul the baul to set
     */
    public void setBaul(String baul) {
        this.baul = baul;
    }

    /**
     * @return the ventanillaT
     */
    public String getVentanillaT() {
        return ventanillaT;
    }

    /**
     * @param ventanillaT the ventanillaT to set
     */
    public void setVentanillaT(String ventanillaT) {
        this.ventanillaT = ventanillaT;
    }

    /**
     * @return the compuerta
     */
    public String getCompuerta() {
        return compuerta;
    }

    /**
     * @param compuerta the compuerta to set
     */
    public void setCompuerta(String compuerta) {
        this.compuerta = compuerta;
    }

    /**
     * @return the puertaTracera
     */
    public String getPuertaTracera() {
        return puertaTracera;
    }

    /**
     * @param puertaTracera the puertaTracera to set
     */
    public void setPuertaTracera(String puertaTracera) {
        this.puertaTracera = puertaTracera;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
