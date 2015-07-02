package com.teamcs.controller;

import com.teamcs.controller.common.NavigationController;
import com.teamcs.database.bean.Utilisateur;
import com.teamcs.service.UtilisateurService;
import com.teamcs.service.impl.UtilisateurServiceImpl;
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
import org.jboss.logging.Logger;

/**
 * FXML Controller class
 *
 * @author chris_000
 */
public class UtilisateursConsulterController {
    
    private static Logger logger = Logger.getLogger(UtilisateursConsulterController.class);
    
    Stage primaryStage;
    private UtilisateurService service;
    private Utilisateur utilisateur;
    private ObservableList<Utilisateur> personData;
    
    @FXML
    private TableView<Utilisateur> personTable;
    @FXML
    private TableColumn<Utilisateur, String> firstNameColumn;
    @FXML
    private TableColumn<Utilisateur, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label mailLabel;
    @FXML
    private Label statutLabel;
    
//    private MenuController controller;
    
    public UtilisateursConsulterController() {
        
    }
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        service = new UtilisateurServiceImpl();
        getDataFromDatabase();
        personTable.setItems(personData);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
        
        showPersonDetails(null);
        
        personTable.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Utilisateur>() {
                public void changed(ObservableValue<? extends Utilisateur> observable, Utilisateur oldValue, Utilisateur newValue) {
                     showPersonDetails(newValue);
                }
            });
        primaryStage = NavigationController.getMainStage();
        primaryStage.setHeight(600.0);
        primaryStage.setWidth(850.0);
    }
    
    public void getDataFromDatabase() {
        personData = FXCollections.observableArrayList();
        personData.addAll(service.findAll());
    }
    
//    public void setFXMLAccueilController(MenuController controller) {
//        this.controller = controller;
//        
//        personTable.setItems(controller.getUserData());
//    }
    
    private void showPersonDetails(Utilisateur user) {
        if(user != null) {
            firstNameLabel.setText(user.getPrenom());
            lastNameLabel.setText(user.getNom());
            mailLabel.setText(user.getMail());
            streetLabel.setText(user.getRue());
            postalCodeLabel.setText(user.getCodePostal());
            cityLabel.setText(user.getVille());
            statutLabel.setText(user.getStatut().getLibelleStatut());
            utilisateur = user;
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            mailLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            statutLabel.setText("");
        }
    }
    
    @FXML
    private void handleNewUser(ActionEvent event) {
        Utilisateur tempPerson = new Utilisateur();
        boolean okClicked = showPersonNewDialog(tempPerson);
        if (okClicked) {
            personData.add(tempPerson);
        }
    }
    
    private boolean showPersonNewDialog(Utilisateur tempPerson) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(UtilisateursConsulterController.class.getResource("/fxml/view/UtilisateursNouveau.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nouvel utilisateur");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            UtilisateursNouveauController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch(Exception e) {
            logger.fatal("Erreur lors du chargement de le Dialog !");
            return false;
        }
    }
    
    private boolean showPersonEditDialog(Utilisateur tempPerson) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(UtilisateursConsulterController.class.getResource("/fxml/view/UtilisateursEditer.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editer utilisateur");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            UtilisateursEditerController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(utilisateur);
            
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } catch(Exception e) {
            logger.fatal("Erreur lors du chargement de le Dialog !");
            return false;
        }
    }
    
    @FXML
    private void handleEditUser(ActionEvent event) {
        Utilisateur selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
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
    @FXML
    private void handleDeleteUser(ActionEvent event) {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        Utilisateur selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
            service.deleteUtilisateur(selectedPerson);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(NavigationController.getMainStage());
            alert.setTitle("Aucune Selection");
            alert.setHeaderText("Aucun utilisateur sélectionné");
            alert.setContentText("Veuillez sélectionner un utilisteur dans la table");
            alert.getDialogPane().getStyleClass().add("myDialogs");
            alert.showAndWait();
        }
    }
}
