package Days;

public enum Fletching {
    Plastic(10), Turkey_Feathers(5), Goose_Feathers(3);

    Fletching(float cost){
        Cost = cost;
    }
    private final float Cost;
    public float GetCost(){
        return Cost;
    }
}
