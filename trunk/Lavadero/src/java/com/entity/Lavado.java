package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Lavado implements Serializable{

        
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;
	private double valor;
	private String obsevaciones; 
	private String horaSalida;
        private String estado;//en proceso, finalizado, truncado,
        
	private boolean vistoBuenoAdministrador;
	private int vistoBuenoCliente;

        @Temporal(javax.persistence.TemporalType.DATE)
        private Date fecha;
	private String horaEntrada;

        @ManyToOne
	private Automovil automovil;
        
        @ManyToOne
	private Cliente cliente;
        
        @ManyToOne
        private Lavador lavador;
        
        @OneToOne
        private Revision revision;        
        
        @OneToOne
        private Programacion programacion;

        @ManyToOne
        private Administrador administrador;
        
        @ManyToOne
        private Lavadero lavadero;
        
        @OneToMany(mappedBy = "lavado",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
        private List<EtapaLavado> etapaLavados;
    
        
	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return this.valor;
	}

	public void setObsevaciones(String obsevaciones) {
		this.obsevaciones = obsevaciones;
	}

	public String getObsevaciones() {
		return this.obsevaciones;
	}

	

	public void setVistoBuenoAdministrador(boolean vistoBuenoAdministrador) {
		this.vistoBuenoAdministrador = vistoBuenoAdministrador;
	}

	public boolean isVistoBuenoAdministrador() {
		return this.vistoBuenoAdministrador;
	}

	public void setVistoBuenoCliente(int vistoBuenoCliente) {
		this.vistoBuenoCliente = vistoBuenoCliente;
	}

	public int getVistoBuenoCliente() {
		return this.vistoBuenoCliente;
	}

    
    /**
     * @return the administrador
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the horaEntrada
     */
    public String getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
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
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the lavador
     */
    public Lavador getLavador() {
        return lavador;
    }

    /**
     * @param lavador the lavador to set
     */
    public void setLavador(Lavador lavador) {
        this.lavador = lavador;
    }

    /**
     * @return the revision
     */
    public Revision getRevision() {
        return revision;
    }

    /**
     * @param revision the revision to set
     */
    public void setRevision(Revision revision) {
        this.revision = revision;
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
     * @return the horaSalida
     */
    public String getHoraSalida() {
        return horaSalida;
    }

    /**
     * @param horaSalida the horaSalida to set
     */
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    /**
     * @return the etapaLavados
     */
    public List<EtapaLavado> getEtapaLavados() {
        return etapaLavados;
    }

    /**
     * @param etapaLavados the etapaLavados to set
     */
    public void setEtapaLavados(List<EtapaLavado> etapaLavados) {
        this.etapaLavados = etapaLavados;
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

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}