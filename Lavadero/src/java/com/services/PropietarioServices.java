/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.controller.FacesUtil;
import com.dao.ImplDao;
import static com.dao.ImplDao.getEntityManagger;
import com.entity.Propietario;
import com.implDao.IPropietario;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class PropietarioServices extends ImplDao<Propietario, Long> implements IPropietario,Serializable{
    public Propietario consultarXIdentificacion(String i){
        Propietario auto=new Propietario();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);        
        EntityTransaction et=em.getTransaction();
        try{        
        String q="select e from Propietario e where e.identificacion = ?1";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q)
                .setParameter(1, i);
        auto=(Propietario) qu.getSingleResult();
        }catch(Exception e){
            FacesUtil.addErrorMessage("Error en consulta de Resultados: "+e.getMessage());            
        }
        em.close();     
        return auto;
    }    
}
