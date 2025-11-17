import java.util.ArrayList;

public class SubjectsYear {
    private int Year;
    ArrayList<ModuleOffering> semester1Modules;
    ArrayList<ModuleOffering> semester2Modules;

public SubjectsYear(int Year) {
    this.Year=Year;
    this.semester1Modules = new ArrayList<>();
    this.semester2Modules = new ArrayList<>();


}
public void addModule(Module module){
    Modules.add(module);
}
}









