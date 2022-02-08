public class KingPiece extends GamePiece {
    protected KingPiece(Integer team) {
        super(team);
        moves.add(1);
        moves.add(-1);
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + team.toString();

    }
}
