package Days.TheFountainOfObjects;

import java.util.Objects;

public class MaelstromRoom extends Room{
    @Override
    public String RoomDescription() {
        return "this is a maelstorm";
    }

    @Override
    public void OnEnterRoom(Day39 game) {
        System.out.println("You enter a room with a maelstorm and are swept away by the winds to another room");
        int newRow = game.Row;
        int newCollumn = game.Column;
        do{
            newRow = (newRow + game.Size - 1) % game.Size;
            newCollumn = (newCollumn + game.Size - 2) % game.Size;
            if(game.Row == newRow && game.Column == newCollumn){
                newCollumn = (newCollumn + game.Size - 1) % game.Size;
            }
        }while(Objects.equals(game.World[newRow][newCollumn], new EmptyRoom()));
        game.World[newRow][newCollumn] = new MaelstromRoom();
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
}
