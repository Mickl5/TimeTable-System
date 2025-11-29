import java.util.ArrayList;

public class StudentController extends Controller {

    public StudentController(CSVDataManager manager) {
        super(manager);
    }

    public void addGroup(StudentGroup studentGroup) {
        getManager().getGroups().add(studentGroup);
    }

    public void deleteGroup(String groupId) {
        StudentGroup group = getManager().getGroupById(groupId);
        SubjectsYear year = group.getSubjectYear();
        ArrayList<ModuleOffering> offerings = year.getModulesForSemester(1);
        offerings.addAll(year.getModulesForSemester(2));

        //Removes the group from the module offering
        for (ModuleOffering offering : offerings) {
            if (offering.getEnrolledGroups().contains(group)) {
                offering.getEnrolledGroups().remove(group);
            }
        }
        //Removes the group's session from the timetables
        for (Session session : getManager().getTimetable().getSessions()) {
            if (session.getGroup().equals(group)) {
                getManager().getTimetable().getSessions().remove(session);
            }
        }
        //Removes the group from the groups in the manager
        for (StudentGroup g : getManager().getGroups()) {
            if (g.getGroupId().equals(groupId)) {
                getManager().getGroups().remove(g);
            }
        }
    }

    public void addSubGroup(String parentId, StudentGroup group) {
        StudentGroup parentGroup = getManager().getGroupById(parentId);
        parentGroup.getSubGroups().add(group);
    }
}
