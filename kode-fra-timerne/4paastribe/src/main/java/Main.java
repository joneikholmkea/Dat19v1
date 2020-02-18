import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Board board = new Board();
        GUI gui = new GUI();
        gui.printBoard(board);
        System.out.println("X starter: make a move from 1 to 7");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int move = scanner.nextInt() - 1; // mere brugervenligt med 1..7
            if(move >= 0 && move < 7) {
                board.makeMove(move);
                gui.printBoard(board);
                System.out.println(board.getCurrentMover() + "'s turn");
            }
        }
    }
}
