import java.util.ArrayList;


/**
 * A representation of a module in code that has its name, code, lecturers, and all the hours needed
 * */
public class Module {
    String name;
    String code;
    ArrayList<Lecturer> lecturers;
    int labHours;
    int tutHours;
    int lecHours;

    /** Creates a module object with the following arguments
     * @param name the name of the module object
     * @param code the code of the module object
     * @param labHours the amount of lab hours for the module object
     * @param lecHours the amount of lecture hours for the module object
     * @param tutHours the amount of tutorial hours for the module object*/
    public Module(String name, String code, int labHours, int tutHours, int lecHours) {
        this.name = name;
        this.code = code;
        this.labHours = labHours;
        this.tutHours = tutHours;
        this.lecHours = lecHours;
        this.lecturers = new ArrayList<>();
    }

    /** @return The name of the module object as a String
     * */
    public String getName() {
        return this.name;
    }

    /** @return The code of the module object as a String
     * */
    public String getCode() {
        return this.code;
    }

    /** @return The amount of lab hours for the module object as an int
     * */
    public int getLabHours() {
        return this.labHours;
    }

    /** @return The amount of tutorial hours for the module object as an int
     * */
    public int getTutHours() {
        return this.tutHours;
    }

    /** @return The amount of lecture hours for the module object as an int
     * */
    public int getLecHours() {
        return this.lecHours;
    }

    /**
     * @param name the value to set the name of the current module object to
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param code the value to set the code of the current module object to
     * */
    public void setCode(String code) {
        if(code == null) throw new IllegalArgumentException("Module code cannot be null");
        this.code = code;
    }

    /**
     * @param lecturers sets the list of lecturers that teach te current module object
     * */
    public void setLecturers(ArrayList<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    /**
     * @param labHours sets the amount of lab hours for this module object
     * */
    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }

    /**
     * @param tutHours sets the amount of tutorial hours for this module object
     * */
    public void setTutHours(int tutHours) {
        this.tutHours = tutHours;
    }

    /**
     * @param lecHours the amount of lecture hours for this module object
     * */
    public void setLecHours(int lecHours) {
        this.lecHours = lecHours;
    }

    /**
     * @param lecturer lecturer to be added to the list of lecturers for this module
     * */
    public void addLecturer(Lecturer lecturer) {
        this.lecturers.add(lecturer);
    }
}



