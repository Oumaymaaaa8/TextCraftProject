package org.example.textcraft;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultController {
    private Result result = new Result();
    private DashboardController dashboardController;
    private ShannonCoder shannonClient;

    private Huffman huffman;
    private RLEClient rleClient;

    @FXML
    private Button decode;

    @FXML
    private Text labebTauxCom;

    @FXML
    private Text labelLongBinaire;

    @FXML
    private Text longBin;

    @FXML
    private TextArea output;

    @FXML
    private BorderPane resultPane;

    @FXML
    private Button retour;

    @FXML
    private Text tauxxCom;


    @FXML
    void decoder(ActionEvent event) throws IOException {
        String alg = result.getAlgorithm();

        switch (alg) {
            case "H":
                result.setText(huffman.decode(output.getText()));
                result.setLongueurBinaire(huffman.longBinaireDecodage());
                result.setTauxComp(huffman.tauxCompDecodage());
                result.setAlgorithm("H");
                break;
            case "FS":

                result.setText(shannonClient.shannonDecoder(output.getText().toString()));
                result.setLongueurBinaire(shannonClient.longBinaireDecodage());
                result.setTauxComp(shannonClient.tauxCompDecodage());
                result.setAlgorithm("FS");
                break;
            case "RLE":
                RLEClient rleClient = new RLEClient(output.getText());
                result.setText(rleClient.deCompression());
                result.setLongueurBinaire(rleClient.longBinaireDecodage());
                result.setTauxComp(rleClient.tauxCompDecodage());
                result.setAlgorithm("RLE");
                break;

        }
        output.setText(result.getText());
        longBin.setText(result.getLongueurBinaire().toString());
        tauxxCom.setText(result.getTauxComp().toString());


    }

    @FXML
    void switchToDashboard(ActionEvent event) throws IOException {
        new ScreenLoader(resultPane, "Dashboard.fxml");
    }


    public void loadResult(Result p) {
        result.setText(p.getText());
        result.setTauxComp(p.getTauxComp());
        result.setLongueurBinaire(p.getLongueurBinaire());
        result.setAlgorithm(p.getAlgorithm());

        output.setText(result.getText());
        longBin.setText(result.getLongueurBinaire().toString());
        tauxxCom.setText(result.getTauxComp().toString());
    }

    public void loadResultHuffman(Result p, Huffman huffmanclient) {
        result.setText(p.getText());
        result.setTauxComp(p.getTauxComp());
        result.setLongueurBinaire(p.getLongueurBinaire());
        result.setAlgorithm(p.getAlgorithm());

        output.setText(result.getText());
        longBin.setText(result.getLongueurBinaire().toString());
        tauxxCom.setText(result.getTauxComp().toString());
        huffman = huffmanclient;
    }

    public void loadResultShannon(Result p, ShannonCoder shannonCoder) {
        result.setText(p.getText());
        result.setTauxComp(p.getTauxComp());
        result.setLongueurBinaire(p.getLongueurBinaire());
        result.setAlgorithm(p.getAlgorithm());

        output.setText(result.getText());
        longBin.setText(result.getLongueurBinaire().toString());
        tauxxCom.setText(result.getTauxComp().toString());
        shannonClient = shannonCoder;
    }
}