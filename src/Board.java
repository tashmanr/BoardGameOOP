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

    public abstract void loadBoard();

    public GamePiece[][] getBoard() {
        return pieces;
    }

    public HashMap<GamePiece, ArrayList<Tuple<Integer, Integer>>> getTeam(Integer i) {
        if (i == 1) {
            return team1;
        } else return team2;
    }

    public void makeMove(Tuple<Integer, Integer> start, Tuple<Integer, Integer> end){
        GamePiece mover = pieces[start.x][start.y];
        if (mover != null && isLegalMove(start, end)){
            pieces[start.x][start.y] = null;
            pieces[end.x][end.y] = mover;
        } else {
            //need to report illegal move
        }
    }

    protected abstract boolean isLegalMove(Tuple<Integer, Integer> start, Tuple<Integer, Integer> end);
}
