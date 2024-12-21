import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private String userType; // "admin" or "user"

    private static HashMap<String, User> users = new HashMap<>();

    public User(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public static void register(String username, String password, String userType) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose another.");
        } else {
            users.put(username, new User(username, password, userType));
            System.out.println("User registered successfully!");
        }
    }

    public static User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.password.equals(password)) {
            return user;
        }
        return null;
    }
}