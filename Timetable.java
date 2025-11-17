import java.util.ArrayList;

/**Creates the timetable*/
public class Timetable {

    /**Defines the array list*/
    ArrayList<ArrayList<String>> sessions;

    /**The timetable is given substance*/
    public void timetable(){
        sessions = new ArrayList<ArrayList<String>>();

    }

    /**Gets the session*/
    public ArrayList<ArrayList<String>> getSessions() {
        return sessions;
    }
}
