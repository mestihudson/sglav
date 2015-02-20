/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.ImplDao;
import static com.dao.ImplDao.getEntityManagger;
import com.entity.Cubiculo;
import com.entity.Lavado;
import com.implDao.ILavado;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class LavadoServices extends ImplDao<Lavado, Long> implements ILavado,Serializable{
    
       public List<Lavado> listarEnProceso(Long a){
        List<Lavado> lavados=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from Lavado e where e.lavadero.id = ?1 and e.estado != ?2";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q)
                .setParameter(1, a).setParameter(2, "terminado");
        lavados=qu.getResultList();
        em.close();   
        return lavados;
    }
     
       public List<Lavado> listarXAutomovil(Long c){
        List<Lavado> lavados=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from Lavado e where e.automovil.id = ?1";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q)
                .setParameter(1, c);
        lavados=qu.getResultList();
        em.close();   
        return lavados;
    }
       
     public List<Lavado> listarXCliente(Long c){
        List<Lavado> lavados=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from Lavado e where e.cliente.id = ?1";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q)
                .setParameter(1, c);
        lavados=qu.getResultList();
        em.close();   
        return lavados;
    }
     
    public List<Lavado> listarXLavador(Long a, Long l){
        List<Lavado> lavados=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from Lavado e where e.lavadero.id = ?1 and e.lavador.id = ?2";        
        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q)
                .setParameter(1, a).setParameter(2, l);
        lavados=qu.getResultList();
        em.close();   
        return lavados;
    }
     
    
}
