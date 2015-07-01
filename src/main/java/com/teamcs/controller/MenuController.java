package com.teamcs.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.teamcs.app.ConnexionApp;
import com.teamcs.controller.common.MainController;
import com.teamcs.controller.common.NavigationController;
import java.net.URL;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chris_000
 */
public class MenuController implements Initializable {
    
    private Stage primaryStage;
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public MenuController() {

    }
    
    /**
     * METHODES BOUTONS COMMUNES
     */   
    
    @FXML
    public void itemProfilEditerAction(ActionEvent event) {  
        NavigationController.loadView(NavigationController.VIEW_PROFIL_EDITER);
    }

    @FXML
    public void itemProfilQuitterAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void itemMissionsConsulterAction(ActionEvent event) {
        
    }
    
    /**
     * METHODES BOUTONS Logisticien
     */
    
    @FXML
    private void itemAvionsConsulterAction(ActionEvent event) {
        NavigationController.loadView(NavigationController.VIEW_AVIONS_CONSULTER);
    }
    
    @FXML
    private void itemCaissesConsulterAction(ActionEvent event) {
        NavigationController.loadView(NavigationController.VIEW_CAISSES_CONSULTER);
    }
    
    @FXML
    private void itemMaterielConsulterAction(ActionEvent event) {
        NavigationController.loadView(NavigationController.VIEW_MATERIELS_CONSULTER);
    }
    
    @FXML
    private void itemMissionsProgrammerAction(ActionEvent event) {
        
    }
    
    /**
     * METHODES BOUTONS MEDECIN/INFIRMIER
     */
    
    @FXML
    private void itemMedicamentsConsulterAction(ActionEvent event) {
        NavigationController.loadView(NavigationController.VIEW_MEDICAMENTS_CONSULTER);
    }
    
    /**
     * METHODES BOUTONS PHARMACIEN
     */
    
    @FXML
    private void itemMedicamentsVerifierAction(ActionEvent event) {
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        primaryStage = NavigationController.getMainStage();
        primaryStage.setHeight(300.0);
        primaryStage.setWidth(300.0);
    }   
}
