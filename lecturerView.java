import java.util.Scanner;
/**
 * lets the lecturers view their timetamble
 *
 */


public class lecturerView  extends View{
    private Scanner scanner;
    UserController userController;
    String studentGroup;

    /**
     * creates a lecvturer view
     * @param controller used to get timetable info
     * @param userController used to find out which user is logged in
     */
    public lecturerView(TimetableController controller,UserController userController){
        this.scanner= new Scanner(System.in);
        super(controller);
        this.userController = userController;
        lecturerGroup=userController.getCurrentUser().getLinked();

    }
    /**
     * shows the timtable for logged in lecturer
     *
     */
    
    public void viewMytimetable(){

    printTimetable(getController().getTimetableForLecturer(this.lecturerGroup).getSessions());
    }

    /**
     * shows a menu that lets lecturers choose what timetable to view
     * 
     */
    public void start(){
        System.out.println("1. View my timetable");
        System.out.println("2. View programme timetable");
        System.out.println("3. View module timetable");
        System.out.println("4. View room timetable");
    }if (ans.equals("1")){
        viewMytimetable();


    }
    else if (ans.equals("2")){
        System.out.println("Please enter the subject code");
        String subjectCode = scanner.nextLine();
        viewSubjectTimetable(subjectCode);
    }
   else if (ans.equals("3")){
        System.out.println("Please enter the module code");
        String moduleCode = scanner.nextLine();
        viewModuleTimetable(moduleCode);
    }
    else if(ans.equals("4")){
        System.out.println("Please enter the room code");
        String roomCode = scanner.nextLine();
        viewRoomTimetable(roomCode);
    }
}
