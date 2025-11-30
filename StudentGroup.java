import java.util.ArrayList;

/**
 * represents a group of students for a specific subject and year.
 * It also stores the sessions that this group attends.
 */

public class StudentGroup {

    private String groupId;
    private Subjects subject;
    private SubjectsYear subjectYear;
    private int noOfStudents;
    private ArrayList<Session> sessions;
    private ArrayList<StudentGroup> subGroups;
    private String subjectCode;
    private int yearNumber;

    /**
     * creates a student group
     * @param groupId the groups Id
     * @param subjectCode Subject the group is for
     * @param yearNumber what year the subject is
     * @param noOfStudents amount of students in the group
     */
    public StudentGroup(String groupId, String subjectCode, int yearNumber, int noOfStudents) {
        this.groupId = groupId;
        this.subjectCode = subjectCode;
        this.yearNumber = yearNumber;
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
    public ArrayList<Session> getSessions() {
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
    public ArrayList<StudentGroup> getSubGroups() {
        return subGroups;
    }

    /**
     * returns the subject code
     * @return subject code
     * */
    public String getSubjectCode() {
        return this.subjectCode;
    }

    /**
     * returns the year number
     * @return year number
     * */
    public int getYearNumber() {
        return this.yearNumber;
    }

    /**
     * sets the subject year
     * @param year year to be set to
     * */
    public void setProgrammeYear(SubjectsYear year) {
        this.subjectYear = year;
    }

    /**
     * sets the subject
     * @param subject subject to be set to
     * */
    public void setProgramme(Subjects subject) {
        this.subject = subject;
    }
}

