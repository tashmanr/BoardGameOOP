import java.util.List;

public abstract class GamePiece {
    private Tuple<Integer, Integer> location;

    public abstract List<Tuple<Integer, Integer>> getMoves();
}
