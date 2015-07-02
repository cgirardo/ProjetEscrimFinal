package com.teamcs.app;

import com.teamcs.controller.common.MainController;
import com.teamcs.controller.common.NavigationController;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConnexionApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("SDIS30 - ESCRIM");
        NavigationController.setMainStage(stage);
        stage.setScene(createScene(loadMainPane()));
        stage.setResizable(false);
        stage.show();
    }
    
    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(NavigationController.VIEW_MAIN));
        MainController mainController = loader.getController();       
        NavigationController.setMainController(mainController);
        NavigationController.loadView(NavigationController.VIEW_CONNEXION);       
        return mainPane;
    }
    
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        return scene;
    }
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
