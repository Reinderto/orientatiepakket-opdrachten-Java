import java.awt.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String resetColor = "\u001B[0m";
        String redColor = "\u001b[31m";
        Scanner reader = new Scanner(System.in);
        System.out.println("Input number");
        int number = reader.nextInt();
        if(number % 2 == 0)
        {
            System.out.println("Tick");
        }
        else
        {
            System.out.println("Tock");
        }

    }
}