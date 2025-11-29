import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Scanner;

public class AdminView extends View {
    private Scanner scanner;
    AdminController adminController;
    String AdminGroup;

    /**
     * creates an admin view
     *
     * @param controller used to manage users, groups and modules
     */
    public AdminView(TimetableController timetableController, AdminController controller) {
         super(timetableController);
         this.adminController = controller;
        this.scanner = new Scanner(System.in);
      
       
    }

    /**
     * shows a menu that lets admin choose what to manage
     *
     */
    public void start() {
        System.out.println("1. Add session");
        System.out.println("2. Remove session");
        System.out.println("3. View programme timetable");
        System.out.println("4. View module timetable");
        System.out.println("5. View room timetable");


        String ans = scanner.nextLine();
        if (ans.equals("1")) {
            System.out.println("Enter sessionId:");
            String sessionId = scanner.nextLine();
            System.out.println("Enter session type:");
            SessionType type = SessionType.valeuOf(scanner.nextLine());

            System.out.println("Enter module code:");
            String moduleCode = scanner.nextLine();
            Module module = adminController.getManager().getModuleById(moduleCode);

            System.out.println("Enter room code:");
            String roomCode = scanner.nextLine();
            Room room = adminController.getManager().getRoomById(roomCode);

            System.out.println("Enter day:");
            String day = scanner.nextLine();
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(day);

            System.out.println("Enter time:");
            String time = scanner.nextLine();
            LocalTime localTime = LocalTime.parse(time);

            System.out.println("Enter groupId:");
            String groupId = scanner.nextLine();
            StudentGroup group = adminController.getManager().getGroupById(groupId);

            System.out.println("Enter lecturerId:");
            String lecturerId = scanner.nextLine();
            Lecturer lecturer = adminController.getManager().getLecturerById(lecturerId);

            System.out.println("Enter the duration of session in minutes:");
            int duration = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the semester number:");
            int semester = Integer.parseInt(scanner.nextLine());

            Session session = new Session(sessionId, type, module, room, lecturer, group, dayOfWeek, localTime, duration, semester);

            if (adminController.addSession(session)) {
                System.out.println("Session added.");
            } else {
                System.out.println("Failed to add session.");
            }
        }

        else if (ans.equals("2")) {
            System.out.println("Enter sessionId:");
            String sessionId = scanner.nextLine();
            System.out.println("Enter session type:");
            SessionType type = SessionType.valueOf(scanner.nextLine());

            System.out.println("Enter module code:");
            String moduleCode = scanner.nextLine();
            Module module = adminController.getManager().getModuleById(moduleCode);

            System.out.println("Enter room code:");
            String roomCode = scanner.nextLine();
            Room room = adminController.getManager().getRoomById(roomCode);

            System.out.println("Enter day:");
            String day = scanner.nextLine();
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(day);

            System.out.println("Enter time:");
            String time = scanner.nextLine();
            LocalTime localTime = LocalTime.parse(time);

            System.out.println("Enter groupId:");
            String groupId = scanner.nextLine();
            StudentGroup group = adminController.getManager().getGroupById(groupId);

            System.out.println("Enter lecturerId:");
            String lecturerId = scanner.nextLine();
            Lecturer lecturer = adminController.getManager().getLecturerById(lecturerId);

            System.out.println("Enter the duration of session in minutes:");
            int duration = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the semester number:");
            int semester = Integer.parseInt(scanner.nextLine());

            Session session = new Session(sessionId, type, module, room, lecturer, group, dayOfWeek, localTime, duration, semester);

            if (adminController.removeSession(session)) {
                System.out.println("Session removed.");
            } else {
                System.out.println("Failed to remove session.");
            }
        }
         else if (ans.equals("3")){
        System.out.println("Please enter the subject code");
        String subjectCode = scanner.nextLine();
        viewSubjectTimetable(subjectCode);
    }
   else if (ans.equals("4")){
        System.out.println("Please enter the module code");
        String moduleCode = scanner.nextLine();
        viewModuleTimetable(moduleCode);
    }
    else if(ans.equals("5")){
        System.out.println("Please enter the room code");
        String roomCode = scanner.nextLine();
        viewRoomTimetable(roomCode);
    }

    }

    }





