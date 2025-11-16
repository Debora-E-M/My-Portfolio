package CSCI1933P2;

public class King extends Piece {

    public King(int row, int col, boolean isBlack) {
        super(row, col, isBlack, isBlack ? '\u265A' : '\u2654'); // Unicode King
    }
    // Checks if the move is valid and only one square away (king's move)
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        return board.verifySourceAndDestination(row, col, endRow, endCol, isBlack) &&
                board.verifyAdjacent(row, col, endRow, endCol);
    }
}
