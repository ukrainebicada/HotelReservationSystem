package Model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserSession implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userId;
    private String username;
    private String role;
    private LocalDateTime loginTime;

    public UserSession(int userId, String username, String role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.loginTime = LocalDateTime.now();
    }

    // Getters
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getRole() { return role; }
    public LocalDateTime getLoginTime() { return loginTime; }
}