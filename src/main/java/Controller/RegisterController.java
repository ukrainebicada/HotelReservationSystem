package Controller;

import Application.Main;
import Database.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterController {

    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private PasswordField txtConfirmPassword;
    @FXML private Label lblMessage;

    @FXML
    private void handleRegister() {
        String user = txtUsername.getText().trim();
        String pass = txtPassword.getText().trim();
        String confirm = txtConfirmPassword.getText().trim();

        if (user.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
            lblMessage.setText("Please complete all fields.");
            return;
        }

        if (!pass.equals(confirm)) {
            lblMessage.setText("Passwords do not match.");
            return;
        }

        String query = "INSERT INTO users (username, password, fullname) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user);
            stmt.setString(2, pass);
            stmt.setString(3, user); // Uses username as placeholder for fullname
            stmt.executeUpdate();

            lblMessage.setStyle("-fx-text-fill: green;");
            lblMessage.setText("Registration successful!");
            Main.switchScene("/View/Login.fxml", "Login");

        } catch (Exception e) {
            e.printStackTrace();
            lblMessage.setText("Database insertion failed.");
        }
    }

    @FXML
    private void goToLogin() {
        Main.switchScene("/View/Login.fxml", "Login");
    }
}