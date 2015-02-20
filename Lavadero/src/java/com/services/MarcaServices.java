/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.ImplDao;
import com.entity.CaracteristicasAuto;
import com.entity.Marca;
import com.entity.Municipio;
import com.implDao.ICaracteristicasAuto;
import com.implDao.IMarca;
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
public class MarcaServices extends ImplDao<Marca, Long> implements IMarca,Serializable{
     public List<Marca> listarXOrden(){
        List<Marca> marcas=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from Marca e order by nombre";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q);
        marcas=qu.getResultList();
        em.close();   
        return marcas;
    }
    
    
}
