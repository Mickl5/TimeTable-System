import java.util.ArrayList;
import java.util.List;

public class SubjectController {
private CSVDataManager Manager;


    public SubjectController(CSVDataManager Manager) {

        this.Manager = Manager;
    }

    public void addSubject(Subjects subject) {
      Manager.getSubjects().add(subject);
        System.out.println("Added subject: " + subject.getName());
    }


    public Subjects getSubjectByCode(String code) {
        for (Subjects s :Manager.getSubjects()) {
            if (s.getCode().equals(code)) {
                return s;
            }
        }
        return null;
    }


    public boolean deleteSubject(String code) {
        Subjects subject = getSubjectByCode(code);
        if (subject != null) {
            Manager.getSubjects().remove(subject);
            return true;
        }
        return false;
    }
    public SubjectsYear getYear(int yearNumber,  String programmeId) {
        for (SubjectsYear y : this.getSubjectByCode(programmeId).getYears()) {
            if (y.getYearNumber() == yearNumber) {
                return y;
            }
        }
        return null;
    }

    public void addYear(int yearNumber, String programmeId) {
       SubjectsYear year = new SubjectsYear(yearNumber);
        this.getSubjectByCode(programmeId).getYears().add(year);
        System.out.println("Added year " + yearNumber + " for programme " + programmeId);
    }

    public boolean removeYear(int yearNumber,  String programmeId) {
        SubjectsYear year = getYear(yearNumber, programmeId);
        if (year != null) {
            this.getSubjectByCode(programmeId).getYears().remove(year);
            System.out.println("Removed year " + yearNumber);
            return true;
        }
        return false;
    }

    public void addOffering(String moduleCode,  String programmeId, int yearNumber, int semesterNumber) {
        Module module = Manager.getModuleById(moduleCode);
        ModuleOffering offering = new ModuleOffering(module, semesterNumber);
        this.getSubjectByCode(programmeId).getYear(yearNumber).getModulesForSemester(semesterNumber).add(offering);
        System.out.println("Added offering: " + offering.getName());
    }

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


//Should be done now



