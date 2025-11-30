import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Static class that enables checking for conflict wherever needed
 * */
public class ConflictChecker {

    /**
     * Checks if a session conflicts with any session in a given array of sessions
     * @param newSession the session to be checked for
     * @param existingSessions the list of sessions to be checked against
     * @return returns true or false if there is or isn't conflict
     * */
    public static boolean hasConflict(Session newSession, ArrayList<Session> existingSessions) {
        for (Session session : existingSessions) {
            if(conflicts(newSession, session)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a session has a conflict with another session
     * Private helper method called inisde hasConflict
     * @param newSession the session to be checked for
     * @param oldSession the session to be checked against
     * */
    private static boolean conflicts(Session newSession, Session oldSession) {
        if (!newSession.getDayOfWeek().equals(oldSession.getDayOfWeek())) return false;
        if (!timesOverlap(oldSession.getTime(), oldSession.getEndTime(), newSession.getTime(), newSession.getEndTime())) return false;
        if(lecturerConflict(newSession, oldSession)) return true;
        if(roomConflict(newSession, oldSession)) return true;
        if(groupConflict(newSession, oldSession)) return true;

        return false;
    }

    /**
     * Checks if 2 sessions overlap by checking their time
     * @param start1 start of one session
     * @param end1 end of one session
     * @param start2 start of the other session
     * @param end2 the end of the other session
     * @return returns true or false on whether there is a time conflict
     * */
    private static boolean timesOverlap(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        return (start1.isBefore(end2) && end1.isAfter(start2));
    }

    /**
     * Checks if 2 sessions have the same lecturer
     * @param newSession the session to be checked for
     * @param oldSession the session to be checked against
     * @return true or false depending on if it is the same lecturer
     * */
    private static boolean lecturerConflict(Session newSession, Session oldSession) {
        if(newSession.getLecturer() == null || oldSession.getLecturer() == null) return false;
        return newSession.getLecturer().getLecturerId() == oldSession.getLecturer().getLecturerId();
    }

    /**
     * Checks if 2 sessions have the same room
     * @param newSession the session to be checked for
     * @param oldSession the session to be checked against
     * @return true or false depending on if it is the same room
     * */
    private static boolean roomConflict(Session newSession, Session oldSession) {
        if (newSession.getRoom() == null || oldSession.getRoom() == null) return false;
        return newSession.getRoom().GetRoomId() == oldSession.getRoom().GetRoomId();
    }

    /**
     * Checks if 2 sessions have the same group
     * @param newSession the session to be checked for
     * @param oldSession the session to be checked against
     * @return true or false depending on if it is the same group
     * */
    private static boolean groupConflict(Session newSession, Session oldSession) {
        if (newSession.getGroup() == null || oldSession.getGroup() == null) return false;
        if (newSession.getGroup().getGroupId().equals(oldSession.getGroup().getGroupId())) {
            return true;
        }
        if(!oldSession.getGroup().getSubGroups().isEmpty()) {
            for (StudentGroup group : oldSession.getGroup().getSubGroups()) {
                if (newSession.getGroup().getGroupId().equals(group.getGroupId())) {
                    return true;
                }
            }
        }
        if(!newSession.getGroup().getSubGroups().isEmpty()) {
            for (StudentGroup group : newSession.getGroup().getSubGroups()) {
                if (oldSession.getGroup().getGroupId().equals(group.getGroupId())) {
                    return true;
                }
            }
        }
        return false;
    }
}
