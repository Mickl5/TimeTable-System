import java.util.ArrayList;

public class Module {
    String name;
    String code;
    ArrayList<Lecturer> lecturers;
    int labHours;
    int tutHours;
    int lecHours;

    public Module(String name, String code, int labHours, int tutHours, int lecHours, ArrayList<Lecturer> lecturers) {
        this.name = name;
        this.code = code;
        this.labHours = labHours;
        this.tutHours = tutHours;
        this.lecHours = lecHours;
        this.lecturers = lecturers;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public int getLabHours() {
        return this.labHours;
    }

    public int getTutHours() {
        return this.tutHours;
    }

    public int getLecHours() {
        return this.lecHours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        if(code == null) throw new IllegalArgumentException("Module code cannot be null");
        this.code = code;
    }

    public void setLecturers(ArrayList<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }

    public void setTutHours(int tutHours) {
        this.tutHours = tutHours;
    }

    public void setLecHours(int lecHours) {
        this.lecHours = lecHours;
    }

    public void addLecturer(Lecturer lecturer) {
        this.lecturers.add(lecturer);
    }


}

