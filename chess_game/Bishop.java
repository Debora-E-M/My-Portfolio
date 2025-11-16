package CSCI1933P2;

public class Bishop extends Piece {

    public Bishop(int row, int col, boolean isBlack) {
        super(row, col, isBlack, isBlack ? '\u265D' : '\u2657'); // Unicode Bishop
    }

    // Checks if the bishop move is legal (valid target and diagonal path)
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        return board.verifySourceAndDestination(row, col, endRow, endCol, isBlack) &&
                board.verifyDiagonal(row, col, endRow, endCol);
    }
}
