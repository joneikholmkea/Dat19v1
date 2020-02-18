public class GUI {
    public void printBoard(Board boardInstance){
        State[][] board = boardInstance.getBoard();
        for (int i = board.length-1; i >= 0 ; i--) {
            System.out.print(" | ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" | ");
            }
            System.out.println("");
        }
    }
}
