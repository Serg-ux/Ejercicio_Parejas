module com.example.practica_5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica_5 to javafx.fxml;
    exports com.example.practica_5;
}