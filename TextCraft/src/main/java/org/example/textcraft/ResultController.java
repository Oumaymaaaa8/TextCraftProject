package org.example.textcraft;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class ResultController {

    @FXML
    private Text NbBits;

    @FXML
    private Button back;

    @FXML
    private BorderPane resultPane;

    @FXML
    private Text tailleBinaire;

    @FXML
    private Text tauxComp;

    @FXML
    void loadDashboard(ActionEvent event) throws IOException {
        new SceneLoader(resultPane , "Dashboard.fxml");

    }

}
