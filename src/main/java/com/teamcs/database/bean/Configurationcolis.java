/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.database.bean;

/**
 *
 * @author chris_000
 */
public class Configurationcolis implements java.io.Serializable {
    
    private ConfigurationcolisId id;
    private Configuration configuration;
    private Caisse caisse;

    public Configurationcolis() {
    }

    public Configurationcolis(ConfigurationcolisId id, Configuration configuration, Caisse caisse) {
        this.id = id;
        this.configuration = configuration;
        this.caisse = caisse;
    }

    public ConfigurationcolisId getId() {
        return id;
    }

    public void setId(ConfigurationcolisId id) {
        this.id = id;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Caisse getCaisse() {
        return caisse;
    }

    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
    }
}
