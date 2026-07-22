package Util;

import Model.UserSession;
import java.io.*;

public class SessionManager {
    private static final String SESSION_FILE = "session.dat";

    // 1. CREATE: Serializes user session to session.dat upon successful login
    public static boolean createSession(UserSession session) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SESSION_FILE))) {
            oos.writeObject(session);
            System.out.println("[SessionManager] Serialized session file created: " + SESSION_FILE);
            return true;
        } catch (IOException e) {
            System.err.println("[SessionManager] Error creating session file: " + e.getMessage());
            return false;
        }
    }

    // 2. READ: Deserializes and validates the existing session file
    public static UserSession getActiveSession() {
        File file = new File(SESSION_FILE);
        if (!file.exists()) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (UserSession) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[SessionManager] Failed to read session file: " + e.getMessage());
            return null;
        }
    }

    // 3. DELETE: Removes session.dat on logout
    public static boolean destroySession() {
        File file = new File(SESSION_FILE);
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("[SessionManager] Session file successfully deleted.");
            }
            return deleted;
        }
        return false;
    }

    // Helper check
    public static boolean hasActiveSession() {
        return getActiveSession() != null;
    }
}