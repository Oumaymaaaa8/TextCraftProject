module org.example.textcraft {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.textcraft to javafx.fxml;
    exports org.example.textcraft;
    exports org.example.textcraft.huffman;
    opens org.example.textcraft.huffman to javafx.fxml;
    exports org.example.textcraft.Shannon;
    opens org.example.textcraft.Shannon to javafx.fxml;
    exports org.example.textcraft.RLE;
    opens org.example.textcraft.RLE to javafx.fxml;
}