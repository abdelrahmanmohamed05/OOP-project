import java.util.HashMap;

public class User {
    private String username;
    private String password;

    private static HashMap<String, String> userCredentials = new HashMap<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static void register(String username, String password) {
        if (userCredentials.containsKey(username)) {
            System.out.println("Username already exists. Please choose another.");
        } else {
            userCredentials.put(username, password);
            System.out.println("User registered successfully!");
        }
    }

    public static boolean login(String username, String password) {
        return userCredentials.getOrDefault(username, "").equals(password);
    }

    public static boolean userExists(String username) {
        return userCredentials.containsKey(username);
    }
}