import java.util.ArrayList;

public class ModuleYear {
    private int Year;
    ArrayList<Module>Modules;

public ModuleYear(int Year, ArrayList<Module> Modules) {
    this.Year=Year;
    this.Modules=Modules;


}
public void addModule(Module module){
    Modules.add(module);
}
public ArrayList<Module> getModules(){
    return this.Modules;
}
    }







