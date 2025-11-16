package CSCI1933P2;

import java.util.Scanner;

public class Pawn extends Piece {

    public Pawn(int row, int col, boolean isBlack) {
        super(row, col, isBlack, isBlack ? '\u265F' : '\u2659'); // Unicode Pawn
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        int direction = isBlack ? 1 : -1;
        Piece target = board.getPiece(endRow, endCol);

        // Normal move forward
        if (col == endCol && target == null) {
            if (endRow == row + direction) {
                return true;
            }
            // First move double step
            if ((isBlack && row == 1 || !isBlack && row == 6) && endRow == row + 2 * direction && board.getPiece(row + direction, col) == null){ return true; }
        }

        // Diagonal capture
        if (Math.abs(endCol - col) == 1 && endRow == row + direction && target != null && target.isBlack != isBlack) {
            return true;
        }

        return false;
    }

    public void promotePawn(Board board) {
        if ((isBlack && row == 7) || (!isBlack && row == 0)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Promote pawn to (Q, R, B, N):");
            String choice = scanner.nextLine().toUpperCase();
            Piece promoted = null;

            switch (choice) {
                case "Q": promoted = new Queen(row, col, isBlack); break;
                case "R": promoted = new Rook(row, col, isBlack); break;
                case "B": promoted = new Bishop(row, col, isBlack); break;
                case "N": promoted = new Knight(row, col, isBlack); break;
                default: System.out.println("Invalid promotion choice.");
            }

            if (promoted != null) {
                board.setPiece(row, col, promoted);
            }
        }
    }
}
