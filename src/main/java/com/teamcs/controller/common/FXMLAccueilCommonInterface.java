/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller.common;

import javafx.event.ActionEvent;

/**
 *
 * @author chris_000
 */
public interface FXMLAccueilCommonInterface {
    
    //Méthodes MenuBar - Menu Profil
    public void itemProfilEditerAction(ActionEvent event);
    public void itemProfilDeconnecterAction(ActionEvent event);
    public void itemProfilQuitterAction(ActionEvent event);
    //Méthode MenuBar - Menu Missions
    public void itemMissionsConsulterAction(ActionEvent event);
}
