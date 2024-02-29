package Days.TheFountainOfObjects;

import java.util.Objects;

public class FountainRoom extends Room{
    private boolean IsEnabled = false;
    @Override
    public String RoomDescription() {
        if(IsEnabled){
            return "You hear the rushing waters from the Fountain of Objects. It has been reactivated!";
        }
        else {
            return "You hear water dripping in this room. The Fountain of Objects is here!";
        }
    }

    @Override
    public String OnInteract(String massage, Day39 game) {
        if(Objects.equals(massage, "enable fountain")){
            if(IsEnabled){
                return "The Fountain of Objects is already enabled";
            }
            else {
                IsEnabled = true;
                game.FountainState = true;
                return "You have Enabled the Fountain of Objects!";
            }
        }
        else {
            return "Invalid interaction maybe try \"enable fountain\"";
        }
    }
}
