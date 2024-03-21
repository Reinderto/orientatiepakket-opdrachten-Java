package Days.UncodedOneGame;

import Days.DayOpdracht;

import java.util.Arrays;
import java.util.List;

public class GameManager extends DayOpdracht {
    List<Character> heroes;
    List<Character> monsters;
    @Override
    public void Run() {
        heroes = Arrays.asList(new Skeleton());
        monsters = Arrays.asList(new Skeleton());
        for(int i = 0; i < 10000;i++){
            for(Character character : heroes){
                DoTurn(character);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for(Character character : monsters){
                DoTurn(character);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void DoTurn(Character character){
        System.out.println();
        System.out.printf("It is %s's turn...\n", character.Name);
        character.DoTurn();
    }
}
