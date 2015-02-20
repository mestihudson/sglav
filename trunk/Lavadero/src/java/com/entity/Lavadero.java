package com.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Lavadero implements Serializable{
    @OneToMany(mappedBy = "lavadero")
    private List<Lavado> lavados;
    @OneToMany(mappedBy = "lavadero")
    private List<Lavador> lavadors;
    @OneToMany(mappedBy = "lavadero")
    private List<Servicio> servicios;

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name="ID")
        private Long id;
	private String nit;
	private String nombre;
	private String direccion;
	private String email;
	private String telefono;	
	private double corrdenadax;
	private double corrdenaday;
	private String ciudad;
	private String estado;
        
        @ManyToOne
	private Administrador administrador;
        
        @OneToMany(mappedBy = "lavadero")
	public List<Cubiculo> cubiculos;

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono() {
		return this.telefono;
	}

	
	public void setCorrdenadax(double corrdenadax) {
		this.corrdenadax = corrdenadax;
	}

	public double getCorrdenadax() {
		return this.corrdenadax;
	}

	public void setCorrdenaday(double corrdenaday) {
		this.corrdenaday = corrdenaday;
	}

	public double getCorrdenaday() {
		return this.corrdenaday;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return this.estado;
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
}