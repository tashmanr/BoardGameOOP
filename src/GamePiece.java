import java.util.ArrayList;
import java.util.List;

public abstract class GamePiece {
    protected List<Tuple<Integer, Integer>> locations;
    protected Integer team;

    protected GamePiece(Integer team) {
        this.team = team;
    }

    public abstract ArrayList<Integer> getMoveDirection();

    public void movePiece(Tuple<Integer, Integer> start, Tuple<Integer, Integer> end){
        this.locations.remove(start);
        this.locations.add(end);
    }
}
