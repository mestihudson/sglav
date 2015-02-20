/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.ImplDao;
import static com.dao.ImplDao.getEntityManagger;
import com.entity.Lavador;
import com.entity.Servicio;
import com.implDao.ILavador;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class LavadorServices extends ImplDao<Lavador, Long> implements ILavador,Serializable{
     public List<Lavador> listarXLavadero(Long a){
        List<Lavador> lavadores=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from Lavador e where e.lavadero.id = ?1";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q)
                .setParameter(1, a);
        lavadores=qu.getResultList();
        em.close();   
        return lavadores;
    }
}
