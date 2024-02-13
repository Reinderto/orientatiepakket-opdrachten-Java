import java.awt.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String resetColor = "\u001B[0m";
        String redColor = "\u001b[31m";
        Scanner reader = new Scanner(System.in);
        System.out.println("Target Row?");
        int row = reader.nextInt();
        System.out.println("Target Column?");
        int column = reader.nextInt();
        System.out.println("Deploy to:");
        System.out.println(redColor + "(" + (row + 1) + ", " + column + ")" + resetColor);
        System.out.println(redColor + "(" + (row - 1) + ", " + column + ")" + resetColor);
        System.out.println(redColor + "(" + row + ", " + (column + 1) + ")" + resetColor);
        System.out.println(redColor + "(" + row + ", " + (column - 1) + ")" + resetColor);
        Toolkit.getDefaultToolkit().beep();
    }
}