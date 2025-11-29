import java.util.Scanner;

public class AdminView extends View {
    private Scanner scanner;
    UserController userController;
    String AdminGroup;

    /**
     * creates an admin view
     *
     * @param controller used to manage users, groups and modules
     */
    public AdminView(AdminController controller) {
        this.scanner = new Scanner(System.in);
        super(controller);
        this.adminController = controller;
    }

    /**
     * shows a menu that lets admin choose what to manage
     *
     */
    public void start() {
        System.out.println("1. Create user");
        System.out.println("2. Remove user");
        System.out.println("3. Create Student group");
        System.out.println("4. Remove Student group");
        System.out.println("5. Add module");
        System.out.println("6. Remove module");
        System.out.println("7. Assign lecturer to module");
        System.out.println("8. Remove lecturer from module");

        String ans = scanner.nextLine();
        if (ans.equals("1")) {
            System.out.println("Enter userId:");
            String userId = scanner.nextLine();
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();
            System.out.println("Enter user type (ADMIN/STUDENT/LECTURER):");
            UserType type = UserType.valueOf(scanner.nextLine().toUpperCase());
            System.out.println("Enter linkedId:");
            String linkedId = scanner.nextLine();
            if (adminController.createUser(userId, name, password, type, linkedId)) {
                System.out.println("User created successfully.");
            } else {
                System.out.println("Failed to create user.");
            }
        } else if (ans.equals("2")) {
            System.out.println("Enter userId to remove:");
            String userId = scanner.nextLine();
            if (adminController.removeUser(userId)) {
                System.out.println("User removed.");
            } else {
                System.out.println("User not found.");
            }
        } else if (ans.equals("3")) {
            System.out.println("Enter Student groupId:");
            String groupId = scanner.nextLine();
            System.out.println("Enter subject:");
            Subjects subject = new Subjects(scanner.nextLine());
            System.out.println("Enter subject year:");
            SubjectsYear subjectYear = new SubjectsYear(scanner.nextLine());
            System.out.println("Enter number of students:");
            int noOfStudents = Integer.parseInt(scanner.nextLine());
            if (adminController.createGroup(groupId, subject, subjectYear, noOfStudents)) {
                System.out.println("Group created successfully.");
            } else {
                System.out.println("Group already exists.");
            }
        } else if (ans.equals("4")) {
            System.out.println("Enter groupId to remove:");
            String groupId = scanner.nextLine();
            adminController.removeGroup(groupId);
            System.out.println("Group removed.");


        }
        else if (ans.equals("5")) {
            System.out.println("Enter module code:");
            String code = scanner.nextLine();
            System.out.println("Enter module name:");
            String name = scanner.nextLine();
            Module module = new Module(code, name);
            if (adminController.addModule(module)) {
                System.out.println("Module added.");
            }
        }
        else if (ans.equals("6")) {
            System.out.println("Enter module code to remove:");
            String code = scanner.nextLine();
            if (adminController.removeModule(code)) {
                System.out.println("Module removed.");
            } else {
                System.out.println("Module not found.");
            }
        }
        else if (ans.equals("7")) {
            System.out.println("Enter module code:");
            String code = scanner.nextLine();
            System.out.println("Enter lecturerId:");
            String lecturerId = scanner.nextLine();
            System.out.println("Enter lecturer name:");
            String name = scanner.nextLine();
            Lecturer lecturer = new Lecturer(lecturerId, name);
            if (adminController.assignLecturer(code, lecturer)) {
                System.out.println("Lecturer assigned.");
            } else {
                System.out.println("Failed to assign lecturer.");
            }
        }
        else if (ans.equals("8")) {
            System.out.println("Enter module code:");
            String code = scanner.nextLine();
            System.out.println("Enter lecturerId:");
            String lecturerId = scanner.nextLine();
            Lecturer lecturer = new Lecturer(lecturerId, "");
            if (adminController.removeLecturer(code, lecturer)) {
                System.out.println("Lecturer removed.");
            } else {
                System.out.println("Failed to remove lecturer.");
            }
        }
    }

    }

