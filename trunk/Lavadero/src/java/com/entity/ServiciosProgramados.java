package com.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ServiciosProgramados implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	
	private boolean estado;
	private boolean estadoConfirmacion;
        @ManyToOne
	private Programacion programacion;
        @ManyToOne
	private Servicio servicio;


	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isEstado() {
		return this.estado;
	}

	public void setEstadoConfirmacion(boolean estadoConfirmacion) {
		this.estadoConfirmacion = estadoConfirmacion;
	}

	public boolean isEstadoConfirmacion() {
		return this.estadoConfirmacion;
	}

    /**
     * @return the programacion
     */
    public Programacion getProgramacion() {
        return programacion;
    }

    /**
     * @param programacion the programacion to set
     */
    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
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