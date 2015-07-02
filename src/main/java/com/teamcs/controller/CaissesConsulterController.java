/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller;

import com.teamcs.controller.common.NavigationController;
import com.teamcs.database.bean.Aeronef;
import com.teamcs.database.bean.Caisse;
import com.teamcs.service.AeronefService;
import com.teamcs.service.CaisseService;
import com.teamcs.service.impl.AeronefServiceImpl;
import com.teamcs.service.impl.CaisseServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author chris_000
 */
public class CaissesConsulterController {

    @FXML Label numeroLabel;
    @FXML Label typeLabel;
    @FXML Label latLabel;
    @FXML Label longLabel;
    @FXML Label affectLabel;
    @FXML Label moduleLabel;
    @FXML Label nominalLabel;
    @FXML Label observationLabel;
    @FXML Label precisionsLabel;
    @FXML Label valeurLabel;
    @FXML Label iataLabel;
    @FXML Label projectionLabel;
    @FXML Label designationLabel;
    @FXML Label secteurLabel;
    
    @FXML private TableView<Caisse> caisseTable;
    @FXML private TableColumn<Caisse, String> numeroColumn;
    @FXML private TableColumn<Caisse, String> affectataireColumn;
    
    private Caisse caisse;
    private CaisseService service;
    private ObservableList<Caisse> caisseData;
    Stage primaryStage;
    
    public CaissesConsulterController () { }
    
    @FXML
    public void initialize() {
        service = new CaisseServiceImpl();
        getDataFromDatabase();
        caisseTable.setItems(caisseData);
        numeroColumn.setCellValueFactory(new PropertyValueFactory<Caisse, String>("idCaisse"));
        affectataireColumn.setCellValueFactory(new PropertyValueFactory<Caisse, String>("affectataire"));
        
        showCaisseDetails(null);
        
        caisseTable.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Caisse>() {
                public void changed(ObservableValue<? extends Caisse> observable, Caisse oldValue, Caisse newValue) {
                     showCaisseDetails(newValue);
                }
            });
        primaryStage = NavigationController.getMainStage();
        primaryStage.setHeight(600.0);
        primaryStage.setWidth(600.0);
    }
    
    public void getDataFromDatabase() {
        caisseData = FXCollections.observableArrayList();
        caisseData.addAll(service.findAllCaisse());
    }
    
    private void showCaisseDetails(Caisse caisse) {
        if(caisse != null) {
            numeroLabel.setText(Integer.toString(caisse.getIdCaisse()));
            typeLabel.setText(caisse.getTypecaisse().getLibelleTypeCaisse());
            latLabel.setText(Double.toString(caisse.getGeolocalisation().getLatitude()));
            longLabel.setText(Double.toString(caisse.getGeolocalisation().getLongitude()));
            affectLabel.setText(caisse.getAffectataire());
            moduleLabel.setText(caisse.getModule());
            nominalLabel.setText(caisse.getNominal());
            observationLabel.setText(caisse.getObservation().getLibelleObservation());
            precisionsLabel.setText(caisse.getPrecisionsColis());
            valeurLabel.setText(Integer.toString(caisse.getValeur()));
            iataLabel.setText(Integer.toString(caisse.getIata()));
            projectionLabel.setText(Integer.toString(caisse.getProjection()));
            designationLabel.setText(caisse.getDesignation().getLibelleDesignation());
            secteurLabel.setText(caisse.getSecteur().getLibelleSecteur());
            this.caisse = caisse;
        } else {
            numeroLabel.setText("");
            typeLabel.setText("");
            latLabel.setText("");
            longLabel.setText("");
            affectLabel.setText("");
            moduleLabel.setText("");
            nominalLabel.setText("");
            observationLabel.setText("");
            precisionsLabel.setText("");
            valeurLabel.setText("");
            iataLabel.setText("");
            projectionLabel.setText("");
            designationLabel.setText("");
            secteurLabel.setText("");
        }
    }
    
    @FXML
    private void handleNewCaisse(ActionEvent event) {
        Caisse tempCaisse = new Caisse();
        boolean okClicked = showCaisseNewDialog(tempCaisse);
        if (okClicked) {
            caisseData.add(tempCaisse);
        }
    }
    
    private boolean showCaisseNewDialog(Caisse tempCaisse) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CaissesConsulterController.class.getResource("/fxml/view/CaissesNouveau.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nouvelle caisse");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            CaissesNouveauController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void handleEditCaisse(ActionEvent event) {
        Caisse selectedCaisse = caisseTable.getSelectionModel().getSelectedItem();
        if (selectedCaisse != null) {
            boolean okClicked = showCaisseEditDialog(selectedCaisse);
            if (okClicked) {
                showCaisseDetails(selectedCaisse);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Aucune sélection");
            alert.setHeaderText("Aucun profil n'est selectionné");
            alert.setContentText("Veuillez selectionner un profil.");
            alert.getDialogPane().getStyleClass().add("myDialogs");  
            alert.showAndWait();
        }
    }
    
    private boolean showCaisseEditDialog(Caisse tempCaisse) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CaissesConsulterController.class.getResource("/fxml/view/CaissesEditer.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editer caisse");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            CaissesEditerController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCaisse(tempCaisse);
            
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void handleDeleteCaisse(ActionEvent event) {
        int selectedIndex = caisseTable.getSelectionModel().getSelectedIndex();
        Caisse selectedCaisse = caisseTable.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            caisseTable.getItems().remove(selectedIndex);
            service.deleteCaisse(selectedCaisse);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(NavigationController.getMainStage());
            alert.setTitle("Aucune Selection");
            alert.setHeaderText("Aucune caisse sélectionnée");
            alert.setContentText("Veuillez sélectionner une caisse dans la table");
            alert.getDialogPane().getStyleClass().add("myDialogs");
            alert.showAndWait();
        }
    }
}
