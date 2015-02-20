/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.ImplDao;
import com.entity.TipoAutomovil;
import com.implDao.ITipoAutomovil;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class TipoAutomovilServices extends ImplDao<TipoAutomovil, Long> implements ITipoAutomovil,Serializable{
      public List<TipoAutomovil> listarXOrden(){
        List<TipoAutomovil> tipos=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from TipoAutomovil e order by nombre";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q);
        tipos=qu.getResultList();
        em.close();   
        return tipos;
    }
    
}
