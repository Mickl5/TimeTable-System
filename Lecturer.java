import java.util.List;

public class Lecturer extends User {
private List<String> Modules;

public Lecturer(String userId, String name, String password, List<String> Modules)
    {
        super(userId, name, password); // calls from user class
        this.Modules = Modules;
    }

    public List<String> getModules() {
        return Modules;
    }
    public void setModules(List<String> Modules) {}
}
