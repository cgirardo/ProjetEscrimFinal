package com.teamcs.controller;

import com.teamcs.database.bean.Utilisateur;
import com.teamcs.exceptions.UtilisateurException;
import com.teamcs.service.UtilisateurService;
import com.teamcs.service.impl.UtilisateurServiceImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLController implements Initializable {
    
    private UtilisateurService service = new UtilisateurServiceImpl();
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Stage stage;
    
    @FXML
    private Label label;
    
    @FXML
    private void connexionButtonAction(ActionEvent event) {
        System.out.println("Connexion: " + username.getText());
        String login = username.getText();
        String pcw = password.getText();
        try {
            service.connectUtilisateur(login, pcw);
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            Scene scene = new Scene(root);
            stage = new Stage();
            stage.setScene(scene);
            stage.show();   
        } catch (Exception e) {
            label.setText(e.getMessage());
        }
    }
    
    @FXML
    private void resetButtonAction(ActionEvent event) {
        username.setText("");
        password.setText("");
        
        username.setPromptText("identifiant");
        password.setPromptText("mot de passe");
    }
    
    @FXML
    private void nouveauButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
