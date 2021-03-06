/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller.common;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.jboss.logging.Logger;

/**
 *
 * @author chris_000
 */
public class NavigationController {
    
    private static Logger logger = Logger.getLogger(NavigationController.class);
    
    private static Stage mainStage;
    private static Scene currentScene;
    private static Pane currentPane;
    public static String profil;
    
    /** Chemin des différentes vues et styles utilisés */
    //menu bar
    public static String MENU_LOG = "/fxml/menu/Logisticien.fxml";
    public static String MENU_PHA = "/fxml/menu/Pharmacien.fxml";
    public static String MENU_MED = "/fxml/menu/Medecin.fxml";
    //occupe toute la scene
    public static String VIEW_MAIN = "/fxml/view/Main.fxml";
    public static String VIEW_CONNEXION = "/fxml/view/Connexion.fxml";
    public static String VIEW_ACCUEIL = "/fxml/view/Accueil.fxml";
    //occupe une partie de la scene principale
    public static String VIEW_PROFIL_EDITER = "/fxml/view/UtilisateursConsulter.fxml";
    public static String VIEW_AVIONS_CONSULTER = "/fxml/view/AvionsConsulter.fxml";
    public static String VIEW_CAISSES_CONSULTER = "/fxml/view/CaissesConsulter.fxml";
    public static String VIEW_MEDICAMENTS_CONSULTER = "/fxml/view/MedicamentsConsulter.fxml";
    public static String VIEW_MATERIELS_CONSULTER = "/fxml/view/MaterielsConsulter.fxml";
    public static String VIEW_MISSIONS_CONSULTER = "/fxml/view/MissionsConsulter.fxml";
    public static String VIEW_MISSIONS_PROGRAMMER = "/fxml/view/MissionsProgrammer.fxml";
    //styles
    public static String STYLE_THEME = "/styles/MainTheme.css";
    public static String STYLE_LOGISTICIEN = "/styles/logisticien.css";
    public static String STYLE_MEDECIN = "/styles/medecin.css";
    public static String STYLE_INFIRMIER = "/styles/infirmier.css";
    public static String STYLE_PHARMACIEN = "/styles/pharmacien.css";
    
    /** Le controlleur de la couche principale de l'appli */
    private static MainController mainController;
    
    private NavigationController() {
        
    }
    
    private static NavigationController INSTANCE = null;
    
    public static NavigationController getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new NavigationController();
        }
        return INSTANCE;
    }

    public static void setMainStage(Stage mainStage) {
        NavigationController.mainStage = mainStage;
    }
    
    public static Stage getMainStage() {
        return NavigationController.mainStage;
    }
    
    public static void setCurrentScene(Scene currentScene) {
        NavigationController.currentScene = currentScene;
    }

    public static Scene getCurrentScene() {
        return currentScene;
    }

    public static void setCurrentPane(Pane currentPane) {
        NavigationController.currentPane = currentPane;
    }
    
    public static void setMainController(MainController controller) {
        NavigationController.mainController = controller;
    }
    
    public static NavigationController getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(NavigationController INSTANCE) {
        NavigationController.INSTANCE = INSTANCE;
    }
    
    public static void loadMenu(String fxml) {
        try {
            mainController.setMenu((Node) FXMLLoader.load(NavigationController.class.getResource(fxml)));
        } catch(IOException e) {
            logger.fatal("Erreur lors du chargement du menu !");
        }
    }
    
    public static void loadView(String fxml) {
        try {
            mainController.setView((Node) FXMLLoader.load(NavigationController.class.getResource(fxml)));
            
        } catch(IOException e) {
            logger.fatal("Erreur lors du chargement de la vue !");
        }
    }
}
