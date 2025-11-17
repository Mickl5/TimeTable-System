import java.util.ArrayList;

public class Subjects {
    private String Name;
    private String Code;
    private ArrayList<SubjectsYear> years;

public Subjects(String Name, String Code){
    this.Name=Name;
    this.Code=Code;
    this.years = new ArrayList<>();
}
public void ShowInfo(){
    System.out.println("Module Name: " + Name);
    System.out.println("Module Code: " + Code);
    System.out.println("Module Year: " + Year);
}
}


