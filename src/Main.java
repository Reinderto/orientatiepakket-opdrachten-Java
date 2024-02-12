import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Bread is ready.");
        System.out.println("Who is the bread for?");
        String name = reader.nextLine();
        System.out.println("Noted: " + name + " got bread.");
    }
}