import java.util.List;

/**
 * Provides login and user management using the users loaded by CSVDataManager.
 */
public class UserController extends Controller{

    private User currentUser;

    /**
     * login controller using the csv data
     * @param manager the Dataanager used to load and store the data
     */
    public UserController(CSVDataManager manager) {
        super(manager);
    }

    /**
     * tries to log in using the users id and password
     * @param userId the id of the user
     * @param password password of user
     * @return the user if login info is correct, else false
     */
    public boolean login(String userId, String password) {
        for (User user : getManager().getUsers()) {
            if (user.getUserId().equals(userId)
                    && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return user thats logged in
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * adds a user to the system
     * @param user user to be added
     */
    public void addUser(User user) {
        getManager().getUsers().add(user);
    }

    /**
     * removes a user form the system based on their ID. if matching
     * ID found user is removed
     * @param userId id of user to remove
     * @return if true found and removed
     */
    public boolean removeUser(String userId) {
        if (userId == null) {
            return false;
        }

        List<User> users = getManager().getUsers();
        if (users == null) {
            return false;
        }

        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.getUserId().equals(userId)) {
                users.remove(i);

                return true;
            }
        }
        return false;
    }
}

