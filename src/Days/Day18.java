package Days;

public class Day18 extends DayOpdracht {

    @Override
    public void Run() {
        int minDistance = 0;
        int maxDistance = 100;
        int cityHealth = 15;
        int manticoreHealth = 10;
        int round = 1;
        int manticoreDistance = AskForNumberInRange("Player 1, how far away from the city do you want to station the Manticore?", minDistance, maxDistance);
        ClearScreen();
        System.out.println("Player 2, it is your turn.");
        do{
            System.out.println("-----------------------------------------------------------");
            System.out.println("STATUS: Round: " + round + " City: " + cityHealth + "/15 Manticore: " + manticoreHealth + "/10");
            int damage = GetDamage(round);
            System.out.println("The cannon is expected to deal " + damage + " damage this round.");
            int cannonRange = AskForNumberInRange("Enter desired cannon range:", minDistance, maxDistance);
            if(cannonRange > manticoreDistance){
                System.out.println("That round OVERSHOT the target.");
            } else if (cannonRange < manticoreDistance) {
                System.out.println("That round FELL SHORT of the target.");
            }else {
                System.out.println("That round was a DIRECT HIT!");
                manticoreHealth -= damage;
            }
            if(manticoreHealth > 0){
                cityHealth--;
            }
            round++;
        }while (cityHealth > 0 && manticoreHealth > 0);
        if(manticoreHealth <= 0){
            System.out.println("The Manticore has been destroyed! The city of Consolas has been saved!");
        }
        else {
            System.out.println("The city of Consolas has been destroyed! The Manticore has won!");
        }
    }

    private int GetDamage(int round) {
        if(round % 3 == 0 ^ round % 5 == 0){
            return 3;
        } else if (round % 3 == 0) {
            return  10;
        }
        else {
            return 1;
        }
    }
}
