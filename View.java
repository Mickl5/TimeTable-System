import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class View {
    private TimetableController controller;

    public View(TimetableController controller) {
        this.controller = controller;
    }

    public void viewSubjectTimetable(String subjectCode) {
        ArrayList<Session> list = controller.getTimetableForSubject(subjectCode).getSessions();
        System.out.printf("================= TIMETABLE FOR %s =================\n",subjectCode);
        printTimetable(list);
    }

    public void viewModuleTimetable(String moduleCode) {
        ArrayList<Session> list = controller.getTimetableForModule(moduleCode).getSessions();
        System.out.printf("================= TIMETABLE FOR %s =================\n",moduleCode);

        printTimetable(list);
    }

    private void printTimetable(ArrayList<Session> list) {
        // Step 1: group by day
        Map<DayOfWeek, ArrayList<Session>> byDay = new HashMap<>();
        for (DayOfWeek day : DayOfWeek.values()) {
            byDay.put(day, new ArrayList<>());
        }

        for (Session s : list) {
            byDay.get(s.getDayOfWeek()).add(s);
        }

        // Step 2: sort each day by time
        for (DayOfWeek day : DayOfWeek.values()) {
            ArrayList<Session> list2 = byDay.get(day);
            bubbleSortByTime(list2);
        }

        // Step 3: print timetable


        for (DayOfWeek day : DayOfWeek.values()) {
            ArrayList<Session> orderedList = byDay.get(day);

            if (orderedList.isEmpty()) {
                continue;
            }

            System.out.println("\n" + day);

            for (Session s : orderedList) {
                System.out.printf(
                        "  %s–%s  %-37s %-12s %-15s Group %s%n",
                        s.getTime(),
                        s.getEndTime(),
                        s.getModule().getName(),
                        s.getType(),
                        s.getLecturer().getLecturerName(),
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

}
