/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller;

import com.teamcs.controller.common.NavigationController;
import com.teamcs.database.bean.Classetherapeutique;
import com.teamcs.database.bean.Medicament;
import com.teamcs.service.MedicamentService;
import com.teamcs.service.impl.MedicamentServiceImpl;
import com.teamcs.util.DateUtil;
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
public class MedicamentsConsulterController {

    @FXML Label libelleLabel;
    @FXML Label classeLabel;
    @FXML Label dluLabel;
    @FXML Label dciLabel;
    @FXML Label dosageLabel;
    @FXML Label lotLabel;
    @FXML Label dotationLabel;
    
    @FXML private TableView<Medicament> medocTable;
    @FXML private TableColumn<Medicament, String> libelleColumn;
    @FXML private TableColumn<Medicament, String> classeColumn;
    
    private Medicament medicament;
    private MedicamentService service;
    private ObservableList<Medicament> medocData;
    Stage primaryStage;
    
    public MedicamentsConsulterController () { }
    
    @FXML
    public void initialize() {
        service = new MedicamentServiceImpl();
        getDataFromDatabase();
        medocTable.setItems(medocData);
        libelleColumn.setCellValueFactory(new PropertyValueFactory<Medicament, String>("libelleMedicament"));
        classeColumn.setCellValueFactory(new PropertyValueFactory<Medicament, String>("formeDosage"));
        
        showMedicamentDetails(null);
        
        medocTable.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Medicament>() {
                public void changed(ObservableValue<? extends Medicament> observable, Medicament oldValue, Medicament newValue) {
                     showMedicamentDetails(newValue);
                }
            });
        primaryStage = NavigationController.getMainStage();
        primaryStage.setHeight(600.0);
        primaryStage.setWidth(600.0);
    }
    
    public void getDataFromDatabase() {
        medocData = FXCollections.observableArrayList();
        medocData.addAll(service.findAllMedicament());
    }
    
    private void showMedicamentDetails(Medicament medoc) {
        if(medoc != null) {
            libelleLabel.setText(medoc.getLibelleMedicament());
            classeLabel.setText(medoc.getClassetherapeutique().getLibelleClasseTherapeutique());
            dluLabel.setText(DateUtil.format(medoc.getDlu()));
            dciLabel.setText(medoc.getDci());
            dosageLabel.setText(medoc.getFormeDosage());
            lotLabel.setText(Integer.toString(medoc.getLot()));
            dotationLabel.setText(Integer.toString(medoc.getDotationU7()));
            medicament = medoc;
        } else {
            libelleLabel.setText("");
            classeLabel.setText("");
            dluLabel.setText("");
            dciLabel.setText("");
            dosageLabel.setText("");
            lotLabel.setText("");
            dotationLabel.setText("");
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
