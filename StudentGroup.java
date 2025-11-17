import java.util.ArrayList;
import java.util.List;

public class StudentGroup {

    private String groupId;
    private Subjects subject;
    private SubjectsYear subjectYear;
    private int noOfStudents;
    private List<Session> sessions;

    public StudentGroup(String groupId, Subjects subject, SubjectsYear subjectYear, int noOfStudents) {
        this.groupId = groupId;
        this.subject = subject;
        this.subjectYear = subjectYear;
        this.noOfStudents = noOfStudents;
        this.sessions = new ArrayList<>();
    }

    public String getGroupId() {
        return groupId;
    }

    public Subjects getSubject() {
        return subject;
    }

    public SubjectsYear getSubjectYear() {
        return subjectYear;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void addSession(Session session) {
        sessions.add(session);
    }
}

