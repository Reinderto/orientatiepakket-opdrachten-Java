package Days.TheFountainOfObjects;

public class AmarokRoom extends Room{
    @Override
    public String RoomDescription() {
        return "this is a amarok.";
    }

    @Override
    public void OnEnterRoom(Day39 game) {
        game.gameIsActive = false;
        System.out.println("You have been eaten by a amarok!\nYou lose.");
    }

    @Override
    public String AdjacentDescription() {
        return "You can smell the rotten stench of an amarok in a nearby room.";
    }

    @Override
    public String toString() {
        return " amarok  ";
    }

    @Override
    public void OnShot(Day39 game, int shootRow, int shootColumn) {
        game.World[shootRow][shootColumn] = new EmptyRoom();
    }
}
