/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author chris_000
 */
public class FXMLAccueilLogController implements Initializable {
    
    MenuBar menuBar = new MenuBar();
    
    Menu menuProfil = new Menu("Profil");
    MenuItem itemProfilEditer = new MenuItem("Editer");
    MenuItem itemProfilDeconnecter = new MenuItem("Se déconnecter");
    MenuItem itemProfilQuitter = new MenuItem("Quitter");
    
    Menu menuAvions = new Menu("Avions");
    MenuItem itemAvionsRechercher = new MenuItem("Rechercher");
    MenuItem itemAvionsAjouter = new MenuItem("Ajouter");
    MenuItem itemAvionsModifier = new MenuItem("Modifier");
    
    Menu menuCaisses = new Menu("Caisses");
    MenuItem itemCaissesRechercher = new MenuItem("Rechercher");
    MenuItem itemCaissesVerifier = new MenuItem("Vérifier stock");
    MenuItem itemCaissesAjouter = new MenuItem("Ajouter");
    MenuItem itemCaissesModifier = new MenuItem("Modifier");
    
    Menu menuMissions = new Menu("Missions");
    MenuItem itemMissions = new MenuItem("Consulter");
    MenuItem itemProgrammer = new MenuItem("Programmer");
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
