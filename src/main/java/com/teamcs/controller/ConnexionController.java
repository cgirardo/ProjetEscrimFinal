package com.teamcs.controller;

import com.teamcs.controller.common.NavigationController;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnexionController implements Initializable {
    
    private UtilisateurService service = new UtilisateurServiceImpl();
    
    @FXML private TextField identifiant;
    @FXML private PasswordField mdp;
    @FXML private Stage stage;
    @FXML private Label connexionError;
    
    @FXML
    private void connexionButtonAction(ActionEvent event) {
        String login = identifiant.getText();
        String pcw = mdp.getText();
        String statut = ""; 
        try {
            statut = service.connectUtilisateur(login, pcw);         
            selectView(statut);
        } catch (UtilisateurException e) {
            connexionError.setText(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void selectView(String statut) throws IOException {
        switch(statut) {
            case "Logisticien":
                NavigationController.loadMenu(NavigationController.MENU_LOG);
                NavigationController.loadView(NavigationController.VIEW_ACCUEIL);
                NavigationController.getMainStage().getScene().getStylesheets().add(getClass().getResource(NavigationController.STYLE_LOGISTICIEN).toExternalForm());
                break;
            case "Pharmacien":
                NavigationController.loadMenu(NavigationController.MENU_PHA);
                NavigationController.loadView(NavigationController.VIEW_ACCUEIL);
                NavigationController.getMainStage().getScene().getStylesheets().add(getClass().getResource(NavigationController.STYLE_PHARMACIEN).toExternalForm());
                break;
            case "Medecin":
                NavigationController.loadMenu(NavigationController.MENU_MED);
                NavigationController.loadView(NavigationController.VIEW_ACCUEIL);
                NavigationController.getMainStage().getScene().getStylesheets().add(getClass().getResource(NavigationController.STYLE_MEDECIN).toExternalForm());
                break;
            case "Infirmier":
                NavigationController.loadMenu(NavigationController.MENU_MED);
                NavigationController.loadView(NavigationController.VIEW_ACCUEIL);
                NavigationController.getMainStage().getScene().getStylesheets().add(getClass().getResource(NavigationController.STYLE_MEDECIN).toExternalForm());
                break;
            default:
                
                break;
        }
    }
    
    @FXML
    private void resetButtonAction(ActionEvent event) {
        identifiant.setText("");
        mdp.setText("");
        
        identifiant.setPromptText("identifiant");
        mdp.setPromptText("mot de passe");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        stage = NavigationController.getMainStage();
//        NavigationController.loadView(NavigationController.VIEW_CONNEXION);
//        NavigationController.getCurrentScene().getStylesheets().add(getClass().getResource(NavigationController.STYLE_LOGISTICIEN).toExternalForm());
    }    
}
    