package Days.TheFountainOfObjects;

import Days.DayOpdracht;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Day39 extends DayOpdracht {
    public boolean FountainState = false;
    public boolean gameIsActive = true;
    public int Row = 0;
    public int Column = 0;
    public Room[][] World;
    public static int PitFrequency = 16;
    @Override
    public void Run() {
        int size = AskForNumberInRange("How big do you want the world to be? (min 4)", 4, 128);
        GenerateWorld(size);
        Scanner reader = new Scanner(System.in);
        while (gameIsActive){
            System.out.println("You are in the room at (Row=" + Row + ", Column=" + Column + ").");
            System.out.println(World[Row][Column].RoomDescription());
            PrintAdjacentRoomDescriptions();
            System.out.println("What do you want to do?");
            String action = reader.nextLine();
            if(action.startsWith("move ")){
                Move(action.substring(5));
                World[Row][Column].OnEnterRoom(this);
            }
            else {
                System.out.println(World[Row][Column].OnInteract(action, this));
            }
            System.out.println("----------------------------------------------------------------------------------");
        }
    }

    private void PrintAdjacentRoomDescriptions(){
        HashSet<String> adjacentRooms = new HashSet<>();
        for(int i = -1;i <= 1; i++){
            for (int j = -1; j <= 1;j++){
                if((i != 0 || j != 0) && IsInWorld(Row + i, Column + j)){
                    String adjacentRoomDesc = World[Row + i][Column + j].AdjacentDescription();
                    if(!adjacentRoomDesc.isEmpty()){
                        adjacentRooms.add(adjacentRoomDesc);
                    }
                }
            }
        }
        if(!adjacentRooms.isEmpty()){
            System.out.println(String.join("\n", adjacentRooms));
        }
    }

    private boolean IsInWorld(int row, int column){
        return row >= 0 && row < World.length && column >= 0 && column < World.length;
    }

    private void Move(String direction){
        switch (direction){
            case "north":
                if(Row < World.length - 1){
                    Row++;
                    return;
                }
                break;
            case "east":
                if(Column < World[Row].length - 1){
                    Column++;
                    return;
                }
                break;
            case "south":
                if(Row > 0){
                    Row--;
                    return;
                }
                break;
            case "west":
                if(Column > 0){
                    Column--;
                    return;
                }
                break;
            default:
                System.out.println("Invalid direction " + direction);
                return;
        }
        System.out.println("This way is a wall try a different direction");
    }

    private void GenerateWorld(int size){
        World = new Room[size][size];
        for(Room[] Row : World){
            for(int i = 0; i < Row.length;i++){
                Row[i] = new EmptyRoom();
            }
        }
        World[0][0] = new EntranceRoom();
        if(size == 4) {
            World[0][2] = new FountainRoom();
        }else {
            Random rand = new Random();
            int row = rand.nextInt(size - 2) + 2;
            int column = rand.nextInt(size - 2) + 2;
            System.out.println("the fountain is at (Row=" + row + ", Column=" + column + ").");
            PlaceRoom(new FountainRoom(), row, column);
        }
        for(int i = 0; i < World.length * World.length / PitFrequency;i++){
            PlaceRoom(new PitRoom());
        }
    }

    private void PlaceRoom(Room room){
        Random rand = new Random();
        int row, column;
        do{
            row = rand.nextInt(World.length-2) + 2;
            column = rand.nextInt(World.length-2)+2;
        }while (World[row][column].equals(new EmptyRoom()));
        PlaceRoom(room, row, column);
    }

    private void PlaceRoom(Room room, int row, int column){
        World[row][column] = room;
    }
}
