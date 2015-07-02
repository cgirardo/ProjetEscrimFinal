/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller;

import com.teamcs.controller.common.NavigationController;
import com.teamcs.database.bean.Caisse;
import com.teamcs.database.bean.Designation;
import com.teamcs.database.bean.Geolocalisation;
import com.teamcs.database.bean.Observation;
import com.teamcs.database.bean.Secteur;
import com.teamcs.database.bean.Typecaisse;
import com.teamcs.service.CaisseService;
import com.teamcs.service.impl.CaisseServiceImpl;
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
public class CaissesNouveauController implements Initializable {
    //initialisation des fields
    @FXML TextField numeroField;
    @FXML TextField typeField;
    @FXML TextField latField;
    @FXML TextField longField;
    @FXML TextField affectField;
    @FXML TextField moduleField;
    @FXML TextField nominalField;
    @FXML TextField observationField;
    @FXML TextField precisionsField;
    @FXML TextField valeurField;
    @FXML TextField iataField;
    @FXML TextField projectionField;
    @FXML TextField designationField;
    @FXML TextField secteurField;
    //service d'intéraction avec la BDD
    CaisseService service = new CaisseServiceImpl();

    private Stage dialogStage;
    private Caisse caisse;
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
        //si les données sont valides
        if (isInputValid()) {
            caisse = new Caisse();
            //valorisation des l'objet en vue de le sauvegarder en base
            caisse.setIdCaisse(Integer.parseInt(numeroField.getText()));
            Typecaisse type = new Typecaisse();
            type.setLibelleTypeCaisse(typeField.getText());
            caisse.setTypecaisse(type);
            Geolocalisation geoloc = new Geolocalisation();
            geoloc.setLatitude(Double.parseDouble(latField.getText()));
            geoloc.setLongitude(Double.parseDouble(longField.getText()));
            caisse.setGeolocalisation(geoloc);
            caisse.setModule(moduleField.getText());
            caisse.setNominal(nominalField.getText());
            Observation obs = new Observation();
            obs.setLibelleObservation(observationField.getText());
            caisse.setObservation(obs);
            caisse.setPrecisionsColis(precisionsField.getText());
            caisse.setValeur(Integer.parseInt(valeurField.getText()));
            caisse.setIata(Integer.parseInt(iataField.getText()));
            caisse.setProjection(Integer.parseInt(projectionField.getText()));
            Designation design = new Designation();
            design.setLibelleDesignation(designationField.getText());
            caisse.setDesignation(design);
            Secteur secteur = new Secteur();
            secteur.setLibelleSecteur(secteurField.getText());
            caisse.setSecteur(secteur);
            
            okClicked = true;
            //sauvegarde en BDD
            service.saveCaisse(caisse);
            
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
        //vérification de tous les fields
        if (numeroField.getText() == null || numeroField.getText().length() == 0) {
            errorMessage += "Numéro non valide!\n"; 
        }
        if (typeField.getText() == null || typeField.getText().length() == 0) {
            errorMessage += "Type non valide!\n"; 
        }
        if (latField.getText() == null || latField.getText().length() == 0) {
            errorMessage += "Latitude non valide!\n"; 
        }
        if (longField.getText() == null || longField.getText().length() == 0) {
            errorMessage += "Longitude non valide!\n"; 
        }
        if (affectField.getText() == null || affectField.getText().length() == 0) {
            errorMessage += "Affectataire non valide!\n"; 
        }

        if (moduleField.getText() == null || moduleField.getText().length() == 0) {
            errorMessage += "Module non valide!\n"; 
        }

        if (nominalField.getText() == null || nominalField.getText().length() == 0) {
            errorMessage += "Nominal non valide!\n";
        }
        
        if (observationField.getText() == null || observationField.getText().length() == 0) {
            errorMessage += "Observation non valide!\n";
        }
        
        if (precisionsField.getText() == null || precisionsField.getText().length() == 0) {
            errorMessage += "Précisions non valides!\n";
        }
        
        if (valeurField.getText() == null || valeurField.getText().length() == 0) {
            errorMessage += "Valeur non valide!\n";
        }
        
        if (iataField.getText() == null || iataField.getText().length() == 0) {
            errorMessage += "Iata non valide!\n";
        }
        
        if (projectionField.getText() == null || projectionField.getText().length() == 0) {
            errorMessage += "Projection non valide!\n";
        }
        
        if (designationField.getText() == null || designationField.getText().length() == 0) {
            errorMessage += "Designation non valide!\n";
        }
        
        if (secteurField.getText() == null || secteurField.getText().length() == 0) {
            errorMessage += "Secteur non valide!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // affiche le message d'erreur
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
        
    }    
}
