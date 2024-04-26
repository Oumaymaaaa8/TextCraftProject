package org.example.textcraft;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String content;
    FileChooser fileChooser = new FileChooser();

    @FXML
    void Coder(ActionEvent event) throws IOException {
        String content = inputText.getText(); // Initialize content with the text from inputText

        // If inputText is not empty, proceed with encoding
        if (!content.isEmpty()) {
            Result result = new Result();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Resultat.fxml"));
            root = loader.load();
            ResultController resultController = loader.getController();
            String alg = AlgorithmSelect.getValue().toString();

            switch (alg) {
                case "Huffman":
                    Huffman huffmanclient = new Huffman(content);
                    result.setText(huffmanclient.encode());
                    result.setLongueurBinaire(huffmanclient.longBinaire());
                    result.setTauxComp(huffmanclient.tauxCompCodage());
                    result.setAlgorithm("H");
                    resultController.loadResultHuffman(result, huffmanclient);
                    break;
                case "Fano-Shannon":
                    ShannonCoder shannonCoder = new ShannonCoder(content);
                    result.setText(shannonCoder.shannonCoder());
                    result.setLongueurBinaire(shannonCoder.longBinaire());
                    result.setTauxComp(shannonCoder.tauxCompCodage());
                    result.setAlgorithm("FS");
                    resultController.loadResultShannon(result, shannonCoder);
                    break;
                case "Run-Length Encoding":
                    RLEClient rleClient = new RLEClient(content);
                    result.setText(rleClient.LREcoder());
                    result.setLongueurBinaire(rleClient.longBinaire());
                    result.setTauxComp(rleClient.tauxCompCodage());
                    result.setAlgorithm("RLE");
                    resultController.loadResult(result);
                    break;
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        // If content is empty, browse for a file
        if (content.isEmpty()) {
            content = browseFiles(event);
            if (!content.isEmpty()) { // Proceed with encoding only if content is not empty
                Result result = new Result();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Resultat.fxml"));
                root = loader.load();
                ResultController resultController = loader.getController();
                String alg = AlgorithmSelect.getValue().toString();

                switch (alg) {
                    case "Huffman":
                        Huffman huffmanclient = new Huffman(content);
                        result.setText(huffmanclient.encode());
                        result.setLongueurBinaire(huffmanclient.longBinaire());
                        result.setTauxComp(huffmanclient.tauxCompCodage());
                        result.setAlgorithm("H");
                        resultController.loadResultHuffman(result, huffmanclient);
                        break;
                    case "Fano-Shannon":
                        ShannonCoder shannonCoder = new ShannonCoder(content);
                        result.setText(shannonCoder.shannonCoder());
                        result.setLongueurBinaire(shannonCoder.longBinaire());
                        result.setTauxComp(shannonCoder.tauxCompCodage());
                        result.setAlgorithm("FS");
                        resultController.loadResultShannon(result, shannonCoder);
                        break;
                    case "Run-Length Encoding":
                        RLEClient rleClient = new RLEClient(content);
                        result.setText(rleClient.LREcoder());
                        result.setLongueurBinaire(rleClient.longBinaire());
                        result.setTauxComp(rleClient.tauxCompCodage());
                        result.setAlgorithm("RLE");
                        resultController.loadResult(result);
                        break;
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                System.out.println("NOT FOUND CONTENT");
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AlgorithmSelect.getItems().setAll(algos);
        fileChooser.setInitialDirectory(new File("/home/ouma/"));

    }

    @FXML
    String browseFiles(ActionEvent event) throws FileNotFoundException {
        StringBuilder fileContent = new StringBuilder();
        File file = fileChooser.showOpenDialog(new Stage());
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            fileContent.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return fileContent.toString();
    }



}






