package Days;

public enum Arrowhead {
    Steel(10), Wood(3), Obsidian(5);

    Arrowhead(float cost){
        Cost = cost;
    }
    private final float Cost;
    public float GetCost(){
        return Cost;
    }
}
