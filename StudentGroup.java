import java.util.ArrayList;
import java.util.List;

/**
 * represents a group of students for a specific subject and year.
 * It also stores the sessions that this group attends.
 */

public class StudentGroup {

    private String groupId;
    private Subjects subject;
    private SubjectsYear subjectYear;
    private int noOfStudents;
    private List<Session> sessions;
    private List<StudentGroup> subGroups;
    private String subjectCode;
    private int yearNumber;

    /**
     * creates a student group
     * @param groupId
     * @param subjectCode
     * @param yearNumber
     * @param noOfStudents
     */
    public StudentGroup(String groupId, String subjectCode, int yearNumber, int noOfStudents) {
        this.groupId = groupId;
        this.subjectCode = subjectCode;
        this.yearNumber = yearNumber;
        this.noOfStudents = noOfStudents;
        this.sessions = new ArrayList<>();
        this.subGroups = new ArrayList<>();
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

    public void addSubGroup(StudentGroup subGroup) {
        subGroups.add(subGroup);
    }

    public List<StudentGroup> getSubGroups() {
        return subGroups;
    }

    public String getSubjectCode() {
        return this.subjectCode;
    }

    public int getYearNumber() {
        return this.yearNumber;
    }

    public void setProgrammeYear(SubjectsYear year) {
        this.subjectYear = year;
    }

    public void setProgramme(Subjects subject) {
        this.subject = subject;
    }
}

