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

    public int AskForNumberInRange(String text, int min, int max)
    {
        int output;
        do
        {
            output = AskForNumber(text);
        }while (output < min || output > max);
        return  output;
    }

    public int AskForOption(String question, Object[] options){
        StringBuilder test = new StringBuilder(question);
        for(int i = 0; i < options.length;i++){
            test.append("\n ").append(i + 1).append(". ").append(options[i]);
        }
        return AskForNumberInRange(test.toString(), 1, options.length);
    }

    public void ClearScreen()
    {
        for(int i = 0; i < 10; i++)
        {
            System.out.println();
        }
    }
}
