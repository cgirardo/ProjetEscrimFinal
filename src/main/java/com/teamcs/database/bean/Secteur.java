package com.teamcs.database.bean;
// Generated 14 juin 2015 18:30:48 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Secteur generated by hbm2java
 */
public class Secteur  implements java.io.Serializable {


     private Integer idSecteur;
     private String libelleSecteur;
     private Set caisses = new HashSet(0);

    public Secteur() {
    }

	
    public Secteur(String libelleSecteur) {
        this.libelleSecteur = libelleSecteur;
    }
    public Secteur(String libelleSecteur, Set caisses) {
       this.libelleSecteur = libelleSecteur;
       this.caisses = caisses;
    }
   
    public Integer getIdSecteur() {
        return this.idSecteur;
    }
    
    public void setIdSecteur(Integer idSecteur) {
        this.idSecteur = idSecteur;
    }
    public String getLibelleSecteur() {
        return this.libelleSecteur;
    }
    
    public void setLibelleSecteur(String libelleSecteur) {
        this.libelleSecteur = libelleSecteur;
    }
    public Set getCaisses() {
        return this.caisses;
    }
    
    public void setCaisses(Set caisses) {
        this.caisses = caisses;
    }




}


