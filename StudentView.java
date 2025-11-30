import java.util.Scanner;

/**
 *lets students view their own timetable and others
 */
public class StudentView extends View {
    private Scanner scanner;
    private UserController userController;
    private String studentGroup;
    private boolean isRunning;

    /**
     * creats a student view
     * @param controller used to get timetable info
     * @param userController used to find out which user is logged in
     */
    public StudentView(TimetableController controller, UserController userController) {
        super(controller);
        this.userController = userController;
        this.scanner = new Scanner(System.in);
        this.isRunning = true;
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
        while (isRunning) {
            studentGroup = userController.getCurrentUser().getLinkedId();
            System.out.println("1) View my timetable");
            System.out.println("2) View programme timetable");
            System.out.println("3) View module timetable");
            System.out.println("4) View room timetable");
            System.out.println("0) Quit");
            String ans = scanner.nextLine();


            if (ans.equals("1")) {
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
            else if (ans.equals("0")) {
                this.isRunning = false;
            }
            else {
                System.out.println("Invalid answer");
            }
        }

    }
}
