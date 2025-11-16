package CSCI1933P2;

public class Board {
    private Piece[][] board; //Chessboard representation

    public Board() {
        board = new Piece[8][8]; //Initialize 8x8 board
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", this);
    }

    public Piece getPiece(int row, int col) {
        if (row >= 0 && row < 8 && col >= 0 && col < 8) {
            return board[row][col];
        }
        return null;
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
        if (piece != null) piece.setPosition(row, col);
    }

    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        Piece piece = getPiece(startRow, startCol);
        if (piece == null || !piece.isMoveLegal(this, endRow, endCol)) return false;

        setPiece(endRow, endCol, piece);
        setPiece(startRow, startCol, null);
        piece.setPosition(endRow, endCol);

        // Pawn Promotion Check
        if (piece instanceof Pawn) {
            ((Pawn) piece).promotePawn(this); //Handle pawn promotion
        }
        return true;
    }

    public boolean isGameOver() {
        int kingCount = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] instanceof King) kingCount++;
            }
        }
        return kingCount < 2; //Game ends if one king remains
    }

    public void clear() {
        for (int i = 0; i < 8; i++) for (int j = 0; j < 8; j++) board[i][j] = null;
    }

    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        Piece startPiece = getPiece(startRow, startCol);
        Piece endPiece = getPiece(endRow, endCol);
        return startPiece != null && startPiece.isBlack == isBlack && (endPiece == null || endPiece.isBlack != isBlack);
    }

    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        return Math.abs(startRow - endRow) <= 1 && Math.abs(startCol - endCol) <= 1;
    }

    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if (startRow != endRow) return false;
        int dir = startCol < endCol ? 1 : -1;
        for (int i = startCol + dir; i != endCol; i += dir) {
            if (getPiece(startRow, i) != null) return false;
        }
        return true;
    }

    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (startCol != endCol) return false;
        int dir = startRow < endRow ? 1 : -1;
        for (int i = startRow + dir; i != endRow; i += dir) {
            if (getPiece(i, startCol) != null) return false;
        }
        return true;
    }

    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        if (Math.abs(endRow - startRow) != Math.abs(endCol - startCol)) return false;
        int rowDir = startRow < endRow ? 1 : -1;
        int colDir = startCol < endCol ? 1 : -1;
        int r = startRow + rowDir;
        int c = startCol + colDir;
        while (r != endRow && c != endCol) {
            if (getPiece(r, c) != null) return false;
            r += rowDir;
            c += colDir;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = board[i][j];
                sb.append(p == null ? ". " : p + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
