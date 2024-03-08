package Days.TheFountainOfObjects;

public class EntranceRoom extends Room{
    @Override
    public String RoomDescription() {
        return "You see light coming from the cavern entrance.";
    }

    @Override
    public void OnEnterRoom(Day39 game) {
        if(game.FountainState){
            game.gameIsActive = false;
            System.out.println("The Fountain of Objects has been reactivated, and you have escaped with your life!\nYou win!");
        }
    }

    @Override
    public String OnInteract(String massage, Day39 game) {
        return "You can't leave before enabling the Fountain of Objects.";
    }

    @Override
    public String toString() {
        return "entrance ";
    }
}
