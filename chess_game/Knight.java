package CSCI1933P2;

public class Knight extends Piece {

    public Knight(int row, int col, boolean isBlack) {
        super(row, col, isBlack, isBlack ? '\u265E' : '\u2658'); // Unicode Knight
    }
    // Checks if the move is valid and in an L-shape (2x1 or 1x2)
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (!board.verifySourceAndDestination(row, col, endRow, endCol, isBlack)) return false;
        int rowDiff = Math.abs(endRow - row);
        int colDiff = Math.abs(endCol - col);
        // L-shaped move
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}
