/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller;

import com.teamcs.database.bean.Classetherapeutique;
import com.teamcs.database.bean.Medicament;
import com.teamcs.service.MedicamentService;
import com.teamcs.service.impl.MedicamentServiceImpl;
import com.teamcs.util.DateUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author chris_000
 */
public class MedicamentsNouveauController implements Initializable {
    @FXML
    private ComboBox<String> classeComboBox;
    
    @FXML
    private TextField libelleField;
    @FXML
    private TextField dciField;
    @FXML
    private TextField dluNameField;
    @FXML
    private TextField lotNameField;
    @FXML
    private TextField dotationField;
    @FXML
    private TextField dosageField;
    
    MedicamentService service = new MedicamentServiceImpl();

    private Stage dialogStage;
    private Medicament medoc;
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
            medoc = new Medicament();
            medoc.setLibelleMedicament(libelleField.getText());
            medoc.setClassetherapeutique(service.findOneClasse(classeComboBox.getSelectionModel().getSelectedItem()));
            medoc.setDci(dciField.getText());
            medoc.setDlu(DateUtil.parse(dluNameField.getText()));
            medoc.setLot(Integer.parseInt(lotNameField.getText()));
            medoc.setDotationU7(Integer.parseInt(dotationField.getText()));
            medoc.setFormeDosage(dosageField.getText());

            okClicked = true;
            service.saveMedicament(medoc);
            
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
            errorMessage += "No valid libelle!\n"; 
        }
        if (dciField.getText() == null || dciField.getText().length() == 0) {
            errorMessage += "No valid dci!\n"; 
        }
        if (dluNameField.getText() == null || dluNameField.getText().length() == 0) {
            errorMessage += "No valid dlu!\n"; 
        }

        if (lotNameField.getText() == null || lotNameField.getText().length() == 0) {
            errorMessage += "No valid lot!\n"; 
        }

        if (dotationField.getText() == null || dotationField.getText().length() == 0) {
            errorMessage += "No valid dotation!\n"; 
        }

        if (dosageField.getText() == null || dosageField.getText().length() == 0) {
            errorMessage += "No valid dosage!\n";
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
        for(Classetherapeutique classe : service.findAllClasses()) {
            classeComboBox.getItems().add(classe.getLibelleClasseTherapeutique());
        }
    }
}
