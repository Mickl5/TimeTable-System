import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class View {
    protected TimetableController controller;

    public View(TimetableController controller) {
        this.controller = controller;
    }

    public boolean viewSubjectTimetable(String subjectCode, int yearNumber, int semesterNumber) {
        ArrayList<Session> list = controller.getTimetableForSubject(subjectCode, yearNumber, semesterNumber).getSessions();
        if(list.isEmpty()) {
            return false;
        }
        System.out.printf("================= TIMETABLE FOR %s =================\n",subjectCode);
        printTimetable(list);
        return true;
    }

    public boolean viewModuleTimetable(String moduleCode) {
        ArrayList<Session> list = controller.getTimetableForModule(moduleCode).getSessions();
        if(list.isEmpty()) {
            return false;
        }
        System.out.printf("================= TIMETABLE FOR %s =================\n",moduleCode);
        printTimetable(list);
        return true;
    }

    public boolean viewRoomTimetable(String roomCode) {
        ArrayList<Session> list = controller.getTimetableForRoom(roomCode).getSessions();
        if(list.isEmpty()) {
            return false;
        }
        System.out.printf("================= TIMETABLE FOR %s =================\n",roomCode);
        printTimetable(list);
        return true;
    }

    public void printTimetable(ArrayList<Session> list) {
        Map<DayOfWeek, ArrayList<Session>> byDay = new HashMap<>();
        for (DayOfWeek day : DayOfWeek.values()) {
            byDay.put(day, new ArrayList<>());
        }

        for (Session s : list) {
            byDay.get(s.getDayOfWeek()).add(s);
        }

        for (DayOfWeek day : DayOfWeek.values()) {
            ArrayList<Session> list2 = byDay.get(day);
            bubbleSortByTime(list2);
        }


        for (DayOfWeek day : DayOfWeek.values()) {
            ArrayList<Session> orderedList = byDay.get(day);

            if (orderedList.isEmpty()) {
                continue;
            }

            System.out.println("\n" + day);
            System.out.printf("  %-12s %-7s %-42s %-12s %-7s %-16s %-11s Group\n", "Time", "Module", "Module Name", "Type", "Room", "Lecturer", "Lecturer Id");

            for (Session s : orderedList) {

                System.out.printf(
                        "  %s–%s  %-7s %-42s %-12s %-7s %-16s %-11s %s%n",
                        s.getTime(),
                        s.getEndTime(),
                        s.getModule().getCode(),
                        s.getModule().getName(),
                        s.getType(),
                        s.getRoom().GetRoomId(),
                        s.getLecturer().getLecturerName(),
                        s.getLecturer().getLecturerId(),
                        s.getGroup().getGroupId()
                );
            }
        }
    }

    private static void bubbleSortByTime(ArrayList<Session> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getTime().isAfter(list.get(j + 1).getTime())) {
                    Session temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public TimetableController getController() {
        return this.controller;
    }

}

