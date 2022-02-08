public class DummyBoard extends Board {
    @Override
    protected void createPieces() {
    }

    @Override
    public void loadBoard() {
    }

    @Override
    protected boolean isLegalMove(Tuple<Integer, Integer> start, Tuple<Integer, Integer> end) {
        return false;
    }
}
