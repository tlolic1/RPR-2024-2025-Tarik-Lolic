module com.example.lvl07 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.lvl07 to javafx.fxml;
    exports com.example.lvl07;
}