package CreationalDesignPattern.PrototypePattern;
import java.util.Arrays;

// GamePiece.java (Product)
public class GamePiece {
    private String type;

    public GamePiece(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "GamePiece{" +
        "type='" + type + '\'' +
        '}';
    }
}

// GameBoard.java (Product)
                import java.util.List;

public class GameBoard {
    private List<GamePiece> pieces;

    public GameBoard(List<GamePiece> pieces) {
        this.pieces = pieces;
    }

    public List<GamePiece> getPieces() {
        return pieces;
    }

    public void setPieces(List<GamePiece> pieces) {
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return "GameBoard{" +
        "pieces=" + pieces +
        '}';
    }
}

// Main.java (Client code)

public class WithoutPrototypePattern {
    public static void main(String[] args) {
        // Creating a game board without Prototype pattern
        GamePiece piece1 = new GamePiece("Knight");
        GamePiece piece2 = new GamePiece("Bishop");
        GameBoard board1 = new GameBoard(Arrays.asList(piece1, piece2));

        System.out.println("Board 1: " + board1);

        // Manually copying the game board (not using Prototype pattern)
        GamePiece piece3 = new GamePiece("Queen");
        GameBoard board2 = new GameBoard(Arrays.asList(piece3));

        System.out.println("Board 2: " + board2);
    }
}
