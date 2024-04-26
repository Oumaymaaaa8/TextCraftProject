package org.example.textcraft;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class ScreenLoader {
    public ScreenLoader(BorderPane pane, String fxml) throws IOException {
        BorderPane next = FXMLLoader.load(TextCraftApplication.class.getResource(fxml));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(next);
    }


}

