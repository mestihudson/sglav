package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;

@Entity
@PrimaryKeyJoinColumn(name="ID")
public class Lavador extends Usuario implements Serializable{
	private String nombres;
	private String apellidos;
	private String identificacion;
	private String telefono;
	private String direccion;
	private String estadoLavadero;
	private int reputacion;
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaNacimiento;
        @ManyToOne
        private Lavadero lavadero;        
        @ManyToOne
	private Especialidad especialidad;
        @OneToMany(mappedBy = "lavador")
	public List<Lavado> lavado;

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setEstadoLavadero(String estadoLavadero) {
		this.estadoLavadero = estadoLavadero;
	}

	public String getEstadoLavadero() {
		return this.estadoLavadero;
	}

	public void setReputacion(int reputacion) {
		this.reputacion = reputacion;
	}

	public int getReputacion() {
		return this.reputacion;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

    /**
     * @return the especialidad
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
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