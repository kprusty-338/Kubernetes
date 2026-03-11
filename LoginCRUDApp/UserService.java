import java.util.*;

public class UserService {
    private Map<Integer, User> users = new HashMap<>();
    private int nextId = 1;

    public User createUser(String username, String password) {
        User user = new User(nextId++, username, password);
        users.put(user.getId(), user);
        return user;
    }

    public User readUser(int id) {
        return users.get(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public boolean updateUser(int id, String username, String password) {
        User user = users.get(id);
        if (user != null) {
            user.setUsername(username);
            user.setPassword(password);
            return true;
        }
        return false;
    }

    public boolean deleteUser(int id) {
        return users.remove(id) != null;
    }
}
