package CSCI1933P2;

public class Rook extends Piece {

    public Rook(int row, int col, boolean isBlack) {
        super(row, col, isBlack, isBlack ? '\u265C' : '\u2656'); // Unicode Rook
    }


    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        return board.verifySourceAndDestination(row, col, endRow, endCol, isBlack) &&
                (board.verifyHorizontal(row, col, endRow, endCol) ||
                        board.verifyVertical(row, col, endRow, endCol));
    }
}
