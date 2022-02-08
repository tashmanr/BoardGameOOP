import java.util.ArrayList;

public class KingPiece extends GamePiece {
    public ArrayList<Integer> moves = new ArrayList<Integer>();
    protected KingPiece(Integer team) {
        super(team);
        moves.add(1);
        moves.add(-1);
    }

    @Override
    public ArrayList<Integer> getMoveDirection() {
        return moves;
    }
}
