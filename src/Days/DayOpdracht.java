package Days;

import java.util.Scanner;

public abstract class DayOpdracht {
    public abstract void Run();

    public int AskForNumber(String text)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println(text);
        return reader.nextInt();
    }
}
