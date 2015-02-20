package com.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class EtapaLavado implements Serializable{
   
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	private String estado;        
        @ManyToOne
	private Lavado lavado;
        @ManyToOne
	private Cubiculo cubiculo;
        @ManyToOne
	private Fase fase;
        private boolean habilitada;

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return this.estado;
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
     * @return the cubiculo
     */
    public Cubiculo getCubiculo() {
        return cubiculo;
    }

    /**
     * @param cubiculo the cubiculo to set
     */
    public void setCubiculo(Cubiculo cubiculo) {
        this.cubiculo = cubiculo;
    }

    /**
     * @return the fase
     */
    public Fase getFase() {
        return fase;
    }

    /**
     * @param fase the fase to set
     */
    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the habilitada
     */
    public boolean isHabilitada() {
        return habilitada;
    }

    /**
     * @param habilitada the habilitada to set
     */
    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }
}