module com.example.sapkis_lw_8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sapkis_lw_8 to javafx.fxml;
    exports com.example.sapkis_lw_8;
}