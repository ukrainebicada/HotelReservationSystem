module com.example.hotelreservationsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.hotelreservationsystem to javafx.fxml;
    exports com.example.hotelreservationsystem;

    opens Controller to javafx.fxml;
    exports Controller;
}