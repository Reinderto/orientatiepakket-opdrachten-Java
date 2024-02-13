//import java.io.Console;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("What is the base size of the triangle");
        double base = reader.nextDouble();
        System.out.println("What is the height of the triangle");
        double height = reader.nextDouble();
        double area = base * height / 2;
        System.out.println("the area of the triangle is " + area);
    }
}