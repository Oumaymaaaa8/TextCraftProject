module org.example.textcraft {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.textcraft to javafx.fxml;
    exports org.example.textcraft;
}