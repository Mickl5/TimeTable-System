import java.util.ArrayList;

/**
 * a class that controls modules on the timetable vy adding and removing them.
 * ALso adds and removes lecturers
 */
public class ModuleController {

    /**
     *list that stores all module objects
     */
    private ArrayList<Module> modules;

    /**
     * constructs a new moduleController and initialises the module list
     */
    public ModuleController() {
        modules = new ArrayList<>();
    }

    /**
     * adds a module to the controllers list
     * @param module the module to be added
     */
    public void addModule(Module module) {
        modules.add(module);
    }

    /**
     * removes a specific module from the controllers list
     * @param module module to be removed
     * @return if true, the module was found and removed, else input was null
     */
    public boolean removeModule(Module module) {
        if (module == null){
            return false;
        }
        return modules.remove(module);
    }

    /**
     * finds a module using its unique  code
     * @param code the code of the module beeing found e.g(CS001)
     * @return the module if its found or null if no module mathces
     */
    public Module getModule(String code) {
        for (Module module : modules) {
            if (module.getCode().equals(code)) {
                return module;
            }
        }
        return null;
    }

    /**
     * returns a list of all modules being managed by the controller
     * @return an arrayList of all modules
     */
    public ArrayList<Module> getAllModules() {
        return modules;
    }

    /**
     * assigns a lecturer to a module by its code and the lecturer is added to the list of
     * assigned lecturers
     * @param moduleCode the code of module the lec is assigned to
     * @param lecturer the lecturer being assigned
     * @return if true module was found and lecturer assigned, else module was not found
     */
    public boolean assignLecturer(String moduleCode, Lecturer lecturer) {
        Module module = getModule(moduleCode);
        if (module == null) {
            return false;
        }
        module.addLecturer(lecturer);
        return true;
    }

    /**
     * removes a lecturer from a module
     * @param moduleCode the code of the module to remove the lecturer from
     * @param lecturer the lecturer to be removed
     * @return if true module and lecturer were removed from the list
     */
    public  boolean removeLecturer(String moduleCode, Lecturer lecturer){
        if (lecturer == null){
            return false;
        }
        Module module = getModule(moduleCode);
        if (module == null) {
            return false;
        }
        return module.getLecturers().remove(lecturer);
    }
}


