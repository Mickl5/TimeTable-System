import java.util.ArrayList;
import java.util.List;

/**
 * manages a list of users and provides a simple login mechanism.
 * Users can be added to the system, and the login method checks login info.
 */
public class Login {

    /**
     * list of users in the system
     */
    private List<User> users;

    /**
     * Constructs a new Login system with empty user list.
     */
    public Login() {
        users = new ArrayList<>();
    }

    /**
     * Adds a user to the login system.
     *
     * @param user the User to add
     */
    public void addUser(User user) {
        this.users.add(user);
    }

    /**
     * Tries to log in with the given user ID and password.
     * If a matching user is found with the correct info, that User is returned.
     *
     * @param UserId the ID of the user attempting to log in
     * @param Password the password of the user
     * @return the User if info matches; null otherwise
     */
    public User login( String UserId, String Password) {
        for (User user : users) {
            if (user.getUserId().equals(UserId) && user.getPassword().equals(Password)) {
                return user;
            }
        }
        return null;

    }
}
