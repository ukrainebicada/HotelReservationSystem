Hotel Reservation System
A desktop app built using JavaFX, MySQL, and Maven for managing hotel room bookings and user sessions.
Features
1. User registration and login connected to a MySQL database.
2. Interactive screens to search available rooms and place bookings.
3. Active user session tracking using local file storage.
Serialization Mechanism
1. Login: Upon successful authentication, `SessionManager` uses `ObjectOutputStream` to save a `UserSession` object to `session.dat`.
2. Session Validation: `SessionManager` uses `ObjectInputStream` to read `session.dat` and verify active user details when navigating screens.
3. Logout: The `session.dat` file is automatically deleted from the disk, and the user is redirected to the login screen.
SOLID Principles Applied
1. Single Responsibility Principle (SRP): `DBConnection` handles database connections, `SessionManager` handles session file operations, and `LoginController` handles user interface logic.
2. Dependency Inversion Principle (DIP): UI controllers depend on the high-level `SessionManager` helper rather than performing raw file stream operations directly.
Setup and Execution
1. Start Apache and MySQL in XAMPP.
2. Create a database named `hotelreservation` in phpMyAdmin and import `hotelreservation.sql`.
3. Open the project in IntelliJ IDEA and run `Launcher.java`.
