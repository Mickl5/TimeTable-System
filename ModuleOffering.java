import java.util.ArrayList;

/**
 * A class that represents the actual module entity in the timetable
 * */
public class ModuleOffering {
    Module module;
    private int semesterNumber;
    ArrayList<Session> sessions;

    /**
     * Creates a ModuleOffering object with the following arguments
     * @param module the module it represents
     * @param semesterNumber the semester it belongs to
     * @param sessions the list of labs/tutorials/labs this module has
     * */
    public ModuleOffering(Module module, int semesterNumber, ArrayList<Session> sessions) {
        this.module = module;
        this.semesterNumber = semesterNumber;
        this.sessions = sessions;
    }

    /* public void addSession(Session session) {
        sessions.add(session);
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    } */
}


