import java.util.Scanner;

public class CLIView extends View{
    private Scanner scanner;
    private UserController controller;
    private StudentView studentView;
    private lecturerView lecturerView;
    private AdminView adminView;
    private boolean running;

    public CLIView(TimetableController timetableController, UserController userController, StudentView studentView, lecturerView lecturerView, AdminView adminView) {
        super(timetableController);
        this.controller = userController;
        this.scanner = new Scanner(System.in);
        this.studentView = studentView;
        this.lecturerView = lecturerView;
        this.adminView = adminView;
        this.running = true;
    }

    public void Start() {
        while (running) {
            System.out.println("1) Log in");
            System.out.println("2) View timetable for programme");
            System.out.println("3) View timetable for module");
            System.out.println("4) View timetable for room");
            System.out.println("0) Quit");

            String ans = scanner.nextLine();
            if (ans.equals("1")) {
                System.out.println("Please enter your username: ");
                String userName = scanner.nextLine();
                System.out.println("Please enter your password: ");
                String password = scanner.nextLine();
                boolean loggedIn = controller.login(userName, password);
                if (!loggedIn) {
                    System.out.println("Invalid user name or password");
                    continue;
                }
                else {
                    routeUser(controller.getCurrentUser());
                }

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

                    if(!viewSubjectTimetable(subjectCode, yearNumber, semesterNumber)){
                        System.out.println("Invalid subject code");
                    }
                    else {
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
                this.running = false;
            }
            else {
                System.out.println("Invalid answer");
            }
        }

    }

    public void routeUser(User user) {
        switch (user.getType()) {
            case ADMIN:
                adminView.start();
                this.running = false;
            break;
            case STUDENT:
                studentView.start();
                this.running = false;
            break;
            case LECTURER:
                lecturerView.start();
                this.running = false;
            break;
        }
    }
}

