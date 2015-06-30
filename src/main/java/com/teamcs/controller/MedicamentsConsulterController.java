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
        
        showMedocDetails(null);
        
        medocTable.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Medicament>() {
                public void changed(ObservableValue<? extends Medicament> observable, Medicament oldValue, Medicament newValue) {
                     showMedocDetails(newValue);
                }
            });
        primaryStage = NavigationController.getMainStage();
        primaryStage.setHeight(600.0);
        primaryStage.setWidth(850.0);
    }
    
    public void getDataFromDatabase() {
        medocData = FXCollections.observableArrayList();
        medocData.addAll(service.findAllMedicament());
    }
    
    private void showMedocDetails(Medicament medoc) {
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
        Medicament tempMedoc = new Medicament();
        boolean okClicked = showMedocNewDialog(tempMedoc);
        if (okClicked) {
            medocData.add(tempMedoc);
        }
    }
    
    private boolean showMedocNewDialog(Medicament tempMedoc) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ProfilEditerController.class.getResource("/fxml/view/MedicamentsNouveau.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nouveau médicament");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            MedicamentsNouveauController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void handleEditMed(ActionEvent event) {
        Medicament selectedMedoc = medocTable.getSelectionModel().getSelectedItem();
        if (selectedMedoc != null) {
            boolean okClicked = showMedocEditDialog(selectedMedoc);
            if (okClicked) {
                showMedocDetails(selectedMedoc);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            
            alert.showAndWait();
        }
    }
    
    private boolean showMedocEditDialog(Medicament tempMedoc) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ProfilEditerController.class.getResource("/fxml/view/MedicamentsEditer.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editer médicament");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            MedicamentsEditerController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMedoc(medicament);
            
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void handleDeleteMed(ActionEvent event) {
        int selectedIndex = medocTable.getSelectionModel().getSelectedIndex();
        Medicament selectedMedoc = medocTable.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            medocTable.getItems().remove(selectedIndex);
            service.deleteMedicament(selectedMedoc);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(NavigationController.getMainStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Medoc Selected");
            alert.setContentText("Please select a medoc in the table.");
            
            alert.showAndWait();
        }
    }
}
