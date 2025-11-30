import java.util.Scanner;
/**
 * lets the lecturers view their timetamble
 *
 */


public class lecturerView  extends View{
    private Scanner scanner;
    private UserController userController;
    private String lecturerId;
    private boolean isRunning;

    /**
     * creates a lecvturer view
     * @param controller used to get timetable info
     * @param userController used to find out which user is logged in
     */
    public lecturerView(TimetableController controller,UserController userController){
        super(controller);
        this.scanner= new Scanner(System.in);
        this.userController = userController;
        this.isRunning = true;
    }
    /**
     * shows the timtable for logged in lecturer
     *
     */

    public void viewMytimetable(){

    printTimetable(getController().getTimetableForLecturer(this.lecturerId).getSessions());
    }

    /**
     * shows a menu that lets lecturers choose what timetable to view
     *
     */
    public void start(){
        while (isRunning) {
            lecturerId=userController.getCurrentUser().getLinkedId();
            System.out.println("1) View my timetable");
            System.out.println("2) View programme timetable");
            System.out.println("3) View module timetable");
            System.out.println("4) View room timetable");
            System.out.println("0) Quit");

            String ans = scanner.nextLine();

            if (ans.equals("1")){
                viewMytimetable();
            }
            else if (ans.equals("2")) {
                boolean running = true;
                while (running) {
                    System.out.println("Please enter the subject code");
                    String subjectCode = scanner.nextLine().toUpperCase();

                    boolean valid = false;
                    int yearNumber = 0;

                    while (!valid) {
                        System.out.println("Please enter the year number");
                        String time = scanner.nextLine();

                        try {
                            yearNumber = Integer.parseInt(time);
                            valid = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid integer. Please insert a number");
                        }
                    }

                    valid = false;
                    int semesterNumber = 0;

                    while (!valid) {
                        System.out.println("Enter the semester number:");
                        String semester = scanner.nextLine();

                        try {
                            semesterNumber = Integer.parseInt(semester);
                            valid = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid integer. Please insert a number");
                        }
                    }

                    if (!viewSubjectTimetable(subjectCode, yearNumber, semesterNumber)) {
                        System.out.println("Invalid subject code");
                    } else {
                        running = false;
                    }
                }
            }
            else if (ans.equals("3")) {
                boolean running = true;
                while (running) {
                    System.out.println("Please enter the module code");
                    String moduleCode = scanner.nextLine().toUpperCase();
                    if (!viewModuleTimetable(moduleCode)) {
                        System.out.println("Invalid module code");
                    } else {
                        running = false;
                    }
                }
            }
            else if (ans.equals("4")) {
                boolean running = true;
                while (running) {
                    System.out.println("Please enter the room code");
                    String roomCode = scanner.nextLine().toUpperCase();
                    if(!viewRoomTimetable(roomCode)) {
                        System.out.println("Invalid room code");
                    }
                    else {
                        running = false;
                    }
                }
            }
            else if(ans.equals("0")) {
                this.isRunning = false;
            }
            else {
                System.out.println("Invalid answer");
            }


        }
    }

}
