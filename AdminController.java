import java.util.List;

/**
 * Admin controller that allows managing users and modules.
 */
public class AdminController extends Controller {
    /**
     * Constructs an AdminController with the CSVDataManager and module CSV path.
     * @param manager the CSV data manager
     */
    public AdminController(CSVDataManager manager, String moduleCsvFile) {
        super(manager);
    }

    /**
     * Adds a new user to the system.
     */
    public boolean createUser(String userId, String name, String password, UserType type, String linkedId) {

        User newUser = new User(userId, name, password, type, linkedId);
        getManager().getUsers().add(newUser);
        saveUsers();
        return true;
    }

    /**
     * Removes a user by ID.
     */
    public boolean removeUser(String userId) {

        List<User> users = getManager().getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(userId)) {
                users.remove(i);
                saveUsers();
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a new student group and adds it to the system.
     * @param groupId       the ID of the group
     * @param subject       the subject the group is for
     * @param subjectYear   the year of the subject
     * @param noOfStudents  number of students in the group
     * @return true if the group was successfully added, false if a group with the same ID already exists
     */
    public boolean createGroup(String groupId, Subjects subject, SubjectsYear subjectYear, int noOfStudents) {
        if (getManager().getGroupById(groupId) != null) {
            return false;
        }

        StudentGroup newGroup = new StudentGroup(groupId, subject, subjectYear, noOfStudents);
        getManager().getGroups().add(newGroup);

        saveGroups();
        return true;
    }

    public void removeGroup(String groupId) {
        StudentController studentController = new StudentController(getManager());
        studentController.deleteGroup(groupId);
        saveGroups();
    }

    public void addSubGroup(String parentId, StudentGroup group) {
        StudentController studentController = new StudentController(getManager());
        studentController.addSubGroup(parentId, group);
        saveGroups();
    }

    /**
     * Adds a module to the system.
     */
    public boolean addModule(Module module) {

        getManager().getModules().add(module);
        saveModules();
        return true;
    }

    /**
     * Removes a module by code.
     */
    public boolean removeModule(String moduleCode) {
        if (moduleCode == null) return false;

        List<Module> modules = getManager().getModules();
        for (int i = 0; i < modules.size(); i++) {
            if (modules.get(i).getCode().equals(moduleCode)) {
                modules.remove(i);
                saveModules();
                return true;
            }
        }
        return false;
    }

    /**
     * Assigns a lecturer to a module.
     */
    public boolean assignLecturer(String moduleCode, Lecturer lecturer) {
        if (lecturer == null) return false;

        Module module = getModule(moduleCode);
        if (module == null) return false;

        module.addLecturer(lecturer);
        saveModules();
        return true;
    }

    /**
     * Removes a lecturer from a module.
     */
    public boolean removeLecturer(String moduleCode, Lecturer lecturer) {
        if (lecturer == null) return false;

        Module module = getModule(moduleCode);
        if (module == null) return false;

        for (int i = 0; i < module.getLecturers().size(); i++) {
            if (module.getLecturers().get(i).getLecturerId().equals(lecturer.getLecturerId())) {
                module.getLecturers().remove(i);
                saveModules();
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a module by its code.
     */
    private Module getModule(String code) {
        for (Module module : getManager().getModules()) {
            if (module.getCode().equals(code)) return module;
        }
        return null;
    }

    /**
     * Saves all users to CSV.
     */
    private void saveUsers() {
        try {
            getManager().saveUsers("User - Sheet1.csv");
        } catch (Exception e) {
            System.err.println("Failed to save users: " + e.getMessage());
        }
    }

    /**
     * Saves all modules to CSV.
     */
    private void saveModules() {
        try {
            getManager().saveModule("studentGroup - Sheet1.csv");
        } catch (Exception e) {
            System.err.println("Failed to save modules: " + e.getMessage());
        }
    }

    /**
     * saves all groups to the CSV
     */
    private void saveGroups() {
        try {
            getManager().saveGroups("studentGroup - Sheet1.csv");
        } catch (Exception e) {
            System.err.println("Failed to save student groups: " + e.getMessage());
        }
    }
}


