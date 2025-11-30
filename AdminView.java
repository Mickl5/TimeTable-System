import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Class showing what the admin views, inherits from view
 * */
public class AdminView extends View {
    private Scanner scanner;
    private AdminController adminController;
    private String AdminGroup;
    private boolean isRunning;

    /**
     * creates an admin view
     *
     * @param controller used to manage users, groups and modules
     */
    public AdminView(TimetableController timetableController, AdminController controller) {
        super(timetableController);
        this.adminController = controller;
        this.scanner = new Scanner(System.in);
        this.isRunning = true;
    }

    /**
     * shows a menu that lets admin choose what to manage
     *
     */
    public void start() {
        while (isRunning) {
            System.out.println("1. Add session");
            System.out.println("2. Remove session");
            System.out.println("3. View programme timetable");
            System.out.println("4. View module timetable");
            System.out.println("5. View room timetable");
            System.out.println("0. Quit");


            String ans = scanner.nextLine();
            if (ans.equals("1")) {
                System.out.println("Enter sessionId:");
                String sessionId = scanner.nextLine();

                SessionType type = null;
                while (type == null) {
                    try {
                        System.out.println("Please enter session type(LECTURE, GENERALLAB, CSLAB, SCIENCELAB, TUTORIAL): ");
                        type = SessionType.valueOf(scanner.nextLine().trim().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid session type. Please enter one of: LECTURE, GENERALLAB, CSLAB, SCIENCELAB, TUTORIAL.");
                    }
                }

                Module module = null;
                while (module == null) {
                    System.out.println("Enter module code:");
                    String moduleCode = scanner.nextLine();
                    module = adminController.getManager().getModuleById(moduleCode.toUpperCase());
                    if(module == null) {
                        System.out.println("Invalid module code");
                    }
                }

                Room room = null;
                while (room == null) {
                    System.out.println("Enter room code:");
                    String roomCode = scanner.nextLine();
                    room = adminController.getManager().getRoomById(roomCode.toUpperCase());
                    if (room == null) {
                        System.out.println("Invalid room code");
                    }
                }

                String day = "";
                boolean incorrectDay = true;
                while (incorrectDay) {
                    System.out.println("Enter day(Monday - Friday): ");
                    day = scanner.nextLine().toUpperCase();
                    if (day.equalsIgnoreCase("monday") || day.equalsIgnoreCase("tuesday") ||
                            day.equalsIgnoreCase("wednesday") || day.equalsIgnoreCase("thursday") ||
                            day.equalsIgnoreCase("friday")) {
                        incorrectDay = false;
                    }
                }
                DayOfWeek dayOfWeek = DayOfWeek.valueOf(day);

                boolean valid = false;
                LocalTime localTime = null;

                while (!valid) {
                    System.out.println("Enter time (hh:mm):");
                    String time = scanner.nextLine();

                    try {
                        localTime = LocalTime.parse(time);
                        valid = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid time format. Please enter in hh:mm format.");
                    }
                }

                StudentGroup group = null;
                while (group == null) {
                    System.out.println("Enter groupId:");
                    String groupId = scanner.nextLine();
                    group = adminController.getManager().getGroupById(groupId);
                    if (group == null) {
                        System.out.println("Group not found");
                    }
                }


                Lecturer lecturer = null;
                while (lecturer == null) {
                    System.out.println("Enter lecturerId:");
                    String lecturerId = scanner.nextLine();
                    lecturer = adminController.getManager().getLecturerById(lecturerId);
                    if(lecturer == null) {
                        System.out.println("Incorrect lecturer id");
                    }
                }


                valid = false;
                int duration = 0;

                while (!valid) {
                    System.out.println("Enter the duration of session in minutes:");
                    String time = scanner.nextLine();

                    try {
                        duration = Integer.parseInt(time);
                        valid = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid integer format. Please enter in hh:mm format.");
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
                        System.out.println("Invalid integer format. Please enter in hh:mm format.");
                    }
                }

                Session session = new Session(sessionId, type, module, room, lecturer, group, dayOfWeek, localTime, duration, semesterNumber);
            }

            else if (ans.equals("2")) {
                System.out.println("Enter sessionId:");
                String sessionId = scanner.nextLine();

                SessionType type = null;
                while (type == null) {
                    try {
                        System.out.println("Please enter session type(LECTURE, GENERALLAB, CSLAB, SCIENCELAB, TUTORIAL): ");
                        type = SessionType.valueOf(scanner.nextLine().trim().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid session type. Please enter one of: LECTURE, GENERALLAB, CSLAB, SCIENCELAB, TUTORIAL.");
                    }
                }

                Module module = null;
                while (module == null) {
                    System.out.println("Enter module code:");
                    String moduleCode = scanner.nextLine();
                    module = adminController.getManager().getModuleById(moduleCode.toUpperCase());
                    if(module == null) {
                        System.out.println("Invalid module code");
                    }
                }

                Room room = null;
                while (room == null) {
                    System.out.println("Enter room code:");
                    String roomCode = scanner.nextLine();
                    room = adminController.getManager().getRoomById(roomCode.toUpperCase());
                    if (room == null) {
                        System.out.println("Invalid room code");
                    }
                }

                String day = "";
                boolean incorrectDay = true;
                while (incorrectDay) {
                    System.out.println("Enter day(Monday - Friday): ");
                    day = scanner.nextLine().toUpperCase();
                    if (day.equalsIgnoreCase("monday") || day.equalsIgnoreCase("tuesday") ||
                            day.equalsIgnoreCase("wednesday") || day.equalsIgnoreCase("thursday") ||
                            day.equalsIgnoreCase("friday")) {
                        incorrectDay = false;
                    }
                }
                DayOfWeek dayOfWeek = DayOfWeek.valueOf(day);

                boolean valid = false;
                LocalTime localTime = null;

                while (!valid) {
                    System.out.println("Enter time (hh:mm):");
                    String time = scanner.nextLine();

                    try {
                        localTime = LocalTime.parse(time);
                        valid = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid time format. Please enter in hh:mm format.");
                    }
                }

                StudentGroup group = null;
                while (group == null) {
                    System.out.println("Enter groupId:");
                    String groupId = scanner.nextLine();
                    group = adminController.getManager().getGroupById(groupId);
                    if (group == null) {
                        System.out.println("Group not found");
                    }
                }


                Lecturer lecturer = null;
                while (lecturer == null) {
                    System.out.println("Enter lecturerId:");
                    String lecturerId = scanner.nextLine();
                    lecturer = adminController.getManager().getLecturerById(lecturerId);
                    if(lecturer == null) {
                        System.out.println("Incorrect lecturer id");
                    }
                }


                valid = false;
                int duration = 0;

                while (!valid) {
                    System.out.println("Enter the duration of session in minutes:");
                    String time = scanner.nextLine();

                    try {
                        duration = Integer.parseInt(time);
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

                Session session = new Session(sessionId, type, module, room, lecturer, group, dayOfWeek, localTime, duration, semesterNumber);
            }

            else if (ans.equals("3")) {
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
            else if (ans.equals("4")) {
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
            else if (ans.equals("5")) {
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

