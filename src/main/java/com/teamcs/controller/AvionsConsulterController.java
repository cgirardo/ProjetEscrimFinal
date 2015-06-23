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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    @FXML private TableView<Aeronef> avionTable;
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
        avionTable.setItems(aeronefData);
        libelleColumn.setCellValueFactory(new PropertyValueFactory<Aeronef, String>("libelleAeronef"));
        volumeColumn.setCellValueFactory(new PropertyValueFactory<Aeronef, String>("volumeCargo"));
        
        showAeronefDetails(null);
        
        avionTable.getSelectionModel().selectedItemProperty().addListener(
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
    private void handleNewMed(ActionEvent event) {
        
    }
    
    @FXML
    private void handleEditMed(ActionEvent event) {
        
    }
    
    @FXML
    private void handleDeleteMed(ActionEvent event) {
        
    }
}
