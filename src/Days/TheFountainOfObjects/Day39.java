package Days.TheFountainOfObjects;

import Days.DayOpdracht;

import java.util.Scanner;

public class Day39 extends DayOpdracht {
    public boolean FountainState = false;
    public boolean gameIsActive = true;
    public int Row = 0;
    public int Column = 0;
    public Room[][] World;
    @Override
    public void Run() {
        int size = 4;
        GenerateWorld(size);
        Scanner reader = new Scanner(System.in);
        while (gameIsActive){
            System.out.println("You are in the room at (Row=" + Row + ", Column=" + Column + ").");
            System.out.println(World[Row][Column].RoomDescription());
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
        World[0][2] = new FountainRoom();
    }
}
