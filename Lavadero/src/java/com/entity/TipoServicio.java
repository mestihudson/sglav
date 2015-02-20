package com.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoServicio implements Serializable{
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;
	private String descripcion;
	
        @OneToMany(mappedBy = "tipoServicio")
	public List<Automovil> automoviles;

    public TipoServicio(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        
    }

    public TipoServicio() {
    }

        
        
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}