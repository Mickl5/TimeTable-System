import java.util.ArrayList;
import java.util.List;

/**
 * lecturer class that has their name, id and sessions they teach
 */
public class Lecturer  {
    private String LecturerId;
    private String LecturerName;
    private List<Session> sessions;
    private LecturerType type;

    /**
     *  creates a lecturer with specific name and id, initialises an empty list of sessions
     * @param LecturerId the lecturers ID number
     * @param LecturerName the lecturers name
     */
    public Lecturer(String LecturerId, String LecturerName, LecturerType type) {
        this.LecturerId = LecturerId;
        this.LecturerName = LecturerName;
        this.sessions = new ArrayList<>();
        this.type = type;
    }

    /**
     * gets their ID
     * @return the lecturers ID
     * */
    public String getLecturerId() {
        return LecturerId;
    }

    /**
     * gets the lecturers name
     * @return the lecturers name
     */
    public String getLecturerName() {
        return LecturerName;
    }

    /**
     * gets the lecturers type
     * @return lecturers type (lecturer/ T/A)
     */
    public LecturerType getType() {
        return type;
    }

    /**
     * adds a class to the lecturers session list
     * @param s the session to add
     */
    public void addSession( Session s) {
        sessions.add(s);
    }

}

/*import java.util.List;

public class Lecturer extends User {
private List<String> Modules;

public Lecturer(String userId, String name, String password, List<String> Modules)
    {
        super(userId, name, password); // calls from user class
        this.Modules = Modules;
    }

    public List<String> getModules() {
        return Modules;
    }
    public void setModules(List<String> Modules) {}
}*/

