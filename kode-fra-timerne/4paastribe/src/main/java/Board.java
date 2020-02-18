public class Board {
    private State[][] board = new State[6][7];
    private boolean isGreensTurn = true;
    public static void main(String[] args) {
        new Board();
    }
    public Board() {
        initBoard();
    }
private void initBoard(){
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            board[i][j] = State.O;
        }
    }
}

public void makeMove(int col){
    for (int i = 0; i < 6; i++) {
        if(board[i][col] == State.O){
            board[i][col] = isGreensTurn ? State.X : State.Y; // skal være dynamisk
            isGreensTurn = !isGreensTurn;
            return;
        }
    }
}

public State getCurrentMover(){
        return isGreensTurn ? State.X : State.Y;
}

public void addCoin(int col,int row, State state){
     board[row][col] = state;
}
    public State[][] getBoard() { // farlig, fordi GUI kan
        // ændre i arrayet...
        return board;
    }
}
