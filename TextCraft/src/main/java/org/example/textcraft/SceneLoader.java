package org.example.textcraft;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class SceneLoader {
    public SceneLoader(BorderPane pane, String fxml) throws IOException {
        BorderPane next = FXMLLoader.load(Objects.requireNonNull(TextCraftApplication.class.getResource(fxml)));
        pane.getChildren().removeAll();
        pane.getChildren().setAll(next);
    }
}
