package com.teamcs.database.bean;
// Generated 14 juin 2015 18:30:48 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Caisse generated by hbm2java
 */
public class Caisse  implements java.io.Serializable {


     private Integer idCaisse;
     private Designation designation;
     private Geolocalisation geolocalisation;
     private Observation observation;
     private Secteur secteur;
     private Typecaisse typecaisse;
     private String affectataire;
     private String module;
     private String nominal;
     private String precisionsColis;
     private int valeur;
     private int iata;
     private int projection;
     private Set configurations = new HashSet(0);
     private Set estcontenudanses = new HashSet(0);

    public Caisse() {
    }

	
    public Caisse(Designation designation, Geolocalisation geolocalisation, Observation observation, Secteur secteur, Typecaisse typecaisse, String affectataire, String module, String nominal, String precisionsColis, int valeur, int iata, int projection) {
        this.designation = designation;
        this.geolocalisation = geolocalisation;
        this.observation = observation;
        this.secteur = secteur;
        this.typecaisse = typecaisse;
        this.affectataire = affectataire;
        this.module = module;
        this.nominal = nominal;
        this.precisionsColis = precisionsColis;
        this.valeur = valeur;
        this.iata = iata;
        this.projection = projection;
    }
    public Caisse(Designation designation, Geolocalisation geolocalisation, Observation observation, Secteur secteur, Typecaisse typecaisse, String affectataire, String module, String nominal, String precisionsColis, int valeur, int iata, int projection, Set configurations, Set estcontenudanses) {
       this.designation = designation;
       this.geolocalisation = geolocalisation;
       this.observation = observation;
       this.secteur = secteur;
       this.typecaisse = typecaisse;
       this.affectataire = affectataire;
       this.module = module;
       this.nominal = nominal;
       this.precisionsColis = precisionsColis;
       this.valeur = valeur;
       this.iata = iata;
       this.projection = projection;
       this.configurations = configurations;
       this.estcontenudanses = estcontenudanses;
    }
   
    public Integer getIdCaisse() {
        return this.idCaisse;
    }
    
    public void setIdCaisse(Integer idCaisse) {
        this.idCaisse = idCaisse;
    }
    public Designation getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(Designation designation) {
        this.designation = designation;
    }
    public Geolocalisation getGeolocalisation() {
        return this.geolocalisation;
    }
    
    public void setGeolocalisation(Geolocalisation geolocalisation) {
        this.geolocalisation = geolocalisation;
    }
    public Observation getObservation() {
        return this.observation;
    }
    
    public void setObservation(Observation observation) {
        this.observation = observation;
    }
    public Secteur getSecteur() {
        return this.secteur;
    }
    
    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
    public Typecaisse getTypecaisse() {
        return this.typecaisse;
    }
    
    public void setTypecaisse(Typecaisse typecaisse) {
        this.typecaisse = typecaisse;
    }
    public String getAffectataire() {
        return this.affectataire;
    }
    
    public void setAffectataire(String affectataire) {
        this.affectataire = affectataire;
    }
    public String getModule() {
        return this.module;
    }
    
    public void setModule(String module) {
        this.module = module;
    }
    public String getNominal() {
        return this.nominal;
    }
    
    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
    public String getPrecisionsColis() {
        return this.precisionsColis;
    }
    
    public void setPrecisionsColis(String precisionsColis) {
        this.precisionsColis = precisionsColis;
    }
    public int getValeur() {
        return this.valeur;
    }
    
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    public int getIata() {
        return this.iata;
    }
    
    public void setIata(int iata) {
        this.iata = iata;
    }
    public int getProjection() {
        return this.projection;
    }
    
    public void setProjection(int projection) {
        this.projection = projection;
    }
    public Set getConfigurations() {
        return this.configurations;
    }
    
    public void setConfigurations(Set configurations) {
        this.configurations = configurations;
    }
    public Set getEstcontenudanses() {
        return this.estcontenudanses;
    }
    
    public void setEstcontenudanses(Set estcontenudanses) {
        this.estcontenudanses = estcontenudanses;
    }




}


