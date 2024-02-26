package Days;

public class Day31 extends DayOpdracht{
    public static int[][] winLines = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    Player currentTurn;
    Player[] board;
    @Override
    public void Run() {
        StartNewGame();
        boolean isDraw = false;
        while (!DoTurn()){
            if(IsDraw()){
                isDraw = true;
                break;
            }
            if(currentTurn == Player.o){
                currentTurn = Player.x;
            }else {
                currentTurn = Player.o;
            }
        }
        if(isDraw){
            System.out.println("It's a draw");
        }
        else {
            System.out.println("Player " + currentTurn + " has won");
        }
        DisplayBoard();
    }

    private void StartNewGame(){
        currentTurn = Player.x;
        board = new Player[9];
    }

    private boolean DoTurn(){
        System.out.println("It is " + currentTurn + "'s turn.");
        DisplayBoard();
        int square;
        do{
            square = AskForNumberInRange("What square do you want to play in?", 1, 9);
        }while (board[square - 1] != null);
        board[square - 1] = currentTurn;
        return HasPlayerWon();
    }

    private boolean IsDraw(){
        for(Player square : board){
            if(square == null){
                return false;
            }
        }
        return true;
    }

    private boolean HasPlayerWon(){
        for (int[] winLine : winLines){
            boolean win = true;
            for (int j : winLine) {
                if (board[j] != currentTurn) {
                    win = false;
                    break;
                }
            }
            if(win){
                return true;
            }
        }
        return false;
    }

    private void DisplayBoard(){
        String[] rows = new String[3];
        for(int i = 0; i < rows.length;i++){
            StringBuilder row = new StringBuilder();
            row.append(" ");
            for(int j = 0; j < 3; j++){
                if(board[i*3 + j] == null){
                    row.append(" ");
                }
                else {
                    row.append(board[i*3 + j]);
                }
                if(j < 2){
                    row.append(" | ");
                }
            }
            rows[i] = row.toString();
        }
        System.out.println(String.join("\n---+---+---\n", rows));
    }
}
