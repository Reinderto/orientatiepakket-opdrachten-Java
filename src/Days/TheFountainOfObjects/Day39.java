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
    public static int PitFrequency = 15;
    public static int MaelstromFrequency = 37;
    public static int AmarokFrequency = 32;
    public int Size;
    public int Arrows = 5;
    @Override
    public void Run() {
        Size = AskForNumberInRange("How big do you want the world to be? (min 4)", 4, 128);
        GenerateWorld(Size);
        Scanner reader = new Scanner(System.in);
        System.out.println("""
                You enter the Cavern of Objects, a maze of rooms filled with dangerous pits in search of the Fountain of Objects.
                Light is visible only in the entrance, and no other light is seen anywhere in the caverns.
                You must navigate the Caverns with your other senses.
                Find the Fountain of Objects, activate it, and return to the entrance.
                Look out for pits. You will feel a breeze if a pit is in an adjacent room. If you enter a room with a pit, you will die.
                Maelstroms are violent forces of sentient wind. Entering a room with one could transport you to any other location in the caverns. You will be able to hear their growling and groaning in nearby rooms.
                Amaroks roam the caverns. Encountering one is certain death, but you can smell their rotten stench in nearby rooms.
                You carry with you a bow and a quiver of arrows. You can use them to shoot monsters in the caverns but be warned: you have a limited supply.""");
        while (gameIsActive){
            System.out.println("You are in the room at (Row=" + Row + ", Column=" + Column + ").");
            System.out.println("you have a bow with " + Arrows + " arrow(s).");
            System.out.println(World[Row][Column].RoomDescription());
            PrintAdjacentRoomDescriptions();
            System.out.println("What do you want to do?");
            String action = reader.nextLine();
            if(action.startsWith("move ")){
                Move(action.substring(5));
                World[Row][Column].OnEnterRoom(this);
            }
            else if(action.startsWith("shoot ")){
                Shoot(action.substring(6));
            }
            else if(action.equals("help")){
                HelpCommand();
            }
            else {
                System.out.println(World[Row][Column].OnInteract(action, this));
            }
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
        for(Room[] row : World){
            System.out.print("|");
            for (Room room : row){
                System.out.print(" " + room + " |");
            }
            System.out.println("\n----------------------------------------------------------------------------------------------------");
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
        return row >= 0 && row < Size && column >= 0 && column < Size;
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
                System.out.println("Invalid direction " + direction + ".");
                return;
        }
        System.out.println("This way is a wall try a different direction.");
    }

    private void Shoot(String direction){
        if(Arrows > 0){
            int shootRow = Row;
            int shootColumn = Column;
            switch (direction){
                case "north":
                    shootRow++;
                    break;
                case "east":
                    shootColumn++;
                    break;
                case "south":
                    shootRow--;
                    break;
                case "west":
                    shootColumn--;
                    break;
                default:
                    System.out.println("Invalid direction " + direction + ".");
                    return;
            }
            if(IsInWorld(shootRow, shootColumn)){
                World[shootRow][shootColumn].OnShot(this, shootRow, shootColumn);
                System.out.println("You shoot one of your arrows to the room " + direction + " of you.");
                Arrows--;
            }
            else {
                System.out.println("You shouldn't try to shoot an arrow at a wall.");
            }
        }
        else {
            System.out.println("You don't have any arrows left.");
        }
    }

    private void HelpCommand(){
        System.out.println("""
                move (north/east/south/west)
                    moves you one room in the chosen direction.
                """);
        if(Arrows > 0){
            System.out.println("""
                    shoot (north/east/south/west)
                       shoots one of your arrows in the room in the chosen direction killing any monsters in that room.
                    """);
        }
        World[Row][Column].PrintRoomCommands();
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
        for(int i = 0; i <= World.length * World.length / PitFrequency;i++){
            PlaceRoom(new PitRoom());
        }
        for(int i = 0; i <= World.length * World.length / MaelstromFrequency;i++){
            PlaceRoom(new MaelstromRoom());
        }
        for(int i = 0; i <= World.length * World.length / AmarokFrequency;i++){
            PlaceRoom(new AmarokRoom());
        }
    }

    private void PlaceRoom(Room room){
        Random rand = new Random();
        int row, column;
        do{
            row = rand.nextInt(World.length);
            if(row <= 1){
                column = rand.nextInt(World.length-2)+2;
            }else {
                column = rand.nextInt(World.length);
            }
        }while (World[row][column].getClass() != EmptyRoom.class);
        PlaceRoom(room, row, column);
    }

    private void PlaceRoom(Room room, int row, int column){
        World[row][column] = room;
    }
}
