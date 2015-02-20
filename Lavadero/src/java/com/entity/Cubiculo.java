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
public class Cubiculo implements Serializable{
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String codigo;
	private String estadoUtilizacion;
        
        private double ancho;
        private double largo;
	private boolean estado;
        
        
        
        @ManyToOne
	private Lavadero lavadero;
        @ManyToOne
	private TipoCubiculo tipoCubiculo;

        @OneToMany(mappedBy = "cubiculo")
        private List<EtapaLavado> etapasLavado;
        
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setEstadoUtilizacion(String estadoUtilizacion) {
		this.estadoUtilizacion = estadoUtilizacion;
	}

	public String getEstadoUtilizacion() {
		return this.estadoUtilizacion;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isEstado() {
		return this.estado;
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
     * @return the tipoCubiculo
     */
    public TipoCubiculo getTipoCubiculo() {
        return tipoCubiculo;
    }

    /**
     * @param tipoCubiculo the tipoCubiculo to set
     */
    public void setTipoCubiculo(TipoCubiculo tipoCubiculo) {
        this.tipoCubiculo = tipoCubiculo;
    }

 

    /**
     * @return the ancho
     */
    public double getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the largo
     */
    public double getLargo() {
        return largo;
    }

    /**
     * @param largo the largo to set
     */
    public void setLargo(double largo) {
        this.largo = largo;
    }
}