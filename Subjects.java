import java.util.ArrayList;

public class Subjects {
    private String Name;
    private String Code;
    private ArrayList<SubjectsYear> years;

    public Subjects(String Code, String Name){
        this.Name=Name;
        this.Code=Code;
        this.years = new ArrayList<>();
    }
    public void ShowInfo(){
        System.out.println("Module Name: " + Name);
        System.out.println("Module Code: " + Code);
    }
    public String getName() {
        return this.Name;
    }

    public String getCode() {
        return this.Code;
    }

    public ArrayList<SubjectsYear> getYears() {
        return this.years;
    }

    public SubjectsYear getYear(int yearNumber) {
        for (SubjectsYear year : years) {
            if(year.getYearNumber() == yearNumber) return year;
        }
        return null;
    }

    public void addYear(SubjectsYear year) {
        this.years.add(year);
    }


}


