package org.example.textcraft;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class ScreenLoader {
    public ScreenLoader(BorderPane pane, String fxml) throws IOException {
        BorderPane next = FXMLLoader.load(Objects.requireNonNull(TextCraftApplication.class.getResource(fxml)));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(next);
    }


    public static Parent loadFXML(String fxml) throws IOException {
        var fileUrl = TextCraftApplication.class.getResource(fxml + ".fxml");
        // System.out.println(fileUrl);
        FXMLLoader fxmlLoader = new FXMLLoader(fileUrl);
        return fxmlLoader.load();
    }

    public static FXMLLoader loadLoader(String fxml) throws IOException {
        var fileUrl = TextCraftApplication.class.getResource(fxml + ".fxml");

        return new FXMLLoader(fileUrl);

    }

    public static FXMLLoader loadResultatPanel() {
        try {
            return loadLoader("Resultat.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

