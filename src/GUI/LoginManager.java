package GUI;

public class LoginManager {
    public boolean authenticate(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }
}