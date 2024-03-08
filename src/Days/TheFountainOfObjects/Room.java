package Days.TheFountainOfObjects;

public abstract class Room {
    public abstract String RoomDescription();
    public String AdjacentDescription(){
        return "";
    }
    public void OnEnterRoom(Day39 game){

    }
    public String OnInteract(String massage, Day39 game){
        return "There is nothing to interact with";
    }

    public void OnShot(Day39 game, int shootRow, int shootColumn){}

    public void PrintRoomCommands(){}
}
