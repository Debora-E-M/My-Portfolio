package CSCI1933P2;

/**
 * For CSCI 1933 Project 2
 * The Fen class was designed to load an object of type
 * Board with any chess board state given a proper
 * Forsyth-Edwards Notation code.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Fen {
    public static void load(String fen, Board b) {
        int rank = 0;
        int square = 0;
        char query;

        Map<Character, Function<int[], Piece>> map = new HashMap<>();
        map.put('p', coords -> new Pawn(coords[0], coords[1], true));
        map.put('P', coords -> new Pawn(coords[0], coords[1], false));
        map.put('r', coords -> new Rook(coords[0], coords[1], true));
        map.put('R', coords -> new Rook(coords[0], coords[1], false));
        map.put('n', coords -> new Knight(coords[0], coords[1], true));
        map.put('N', coords -> new Knight(coords[0], coords[1], false));
        map.put('b', coords -> new Bishop(coords[0], coords[1], true));
        map.put('B', coords -> new Bishop(coords[0], coords[1], false));
        map.put('q', coords -> new Queen(coords[0], coords[1], true));
        map.put('Q', coords -> new Queen(coords[0], coords[1], false));
        map.put('k', coords -> new King(coords[0], coords[1], true));
        map.put('K', coords -> new King(coords[0], coords[1], false));

        for (int i = 0; i < fen.length(); i++) {
            query = fen.charAt(i);

            if (query == '/') {
                rank++;
                square = 0;
            } else if (Character.isDigit(query)) {
                square += Character.getNumericValue(query);
            } else {
                Function<int[], Piece> pieceConstructor = map.get(query);
                if (pieceConstructor != null) {
                    b.setPiece(rank, square, pieceConstructor.apply(new int[]{rank, square}));
                }
                square++;
            }
        }
    }
}
