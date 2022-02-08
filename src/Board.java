import java.util.ArrayList;
import java.util.HashMap;

public abstract class Board {
    public GamePiece[][] pieces;
    public HashMap<GamePiece, ArrayList<Tuple<Integer, Integer>>> team1 = new HashMap<>();
    public HashMap<GamePiece, ArrayList<Tuple<Integer, Integer>>> team2 = new HashMap<>();
    public Integer size = 8;

    public Board() {
        this.pieces = new GamePiece[size][size];
    }

    protected abstract void createPieces();

    public abstract void LoadBoard();

    public GamePiece[][] getBoard() {
        return pieces;
    }

    public HashMap<GamePiece, ArrayList<Tuple<Integer, Integer>>> getTeam(Integer i) {
        if (i == 1) {
            return team1;
        } else return team2;
    }
}
