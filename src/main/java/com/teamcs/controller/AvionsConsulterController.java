/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller;

import com.teamcs.controller.common.NavigationController;
import com.teamcs.database.bean.Aeronef;
import com.teamcs.service.AeronefService;
import com.teamcs.service.impl.AeronefServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
public class AvionsConsulterController {
    
    @FXML Label libelleLabel;
    @FXML Label poidsLabel;
    @FXML Label dimPorteLabel;
    @FXML Label dimCargoLabel;
    @FXML Label volLabel;
    @FXML Label longPisteLabel;
    @FXML Label capPleinLabel;
    @FXML Label capVideLabel;
    @FXML Label vitesseLabel;
    @FXML Label consoLabel;
    @FXML Label dispoLabel;
    
    @FXML private TableView<Aeronef> aeronefTable;
    @FXML private TableColumn<Aeronef, String> libelleColumn;
    @FXML private TableColumn<Aeronef, String> volumeColumn;
    
    private Aeronef aeronef;
    private AeronefService service;
    private ObservableList<Aeronef> aeronefData;
    Stage primaryStage;
    
    public AvionsConsulterController () { }
    
    @FXML
    public void initialize() {
        service = new AeronefServiceImpl();
        getDataFromDatabase();
        aeronefTable.setItems(aeronefData);
        libelleColumn.setCellValueFactory(new PropertyValueFactory<Aeronef, String>("libelleAeronef"));
        volumeColumn.setCellValueFactory(new PropertyValueFactory<Aeronef, String>("volumeCargo"));
        
        showAeronefDetails(null);
        
        aeronefTable.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Aeronef>() {
                public void changed(ObservableValue<? extends Aeronef> observable, Aeronef oldValue, Aeronef newValue) {
                     showAeronefDetails(newValue);
                }
            });
        primaryStage = NavigationController.getMainStage();
        primaryStage.setHeight(600.0);
        primaryStage.setWidth(600.0);
    }
    
    public void getDataFromDatabase() {
        aeronefData = FXCollections.observableArrayList();
        aeronefData.addAll(service.findAllAeronef());
    }
    
    private void showAeronefDetails(Aeronef avion) {
        if(avion != null) {
            libelleLabel.setText(avion.getLibelleAeronef());
            poidsLabel.setText(Integer.toString(avion.getPoidsMax()));
            dimPorteLabel.setText(avion.getDimensionPorte());
            dimCargoLabel.setText(avion.getDimensionCargo());
            volLabel.setText(Integer.toString(avion.getVolumeCargo()));
            longPisteLabel.setText(Integer.toString(avion.getLongueurPisteNecessaire()));
            capPleinLabel.setText(Integer.toString(avion.getCapacitePlein()));
            capVideLabel.setText(Integer.toString(avion.getCapaciteVide()));
            vitesseLabel.setText(Integer.toString(avion.getVitesse()));
            consoLabel.setText(Double.toString(avion.getConsommation()));
            if(avion.isDisponibilite()) {
                dispoLabel.setText("Oui");
            } else {
                dispoLabel.setText("non");
            }
            aeronef = avion;
        } else {
            libelleLabel.setText("");
            poidsLabel.setText("");
            dimPorteLabel.setText("");
            dimCargoLabel.setText("");
            volLabel.setText("");
            longPisteLabel.setText("");
            capPleinLabel.setText("");
            capVideLabel.setText("");
            vitesseLabel.setText("");
            consoLabel.setText("");
            dispoLabel.setText("");
        }
    }
    
    @FXML
    private void handleNewAeronef(ActionEvent event) {
        Aeronef tempAeronef = new Aeronef();
        boolean okClicked = showAeronefNewDialog(tempAeronef);
        if (okClicked) {
            aeronefData.add(tempAeronef);
        }
    }
    
    private boolean showAeronefNewDialog(Aeronef tempAeronef) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AvionsConsulterController.class.getResource("/fxml/view/AvionsNouveau.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nouvel aeronef");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            AvionsNouveauController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void handleEditAeronef(ActionEvent event) {
        Aeronef selectedAeronef = aeronefTable.getSelectionModel().getSelectedItem();
        if (selectedAeronef != null) {
            boolean okClicked = showAeronefEditDialog(selectedAeronef);
            if (okClicked) {
                showAeronefDetails(selectedAeronef);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Aucune Selection");
            alert.setHeaderText("Aucun aéronef sélectionné");
            alert.setContentText("Veuillez sélectionner un aéronef dans la table");
            alert.getDialogPane().getStyleClass().add("myDialogs");
            alert.showAndWait();
        }
    }
    
    private boolean showAeronefEditDialog(Aeronef tempAeronef) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AvionsConsulterController.class.getResource("/fxml/view/AvionsEditer.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editer avion");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            AvionsEditerController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setAeronef(aeronef);
            
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void handleDeleteAeronef(ActionEvent event) {
        int selectedIndex = aeronefTable.getSelectionModel().getSelectedIndex();
        Aeronef selectedAeronef = aeronefTable.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            aeronefTable.getItems().remove(selectedIndex);
            service.deleteAeronef(selectedAeronef);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(NavigationController.getMainStage());
            alert.setTitle("Aucune Selection");
            alert.setHeaderText("Aucun aéronef sélectionné");
            alert.setContentText("Veuillez sélectionner un aéronef dans la table");
            alert.getDialogPane().getStyleClass().add("myDialogs");
            alert.showAndWait();
        }
    }
}
