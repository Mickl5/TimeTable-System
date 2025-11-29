import java.util.Scanner;
/**
 * lets the lecturers view their timetamble
 *
 */


public class lecturerView  extends View{
    private Scanner scanner;
    UserController userController;
    String lectureId;

    /**
     * creates a lecvturer view
     * @param controller used to get timetable info
     * @param userController used to find out which user is logged in
     */
    public lecturerView(TimetableController controller,UserController userController){
        
        super(controller);
        this.scanner= new Scanner(System.in);
        this.userController = userController;
        
    }
    /**
     * shows the timtable for logged in lecturer
     *
     */
    
    public void viewMytimetable(){

    printTimetable(getController().getTimetableForLecturer(this.lecturerId).getSessions());
    

    /**
     * shows a menu that lets lecturers choose what timetable to view
     * 
     */
    public void start(){
        lecturerId=userController.getCurrentUser().getLinkedId();

        System.out.println("1. View my timetable");
        System.out.println("2. View programme timetable");
        System.out.println("3. View module timetable");
        System.out.println("4. View room timetable");
        String ans=scanner.nextLine();
    if (ans.equals("1")){
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

}
}


