/**
 * the class gets timetables for the students,lecturers,rooms,subjects,and modules
 *
 */
public class TimetableController extends Controller {

    public TimetableController(CSVDataManager manager) {
        super(manager);

    }

    /**
     *  Retrieves the timetable for a specific lecturer.
     * @param lecturerID the lecturer to be searchd for
     * @return a timetable object containing all the sessions with the specified arguments
     */
    public Timetable getTimetableForLecturer(String lecturerID) {
        Timetable timetable = new Timetable();
        Lecturer lecturer = getManager().getLecturerById(lecturerID);
        for (Session session : getManager().getTimetable().getSessions()) {
            if (session.getLecturer().equals(lecturer)) {
                timetable.addSession(session);
            }
        }
        return timetable;
    }

    /**
     * gets the timetable for a specific student
     * @param groupID the student group to be searched for
     * @return a timetable object containing all the sessions with the specified arguments
     */
    public Timetable getTimetableForStudent(String groupID) {
        Timetable timetable = new Timetable();
        StudentGroup studentGroup = getManager().getGroupById(groupID);
        for (Session session : getManager().getTimetable().getSessions()) {
            if (session.getGroup().equals(studentGroup)) {
                timetable.addSession(session);
            }
            if (!session.getGroup().getSubGroups().isEmpty()) {
                for (StudentGroup group : session.getGroup().getSubGroups()) {
                    if (group.equals(studentGroup)) {
                        timetable.addSession(session);
                    }
                }
            }
        }
        return timetable;
    }

    /**
     * gets the timetable for a specific room
     * @param roomID the room to be searched for
     * @return a timetable object containing all the sessions with the specified arguments
     */
    public Timetable getTimetableForRoom(String roomID) {
        Timetable timetable = new Timetable();
        Room room = getManager().getRoomById(roomID);
        for (Session session : getManager().getTimetable().getSessions()) {
            if (session.getRoom().equals(room)) {
                timetable.addSession(session);
            }
        }
        return timetable;


    }

    /**
     * gets the timetable for a specific subject
     * @param subjectCode the subject to be searched for
     * @param yearNumber the year to be searched for
     * @param semesterNumber the semester to be searched fr
     * @return a timetable object containing all the sessions with the specified arguments
     */
    public Timetable getTimetableForSubject(String subjectCode, int yearNumber, int semesterNumber) {
        Timetable timetable = new Timetable();
        Subjects subject = getManager().getSubjectById(subjectCode);
        if(subject == null) return null;
        for (Session session : getManager().getTimetable().getSessions()) {
            SubjectsYear year = subject.getYear(yearNumber);
            if (session.getGroup().getSubject().equals(subject) && session.getGroup().getSubjectYear().equals(year) && session.getSemesterNumber() == semesterNumber) {
                timetable.addSession(session);
            }
        }
        return timetable;

    }

    /**
     * gets the timetable for a specific module
     *
     */

    public Timetable getTimetableForModule(String moduleCode) {
        Timetable timetable = new Timetable();
        Module module = getManager().getModuleById(moduleCode);
        for (Session session : getManager().getTimetable().getSessions()) {
            if (session.getModule().equals(module)) {
                timetable.addSessionIgnoresConflicts(session);
            }
        }
        return timetable;
    }
}