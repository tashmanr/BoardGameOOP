public abstract class Board {
    public GamePiece[][] pieces;
    public Integer size = 8;

    public Board(){
        this.pieces = new GamePiece[size][size];
    }

    protected abstract void createPieces();
    public abstract void LoadBoard();
}
