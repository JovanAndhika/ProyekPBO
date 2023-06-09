module com.example.proyek2pbo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.proyek2pbo to javafx.fxml;
    exports com.example.proyek2pbo;
}