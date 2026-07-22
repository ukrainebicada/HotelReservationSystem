package Controller;

import Application.Main;
import Database.DBConnection;
import Model.UserSession;
import Util.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMessage;

    @FXML
    private void handleLogin() {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            lblMessage.setText("Please fill in all fields.");
            return;
        }

        String query = "SELECT user_id, username FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("user_id");

                // CREATE SERIALIZED SESSION
                UserSession userSession = new UserSession(id, username, "Guest");
                SessionManager.createSession(userSession);

                // REDIRECT TO DASHBOARD
                Main.switchScene("/View/Dashboard.fxml", "Dashboard");
            } else {
                lblMessage.setText("Invalid username or password.");
            }
        } catch (Exception e) {
            lblMessage.setText("Database connection error.");
            e.printStackTrace();
        }
    }

    @FXML
    private void goToRegister() {
        Main.switchScene("/View/Register.fxml", "Register");
    }
}