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
    public void addOffering(ModuleOffering offering) {
        Manager.getModuleOffering().add(offering);
        System.out.println("Added offering: " + offering.getName());
    }

    public boolean removeOffering(String offeringCode) {
        for (ModuleOffering o : Manager.getModuleOffering()) {
            if (o.getCode().equals(offeringCode)) {
                Manager.getModuleOffering().remove(o);
                System.out.println("Removed offering: " + o.getName());
                return true;
            }
        }
        return false;
    }

}
//Will finish tomorrow





