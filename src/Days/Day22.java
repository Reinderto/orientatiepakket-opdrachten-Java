package Days;

public class Day22 extends DayOpdracht{
    @Override
    public void Run() {
        int arrowType = AskForOption("Witch arrow do you want?", new String[]{"Elite Arrow", "Beginner Arrow", "Marksman Arrow", "Custom Arrow"});
        Arrow arrow = switch (arrowType) {
            case 1 -> Arrow.CreateEliteArrow();
            case 2 -> Arrow.CreateBeginnerArrow();
            case 3 -> Arrow.CreateMarksmanArrow();
            default -> CreateCustomArrow();
        };
        System.out.println("Your arrow costs " + arrow.GetCost() + " gold.");
    }

    private Arrow CreateCustomArrow(){
        Arrowhead head = Arrowhead.values()[AskForOption("Witch arrow head do you want?", Arrowhead.values()) - 1];
        int length = AskForNumberInRange("How long does the shaft need to be?", 60, 100);
        Fletching fletch = Fletching.values()[AskForOption("Witch fletching do you want?", Fletching.values()) - 1];
        return new Arrow(head, length, fletch);
    }
}
