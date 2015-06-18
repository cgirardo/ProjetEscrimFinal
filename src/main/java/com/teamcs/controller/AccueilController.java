package com.teamcs.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.teamcs.app.ConnexionApp;
import com.teamcs.controller.common.NavigationController;
import com.teamcs.database.bean.Utilisateur;
import com.teamcs.service.UtilisateurService;
import com.teamcs.service.impl.UtilisateurServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chris_000
 */
public class AccueilController implements Initializable {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public AccueilController() {

    }
    
    private ObservableList<Utilisateur> userData = FXCollections.observableArrayList();
    
    public ObservableList<Utilisateur> getUserData() {
        return userData;
    }
    
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
    public void itemProfilDeconnecterAction(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(ConnexionApp.class.getResource("/fxml/Connexion.fxml"));
//            AnchorPane page = (AnchorPane) loader.load();
//            Scene scene = new Scene(page);
//            stage = new Stage();
//            stage.close();
//            stage.setScene(scene);
//            scene.getStylesheets().add("/styles/Accueil.css");
//            stage.show();
//            
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
        
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
    private void itemAvionsRechercherAction(ActionEvent event) {
        
    }
    
    @FXML
    private void itemAvionsAjouterAction(ActionEvent event) {
        
    }
    
    @FXML
    private void itemAvionsModifierAction(ActionEvent event) {
        
    }
    
    @FXML
    private void itemCaissesRechercherAction(ActionEvent event) {
        
    }
    
    @FXML
    private void itemCaissesVerifierAction(ActionEvent event) {
        
    }
    
    @FXML
    private void itemCaissesAjouterAction(ActionEvent event) {
        
    }
    
    @FXML
    private void itemCaissesModifierAction(ActionEvent event) {
        
    }
    
    @FXML
    private void itemMissionsProgrammerAction(ActionEvent event) {
        
    }
    
    /**
     * METHODES BOUTONS MEDECIN/INFIRMIER
     */
    
    @FXML
    private void itemMedicamentsRechercherAction(ActionEvent event) {
        
    }
    
    /**
     * METHODES BOUTONS PHARMACIEN
     */
    
    @FXML
    private void itemMedicamentsVerifierAction(ActionEvent event) {
        
    }
    
    @FXML
    private void itemMedicamentsAjouterAction(ActionEvent event) {
        
    }
    
    @FXML
    private void itemMedicamentModifierAction(ActionEvent event) {
        
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
