package Controller;
import Database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterController {

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ComboBox<String> cmbRole;

    @FXML
    public void initialize() {

        cmbRole.getItems().add("Admin");
        cmbRole.getItems().add("Receptionist");

    }


    @FXML
    public void onBackClicked() {

        System.out.println("Back button clicked");

    }
    @FXML
    public void onRegisterClicked() {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "INSERT INTO users(fullname,username,password,role) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, txtFullName.getText());
            ps.setString(2, txtUsername.getText());
            ps.setString(3, txtPassword.getText());
            ps.setString(4, cmbRole.getValue());

            ps.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Registration Successful!");
            alert.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
