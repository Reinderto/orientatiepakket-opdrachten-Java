package Days.UncodedOneGame;

public abstract class Character {
    public String Name;
    public abstract void DoTurn();
    public Character(){
        Name = this.getClass().getSimpleName().toUpperCase();
    }
}
