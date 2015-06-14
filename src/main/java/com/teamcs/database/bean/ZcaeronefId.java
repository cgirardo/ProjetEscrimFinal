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
public class ZcaeronefId implements java.io.Serializable {
    
    private int idZoneChargement;
    private int idAeronef;
    
    public ZcaeronefId() {
    }

    public ZcaeronefId(int idZoneChargement, int idAeronef) {
        this.idZoneChargement = idZoneChargement;
        this.idAeronef = idAeronef;
    }

    public int getIdZoneChargement() {
        return idZoneChargement;
    }

    public void setIdZoneChargement(int idZoneChargement) {
        this.idZoneChargement = idZoneChargement;
    }

    public int getIdAeronef() {
        return idAeronef;
    }

    public void setIdAeronef(int idAeronef) {
        this.idAeronef = idAeronef;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idZoneChargement;
        hash = 47 * hash + this.idAeronef;
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
        final ZcaeronefId other = (ZcaeronefId) obj;
        if (this.idZoneChargement != other.idZoneChargement) {
            return false;
        }
        if (this.idAeronef != other.idAeronef) {
            return false;
        }
        return true;
    }
}
