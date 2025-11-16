package CSCI1933P2;

public abstract class Piece {
    protected int row, col;    // Current position
    protected boolean isBlack;   // True if the piece is black
    protected char representation;    // Unicode character for display

    public Piece(int row, int col, boolean isBlack, char rep) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
        this.representation = rep;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isSameColor(Piece other) {
        return other != null && this.isBlack == other.isBlack;
    }

    public abstract boolean isMoveLegal(Board board, int endRow, int endCol);

    public String toString() {
        return Character.toString(representation);
    }
}
