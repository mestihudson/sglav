/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.controller.FacesUtil;
import com.dao.ImplDao;
import static com.dao.ImplDao.getEntityManagger;
import com.entity.Automovil;
import com.entity.Marca;
import com.implDao.IAutomovil;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class AutomovilServices extends ImplDao<Automovil, Long> implements IAutomovil,Serializable{

     public Automovil consultarXPlaca(String p){
        Automovil auto=new Automovil();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);        
        EntityTransaction et=em.getTransaction();
        try{        
        String q="select e from Automovil e where e.placa = ?1";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q)
                .setParameter(1, p);
        auto=(Automovil) qu.getSingleResult();
        }catch(Exception e){
            FacesUtil.addErrorMessage("Error en consulta de Resultados: "+e.getMessage());            
        }
        em.close();     
        return auto;
    }
    
     public List<Automovil> listarXPropietario(Long id){
        List<Automovil> automoviles=new LinkedList();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);
        em.getTransaction().begin();        
        String q="select e from Automovil e where e.propietario.id = ?1";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q);
        automoviles=qu.setParameter(1, id).getResultList();
        em.close();   
        return automoviles;
    }

     
}
