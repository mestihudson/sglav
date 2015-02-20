package com.entity;

import com.entity.Administrador;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Programacion implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date fecha;
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date hora;
	private String estado;
	private boolean estadoActivo;
        @ManyToOne
	private Automovil automovil;
        @ManyToOne
	private Propietario propietario;
        @ManyToOne
	private Administrador administrado;                
        
        @OneToMany(mappedBy = "programacion")
	private List<ServiciosProgramados> serviciosProgramados;

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Date getHora() {
		return this.hora;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstadoActivo(boolean estadoActivo) {
		this.estadoActivo = estadoActivo;
	}

	public boolean isEstadoActivo() {
		return this.estadoActivo;
	}

    /**
     * @return the automovil
     */
    public Automovil getAutomovil() {
        return automovil;
    }

    /**
     * @param automovil the automovil to set
     */
    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
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
     * @return the administrado
     */
    public Administrador getAdministrado() {
        return administrado;
    }

    /**
     * @param administrado the administrado to set
     */
    public void setAdministrado(Administrador administrado) {
        this.administrado = administrado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  

    /**
     * @return the serviciosProgramados
     */
    public List<ServiciosProgramados> getServiciosProgramados() {
        return serviciosProgramados;
    }

    /**
     * @param serviciosProgramados the serviciosProgramados to set
     */
    public void setServiciosProgramados(List<ServiciosProgramados> serviciosProgramados) {
        this.serviciosProgramados = serviciosProgramados;
    }
}