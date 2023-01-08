module com.example.etmekchyanfinalprojectv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.etmekchyanfinalprojectv2 to javafx.fxml;
    exports com.example.etmekchyanfinalprojectv2;
}