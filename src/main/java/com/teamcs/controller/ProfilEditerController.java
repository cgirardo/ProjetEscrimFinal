package com.teamcs.controller;

import com.teamcs.database.bean.Utilisateur;
import com.teamcs.service.UtilisateurService;
import com.teamcs.service.impl.UtilisateurServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author chris_000
 */
public class ProfilEditerController {
    
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
    
    private AccueilController controller;
    
    public ProfilEditerController() {
        
    }
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        personTable.setItems(getDataFromDatabase());
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
        
        showPersonDetails(null);
        
        personTable.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Utilisateur>() {
                    public void changed(ObservableValue<? extends Utilisateur> observable, Utilisateur oldValue, Utilisateur newValue) {
                         showPersonDetails(newValue);
                    }
                });
    }
    
    public ObservableList<Utilisateur> getDataFromDatabase() {
        ObservableList<Utilisateur> personData = FXCollections.observableArrayList();
        UtilisateurService service = new UtilisateurServiceImpl();
        personData.addAll(service.findAll());
        return personData;
    }
    
    public void setFXMLAccueilController(AccueilController controller) {
        this.controller = controller;
        
        personTable.setItems(controller.getUserData());
    }
    
    private void showPersonDetails(Utilisateur user) {
        if(user != null) {
            firstNameLabel.setText(user.getPrenom());
            lastNameLabel.setText(user.getNom());
            mailLabel.setText(user.getMail());
            streetLabel.setText(user.getRue());
            postalCodeLabel.setText(user.getCodePostal());
            cityLabel.setText(user.getVille());
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            mailLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
        }
    }
}
