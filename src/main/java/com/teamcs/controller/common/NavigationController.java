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

/**
 *
 * @author chris_000
 */
public class NavigationController {
    
    private static Stage mainStage;
    private static Scene currentScene;
    private static Pane currentPane;
    
    /** Chemin des différentes vues et styles utilisés */
    //menu bar
    public static String MENU_LOG = "/fxml/menu/Logisticien.fxml";
    public static String MENU_PHA = "/fxml/menu/Pharmacien.fxml";
    public static String MENU_MED = "/fxml/menu/Medecin.fxml";
    //occupe toute la scene
    public static String VIEW_MAIN = "/fxml/view/Main.fxml";
    public static String VIEW_CONNEXION = "/fxml/view/Connexion.fxml";
    public static String VIEW_ACCUEIL = "/fxml/view/Accueil.fxml";
    public static String VIEW_ERREUR = "/fxml/view/Erreur404.fxml";
    //occupe une partie de la scene principale
    public static String VIEW_PROFIL_EDITER = "/fxml/view/ProfilEditer.fxml";
    public static String VIEW_AVIONS_EDITER = "/fxml/view/AvionsEditer.fxml";
    public static String VIEW_CAISSES_EDITER = "/fxml/view/CaissesEditer.fxml";
    public static String VIEW_CAISSES_VERIFIER = "/fxml/view/CaissesVerifier.fxml";
    public static String VIEW_MEDICAMENTS_EDITER = "/fxml/view/MedicamentsEditer.fxml";
    public static String VIEW_MEDICAMENTS_VERIFIER = "/fxml/view/MedicamentsVerifier.fxml";
    public static String VIEW_MISSIONS_CONSULTER = "/fxml/view/MissionsConsulter.fxml";
    public static String VIEW_MISSIONS_PROGRAMMER = "/fxml/view/MissionsProgrammer.fxml";
    //styles
    public static String STYLE_CONNEXION = "/styles/Login.css";
    public static String STYLE_THEME = "/styles/MainTheme.css";
    
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

    public static void setCurrentScene(Scene currentScene) {
        NavigationController.currentScene = currentScene;
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
            e.printStackTrace();
        }
    }
    
    public static void loadView(String fxml) {
        try {
            mainController.setView((Node) FXMLLoader.load(NavigationController.class.getResource(fxml)));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
