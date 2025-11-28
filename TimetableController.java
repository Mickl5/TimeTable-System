public class TimetableController extends Controller {
    public TimetableController() {
        super(manager);

    }

    public Timetable getTimetableForLecturer(String lecturerID) {
        Timetable timetable = new Timetable();
        Lecturer lecturer = getManager().getLecturerById();
        for (Session session : getManager().getTimetable().getSessions()) {
            if (session.getLecturer().equals(lecturer)) {
                timetable.addSession(session);
            }
        }
        return timetable;
    }

    public Timetable getTimetableForStudent(String groupID) {
        Timetable timetable = new Timetable();
        StudentGroup studentGroup = getManager().getGroupById(groupID);
        for (Session session : getManager().getTimetable().getSessions()) {
            if (session.getGroup().equals(studentGroup)) {
                timetable.addSession(session);

            }
        }
        return timetable;
    }

    public Timetable getTimetableForRoom(String roomID) {
        Timetable timetable = new Timetable();
        Room room = getManager().getRoomById(roomID);
        for (Session session : getManager().getTimetable().getSessions()) {
            if (session.getroom().equals(room)) {
                timetable.addSession(session);
            }
        }
        return timetable;


    }

    public Timetable getTimetableForSubject(String subjectCode) {
        Timetable timetable = new Timetable();
        Subjects subject = getManager().getSubjectByCode(subjectCode);
        for (Session session : getManager().getTimetable().getSessions()) {
            if (session.getsubject().equals(subject)) {
                timetable.addSession(session);
            }
        }
        return timetable;

    }

    public Timetable getTimetableForSubject(String moduleCode) {
        Timetable timetable = new Timetable();
        Module module = getManager().getModuleByCode(moduleCode);
        for (Session session : getManager().getTimetable().getSessions()) {
            if (session.getmodule().equals(module)) {
                timetable.addSession(session);
            }
        }
        return timetable;
    }
}