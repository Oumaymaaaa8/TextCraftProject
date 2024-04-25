package org.example.textcraft;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {


    @FXML
    private ChoiceBox<String> AlgorithmSelect;
    private String[] algos = {"Huffman", "Fano-Shannon", "Run-Length Encoding"};

    @FXML
    private Button BrowseButton;

    @FXML
    private Button DecoderButtom;

    @FXML
    private Button coderButtom;

    @FXML
    private BorderPane dashboardPane;

    @FXML
    private TextArea inputText;

    private Result result = new Result();
    @FXML
    void Coder(ActionEvent event) throws IOException {
        var texte = inputText.getText();
        String alg = AlgorithmSelect.getValue();

        switch (alg) {
            case "Huffman":
                Huffman huffmanclient = new Huffman(texte);
                result.setResult(huffmanclient.coder());
                result.setLongueurBinaire(huffmanclient.longBinaire());
                result.setTauxComp(huffmanclient.tauxCompCodage());
                switchToResultPanel(result);
                break;
            case "Fano-Shannon":
                ShannonCoder shannonCoder = new ShannonCoder(texte);
                result.setResult(shannonCoder.coder(texte));
                result.setLongueurBinaire(shannonCoder.longBinaire());
                result.setTauxComp(shannonCoder.tauxCompCodage());
                switchToResultPanel(result);
                break;
            case "Run-Length Encoding":
                RLEClient rleClient = new RLEClient(texte);
                result.setResult(rleClient.LREcoder());
                result.setLongueurBinaire(rleClient.longBinaire());
                result.setTauxComp(rleClient.tauxCompCodage());
                switchToResultPanel(result);

                break;

        }
    }





@FXML
void Decoder(ActionEvent event) {



}


@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    AlgorithmSelect.getItems().setAll(algos);

}


    public void switchToResultPanel(Result result) throws IOException {
        FXMLLoader loader = ScreenLoader.loadResultatPanel();
        try {
            assert loader != null;
            Parent panel = (Parent) loader.load();
            ResultController controller = loader.getController();
            controller.loadResult(result); // Pass the result object to the controller
            dashboardPane.setCenter(panel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {


}
}
