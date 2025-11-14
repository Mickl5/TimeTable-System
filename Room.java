public class Room {
    private String RoomId;
    private String name;
    private int capacity;
    private RoomType type;


    public Room(String id, String name, int capacity, RoomType type) {
        this.RoomId = id;
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    public String GetRoomId(){
        return RoomId;
    }

    public String GetName(){
        return name;
    }

    public int getCapacity(){
        return capacity;
    }

    public RoomType getType(){
        return type;
    }

    public void SetRoomID(String roomID){
        this.RoomId = roomID;
    }

    public void SetName(String name){
        this.name = name;
    }

    public void setCapacity (int capacity){
        this.capacity = capacity;
    }

    public void setType(RoomType type){
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
