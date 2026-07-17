package Controller;

import javafx.fxml.FXML;

   import javafx.event.ActionEvent;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

    public class LoginController {

        @FXML
        private TextField txtUsername;

        @FXML
        private PasswordField txtPassword;

        @FXML
        private void onLoginClicked(ActionEvent event) {

            String username = txtUsername.getText();
            String password = txtPassword.getText();

            if (username.equals("admin") && password.equals("1234")) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Login Successful!");
                alert.showAndWait();

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Invalid Username or Password!");
                alert.showAndWait();
            }
        }

        @FXML
        private void onExitClicked(ActionEvent event) {
            System.exit(0);
        }
    }

