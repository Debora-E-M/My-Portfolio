package CSCI1933P2;

public class Queen extends Piece {

    public Queen(int row, int col, boolean isBlack) {
        super(row, col, isBlack, isBlack ? '\u265B' : '\u2655'); // Unicode Queen
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        return board.verifySourceAndDestination(row, col, endRow, endCol, isBlack) &&
                (board.verifyHorizontal(row, col, endRow, endCol) ||
                        board.verifyVertical(row, col, endRow, endCol) ||
                        board.verifyDiagonal(row, col, endRow, endCol));
    }
}
