import java.util.ArrayList;

/**
 * A class that represents the actual module entity in the timetable
 * */
public class ModuleOffering {
    Module module;
    private int semesterNumber;
    private ArrayList<Session> sessions;
    private ArrayList<StudentGroup> enrolledGroups;

    /**
     * Creates a ModuleOffering object with the following arguments
     * @param module the module it represents
     * @param semesterNumber the semester it belongs to
     * */
    public ModuleOffering(Module module, int semesterNumber) {
        this.module = module;
        this.semesterNumber = semesterNumber;
        this.sessions = new ArrayList<>();
        this.enrolledGroups = new ArrayList<>();
    }

    public ArrayList<StudentGroup> getEnrolledGroups() {
        return this.enrolledGroups;
    }

    public void addGroup(StudentGroup group) {
        enrolledGroups.add(group);
    }

    public Module getModule() {
        return this.module;
    }

    /* public void addSession(Session session) {
        sessions.add(session);
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    } */
}


