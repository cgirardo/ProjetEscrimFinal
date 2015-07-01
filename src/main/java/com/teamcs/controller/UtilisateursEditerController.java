/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller;

import com.teamcs.database.bean.Statut;
import com.teamcs.database.bean.Utilisateur;
import com.teamcs.service.UtilisateurService;
import com.teamcs.service.impl.UtilisateurServiceImpl;
import com.teamcs.util.DateUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author chris_000
 */
public class UtilisateursEditerController implements Initializable {

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
    private ComboBox<String> statutComboBox;
    
    UtilisateurService service = new UtilisateurServiceImpl();

    private Stage dialogStage;
    private Utilisateur user;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        service = new UtilisateurServiceImpl();
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setPerson(Utilisateur user) {
        this.user = user;

        firstNameField.setText(user.getPrenom());
        lastNameField.setText(user.getNom());
        streetField.setText(user.getRue());
        postalCodeField.setText(user.getCodePostal());
        cityField.setText(user.getVille());
        mailField.setText(user.getMail());
        statutComboBox.getSelectionModel().select(user.getStatut().getLibelleStatut());
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
            user.setPrenom(firstNameField.getText());
            user.setNom(lastNameField.getText());
            user.setRue(streetField.getText());
            user.setCodePostal(postalCodeField.getText());
            user.setVille(cityField.getText());
            user.setMail(mailField.getText());       
            user.setStatut(service.findOneStatutByLibelle(statutComboBox.getSelectionModel().getSelectedItem()));
            okClicked = true;
            service.updateUtilisateur(user);
            
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
            errorMessage += "No valid first name!\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n"; 
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n"; 
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }

        if (mailField.getText() == null || mailField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Champs invalides");
            alert.setHeaderText("Veuillez selectionnez des champs valides");
            alert.setContentText(errorMessage);
            alert.getDialogPane().getStyleClass().add("myDialogs.css");
            alert.showAndWait();
            
            return false;
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(Statut statut : service.findAllStatuts()) {
            statutComboBox.getItems().add(statut.getLibelleStatut());
        }
    }
}
