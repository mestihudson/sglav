package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;

@Entity
@PrimaryKeyJoinColumn(name="ID")
public class Administrador extends Usuario implements Serializable{
	private String nombres;
	private String apellidos;
	private String identificacion;
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaNacimiento;
	private String direccion;
	private String ciudad;
	private String telefono;
        
        @OneToMany(mappedBy = "administrado")
	public List<Programacion> programaciones;
        @OneToMany(mappedBy = "administrador")        
        public List<Lavado> lavados;
        @OneToMany(mappedBy = "administrador")
	public List<Lavadero> lavaderos;

	

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

	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono() {
		return this.telefono;
	}

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}