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
        sessions.add (session);
    }

}
