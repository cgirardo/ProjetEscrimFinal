/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller;

import com.teamcs.controller.common.NavigationController;
import com.teamcs.database.bean.Statut;
import com.teamcs.database.bean.Utilisateur;
import com.teamcs.service.UtilisateurService;
import com.teamcs.service.impl.UtilisateurServiceImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chris_000
 */
public class UtilisateursNouveauController implements Initializable {
    
    @FXML
    private ComboBox<String> statutComboBox;
    
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField mailField;
    @FXML
    private TextField mdpField;
    @FXML
    private TextField identifiantField;
    
    UtilisateurService service = new UtilisateurServiceImpl();

    private Stage dialogStage;
    private Utilisateur user;
    private boolean okClicked = false;
    
    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            user = new Utilisateur();
            user.setLogin(identifiantField.getText());
            user.setMotDePasse(mdpField.getText());
            user.setStatut(service.findOneStatutByLibelle(statutComboBox.getSelectionModel().getSelectedItem()));
            user.setPrenom(firstNameField.getText());
            user.setNom(lastNameField.getText());
            user.setRue(streetField.getText());
            user.setCodePostal(postalCodeField.getText());
            user.setVille(cityField.getText());
            user.setMail(mailField.getText());

            okClicked = true;
            service.saveUtilisateur(user);
            
            dialogStage.close();
        }
    }
    
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "Invalide prenom!\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "Invalide nom!\n"; 
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "Invalide rue!\n"; 
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "Invalide postal code!\n"; 
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "Invalide ville!\n"; 
        }

        if (mailField.getText() == null || mailField.getText().length() == 0) {
            errorMessage += "Invalide mail!\n";
        }
        
        if (mdpField.getText() == null || mdpField.getText().length() == 0) {
            errorMessage += "Invalide mdp!\n";
        }
        
        if (identifiantField.getText() == null || identifiantField.getText().length() == 0) {
            errorMessage += "Invalide identifiant!\n";
        }
        
        if (statutComboBox.getItems() == null || statutComboBox.getItems().size() == 0) {
            errorMessage += "Invalide statut!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(dialogStage);
            alert.setTitle("Champs invalides");
            alert.setHeaderText("Veuillez renseigner les champs invalides");
            alert.setContentText(errorMessage);
            dialogStage.getScene().getStylesheets().add(getClass().getResource(NavigationController.STYLE_LOGISTICIEN).toExternalForm());
            alert.getDialogPane().getStyleClass().add("myDialogs");
            alert.showAndWait();
            
            return false;
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Statut statut : service.findAllStatuts()) {
            statutComboBox.getItems().add(statut.getLibelleStatut());
        }
    }    
}
