/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller;

import com.teamcs.database.bean.Aeronef;
import com.teamcs.service.AeronefService;
import com.teamcs.service.impl.AeronefServiceImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chris_000
 */
public class AvionsNouveauController implements Initializable {
    
    @FXML TextField libelleField;
    @FXML TextField poidsField;
    @FXML TextField dimPorteField;
    @FXML TextField dimCargoField;
    @FXML TextField volField;
    @FXML TextField longPisteField;
    @FXML TextField capPleinField;
    @FXML TextField capVideField;
    @FXML TextField vitesseField;
    @FXML TextField consoField;
    @FXML TextField dispoField;
    
    AeronefService service = new AeronefServiceImpl();

    private Stage dialogStage;
    private Aeronef aeronef;
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
            aeronef.setLibelleAeronef(libelleField.getText());
            aeronef.setPoidsMax(Integer.parseInt(poidsField.getText()));
            aeronef.setDimensionPorte(dimPorteField.getText());
            aeronef.setDimensionCargo(dimCargoField.getText());
            aeronef.setVolumeCargo(Integer.parseInt(volField.getText()));
            aeronef.setLongueurPisteNecessaire(Integer.parseInt(longPisteField.getText()));
            aeronef.setCapacitePlein(Integer.parseInt(capPleinField.getText()));
            aeronef.setCapaciteVide(Integer.parseInt(capVideField.getText()));
            aeronef.setVitesse(Integer.parseInt(vitesseField.getText()));
            aeronef.setConsommation(Double.parseDouble(consoField.getText()));
            if(dispoField.getText().toLowerCase().equals("oui")) {
                aeronef.setDisponibilite(true);
            } else {
                aeronef.setDisponibilite(false);
            }

            okClicked = true;
            service.saveAeronef(aeronef);
            
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

        if (libelleField.getText() == null || libelleField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (poidsField.getText() == null || poidsField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (dimPorteField.getText() == null || dimPorteField.getText().length() == 0) {
            errorMessage += "No valid street!\n"; 
        }

        if (dimCargoField.getText() == null || dimCargoField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n"; 
        }

        if (volField.getText() == null || volField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }

        if (longPisteField.getText() == null || longPisteField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        }
        
        if (capPleinField.getText() == null || capPleinField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        }
        if (capVideField.getText() == null || capVideField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        }
        if (vitesseField.getText() == null || vitesseField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        }
        if (longPisteField.getText() == null || longPisteField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        }
        if (consoField.getText() == null || consoField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        }
        if (dispoField.getText() == null || dispoField.getText().length() == 0 ||
                (dispoField.getText().toLowerCase().equals("oui") && dispoField.getText().toLowerCase().equals("non"))) {
            errorMessage += "Disponibilite invalide (oui ou non)!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
}
