/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.controller.FacesUtil;
import com.dao.ImplDao;
import com.entity.Cliente;
import com.implDao.ICliente;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class ClienteServices extends ImplDao<Cliente, Long> implements ICliente,Serializable{
    
    public Cliente consultarXIdentificacion(String i){
        Cliente auto=new Cliente();
        EntityManager em =getEntityManagger();
        //System.out.println(l+" y contraceña: "+c);        
        EntityTransaction et=em.getTransaction();
        try{        
        String q="select e from Cliente e where e.identificacion = ?1";        
        System.out.println(" Consulta: "+q);
        Query qu=em.createQuery(q)
                .setParameter(1, i);
        auto=(Cliente) qu.getSingleResult();
        }catch(Exception e){
            FacesUtil.addErrorMessage("Error en consulta de Resultados: "+e.getMessage());            
        }
        em.close();     
        return auto;
    }
}
