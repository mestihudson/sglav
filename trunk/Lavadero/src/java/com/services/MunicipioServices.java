/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.ImplDao;
import com.entity.CaracteristicasAuto;
import com.entity.Municipio;
import com.implDao.ICaracteristicasAuto;
import com.implDao.IMunicipio;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class MunicipioServices extends ImplDao<Municipio, Long> implements IMunicipio,Serializable{
     public List<Municipio> listarXOrden(){
        List<Municipio> municipios=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from Municipio e order by nomMun";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q);
        municipios=qu.getResultList();
        em.close();   
        return municipios;
    }
    
    
}
