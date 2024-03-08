package Days.TheFountainOfObjects;

public class EmptyRoom extends Room{
    @Override
    public String RoomDescription() {
        return "There is nothing interesting in this room.";
    }

    @Override
    public String toString() {
        return "         ";
    }
}
