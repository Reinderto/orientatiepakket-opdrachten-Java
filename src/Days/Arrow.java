package Days;

public class Arrow {
    private Arrowhead Head;
    private int Length;
    private Fletching Fletch;

    public Arrow(Arrowhead head, int length, Fletching fletching){
        Head = head;
        Length = length;
        Fletch = fletching;
    }

    public static Arrow CreateEliteArrow(){
        return new Arrow(Arrowhead.Steel, 95, Fletching.Plastic);
    }

    public static Arrow CreateBeginnerArrow(){
        return new Arrow(Arrowhead.Wood, 75, Fletching.Goose_Feathers);
    }

    public static Arrow CreateMarksmanArrow(){
        return new Arrow(Arrowhead.Steel, 65, Fletching.Goose_Feathers);
    }

    public float GetCost(){
        float cost = Head.GetCost();
        cost += (float) Length * 0.05f;
        cost += Fletch.GetCost();
        return cost;
    }
    public Arrowhead getHead() {
        return Head;
    }

    public int getLength() {
        return Length;
    }

    public Fletching getFletch() {
        return Fletch;
    }
}

