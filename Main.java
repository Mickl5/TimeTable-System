import java.io.IOException;

/**
 * Main class that contains the main method to run the app
 * */
public class Main {
    /**
     * Main method that runs the entire app
     * Contains all the file paths needed
     * Initialises all the managers, generators, controllers and the CLIView that will route to other views
     * */
    public static void main(String[] args) throws IOException {
        String programmeFile = "src/programme - Sheet1.csv";
        String moduleFile = "src/Module - Sheet1.csv";
        String groupFile = "src/studentGroup - Sheet1.csv";
        String programmeStructureFile = "src/programmeStructure - Sheet1.csv";
        String lecturerFile = "src/lecturer - Sheet1.csv";
        String roomFile = "src/Room - Sheet1.csv";
        String timetableFile = "";
        String moduleLecturerFile = "src/moduleLecturers - Sheet1.csv";
        String usersFile = "src/User - Sheet1.csv";
        CSVDataManager manager = new CSVDataManager();
        manager.loadAll(programmeFile, moduleFile, groupFile, programmeStructureFile, lecturerFile, roomFile,
                timetableFile, moduleLecturerFile, usersFile);

        ScheduleGenerator generator = new ScheduleGenerator(manager);
        if (manager.getTimetable().getSessions().isEmpty()) {
            Timetable timetable = generator.generateForAllSemesters();
            manager.setTimetable(timetable);
            manager.saveTimetable("src/Timetable - Output.csv");
            System.out.println("No timetable found");
            System.out.println("Generating timetable");
        }

        TimetableController timetableController = new TimetableController(manager);
        UserController userController = new UserController(manager);
        StudentView studentView = new StudentView(timetableController, userController);
        lecturerView lecturerView = new lecturerView(timetableController, userController);
        AdminController adminController = new AdminController(manager);
        AdminView adminView = new AdminView(timetableController, adminController);
        CLIView view = new CLIView(timetableController, userController, studentView, lecturerView, adminView);
        System.out.println("================= UNIVERSITY TIMETABLE =================");
        System.out.println();
        view.Start();
    }
}