package Days.TheFountainOfObjects;

public class MaelstromRoom extends Room{
    @Override
    public String RoomDescription() {
        return "this is a maelstrom.";
    }

    @Override
    public void OnEnterRoom(Day39 game) {
        System.out.println("You enter a room with a maelstrom and are swept away by the winds to another room.");
        int newRow = game.Row;
        int newColumn = game.Column;
        do{
            newRow = (newRow + game.Size - 1) % game.Size;
            newColumn = (newColumn + game.Size - 2) % game.Size;
            if(game.Row == newRow && game.Column == newColumn){
                newColumn = (newColumn + game.Size - 1) % game.Size;
            }
        }while(game.World[newRow][newColumn].getClass() != EmptyRoom.class);
        game.World[newRow][newColumn] = new MaelstromRoom();
        game.World[game.Row][game.Column] = new EmptyRoom();

        game.Row = Math.min(game.Row + 1, game.Size - 1);
        game.Column = Math.min(game.Column + 2, game.Size - 1);
        game.World[game.Row][game.Column].OnEnterRoom(game);
    }

    @Override
    public String AdjacentDescription() {
        return "You hear the growling and groaning of a maelstrom nearby.";
    }

    @Override
    public String toString() {
        return "Maelstrom";
    }


    @Override
    public void OnShot(Day39 game, int shootRow, int shootColumn) {
        game.World[shootRow][shootColumn] = new EmptyRoom();
    }
}
