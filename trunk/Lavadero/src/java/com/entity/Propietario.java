package com.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="ID")
public class Propietario extends Cliente implements Serializable{
	private String direccion;
	private String ciudad;
	private String ocupacion;
        @OneToMany(mappedBy = "propietario")
	public List<Automovil> automoviles;
        @OneToMany(mappedBy = "propietario")
	public List<Programacion> programaciones;

	

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

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}
}