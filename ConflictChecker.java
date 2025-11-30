import java.time.LocalTime;
import java.util.ArrayList;

public class ConflictChecker {
    public static boolean hasConflict(Session newSession, ArrayList<Session> existingSessions) {
        for (Session session : existingSessions) {
            if(conflicts(newSession, session)) {
                return true;
            }
        }
        return false;
    }

    private static boolean conflicts(Session newSession, Session oldSession) {
        if (!newSession.getDayOfWeek().equals(oldSession.getDayOfWeek())) return false;
        if (!timesOverlap(oldSession.getTime(), oldSession.getEndTime(), newSession.getTime(), newSession.getEndTime())) return false;
        if(lecturerConflict(newSession, oldSession)) return true;
        if(roomConflict(newSession, oldSession)) return true;
        if(groupConflict(newSession, oldSession)) return true;

        return false;
    }

    private static boolean timesOverlap(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        return (start1.isBefore(end2) && end1.isAfter(start2));
    }

    private static boolean lecturerConflict(Session newSession, Session oldSession) {
        if(newSession.getLecturer() == null || oldSession.getLecturer() == null) return false;
        return newSession.getLecturer().getLecturerId() == oldSession.getLecturer().getLecturerId();
    }

    private static boolean roomConflict(Session newSession, Session oldSession) {
        if (newSession.getRoom() == null || oldSession.getRoom() == null) return false;
        return newSession.getRoom().GetRoomId() == oldSession.getRoom().GetRoomId();
    }

    private static boolean groupConflict(Session newSession, Session oldSession) {
        if (newSession.getGroup() == null || oldSession.getGroup() == null) return false;
        return newSession.getGroup().getGroupId() == oldSession.getGroup().getGroupId();
    }
}
