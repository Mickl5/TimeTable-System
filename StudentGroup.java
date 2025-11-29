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

    /**
     * creates a student group
     * @param groupId the groups Id
     * @param subject Subject the group is for
     * @param subjectYear what year the subject is
     * @param noOfStudents amount of students in the group
     */
    public StudentGroup(String groupId, Subjects subject, SubjectsYear subjectYear, int noOfStudents) {
        this.groupId = groupId;
        this.subject = subject;
        this.subjectYear = subjectYear;
        this.noOfStudents = noOfStudents;
        this.sessions = new ArrayList<>();
        this.subGroups = new ArrayList<>();
    }

    /**
     * returns the groups Id
     * @return groupid
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * returns the subject the group is for
     * @return subject
     */
    public Subjects getSubject() {
        return subject;
    }

    /**
     * returns what year the groups subject is
     * @return subjects year
     */
    public SubjectsYear getSubjectYear() {
        return subjectYear;
    }

    /**
     * returns the amount of students in the group
     * @return number of students
     */
    public int getNoOfStudents() {
        return noOfStudents;
    }

    /**
     * returns a list off all sessions(lab, lecs, tuts) the group has
     * @return sessions
     */
    public List<Session> getSessions() {
        return sessions;
    }

    /**
     * adds a session to the groups timetable
     * @param session the session thats added
     */
    public void addSession(Session session) {
        sessions.add(session);
    }

    /**
     * adds a subgroup for labs/tuts etc, to the group
     * @param subGroup the sub group thats added
     */
    public void addSubGroup(StudentGroup subGroup) {
        subGroups.add(subGroup);
    }

    /**
     * returns a list of subgroups
     * @return sub groups
     */
    public List<StudentGroup> getSubGroups() {
        return subGroups;
    }
}

