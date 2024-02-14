import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Tuple<?, ?>[] items = new Tuple[]{
                new Tuple<>("Rope", 10),
                new Tuple<>("Torches", 15),
                new Tuple<>("Climbing Equipment", 25),
                new Tuple<>("Clean Water", 1),
                new Tuple<>("Machete", 20),
                new Tuple<>("Canoe", 200),
                new Tuple<>("Food Supplies", 1)
        };
        String discountName = "Reindert";
        System.out.println("The following items are available:");
        System.out.println();
        for(int i = 0;i < items.length;i++)
        {
            System.out.println(i + 1 + ". " + items[i].Item1);
        }
        System.out.println();
        System.out.println("What number do you want to see the price of?");
        int number = reader.nextInt();
        reader.nextLine();
        if(number <= 0 || number > items.length)
        {
            System.out.println("There is no item number " + number);
        }
        else
        {
            int price = (int) items[number - 1].Item2;
            System.out.println("What is your name?");
            String name = reader.nextLine();
            if(discountName.equals(name))
            {
                price /= 2;
            }
            System.out.println(items[number - 1].Item1 + " cost " + price + " gold.");
        }
    }
}

