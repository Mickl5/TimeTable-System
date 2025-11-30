import java.util.ArrayList;

/**Creates the timetable*/
public class Timetable {

    /**Defines the array list*/
    ArrayList<Session> sessions;

    /**The timetable is given substance*/
    public Timetable(){
        sessions = new ArrayList<Session>();
    }

    /**Gets the session*/
    public ArrayList<Session> getSessions() {
        return sessions;
    }

    /**Adds a session to the timetable*/
    public void addSession(Session session){
        if (ConflictChecker.hasConflict(session, getSessions())) {
            System.out.println("The entered session overlaps an existing session");
            return;
        }
        sessions.add (session);
    }

    /**
     * Removes the given session from the timetable
     * @param session
     * */
    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public void addSessionIgnoresConflicts(Session session) {
        sessions.add(session);
    }

}
