/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller;

import com.teamcs.controller.common.NavigationController;
import com.teamcs.database.bean.Classetherapeutique;
import com.teamcs.database.bean.Contenu;
import com.teamcs.database.bean.Medicament;
import com.teamcs.service.ContenuService;
import com.teamcs.service.MedicamentService;
import com.teamcs.service.impl.ContenuServiceImpl;
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
    
    MedicamentService serviceMedicament = new MedicamentServiceImpl();
    ContenuService serviceContenu = new ContenuServiceImpl();

    private Stage dialogStage;
    private Medicament medoc;
    private Contenu contenu;
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
            medoc.setClassetherapeutique(serviceMedicament.findOneClasse(classeComboBox.getSelectionModel().getSelectedItem()));
            medoc.setDci(dciField.getText());
            medoc.setDlu(DateUtil.parse(dluNameField.getText()));
            medoc.setLot(lotNameField.getText());
            medoc.setDotationU7(Integer.parseInt(dotationField.getText()));
            medoc.setFormeDosage(dosageField.getText());

            contenu = new Contenu();
            contenu.setLibelleContenu(libelleField.getText());
            
            okClicked = true;
            serviceMedicament.saveMedicament(medoc);
            serviceContenu.saveContenu(contenu);
            
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
            errorMessage += "Invalide libelle!\n"; 
        }
        if (dciField.getText() == null || dciField.getText().length() == 0) {
            errorMessage += "Invalide DCI!\n"; 
        }
        if (dluNameField.getText() == null || dluNameField.getText().length() == 0) {
            errorMessage += "Invalide DLU!\n"; 
        }

        if (lotNameField.getText() == null || lotNameField.getText().length() == 0) {
            errorMessage += "Invalide Lot!\n"; 
        }

        if (dotationField.getText() == null || dotationField.getText().length() == 0) {
            errorMessage += "Invalide dotation!\n"; 
        }

        if (dosageField.getText() == null || dosageField.getText().length() == 0) {
            errorMessage += "Invalide dosage!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Champs invalides");
            alert.setHeaderText("Veuillez entrer des champs valides");
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
        for(Classetherapeutique classe : serviceMedicament.findAllClasses()) {
            classeComboBox.getItems().add(classe.getLibelleClasseTherapeutique());
        }
    }
}
