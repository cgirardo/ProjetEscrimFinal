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
public class Zcaeronef implements java.io.Serializable {
    
    private ZcaeronefId id;
    private Zonechargement zoneChargement;
    private Aeronef aeronef;

    public Zcaeronef() {
    }

    public Zcaeronef(ZcaeronefId id, Zonechargement zoneChargement, Aeronef aeronef) {
        this.id = id;
        this.zoneChargement = zoneChargement;
        this.aeronef = aeronef;
    }

    public ZcaeronefId getId() {
        return id;
    }

    public void setId(ZcaeronefId id) {
        this.id = id;
    }

    public Zonechargement getZoneChargement() {
        return zoneChargement;
    }

    public void setZoneChargement(Zonechargement zoneChargement) {
        this.zoneChargement = zoneChargement;
    }

    public Aeronef getAeronef() {
        return aeronef;
    }

    public void setAeronef(Aeronef aeronef) {
        this.aeronef = aeronef;
    }
}
