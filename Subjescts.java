import java.util.ArrayList;

public class Modules {
    private String Name;
    private String Code;
    private int Year;

public Modules( String Name, String Code, int Year){
    this.Name=Name;
    this.Code=Code;
    this.Year=Year;
}
public void ShowInfo(){
    System.out.println("Module Name: " + Name);
    System.out.println("Module Code: " + Code);
    System.out.println("Module Year: " + Year);
}
}
