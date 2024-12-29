module com.example.lv09 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.lv09 to javafx.fxml;
    exports com.example.lv09;
}