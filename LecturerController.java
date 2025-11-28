/**A class that creates and deletes lecturers and gets their id*/
public class LecturerController extends Controller{
    //create lecturer
    //delete lecturer
    //get lecturer by id

    CSVDataManager manager;

    /**Constructs a new lecturerController and initialises it with the datamanager
     *@param dataManager manages the data*/
    public LecturerController(CSVDataManager dataManager) {
        super(dataManager);
    }


    /**Adds a lecturer to the controllers list
     *@param Lecturer the lecturer to be added */
    public void addLecturer(Lecturer lecturer) {
        getManager().getLecturers().add(lecturer);
    }

    /**Removes a specific lecturer from the controllers list
     *@param lecturerId Lecturer to be removed
     *@return If true, the lecturer was found and removed, else input was null*/
    public boolean removeLecturer(String lecturerId) {
        for (Lecturer lecturer : getManager().getLecturers()) {
            if (lecturer.getLecturerId().equals(lecturerId)) {
                getManager().getLecturers().remove(lecturer);
                return true;
            }
        }
        return false;

    }

    /**Finds a lecturer using their unique ID
     *@param Id the ID of the lecturer being found e.g(CS4114)
     *@return the lecturer if their found or null if no lecturer matches*/
    public Lecturer getLecturer(String id) {
        for (Lecturer lecturer : getManager().getLecturers()) {
            if (lecturer.getLecturerId().equals(id)) {
                return lecturer;
            }
        }
        return null;
    }
}