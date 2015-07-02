/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamcs.controller;

import com.teamcs.controller.common.NavigationController;
import com.teamcs.database.bean.Materiel;
import com.teamcs.service.MaterielService;
import com.teamcs.service.impl.MaterielServiceImpl;
import java.net.URL;
import java.util.ResourceBundle;
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
 * FXML Controller class
 *
 * @author chris_000
 */
public class MaterielsConsulterController {
    
    @FXML Label libelleLabel;
    
    @FXML private TableView<Materiel> materielTable;
    @FXML private TableColumn<Materiel, String> libelleColumn;
    
    private Materiel materiel;
    private MaterielService service;
    private ObservableList<Materiel> materielData;
    Stage primaryStage;
    
    public MaterielsConsulterController () { }
    
    @FXML
    public void initialize() {
        service = new MaterielServiceImpl();
        getDataFromDatabase();
        materielTable.setItems(materielData);
        libelleColumn.setCellValueFactory(new PropertyValueFactory<Materiel, String>("libelleMateriel"));
        
        showMaterielDetails(null);
        
        materielTable.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Materiel>() {
                public void changed(ObservableValue<? extends Materiel> observable, Materiel oldValue, Materiel newValue) {
                     showMaterielDetails(newValue);
                }
            });
        primaryStage = NavigationController.getMainStage();
        primaryStage.setHeight(600.0);
        primaryStage.setWidth(850.0);
    }
    
    public void getDataFromDatabase() {
        materielData = FXCollections.observableArrayList();
        materielData.addAll(service.findAllMateriel());
    }
    
    private void showMaterielDetails(Materiel materiel) {
        if(materiel != null) {
            libelleLabel.setText(materiel.getLibelleMateriel());
            this.materiel = materiel;
        } else {
            libelleLabel.setText("");
        }
    }
    
    @FXML
    private void handleNewMat(ActionEvent event) {
        Materiel tempMat = new Materiel();
        boolean okClicked = showMatNewDialog(tempMat);
        if (okClicked) {
            materielData.add(tempMat);
            initialize();
        }
    }
    
    private boolean showMatNewDialog(Materiel tempMat) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MaterielsConsulterController.class.getResource("/fxml/view/MaterielNouveau.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nouveau matériel");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            MaterielsNouveauController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void handleEditMat(ActionEvent event) {
        Materiel selectedMat = materielTable.getSelectionModel().getSelectedItem();
        if (selectedMat != null) {
            boolean okClicked = showMaterielEditDialog(selectedMat);
            if (okClicked) {
                showMaterielDetails(selectedMat);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle("Aucune selection");
            alert.setHeaderText("Aucun profil selectionné");
            alert.setContentText("Veuillez selectionner une personne sur la table.");
            alert.getDialogPane().getStyleClass().add("myDialogs");
            alert.showAndWait();
        }
    }
    
    private boolean showMaterielEditDialog(Materiel tempMat) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MaterielsConsulterController.class.getResource("/fxml/view/MaterielsEditer.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editer matériels");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            MaterielsEditerController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMateriel(materiel);
            
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @FXML
    private void handleDeleteMat(ActionEvent event) {
        int selectedIndex = materielTable.getSelectionModel().getSelectedIndex();
        Materiel selectedMat = materielTable.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            materielTable.getItems().remove(selectedIndex);
            service.deleteMateriel(selectedMat);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(NavigationController.getMainStage());
            alert.setTitle("Aucune selection");
            alert.setHeaderText("Aucun matériel selectionné");
            alert.setContentText("Veuillez selectionner un matériel sur la table.");
            alert.getDialogPane().getStyleClass().add("myDialogs");
            alert.showAndWait();
        }
    }
}
