import java.util.ArrayList;

public abstract class GamePiece {
//    protected ArrayList<Tuple<Integer, Integer>> locations;
    public ArrayList<Integer> moves = new ArrayList<>();
    protected Integer team;

    protected GamePiece(Integer team) {
        this.team = team;
    }

//
//    public void addPiece(Tuple<Integer, Integer> spot) {
//        locations.add(spot);
//    }

//    public void killPiece(Tuple<Integer, Integer> spot) {
//        locations.remove(spot);
//    }

    public ArrayList<Integer> getMoveDirection() {
        return moves;
    }

//    public void movePiece(Tuple<Integer, Integer> start, Tuple<Integer, Integer> end) {
//        this.locations.remove(start);
//        this.locations.add(end);
//    }
}
