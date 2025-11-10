public class Student extends User {

    private String classes;
    private String courseCode;

    public  Student(String userId, String name, String password, String classes, String courseCode)
    {
        super(userId, name, password); // calls from user class
        this.classes = classes;
        this.courseCode = courseCode;
    }

    public String getClasses() {
        return classes;
    }
    public void setClasses(String classes) {}

    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {}

}
