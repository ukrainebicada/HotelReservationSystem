package Controller;

import Application.Main;
import Model.UserSession;
import Util.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML private Label lblWelcome;

    @FXML
    public void initialize() {
        // Validate active session via deserialization
        UserSession activeSession = SessionManager.getActiveSession();

        if (activeSession != null) {
            lblWelcome.setText("Welcome back, " + activeSession.getUsername() + "!");
        } else {
            // Unauthenticated access protection
            handleLogout();
        }
    }

    @FXML
    private void goToSearchRooms() {
        Main.switchScene("/View/SearchRoom.fxml", "Search Rooms");
    }

    @FXML
    private void goToBookings() {
        Main.switchScene("/View/Booking.fxml", "Bookings");
    }

    @FXML
    private void handleLogout() {
        // DELETE SERIALIZED SESSION FILE
        SessionManager.destroySession();

        // REDIRECT TO LOGIN
        Main.switchScene("/View/Login.fxml", "Login");
    }
}