/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller.common;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author chris_000
 */
public class FXMLAccueilCommonController implements FXMLAccueilCommonInterface {
    
    @Override
    @FXML
    public void itemProfilEditerAction(ActionEvent event) {
        
    }
    
    @Override
    @FXML
    public void itemProfilDeconnecterAction(ActionEvent event) {
        
    }
    
    @Override
    @FXML
    public void itemProfilQuitterAction(ActionEvent event) {
        System.exit(0);
    }

    @Override
    @FXML
    public void itemMissionsConsulterAction(ActionEvent event) {
        
    }
}
