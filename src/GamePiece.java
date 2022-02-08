import java.util.ArrayList;
import java.util.List;

public abstract class GamePiece {
    protected List<Tuple<Integer, Integer>> locations;
    public ArrayList<Integer> moves = new ArrayList<>();
    protected Integer team;

    protected GamePiece(Integer team) {
        this.team = team;
    }

    public List<Tuple<Integer, Integer>> getLocations() {
        return locations;
    }

    public void addPiece(Tuple<Integer, Integer> spot) {
        locations.add(spot);
    }

    public void killPiece(Tuple<Integer, Integer> spot) {
        locations.remove(spot);
    }

    public ArrayList<Integer> getMoveDirection() {
        return moves;
    }

    public void movePiece(Tuple<Integer, Integer> start, Tuple<Integer, Integer> end) {
        this.locations.remove(start);
        this.locations.add(end);
    }
}
