/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jcmm
 */
@Entity
@Table(name = "municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByCdep", query = "SELECT m FROM Municipio m WHERE m.cdep = :cdep"),
    @NamedQuery(name = "Municipio.findByCmun", query = "SELECT m FROM Municipio m WHERE m.cmun = :cmun"),
    @NamedQuery(name = "Municipio.findByCCenPo", query = "SELECT m FROM Municipio m WHERE m.cCenPo = :cCenPo"),
    @NamedQuery(name = "Municipio.findByNomDep", query = "SELECT m FROM Municipio m WHERE m.nomDep = :nomDep"),
    @NamedQuery(name = "Municipio.findByNomMun", query = "SELECT m FROM Municipio m WHERE m.nomMun = :nomMun")})
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Cdep")
    private Integer cdep;
    @Id
    @Basic(optional = false)
    @Column(name = "Cmun")
    private Integer cmun;
    @Column(name = "CCenPo")
    private Integer cCenPo;
    @Column(name = "NomDep")
    private String nomDep;
    @Column(name = "NomMun")
    private String nomMun;

    public Municipio() {
    }

    public Municipio(Integer cmun) {
        this.cmun = cmun;
    }

    public Integer getCdep() {
        return cdep;
    }

    public void setCdep(Integer cdep) {
        this.cdep = cdep;
    }

    public Integer getCmun() {
        return cmun;
    }

    public void setCmun(Integer cmun) {
        this.cmun = cmun;
    }

    public Integer getCCenPo() {
        return cCenPo;
    }

    public void setCCenPo(Integer cCenPo) {
        this.cCenPo = cCenPo;
    }

    public String getNomDep() {
        return nomDep;
    }

    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }

    public String getNomMun() {
        return nomMun;
    }

    public void setNomMun(String nomMun) {
        this.nomMun = nomMun;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cmun != null ? cmun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.cmun == null && other.cmun != null) || (this.cmun != null && !this.cmun.equals(other.cmun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Municipio[ cmun=" + cmun + " ]";
    }
    
}
