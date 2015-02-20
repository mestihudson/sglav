package com.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class TipoAutomovil implements Serializable{
   
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;
	private String nombre;
	
        @OneToOne(mappedBy = "tipoauto")
        private CaracteristicasAuto caracteristicasAuto;
    
        
        @OneToMany(mappedBy = "tipoAutomovil")
	private List<Automovil> automoviles;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the caracteristicasAuto
     */
    public CaracteristicasAuto getCaracteristicasAuto() {
        return caracteristicasAuto;
    }

    /**
     * @param caracteristicasAuto the caracteristicasAuto to set
     */
    public void setCaracteristicasAuto(CaracteristicasAuto caracteristicasAuto) {
        this.caracteristicasAuto = caracteristicasAuto;
    }


}