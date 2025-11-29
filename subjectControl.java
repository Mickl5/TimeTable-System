import java.util.ArrayList;
import java.util.List;

/**
 * Control class for managing subjects, their years, and the module offerings.
 * Gives methods to add, retrieve, and remove subjects, the year, and the offerings
 */

public class SubjectController {
    private CSVDataManager Manager;

    /**
     * Constructs a SubjectController with the data manager.
     *
     * @param Manager the CSVDataManager is used to manage subjects and modules
     */

    public SubjectController(CSVDataManager Manager) {

        this.Manager = Manager;
    }
    /**
     * Adds a new subject.
     *
     * @param subject the subject to add
     */

    public void addSubject(Subjects subject) {
        Manager.getSubjects().add(subject);
        System.out.println("Added subject: " + subject.getName());
    }

    /**
     * Gets a subject by its code.
     *
     * @param code the subject code
     * @return the matching subject, or {@code null} if not found
     */

    public Subjects getSubjectByCode(String code) {
        for (Subjects s :Manager.getSubjects()) {
            if (s.getCode().equals(code)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Deletes subject by its code.
     *
     * @param code the subject code
     * @return {@code true} if the subject was removed, {@code false} if not
     */

    public boolean deleteSubject(String code) {
        Subjects subject = getSubjectByCode(code);
        if (subject != null) {
            Manager.getSubjects().remove(subject);
            return true;
        }
        return false;
    }
    /**
     * Retrieves a specific year for the programme.
     *
     * @param yearNumber  the year number
     * @param programmeId the programme identifier
     * @return the matching SubjectsYear, or {@code null} if not found
     */

    public SubjectsYear getYear(int yearNumber,  String programmeId) {
        for (SubjectsYear y : this.getSubjectByCode(programmeId).getYears()) {
            if (y.getYearNumber() == yearNumber) {
                return y;
            }
        }
        return null;
    }
    /**
     * Adds a new year to the programme.
     *
     * @param yearNumber  the year number to be added
     * @param programmeId the programme identifier
     */

    public void addYear(int yearNumber, String programmeId) {
        SubjectsYear year = new SubjectsYear(yearNumber);
        this.getSubjectByCode(programmeId).getYears().add(year);
        System.out.println("Added year " + yearNumber + " for programme " + programmeId);
    }
    /**
     * Removes a year from the programme.
     *
     * @param yearNumber  the year number to remove
     * @param programmeId the programme identifier
     * @return {@code true} if the year was found and removed, {@code false} if not
     */

    public boolean removeYear(int yearNumber,  String programmeId) {
        SubjectsYear year = getYear(yearNumber, programmeId);
        if (year != null) {
            this.getSubjectByCode(programmeId).getYears().remove(year);
            System.out.println("Removed year " + yearNumber);
            return true;
        }
        return false;
    }



    /**
     * Adds a module offering to a specific year and semester of the programme.
     *
     * @param moduleCode     the module code
     * @param programmeId    the programme identifier
     * @param yearNumber     the year number
     * @param semesterNumber the semester number
     */


    public void addOffering(String moduleCode,  String programmeId, int yearNumber, int semesterNumber) {
        Module module = Manager.getModuleById(moduleCode);
        ModuleOffering offering = new ModuleOffering(module, semesterNumber);
        this.getSubjectByCode(programmeId).getYear(yearNumber).getModulesForSemester(semesterNumber).add(offering);
        System.out.println("Added offering: " + offering.getName());
    }
    /**
     * Removes a module offering from a specific year and semester of the programme.
     *
     * @param moduleCode     the module code
     * @param programmeId    the programme identifier
     * @param yearNumber     the year number
     * @param semesterNumber the semester number
     * @return {@code true} if the offering was found and removed, {@code false} if not
     */

    public boolean removeOffering(String moduleCode, String programmeId, int yearNumber, int semesterNumber) {
        Module module = Manager.getModuleById(moduleCode);
        ModuleOffering offering = new ModuleOffering(module, semesterNumber);
        ArrayList<ModuleOffering> offerings = this.getSubjectByCode(programmeId).getYear(yearNumber).getModulesForSemester(semesterNumber);
        for (ModuleOffering o : offerings) {
            if (o.getModule().getModuleCode().equals(moduleCode)) {
                this.getSubjectByCode(programmeId).getYear(yearNumber).getModulesForSemester(semesterNumber).remove(o);
                return true;
            }
        }
        return false;
    }

}
