module com.example.lvl08 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.lvl08 to javafx.fxml;
    opens com.example.lvl08.controller to javafx.fxml;

    exports com.example.lvl08;
    exports com.example.lvl08.controller;
}