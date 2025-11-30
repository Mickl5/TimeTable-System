import java.util.ArrayList;

/**
 * Controller for student groups
 * Adds, deletes and links student groups
 * */
public class StudentController extends Controller {

    /**
     * public constructor
     * @param manager the manager needed for the controller superclass
     * */
    public StudentController(CSVDataManager manager) {
        super(manager);
    }

    /**
     * method to add a group
     * @param studentGroup the group to be added
     * */
    public void addGroup(StudentGroup studentGroup) {
        getManager().getGroups().add(studentGroup);
    }

    /**
     * method to permanently delete a group by its id
     * @param groupId the id of the group to be deleted
     * */
    public void deleteGroup(String groupId) {
        StudentGroup group = getManager().getGroupById(groupId);
        SubjectsYear year = group.getSubjectYear();
        ArrayList<ModuleOffering> offerings = year.getModulesForSemester(1);
        offerings.addAll(year.getModulesForSemester(2));


        for (ModuleOffering offering : offerings) {
            if (offering.getEnrolledGroups().contains(group)) {
                offering.getEnrolledGroups().remove(group);
            }
        }

        for (Session session : getManager().getTimetable().getSessions()) {
            if (session.getGroup().equals(group)) {
                getManager().getTimetable().getSessions().remove(session);
            }
        }

        for (StudentGroup g : getManager().getGroups()) {
            if (g.getGroupId().equals(groupId)) {
                getManager().getGroups().remove(g);
            }
        }
    }

    /**
     * method to add a subgroup
     * @param group the group to be added
     * @param parentId the parent id group to add the subgroup to
     * */
    public void addSubGroup(String parentId, StudentGroup group) {
        StudentGroup parentGroup = getManager().getGroupById(parentId);
        parentGroup.getSubGroups().add(group);
    }
}
