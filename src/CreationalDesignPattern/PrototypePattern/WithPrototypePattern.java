package CreationalDesignPattern.PrototypePattern;
import java.util.Arrays;

// GamePiece.java (Product)
public class GamePiece implements Cloneable {
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

    @Override
    public GamePiece clone() {
        try {
            return (GamePiece) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

// GameBoard.java (Product)
                import java.util.List;

public class GameBoard implements Cloneable {
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

    @Override
    public GameBoard clone() {
        try {
            // Clone the GameBoard itself
            GameBoard clonedBoard = (GameBoard) super.clone();

            // To ensure deep cloning, we also clone the pieces list
            clonedBoard.pieces = new ArrayList<>();
            for (GamePiece piece : this.pieces) {
                clonedBoard.pieces.add(piece.clone());
            }
            return clonedBoard;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

// Main.java (Client code)

public class WithPrototypePattern {
    public static void main(String[] args) {
        // Creating a game board with Prototype pattern
        GamePiece piece1 = new GamePiece("Knight");
        GamePiece piece2 = new GamePiece("Bishop");
        GameBoard board1 = new GameBoard(Arrays.asList(piece1, piece2));

        System.out.println("Original Board 1: " + board1);

        // Cloning the game board (using the Prototype pattern)
        GameBoard board2 = board1.clone();

        System.out.println("Cloned Board 2: " + board2);

        // Modifying the cloned board's pieces to show independence
        board2.getPieces().get(0).setType("Queen");

        System.out.println("Modified Cloned Board 2: " + board2);
        System.out.println("Original Board 1 (After Clone modification): " + board1);
    }
}


/***
 * +--------------------+     +-------------------+
 * |    GamePiece       |<----|    GamePiece      |
 * +--------------------+     +-------------------+
 * | +clone()           |     | +clone()          |
 * | +getType()         |     | +getType()        |
 * +--------------------+     +-------------------+
 *
 *           ^                         ^
 *           |                         |
 * +-------------------+     +-------------------+
 * |   GameBoard       |<----|    GameBoard      |
 * +-------------------+     +-------------------+
 * | +clone()          |     | +clone()          |
 * | +getPieces()      |     | +getPieces()      |
 * +-------------------+     +-------------------+
 *          ^
 *          |
 * +-------------------+
 * |    Client         |
 * +-------------------+
 * | +main()           |
 * +-------------------+
 *
 * GamePiece: The product class that represents a piece in the game. It implements clone() to allow creating copies of game pieces.
 * GameBoard: The product class representing the game board. It implements clone() to clone the entire board and its pieces.
 * Client: The class that uses the clone() method to create new boards from existing prototypes and modify them.
 */