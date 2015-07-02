/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller.common;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * Controlleur principal pour la vue entière
 * 
 * @author chris_000
 */
public class MainController {

    /** Contenu d'une vue modifiable */
    @FXML
    private BorderPane viewHolder;
    
    /**
     * Remplace la partie Top du BorderPane
     * 
     * @param node le noeud à ajouter
     */
    public void setMenu(Node node) {
        viewHolder.setTop(node);
    }
    
    /**
     * Remplace la partie Center du BorderPane
     * 
     * @param node le noeud à ajouter
     */
    public void setView(Node node) {
        viewHolder.setCenter(node);
//        setStyle();
    }
    
    public void setStyle() {
        Scene scene = new Scene(viewHolder);
        scene.getStylesheets().add(getClass().getResource(NavigationController.STYLE_LOGISTICIEN).toExternalForm());
    }
}
