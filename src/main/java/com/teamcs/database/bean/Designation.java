package com.teamcs.database.bean;
// Generated 8 juin 2015 21:32:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Designation generated by hbm2java
 */
public class Designation  implements java.io.Serializable {

    private Integer idDesignation;
    private String libelleDesignation;
    private Set caisses = new HashSet(0);

    public Designation() {
    }
	
    public Designation(String libelleDesignation) {
        this.libelleDesignation = libelleDesignation;
    }
    
    public Designation(String libelleDesignation, Set caisses) {
       this.libelleDesignation = libelleDesignation;
       this.caisses = caisses;
    }
   
    public Integer getIdDesignation() {
        return this.idDesignation;
    }
    
    public void setIdDesignation(Integer idDesignation) {
        this.idDesignation = idDesignation;
    }
    public String getLibelleDesignation() {
        return this.libelleDesignation;
    }
    
    public void setLibelleDesignation(String libelleDesignation) {
        this.libelleDesignation = libelleDesignation;
    }
    public Set getCaisses() {
        return this.caisses;
    }
    
    public void setCaisses(Set caisses) {
        this.caisses = caisses;
    }
}

