package com.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Revision implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;	
        
        @ManyToOne
        CaracteristicasAuto caracteristicas;
	

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
}