import java.util.ArrayList;
/**
*this class gives the module offering for the specific semester
*
*/
public class SubjectsYear {
    private int Year;
    ArrayList<ModuleOffering> semester1Modules;
    ArrayList<ModuleOffering> semester2Modules;
    /**
    *sets the year and creates 2 empty lists for the semester 1 ans 2 modules
    *
    */

    public SubjectsYear(int Year) {
        this.Year = Year;
        this.semester1Modules = new ArrayList<>();
        this.semester2Modules = new ArrayList<>();
    }

    public int getYearNumber() {
        return this.Year;
    }
    /**
    *
    *
    */

    public ArrayList<ModuleOffering> getModulesForSemester(int semester) {
        if (semester == 1) {
            return semester1Modules;
        }
        else {
            return semester2Modules;
        }
    }
}










