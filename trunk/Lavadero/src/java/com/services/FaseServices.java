/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.ImplDao;
import com.entity.Fase;
import com.implDao.IFase;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class FaseServices extends ImplDao<Fase, Long> implements IFase,Serializable{
 
    public List<Fase> listarXServicio(Long a){
        List<Fase> fases=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from Fase e where e.servicio.id = ?1";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q)
                .setParameter(1, a);
        fases=qu.getResultList();
        em.close();   
        return fases;
    }
    
}
