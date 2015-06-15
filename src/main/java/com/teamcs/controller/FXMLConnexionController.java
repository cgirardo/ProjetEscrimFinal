package com.teamcs.controller;

import com.teamcs.exceptions.UtilisateurException;
import com.teamcs.service.UtilisateurService;
import com.teamcs.service.impl.UtilisateurServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FXMLConnexionController implements Initializable {
    
    private UtilisateurService service = new UtilisateurServiceImpl();
    
    @FXML private TextField identifiant;
    @FXML private PasswordField mdp;
    @FXML private Stage stage;
    @FXML private Label label;
    @FXML private AnchorPane content;   
    @FXML private StackPane vistaHolder;
    
    @FXML
    private void connexionButtonAction(ActionEvent event) {
        String login = identifiant.getText();
        String pcw = mdp.getText();
        String statut = "";
        try {
            System.out.println("test connection");
            statut = service.connectUtilisateur(login, pcw);
            System.out.println("login correct");
            
            
            
            Scene scene = selectScene(statut);
            stage = new Stage();
//            stage.setScene(scene);
//            stage.show();
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();
            System.out.println("connecté");
        } catch (UtilisateurException e) {
            System.out.println(e.getMessage());
            label.setText(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(FXMLConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Scene selectScene(String statut) throws IOException {
        String page = "";
        
        switch(statut) {
            case "Logisticien":
                page = "/fxml/AccueilLog.fxml";
                break;
            case "Pharmacien":
                page = "/fxml/AccueilPha.fxml";
                break;
            case "Medecin":
                page = "/fxml/AccueilMed.fxml";
                break;
            case "Infirmier":
                page = "/fxml/AccueilMed.fxml";
                break;
            default:
                page = "/fxml/Erreur404.fxml";
                break;
        }
        
        Parent root = FXMLLoader.load(getClass().getResource(page));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Accueil.css");
        return scene;
    }
    
    @FXML
    private void resetButtonAction(ActionEvent event) {
        identifiant.setText("");
        mdp.setText("");
        
        identifiant.setPromptText("identifiant");
        mdp.setPromptText("mot de passe");
    }
    
    @FXML
    private void nouveauButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
}
