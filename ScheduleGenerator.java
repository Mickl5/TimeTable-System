import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;


/**
 * Generates the timetable for all the subjects per semester
 * */
public class ScheduleGenerator {
    private CSVDataManager manager;

    /**
     * Constructor using the CSVDataManager for interacting with CSVs
     * */
    public ScheduleGenerator(CSVDataManager manager) {
        this.manager = manager;
    }


    /**
     * Method to generate a timetable for all semesters by calling generateForSemester for each semester
     * @return the generated timetable for all semesters
     * */
    public Timetable generateForAllSemesters() {
        Timetable t1 = generateForSemester(1);
        // add t1 sessions as "existing" for t2 generation context by temporarily merging into data manager's timetable
        // (we avoid mutating dataManager here - generator maintains local existingAll logic)
        Timetable t2 = generateForSemester(2);

        Timetable merged = new Timetable();
        for (Session s : t1.getSessions()) merged.addSession(s);
        for (Session s : t2.getSessions()) merged.addSession(s);
        return merged;
    }


    /**
     * Method to generate the timetable for all programmes for a given semester
     * @param semesterNumber the semester to be generated for
     * @return a timetable object holding all the sessions for the semester
     * */
    public Timetable generateForSemester(int semesterNumber) {
        Timetable timetable = new Timetable();

        ArrayList<Subjects> subjects = manager.getSubjects();

        ArrayList<Session> existing = new ArrayList<>();
        Timetable alreadyExisting = manager.getTimetable();
        if (alreadyExisting.getSessions() != null) {
            existing.addAll(alreadyExisting.getSessions());
        }
        for (Subjects subject : subjects) {
            for (SubjectsYear year : subject.getYears()) {
                ArrayList<ModuleOffering> offerings = year.getModulesForSemester(semesterNumber);
                for (ModuleOffering offering : offerings) {
                    Module module = offering.getModule();
                    if (module == null) continue;
                    int lecHours = module.getLecHours();
                    int tutHours = module.getTutHours();
                    int labHours = module.getLabHours();

                    ArrayList<StudentGroup> groups = offering.getEnrolledGroups();

                    for (int i = 0; i < groups.size(); i++) {
                        if (!groups.get(i).getSubGroups().isEmpty()) {
                            for (int j = 0; j < lecHours; j++) {
                                Session session = tryCreateSession(module, SessionType.LECTURE, 60, semesterNumber, existing, groups.get(i));
                                if (session == null) continue;
                                timetable.addSession(session);
                                existing.add(session);
                            }
                        }
                        else {
                            for (int j = 0; j < tutHours; j++) {
                                Session session = tryCreateSession(module, SessionType.TUTORIAL, 60, semesterNumber, existing, groups.get(i));
                                if (session == null) continue;
                                timetable.addSession(session);
                                existing.add(session);
                            }

                            for (int j = 0; j < labHours; j++) {
                                SessionType type = SessionType.valueOf(String.valueOf(module.getLabType()));
                                Session session = tryCreateSession(module, type, 60, semesterNumber, existing, groups.get(i));
                                if (session == null) continue;
                                timetable.addSession(session);
                                existing.add(session);
                            }
                        }
                    }

                }
            }
        }

        return timetable;
    }

    /**
     * Method to try and create a session for the conflict checker to see if there are any overlaps
     * If the session has no overlap between lecturers/groups/rooms it returns the session to be added
     * @param module the module to be generated for
     * @param type the type of session e.g CSLAB
     * @param durationMins the duration of the session
     * @param semesterNumber the semester it generates for
     * @param existing list of existing sessions for the current session to be compared to
     * @param group the group of students that will attend the session
     * @return the first valid session
     * */
    public Session tryCreateSession(Module module, SessionType type, int durationMins,
                                    int semesterNumber, ArrayList<Session> existing, StudentGroup group) {


            ArrayList<StudentGroup> candidateGroups = new ArrayList<>();

            if((!type.equals(SessionType.LECTURE)) && !group.getSubGroups().isEmpty()) {
                candidateGroups.addAll(group.getSubGroups());
            }
            else {
                candidateGroups.add(group);
            }

            ArrayList<DayOfWeek> days = getTeachingDays();
            ArrayList<LocalTime> timeSlots = getTimeSlots();

            Collections.shuffle(days);
            Collections.shuffle(timeSlots);

            for (StudentGroup g : candidateGroups) {
                int groupSize = group.getNoOfStudents();

                for (DayOfWeek day : days) {
                    for (LocalTime startTime : timeSlots) {
                        LocalTime end = startTime.plusMinutes(durationMins);

                        if (end.isAfter(LocalTime.of(18, 0))) continue;

                        Lecturer lecturer = findAvailableLecturer(module.getLecturers(), module, type, g, day, startTime,
                                durationMins, semesterNumber, existing);
                        if (lecturer == null) continue;

                        Room room = findAvailableRoom(module, type, groupSize, lecturer, g, day, startTime,
                                durationMins, semesterNumber, existing);
                        if (room == null) continue;

                        Session candidate = createSession(type, module, room, lecturer, g, day, startTime, durationMins, semesterNumber);
                        if (!ConflictChecker.hasConflict(candidate, existing)) {
                            return candidate;
                        }
                    }
                }
            }

        return null;
    }


    /**
     * Checks to see what lecturer is available for the session if there are multiple
     * @param lecturers list of lecturers
     * @param module the module to which the session belongs
     * @param group the group of students attending
     * @param day the day of the session
     * @param startTime the start time of the session
     * @param durationMins the duration of the session
     * @param semesterNumber the semester of the session
     * @param existing array list of existing sessions
     * @return the first available lecturer
     * */
    public Lecturer findAvailableLecturer(ArrayList<Lecturer> lecturers, Module module, SessionType type, StudentGroup group, DayOfWeek day,
                                          LocalTime startTime, int durationMins, int semesterNumber, ArrayList<Session> existing) {
        LecturerType requiredType;
        if (type == SessionType.LECTURE) {
            requiredType = LecturerType.LECTURER;
        }
        else {
            requiredType = LecturerType.TA;
        }
        for (Lecturer lecturer : lecturers) {
            if (!requiredType.equals(lecturer.getType())) continue;
            Session session = createSession(SessionType.LECTURE, module, null, lecturer, group, day, startTime, durationMins, semesterNumber);
            if (!ConflictChecker.hasConflict(session, existing)) {
                return lecturer;
            }
        }
        return null;
    }

    /**
     * Checks to see what lecturer is available for the session if there are multiple
     * @param module the module to which the session belongs
     * @param type the type of room needed for the session type
     * @param groupSize the size of the group to be checked if it fits in the room
     * @param lecturer the lecturer tat will teach the session
     * @param group the group of students attending
     * @param day the day of the session
     * @param startTime the start time of the session
     * @param durationMins the duration of the session
     * @param semesterNumber the semester of the session
     * @param existing array list of existing sessions
     * @return the first available room
     * */
    public Room findAvailableRoom(Module module, SessionType type, int groupSize, Lecturer lecturer,
                                  StudentGroup group, DayOfWeek day, LocalTime startTime, int durationMins,
                                  int semesterNumber, ArrayList<Session> existing) {
        ArrayList<Room> rooms = manager.getRooms();
        RoomType roomType;
        if(type == SessionType.LECTURE || type == SessionType.TUTORIAL) {
            roomType = RoomType.CLASSROOM;
        } else if (type == SessionType.GENERALLAB) {
            roomType = RoomType.GENERALLAB;
        }
        else if (type == SessionType.CSLAB) {
            roomType = RoomType.CSLAB;
        }
        else {
            roomType = RoomType.SCIENCELAB;
        }

        for (Room room : rooms) {
            if (room.GetCapacity() < groupSize) continue;
            if (room.GetType() != roomType) continue;

            Session candidate = createSession(type, module, room, lecturer, group, day, startTime, durationMins, semesterNumber);
            if (!ConflictChecker.hasConflict(candidate, existing)) {
                return room;
            }
        }
        return null;
    }

    /**
     * Method to create a session from all its components
     * @param type the type of the session
     * @param module the module the session belongs to
     * @param room the room the session will take place in
     * @param lecturer the lecturer that will teach the session
     * @param group the group that will attend the session
     * @param day the day the session will take place in
     * @param startTime the time the session starts at
     * @param durationMins the duration of the session
     * @param semesterNumber the semester the session takes place in
     * @return the created session
     * */
    private Session createSession(SessionType type, Module module, Room room, Lecturer lecturer, StudentGroup group, DayOfWeek day, LocalTime startTime, int durationMins, int semesterNumber) {
        String id = module.getCode() + "-" + type.name() + "-" + UUID.randomUUID().toString().substring(0, 8);
        return new Session(id, type, module, room, lecturer, group, day, startTime, durationMins, semesterNumber);
    }


    /**
     * Helper method to get all the days possible in an array list
     * @return the array list containing every teaching day
     * */
    public ArrayList<DayOfWeek> getTeachingDays() {
        ArrayList<DayOfWeek> days = new ArrayList<>();
        days.add(DayOfWeek.MONDAY);
        days.add(DayOfWeek.TUESDAY);
        days.add(DayOfWeek.WEDNESDAY);
        days.add(DayOfWeek.THURSDAY);
        days.add(DayOfWeek.FRIDAY);
        return days;
    }

    /**
     * Helper method to get all the possible time slots a lecture can start at
     * @return the array list containing all the possible start times
     * */
    public ArrayList<LocalTime> getTimeSlots() {
        ArrayList<LocalTime> times = new ArrayList<>();
        for (int i = 9; i < 18; i++) {
            times.add(LocalTime.of(i, 0));
        }
        return times;
    }
}
