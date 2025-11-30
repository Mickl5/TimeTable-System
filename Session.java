import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * session class containing important variables for class scheduling
 */
public class Session {
    private String sessionId;
    private SessionType type;
    private Module module;
    private Room room;
    private Lecturer lecturer;
    private StudentGroup group;
    private LocalTime Time;
    private DayOfWeek day;
    private int durationMinutes;
    private int semesterNumber;

    /**
     * creates a session with a code, what type of class, module, room, time, etc
     * @param sessionId the classes code
     * @param type wether its a lab, lecture, or tutorial
     * @param module what module the class is for
     * @param room the room Id
     * @param lecturer lecturers name who is teaching
     * @param group the students taking the class's group code
     * @param day what day it's on
     * @param time what time it's on
     * @param durationMinutes how long the class is
     * @param semesterNumber what semester this session is in
     */
    public Session(String sessionId, SessionType type, Module module, Room room, Lecturer lecturer, StudentGroup group,
                   DayOfWeek day, LocalTime time, int durationMinutes, int semesterNumber) {

        this.sessionId = sessionId;
        this.type = type;
        this.module = module;
        this.room = room;
        this.lecturer = lecturer;
        this.group = group;
        this.Time = time;
        this.durationMinutes = durationMinutes;
        this.day = day;
        this.semesterNumber = semesterNumber;

    }

    /**
     * gets the sessionId
     * @return the sessionId
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * gets sessionType
     * @return the sessionType
     */
    public SessionType getType() {
        return type;
    }

    /**
     * gets the module the class is for
     * @return the module
     */
    public Module getModule() {
        return module;
    }

    /**
     * gets the room
     * @return room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * gets the lecturer
     * @return lecturer
     */
    public Lecturer getLecturer() {
        return lecturer;
    }

    /**
     * gets the studentGroup number
     * @return the studentGroup
     */
    public StudentGroup getGroup() {
        return group;
    }

    /**
     * gets what time the class is at
     * @return time
     */
    public LocalTime getTime() {
        return Time;
    }

    /**
     * gets the day it's on
     * @return day
     */
    public DayOfWeek getDayOfWeek() {
        return day;
    }

    /**
     * gets how long the class is
     * @return duration
     */
    public int getDurationMinutes() {
        return durationMinutes;
    }

    /**
     * gets the semester number of the session
     * @return semester number
     * */
    public int getSemesterNumber() {
        return this.semesterNumber;
    }

    /**
     * gets the end time of the session
     * @return the end time
     * */
    public LocalTime getEndTime() {
        return this.Time.plusMinutes(this.durationMinutes);
    }
}
