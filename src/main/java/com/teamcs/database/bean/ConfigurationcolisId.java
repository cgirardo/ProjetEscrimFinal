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
public class ConfigurationcolisId implements java.io.Serializable {
    
    private int idConfiguration;
    private int idCaisse;
    
    public ConfigurationcolisId() {
    }

    public ConfigurationcolisId(int idConfiguration, int idCaisse) {
        this.idConfiguration = idConfiguration;
        this.idCaisse = idCaisse;
    }

    public int getIdConfiguration() {
        return idConfiguration;
    }

    public void setIdConfiguration(int idConfiguration) {
        this.idConfiguration = idConfiguration;
    }

    public int getIdCaisse() {
        return idCaisse;
    }

    public void setIdCaisse(int idCaisse) {
        this.idCaisse = idCaisse;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idConfiguration;
        hash = 83 * hash + this.idCaisse;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConfigurationcolisId other = (ConfigurationcolisId) obj;
        if (this.idConfiguration != other.idConfiguration) {
            return false;
        }
        if (this.idCaisse != other.idCaisse) {
            return false;
        }
        return true;
    }
}
