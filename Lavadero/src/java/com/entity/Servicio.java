package com.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Servicio implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	
	private String descripcion;
	private double precio;
	private String nombre;
	private boolean estado;
	private boolean programable;
	private String duracionPromedio;
        @ManyToOne
        private Lavadero lavadero;
        @OneToMany(mappedBy = "servicio")
	private List<ServiciosLavado> serviciosLavado;
        @OneToMany(mappedBy = "servicio")
	private List<ServiciosProgramados> serviciosProgramados;
        @OneToMany(mappedBy = "servicio")
	private List<Fase> fases;

	

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isEstado() {
		return this.estado;
	}

	public void setProgramable(boolean programable) {
		this.programable = programable;
	}

	public boolean isProgramable() {
		return this.programable;
	}

	

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the duracionPromedio
     */
    public String getDuracionPromedio() {
        return duracionPromedio;
    }

    /**
     * @param duracionPromedio the duracionPromedio to set
     */
    public void setDuracionPromedio(String duracionPromedio) {
        this.duracionPromedio = duracionPromedio;
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
}