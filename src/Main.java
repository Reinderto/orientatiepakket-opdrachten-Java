import Days.DayOpdracht;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option = AskForOption("Which challenge do you want to run?", new String[]{
                "Buying Inventory (day 11)",
                "Boss Battle Hunting the Manticore (day 18)",
                "Vin Fletcher’s Arrows (day 21 and 22)",
                "Tic-Tac-Toe (day 31)",
                "The Fountain of Objects (days 39 -43"});
        DayOpdracht day = switch (option){
            case 1 -> new Days.Day11();
            case 2 -> new Days.Day18();
            case 3 -> new Days.Day22();
            case 4 -> new Days.Day31();
            case 5 -> new Days.TheFountainOfObjects.Day39();
            default -> throw new IndexOutOfBoundsException();
        };
        //DayOpdracht day = new Days.UncodedOneGame.GameManager();
        day.Run();
    }

    private static int AskForNumber(String text)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println(text);
        return reader.nextInt();
    }

    private static int AskForNumberInRange(String text, int min, int max)
    {
        int output;
        do
        {
            output = AskForNumber(text);
        }while (output < min || output > max);
        return  output;
    }

    private static int AskForOption(String question, Object[] options){
        StringBuilder test = new StringBuilder(question);
        for(int i = 0; i < options.length;i++){
            test.append("\n ").append(i + 1).append(". ").append(options[i]);
        }
        return AskForNumberInRange(test.toString(), 1, options.length);
    }
}

