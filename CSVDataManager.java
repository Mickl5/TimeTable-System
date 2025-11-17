import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Class that uses the CSVutils auxiliary class to translate all the model classes into csv data and vice versa
 * */
public class CSVDataManager {
    private ArrayList<Room> rooms;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Module> modules;
    private ArrayList<Subjects> subjects;
    private ArrayList<StudentGroup> groups;
    private Timetable timetable;

    /**
     *A no arg constructor that initialises all the array lists at runtime
     * */
    public CSVDataManager() {
        this.rooms = new ArrayList<>();
        this.lecturers = new ArrayList<>();
        this.modules = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.timetable = new Timetable();
        this.groups = new ArrayList<>();
    }

    //                  ROOM FUNCTIONS
    /**
     * Loads the data of all rooms from the csv file specified
     * @param filePath the filepath to a csv file to get all the rooms information from there
     * */
    public void loadRooms(String filePath) throws IOException {
        rooms.clear();
        ArrayList<String[]> rows = CSVutils.readCSV(filePath);
        for (String[] row : rows) {
            rooms.add(parseRoom(row));
        }
    }

    /**
     * Saves the data of all rooms to the csv file specified
     * @param filePath the filepath to a csv file to store all the information of the rooms
     * */
    public void saveRooms(String filePath) throws IOException {
        ArrayList<String[]> rows = new ArrayList<>();
        for (Room room : rooms) {
            rows.add(toCSV(room));
        }
        CSVutils.writeCSV(filePath, rows);
    }

    /**
     * It translates an array of values from a csv file to an actual object of type Room
     * @param fields the array of values taken from the csv file
     * */
    private Room parseRoom(String[] fields) {
        if (fields.length < 4) return null;
        return new Room(
                fields[0], fields[1], Integer.parseInt(fields[3]), RoomType.valueOf(fields[2])
        );
    }

    /**
     * It translates an object into an array of values to be written inside a csv
     * @param room the object that will be transformed into an array of type string containing the values for the csv
     * */
    private String[] toCSV(Room room) {
        return new String[]{room.GetRoomId(), room.GetName(), String.valueOf(room.getType()), String.valueOf(room.getCapacity())};
    }
    //                  END OF ROOM FUNCTIONS



    //                  LECTURER FUNCTIONS
    /**
     * Loads the data of all lecturers from the csv file specified
     * @param filePath the filepath to a csv file to get all the lecturers information from there
     * */
    public void loadLecturers(String filePath) throws IOException {
        lecturers.clear();
        ArrayList<String[]> rows = CSVutils.readCSV(filePath);
        for (String[] row : rows) {
            lecturers.add(parseLecturer(row));
        }
    }

    /**
     * Saves the data of all lecturers to the csv file specified
     * @param filePath the filepath to a csv file to store all the information of the lecturers
     * */
    public void saveLecturer(String filePath) throws IOException {
        ArrayList<String[]> rows = new ArrayList<>();
        for (Lecturer lecturer : lecturers) {
            rows.add(toCSV(lecturer));
        }
        CSVutils.writeCSV(filePath, rows);
    }

    /**
     * It translates an array of values from a csv file to an actual object of type Lecturer
     * @param fields the array of values taken from the csv file
     * */
    private Lecturer parseLecturer(String[] fields) {
        if (fields.length < 2) return null;
        return new Lecturer(
                fields[0], fields[1]
        );
    }

    /**
     * It translates an object into an array of values to be written inside a csv
     * @param lecturer the object that will be transformed into an array of type string containing the values for the csv
     * */
    private String[] toCSV(Lecturer lecturer) {
        return new String[]{lecturer.getLecturerId(), lecturer.getLecturerName()};
    }
    //                  END OF LECTURER FUNCTIONS



    //                  MODULE FUNCTIONS
    /**
     * Loads the data of all modules from the csv file specified
     * @param filePath the filepath to a csv file to get all the modules information from there
     * */
    public void loadModule(String filePath) throws IOException {
        modules.clear();
        ArrayList<String[]> rows = CSVutils.readCSV(filePath);
        for (String[] row : rows) {
            modules.add(parseModule(row));
        }
    }

    /**
     * Saves the data of all modules to the csv file specified
     * @param filePath the filepath to a csv file to store all the information of the modules
     * */
    public void saveModule(String filePath) throws IOException {
        ArrayList<String[]> rows = new ArrayList<>();
        for (Module module : modules) {
            rows.add(toCSV(module));
        }
        CSVutils.writeCSV(filePath, rows);
    }

    /**
     * It translates an array of values from a csv file to an actual object of type Lecturer
     * @param fields the array of values taken from the csv file
     * */
    private Module parseModule(String[] fields) {
        if (fields.length < 5) return null;
        return new Module(
                fields[0], fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4])
        );
    }

    /**
     * It translates an object into an array of values to be written inside a csv
     * @param module the object that will be transformed into an array of type string containing the values for the csv
     * */
    private String[] toCSV(Module module) {
        return new String[]{ module.getName(), module.getCode(), String.valueOf(module.getLecHours()), String.valueOf(module.getLabHours()),
                String.valueOf(module.getTutHours())
        };
    }
    //                  END OF MODULE FUNCTIONS



    //                  PROGRAMME FUNCTIONS
    /**
     * Loads the data of all programmes from the csv file specified
     * @param filePath the filepath to a csv file to get all the programmes information from there
     * */
    public void loadProgramme(String filePath) throws IOException {
        subjects.clear();
        ArrayList<String[]> rows = CSVutils.readCSV(filePath);
        for (String[] row : rows) {
            subjects.add(parseProgramme(row));
        }
    }

    /**
     * Saves the data of all programmes to the csv file specified
     * @param filePath the filepath to a csv file to store all the information of the programmes
     * */
    public void saveProgramme(String filePath) throws IOException {
        ArrayList<String[]> rows = new ArrayList<>();
        for (Subjects subject : subjects) {
            rows.add(toCSV(subject));
        }
        CSVutils.writeCSV(filePath, rows);
    }

    /**
     * It translates an array of values from a csv file to an actual object of type Lecturer
     * @param fields the array of values taken from the csv file
     * */
    private Subjects parseProgramme(String[] fields) {
        if (fields.length < 2) return null;
        return new Subjects(fields[0], fields[1]);
    }

    /**
     * It translates an object into an array of values to be written inside a csv
     * @param subjects the object that will be transformed into an array of type string containing the values for the csv
     * */
    private String[] toCSV(Subjects subjects) {
        return new String[]{subjects.getCode(), subjects.getName()};
    }
    //                  END OF PROGRAMME FUNCTIONS



    //                  TIMETABLE FUNCTIONS
    /**
     * Loads the data of all timetables from the csv file specified
     * @param filePath the filepath to a csv file to get all the timetables information from there
     * */
    public void loadTimetable(String filePath) throws IOException {
        timetable = new Timetable();
        ArrayList<String[]> rows = CSVutils.readCSV(filePath);
        for (String[] row : rows) {
            timetable.addSession(parseSession(row));
        }
    }

    /**
     * Saves the data of all timetables to the csv file specified
     * @param filePath the filepath to a csv file to store all the information of the timetables
     * */
    public void saveTimetable(String filePath) throws IOException {
        ArrayList<String[]> rows = new ArrayList<>();
        for (Session session : timetable.getSessions()) {
            rows.add(toCSV(session));
        }
        CSVutils.writeCSV(filePath, rows);
    }

    /**
     * It translates an array of values from a csv file to an actual object of type Lecturer
     * @param fields the array of values taken from the csv file
     * */
    private Session parseSession(String[] fields) {
        if (fields.length < 10) return null;


        SessionType type = SessionType.valueOf(fields[1]);
        Module module = getModuleById(fields[2]);
        Room room = getRoomById(fields[3]);
        Lecturer lecturer = getLecturerById(fields[4]);
        StudentGroup group = getGroupById(fields[5]);
        return new Session(
          fields[0], type, module, room, lecturer, group, DayOfWeek.valueOf(fields[6]), LocalTime.parse(fields[7]),
                Integer.parseInt(fields[8]), Integer.parseInt(fields[9])
        );
    }

    /**
     * It translates an object into an array of values to be written inside a csv
     * @param session the object that will be transformed into an array of type string containing the values for the csv
     * */
    private String[] toCSV(Session session) {
        return new String[]{session.getSessionId(), String.valueOf(session.getType()), session.getModule().getCode(),
                session.getRoom().GetRoomId(), session.getLecturer().getLecturerId(), String.valueOf(session.getDayOfWeek()),
                String.valueOf(session.getTime()), String.valueOf(session.getDurationMinutes()),
                String.valueOf(session.getSemesterNumber())
        };
    }
    //                  END OF TIMETABLE METHODS



    //                  STUDENT GROUP FUNCTIONS
    /**
     * Loads the data of all student groups from the csv file specified
     * @param filePath the filepath to a csv file to get all the student groups information from there
     * */
    public void loadGroups(String filePath) throws IOException {
        groups.clear();
        ArrayList<String[]> rows = CSVutils.readCSV(filePath);
        for (String[] row : rows) {
            groups.add(parseGroup(row));
        }
    }

    /**
     * Saves the data of all groups to the csv file specified
     * @param filePath the filepath to a csv file to store all the information of the groups
     * */
    public void saveGroups(String filePath) throws IOException {
        ArrayList<String[]> rows = new ArrayList<>();

        for (StudentGroup group : groups) {
            String parentGroupId = getParentGroupById(group);
            rows.add(toCSV(group, parentGroupId));
        }
        CSVutils.writeCSV(filePath, rows);
    }

    /**
     * It translates an array of values from a csv file to an actual object of type Lecturer
     * @param fields the array of values taken from the csv file
     * */
    private StudentGroup parseGroup(String[] fields) {
        if (fields.length < 4) return null;

        String groupId = fields[0];
        String programmeCode = fields[1];
        int yearNumebr = Integer.parseInt(fields[2]);
        int size = Integer.parseInt(fields[3]);
        String parentGroupId = fields.length > 4 ? fields[4] : "";

        Subjects subject = getProgrammeById(programmeCode);
        SubjectsYear year = subject.getYear(yearNumebr);
        StudentGroup group = new StudentGroup(groupId, subject, year, size);

        if (!parentGroupId.isEmpty()) {
            StudentGroup parent = getGroupById(parentGroupId);
            if(parent != null) {
                parent.addSubGroup(group);
            }
        }
        return group;
    }

    /**
     * It translates an object into an array of values to be written inside a csv
     * @param group the object that will be transformed into an array of type string containing the values for the csv
     * @param parentGroupId the value of the parentGroupId, should be an empty string if there is no parent group
     * */
    private String[] toCSV(StudentGroup group, String parentGroupId) {
        return new String[]{group.getGroupId(), group.getSubject().getCode(),
                String.valueOf(group.getSubjectYear().getYearNumber()), String.valueOf(group.getNoOfStudents()), parentGroupId
        };
    }

    /**
     * It checks if the given group is a subgroup of a parent group. If it is it returns the parent group id
     * @param subGroup the group to be checked for parent groups
     * */
    private String getParentGroupById(StudentGroup subGroup) {
        for (StudentGroup group : groups) {
            if (group.getSubGroups().contains(subGroup)) {
                return group.getGroupId();
            }
        }
        return "";
    }



    //                  GETTERS FOR EXISTING OBJECTS
    /**
     * returns the module with the given id.
     * If it doesn't exist it returns null.
     * @param moduleCode the module code to search for
     * */
    private Module getModuleById(String moduleCode) {
        for (Module module : modules) {
            if (module.getCode().equals(moduleCode)) {
                return module;
            }
        }
        return null;
    }

    /**
     * returns the room with the given id.
     * If it doesn't exist it returns null.
     * @param roomId the module code to search for
     * */
    private Room getRoomById(String roomId) {
        for (Room room : rooms) {
            if (room.GetRoomId().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    /**
     * returns the lecturer with the given id.
     * If it doesn't exist it returns null.
     * @param lecturerId the module code to search for
     * */
    private Lecturer getLecturerById(String lecturerId) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getLecturerId().equals(lecturerId)) {
                return lecturer;
            }
        }
        return null;
    }

    /**
     * returns the group with the given id.
     * If it doesn't exist it returns null.
     * @param groupId the module code to search for
     * */
    private StudentGroup getGroupById(String groupId) {
        for (StudentGroup group : groups) {
            if(group.getGroupId().equals(groupId)) {
                return group;
            }
        }
        return null;
    }

    /**
     * returns the programme with the given id.
     * If it doesn't exist it returns null.
     * @param subjectId the module code to search for
     * */
    private Subjects getProgrammeById(String subjectId) {
        for (Subjects subject : subjects) {
            if (subject.getCode().equals(subjectId)) return subject;
        }
        return null;
    }
}

