/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.ImplDao;
import static com.dao.ImplDao.getEntityManagger;
import com.entity.Cubiculo;
import com.entity.Lavadero;
import com.implDao.ICubiculo;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class CubiculoServices extends ImplDao<Cubiculo, Long> implements ICubiculo,Serializable{
     public List<Cubiculo> listarXLavadero(Long a){
        List<Cubiculo> cubiculos=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from Cubiculo e where e.lavadero.id = ?1";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q)
                .setParameter(1, a);
        cubiculos=qu.getResultList();
        em.close();   
        return cubiculos;
    }

}
