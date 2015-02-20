package com.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ServiciosLavado implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	
	private String estadoEjecucion;
        @ManyToOne
	private Lavado lavado;
        @ManyToOne
	private Servicio servicio;

	

	public void setEstadoEjecucion(String estadoEjecucion) {
		this.estadoEjecucion = estadoEjecucion;
	}

	public String getEstadoEjecucion() {
		return this.estadoEjecucion;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}