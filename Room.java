/**A representation of the room*/

public class Room {
    private String RoomId;
    private String name;
    private int capacity;
    private RoomType type;

    /**
     *@param id sets the roomid
     *@param name sets the name
     *@param capacity sets the capacity
     *@param type sets the type
     * */
    public Room(String id, String name, int capacity, RoomType type) {
        this.RoomId = id;
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }
    /**@return Gets the room ID*/
    public String GetRoomId(){
        return RoomId;
    }
    /**@return Gets the room name*/
    public String GetName(){
        return name;
    }
    /**@return Gets the room capacity*/
    public int GetCapacity(){
        return capacity;
    }
    /**@return Gets the room type*/
    public RoomType GetType(){
        return type;
    }
    /**Sets the room ID*/
    public void SetRoomID(String roomID){
        this.RoomId = roomID;
    }
    /**Sets the room name*/
    public void SetName(String name){
        this.name = name;
    }
    /**Sets the room capacity*/
    public void SetCapacity (int capacity){
        this.capacity = capacity;
    }

    /**Sets the room type*/
    public void SetType(RoomType type){
        this.type = type;
    }



/* public void String (){
    String Building = "TSPMOSYBAU";
    int picker = ((int) (Math.random() * 10) + 1);
    int roomNumber = ((int) (Math.random() * 100) + 1);

    String noomRumber = Integer.toString(roomNumber);
    String buildingLetter = String.valueOf(Building.charAt(picker));
    String roomCode = (buildingLetter + noomRumber);

} */
}
