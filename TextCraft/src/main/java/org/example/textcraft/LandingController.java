package org.example.textcraft;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LandingController {
    private Stage stage ;
    private  Scene scene;


    @FXML
    private BorderPane landingPane;

    @FXML
    private Button startButton;

    @FXML
    void switchToDashboard(ActionEvent event) throws IOException {
         new SceneLoader(landingPane , "Dashboard.fxml");
    }

}
