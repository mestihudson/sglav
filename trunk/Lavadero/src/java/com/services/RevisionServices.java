/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.ImplDao;
import com.entity.Revision;
import com.implDao.IRevision;
import java.io.Serializable;

/**
 *
 * @author Jcmm
 */
public class RevisionServices extends ImplDao<Revision, Long> implements IRevision,Serializable{
    
}
