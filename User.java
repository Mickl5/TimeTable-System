/**
 * user system that has the user's ID, name and password.
 *
 */
public class User {
    private String userId;
    private String name;
    private String password;

    /**
     * creates an empty user object to load CSV
     */
    public User() {} // had to add no arg to be able to extend + make empty object

    /**
     *
     * @param userId the isers unique ID
     * @param name the users name
     * @param password the users password
     */
    public User(String userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    /**
     * gets the users name
     * @return the users name
     */
    public String getName() { return name;}


    /**
     * sets the users name
     * @param name the name for the user
     */
    public void setName(String name) {this.name = name;}

    /**
     * gets the users password
     * @return the users password
     */
    public String getPassword() {return password;}

    /**
     * sets the users password
     * @param password password for the user
     */
    public void setPassword(String password) {this.password = password;}

    /**
     * gets the users ID number
     * @return the users ID number
     */
    public String getUserId() {return userId;}

    /**
     * sets the users ID
     * @param userId the ID no. for the user
     */
    public void setUserId(String userId) {this.userId = userId;}

}
