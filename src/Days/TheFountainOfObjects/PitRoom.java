package Days.TheFountainOfObjects;

public class PitRoom extends Room{
    @Override
    public String RoomDescription() {
        return "this is a pit";
    }

    @Override
    public void OnEnterRoom(Day39 game) {
        game.gameIsActive = false;
        System.out.println("You fell into a Pit!\nYou lose.");
    }

    @Override
    public String AdjacentDescription() {
        return "You feel a draft. There is a pit in a nearby room.";
    }

    @Override
    public String toString() {
        return "   Pit   ";
    }
}
