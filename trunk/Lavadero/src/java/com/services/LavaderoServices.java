/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.ImplDao;
import static com.dao.ImplDao.getEntityManagger;
import com.entity.Lavadero;
import com.implDao.ILavadero;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class LavaderoServices extends ImplDao<Lavadero, Long> implements ILavadero,Serializable{
    
     public List<Lavadero> listarXAdministrador(Long a){
        List<Lavadero> lavaderos=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from Lavadero e where e.administrador.id = ?1";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q)
                .setParameter(1, a);
        lavaderos=qu.getResultList();
        em.close();   
        return lavaderos;
    }
    
    
}
