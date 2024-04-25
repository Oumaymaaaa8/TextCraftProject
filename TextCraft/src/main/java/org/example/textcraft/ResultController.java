package org.example.textcraft;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public  class ResultController implements Initializable {
    private Result result;
    private DashboardController dashboardController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadResult(result );

    }


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
        new ScreenLoader(resultPane, "Dashboard.fxml");

    }

    public void loadResult(Result p) {
        result = p;

        tailleBinaire.setText(p.getLongueurBinaire().toString());
        tauxComp.setText(p.getTauxComp().toString());
    }
}