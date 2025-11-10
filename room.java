public class room {
    private int roomid;
    private String name;
    private int capacity;
    private String type;

    public room() {

    }

    public room(int id, String name, int capacity, int type) {
        this.roomid = id;
        this.name = name;
    }

    public int GetRoomid(){
        return roomid;
    }

    public String GetName(){
        return name;
    }

    public int getCapacity(){
        return capacity;
    }

    public String getType(){
        return type;
    }

    public void SetRoomID(int roomID){
        this.roomid = roomID;
    }

    public void SetName(String name){
        this.name = name;
    }

    public void setCapacity (int capacity){
        this.capacity = capacity;
    }

    public void setType(String type){
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
