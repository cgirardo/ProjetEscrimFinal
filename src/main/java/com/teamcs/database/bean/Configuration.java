package com.teamcs.database.bean;
// Generated 14 juin 2015 18:30:48 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Configuration generated by hbm2java
 */
public class Configuration  implements java.io.Serializable {


     private Integer idConfiguration;
     private String libelleConfiguration;
     private String parametreConfiguration;
     private Set caisses = new HashSet(0);
     private Set configurationaeronefs = new HashSet(0);

    public Configuration() {
    }

	
    public Configuration(String libelleConfiguration, String parametreConfiguration) {
        this.libelleConfiguration = libelleConfiguration;
        this.parametreConfiguration = parametreConfiguration;
    }
    public Configuration(String libelleConfiguration, String parametreConfiguration, Set caisses, Set configurationaeronefs) {
       this.libelleConfiguration = libelleConfiguration;
       this.parametreConfiguration = parametreConfiguration;
       this.caisses = caisses;
       this.configurationaeronefs = configurationaeronefs;
    }
   
    public Integer getIdConfiguration() {
        return this.idConfiguration;
    }
    
    public void setIdConfiguration(Integer idConfiguration) {
        this.idConfiguration = idConfiguration;
    }
    public String getLibelleConfiguration() {
        return this.libelleConfiguration;
    }
    
    public void setLibelleConfiguration(String libelleConfiguration) {
        this.libelleConfiguration = libelleConfiguration;
    }
    public String getParametreConfiguration() {
        return this.parametreConfiguration;
    }
    
    public void setParametreConfiguration(String parametreConfiguration) {
        this.parametreConfiguration = parametreConfiguration;
    }
    public Set getCaisses() {
        return this.caisses;
    }
    
    public void setCaisses(Set caisses) {
        this.caisses = caisses;
    }
    public Set getConfigurationaeronefs() {
        return this.configurationaeronefs;
    }
    
    public void setConfigurationaeronefs(Set configurationaeronefs) {
        this.configurationaeronefs = configurationaeronefs;
    }




}


