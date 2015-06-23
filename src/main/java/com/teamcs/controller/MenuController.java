package com.teamcs.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.teamcs.controller.common.NavigationController;
import com.teamcs.database.bean.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chris_000
 */
public class MenuController implements Initializable {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public MenuController() {

    }
    
//    private ObservableList<Utilisateur> userData = FXCollections.observableArrayList();
//    
//    public ObservableList<Utilisateur> getUserData() {
//        return userData;
//    }
    
    @FXML private Stage stage;
    @FXML MenuBar myMenuBar;
    
    /**
     * METHODES BOUTONS COMMUNES
     */   
    
    @FXML private BorderPane myborder;
    
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
    private void itemCaissesVerifierAction(ActionEvent event) {
        
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
