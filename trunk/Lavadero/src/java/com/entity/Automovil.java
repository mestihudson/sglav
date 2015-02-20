package com.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Automovil implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	private String placa;        
        @ManyToOne
	private Marca marca;	
        private int modelo;
	private String color;
	private String version;
	private String ciudad;
        private String estadoLavado;
        private String sistema;
	private String numeroPuertas;
	private String sistemaCombustible;
        @ManyToOne
	private TipoAutomovil tipoAutomovil;
        @ManyToOne
	private TipoServicio tipoServicio;        
        @ManyToOne
	private Propietario propietario;
        @OneToMany(mappedBy = "automovil")
	private List<Programacion> programaciones;

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return this.placa;
	}

	

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public int getModelo() {
		return this.modelo;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return "#"+this.color;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return this.version;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCiudad() {
		return this.ciudad;
	}

    /**
     * @return the tipoAutomovil
     */
    public TipoAutomovil getTipoAutomovil() {
        return tipoAutomovil;
    }

    /**
     * @param tipoAutomovil the tipoAutomovil to set
     */
    public void setTipoAutomovil(TipoAutomovil tipoAutomovil) {
        this.tipoAutomovil = tipoAutomovil;
    }

    /**
     * @return the tipoServicio
     */
    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    /**
     * @param tipoServicio the tipoServicio to set
     */
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the estadoLavado
     */
    public String getEstadoLavado() {
        return estadoLavado;
    }

    /**
     * @param estadoLavado the estadoLavado to set
     */
    public void setEstadoLavado(String estadoLavado) {
        this.estadoLavado = estadoLavado;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * @return the sistema
     */
    public String getSistema() {
        return sistema;
    }

    /**
     * @param sistema the sistema to set
     */
    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    /**
     * @return the numeroPuertas
     */
    public String getNumeroPuertas() {
        return numeroPuertas;
    }

    /**
     * @param numeroPuertas the numeroPuertas to set
     */
    public void setNumeroPuertas(String numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    /**
     * @return the sistemaCombustible
     */
    public String getSistemaCombustible() {
        return sistemaCombustible;
    }

    /**
     * @param sistemaCombustible the sistemaCombustible to set
     */
    public void setSistemaCombustible(String sistemaCombustible) {
        this.sistemaCombustible = sistemaCombustible;
    }
}