package CSCI1933P2;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        boolean isBlackTurn = false; // White starts first
        while (!board.isGameOver()) {
            System.out.println(board);  // Print the current board
            System.out.println((isBlackTurn ? "Black" : "White") + "'s turn. Enter your move (startRow startCol endRow endCol):");

            int startRow = scanner.nextInt();
            int startCol = scanner.nextInt();
            int endRow = scanner.nextInt();
            int endCol = scanner.nextInt();
            scanner.nextLine();  // Consume newline


            // Validate selection and attempt move
            Piece piece = board.getPiece(startRow, startCol);
            if (piece != null && piece.isBlack == isBlackTurn) {
                if (board.movePiece(startRow, startCol, endRow, endCol)) {
                    isBlackTurn = !isBlackTurn;  // Switch turn
                } else {
                    System.out.println("Illegal move. Try again.");
                }
            } else {
                System.out.println("Invalid selection. Try again.");
            }
        }

        System.out.println("Game Over!");
        scanner.close();
    }
}

