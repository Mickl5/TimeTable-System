import java.util.ArrayList;
import java.util.List;

public class Login {

    private List<User> users;

    public Login() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public User login( String UserId, String Password) {
        for (User user : users) {
            if (user.getUserId().equals(UserId) && user.getPassword().equals(Password)) {
                return user;
            }
        }
        return null;

    }
}
