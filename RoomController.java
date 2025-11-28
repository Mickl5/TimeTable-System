/**A class that creates and deletes rooms and gets their id*/
public class RoomController extends Controller{
    //create room
    //delete room
    //get room by id

    CSVDataManager manager;

    /**Constructs a new roomController and initialises it with the datamanager
     *@param dataManager manages the data*/
    public RoomController(CSVDataManager dataManager) {
        super(dataManager);
    }


    /**Adds a room to the controllers list
     *@param Room the room to be added */
    public void addRoom(Room room) {
        getManager().getRooms().add(room);
    }

    /**Removes a specific room from the controllers list
     *@param roomId Room to be removed
     *@return If true, the room was found and removed, else input was null*/
    public boolean removeRoom(String roomId) {
        for (Room room : getManager().getRooms()) {
            if (room.getCode().equals(roomId)) {
                getManager().getRooms().remove(room);
                return true;
            }
        }
        return false;

    }

    /**Finds a room using its unique code
     *@param code the code of the room being found e.g(CS4114)
     *@return the room if its found or null if no room matches*/
    public Room getRoom(String code) {
        for (Room room : getManager().getRooms()) {
            if (room.getCode().equals(code)) {
                return room;
            }
        }
        return null;
    }
}


