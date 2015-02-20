/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.ImplDao;
import static com.dao.ImplDao.getEntityManagger;
import com.entity.Cubiculo;
import com.entity.Servicio;
import com.implDao.IServicio;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class ServicioServices extends ImplDao<Servicio, Long> implements IServicio,Serializable{
    
    
    public List<Servicio> listarXLavadero(Long a){
        List<Servicio> servicios=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from Servicio e where e.lavadero.id = ?1";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q)
                .setParameter(1, a);
        servicios=qu.getResultList();
        em.close();   
        return servicios;
    }
}
