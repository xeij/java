module com.example.collab {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.collab to javafx.fxml;
    exports com.example.collab;
}