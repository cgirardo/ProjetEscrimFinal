package com.teamcs.database.bean;
// Generated 14 juin 2015 18:30:48 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Contenu generated by hbm2java
 */
public class Contenu  implements java.io.Serializable {


     private Integer idContenu;
     private String libelleContenu;
     private Set estcontenudanses = new HashSet(0);

    public Contenu() {
    }

	
    public Contenu(String libelleContenu) {
        this.libelleContenu = libelleContenu;
    }
    public Contenu(String libelleContenu, Set estcontenudanses) {
       this.libelleContenu = libelleContenu;
       this.estcontenudanses = estcontenudanses;
    }
   
    public Integer getIdContenu() {
        return this.idContenu;
    }
    
    public void setIdContenu(Integer idContenu) {
        this.idContenu = idContenu;
    }
    public String getLibelleContenu() {
        return this.libelleContenu;
    }
    
    public void setLibelleContenu(String libelleContenu) {
        this.libelleContenu = libelleContenu;
    }
    public Set getEstcontenudanses() {
        return this.estcontenudanses;
    }
    
    public void setEstcontenudanses(Set estcontenudanses) {
        this.estcontenudanses = estcontenudanses;
    }




}


