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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author chris_000
 */
public class CaissesConsulterController {

    @FXML Label numeroLabel;
    @FXML Label typeLabel;
    @FXML Label geolocLabel;
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
            geolocLabel.setText("Lat: "+Double.toString(caisse.getGeolocalisation().getLatitude())+" -Long: "+Double.toString(caisse.getGeolocalisation().getLongitude()));
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
            geolocLabel.setText("");
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
        
    }
    
    @FXML
    private void handleEditCaisse(ActionEvent event) {
        
    }
    
    @FXML
    private void handleDeleteCaisse(ActionEvent event) {
        
    }
}
