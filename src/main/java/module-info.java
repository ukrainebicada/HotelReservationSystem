module com.example.hotelreservationsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens Application to javafx.graphics, javafx.fxml;
    opens Controller to javafx.fxml;
    opens com.example.hotelreservationsystem to javafx.graphics, javafx.fxml;
    opens Model to javafx.base; // Added for Serialization & Data Binding

    exports Application;
    exports Controller;
    exports Database;
    exports Model;
    exports Util;
}