import java.util.ArrayList;

/**
 * Method to add, change, and delete subjects
 * */
public class SubjectController {
    private CSVDataManager Manager;

        /**
         * public constructor
         * @param Manager manager needed for the controller superClass
         * */
        public SubjectController(CSVDataManager Manager) {

            this.Manager = Manager;
        }

        /**
         * adds a subject permanently
         * @param subject the subject to be added
         * */
        public void addSubject(Subjects subject) {
          Manager.getSubjects().add(subject);
            System.out.println("Added subject: " + subject.getName());
        }


        /**
         * gets a subject using its code
         * @param code the code of the subject
         * */
        public Subjects getSubjectByCode(String code) {
            for (Subjects s :Manager.getSubjects()) {
                if (s.getCode().equals(code)) {
                    return s;
                }
            }
            return null;
        }


        /**
         * method to permanently delete a subject
         * @param code the code of  the subject to be deleted
         * */
        public boolean deleteSubject(String code) {
            Subjects subject = getSubjectByCode(code);
            if (subject != null) {
                Manager.getSubjects().remove(subject);
                return true;
            }
            return false;
        }

        /**
         * gets the subject year of a subject given a certain year number
         * @param yearNumber the year to be searched for
         * @param programmeId the subject to search in
         * */
        public SubjectsYear getYear(int yearNumber,  String programmeId) {
            for (SubjectsYear y : this.getSubjectByCode(programmeId).getYears()) {
                if (y.getYearNumber() == yearNumber) {
                    return y;
                }
            }
            return null;
        }

        /**
         * method to add a year to a sujbect
         * @param yearNumber the year to be added
         * @param programmeId the subject to be added to
         * */
        public void addYear(int yearNumber, String programmeId) {
           SubjectsYear year = new SubjectsYear(yearNumber);
            this.getSubjectByCode(programmeId).getYears().add(year);
            System.out.println("Added year " + yearNumber + " for programme " + programmeId);
        }

        /**
         * method to permanently delete a year
         * @param programmeId the id of the subjcet to delete a year of
         * @param yearNumber the year number to be deleted
         * */
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
         * Method to add an offering to a year
         * @param programmeId the subject the year belongs to
         * @param moduleCode the module to be added
         * @param yearNumber the year the offering will be added to
         * @param semesterNumber the semester the offering belongs to
         * */
        public void addOffering(String moduleCode,  String programmeId, int yearNumber, int semesterNumber) {
            Module module = Manager.getModuleById(moduleCode);
            ModuleOffering offering = new ModuleOffering(module, semesterNumber);
            this.getSubjectByCode(programmeId).getYear(yearNumber).getModulesForSemester(semesterNumber).add(offering);
            System.out.println("Added offering: " + offering.getModule().getName());
        }

        /**
         * method to permanently delete an offering from a year
         * @param moduleCode the module of the offering to be deleted
         * @param semesterNumber the semester of the offering
         * @param programmeId the code of the subject containing the offering
         * @param yearNumber the year of the offering
         * */
        public boolean removeOffering(String moduleCode, String programmeId, int yearNumber, int semesterNumber) {
            Module module = Manager.getModuleById(moduleCode);
            ModuleOffering offering = new ModuleOffering(module, semesterNumber);
            ArrayList<ModuleOffering> offerings = this.getSubjectByCode(programmeId).getYear(yearNumber).getModulesForSemester(semesterNumber);
            for (ModuleOffering o : offerings) {
                if (o.getModule().getCode().equals(moduleCode)) {
                    this.getSubjectByCode(programmeId).getYear(yearNumber).getModulesForSemester(semesterNumber).remove(o);
                    return true;
                }
            }
            return false;
        }

}



