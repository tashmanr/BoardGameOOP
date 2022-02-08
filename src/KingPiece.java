public class KingPiece extends GamePiece {
    protected KingPiece(Integer team) {
        super(team);
        moves.add(1);
        moves.add(-1);
    }
}
