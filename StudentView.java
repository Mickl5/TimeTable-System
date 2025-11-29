import java.util.Scanner;

/**
 *lets students view their own timetable and others
 */
public class StudentView extends View {
    private Scanner scanner;
    UserController userController;
    String studentGroup;

    /**
     * creats a student view
     * @param controller used to get timetable info
     * @param userController used to find out which user is logged in
     */
    public StudentView(TimetableController controller, UserController userController) {
        super(controller);
        this.userController = userController;
        this.scanner = new Scanner(System.in);
        studentGroup = userController.getCurrentUser().getLinkedId();
    }

    /**
     * shows the timetable for the logged in student
     */
    public void viewMytimetable() {
        printTimetable(getController().getTimetableForStudent(this.studentGroup).getSessions());
    }

    /**
     * shows a menu that lets student choose what timetable to view
     * asks for extra info if needed
     */
    public void start(){
        System.out.println("1) View my timetable");
        System.out.println("2) View programme timetable");
        System.out.println("3) View module timetable");
        System.out.println("4) View room timetable");
        String ans = scanner.nextLine();


        if (ans.equals("1")) {
            viewMytimetable();
        }
        else if (ans.equals("2")) {
            System.out.println("please enter subject code");
            String subjectCode =  scanner.nextLine();
            viewSubjectTimetable(subjectCode);
        }
        else if (ans.equals("3")) {
            System.out.println("please enter module code");
            String moduleCode =  scanner.nextLine();
            viewModuleTimetable(moduleCode);
        }
        else if (ans.equals("4")) {
            System.out.println("please enter room code");
            String roomCode =  scanner.nextLine();
            viewRoomTimetable(roomCode);
        }
    }
}
